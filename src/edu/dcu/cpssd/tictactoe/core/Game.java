package edu.dcu.cpssd.tictactoe.core;

import java.util.ArrayList;

public class Game {
	final ArrayList<User> users;
	final Board board;
	String id;
	int turn = 1;
	int winner = 0;
	boolean first = false;

	public Game(String id) {
		this.id = id;
		this.users = new ArrayList<User>(2);
		this.board = new Board();
	}
	
	public Game(ArrayList<User> users, Board board) {
		this.users = users;
		this.board = board;
	}

	public Game(String id, Board board) {
		this.id = id;
		this.users = new ArrayList<>(2);
		this.users.add(new User("test"));
		this.users.add(new User("test2"));
		this.board = board;
	}

	public ArrayList<User> addUser(User user) {
		users.add(user);
		return users;
	}

	public Game createNewGame(String name) {
		User user = new User(name);
		users.add(user);
		return this;
	}

	public String getLetter() {
		if (turn == 1) {
			return "X";
		}
		if (turn == 2) {
			return "O";
		}

		return "no valid";
	}

	public int[] move(int position, int turn) throws Exception {
		// TODO check if turn is wrong
		if (turn != this.turn) {
			throw new IllegalArgumentException("It's not your turn!!");
		}
		int[] positions = board.move(position, turn);
		this.turn = turn == 1? 2 : 1;
		return positions;
	}

	public boolean isWinner(int turn) {
		if (winner != 0) {
			return turn == winner;
		}
		boolean isWinner = board.isWinner(turn);
		if (isWinner) {
			this.winner = turn;
		}
		return isWinner;
	}

	public Board getBoard() {
		return this.board;
	}

	public int getTurn() {
		return this.turn;
	}

	public int getWinner() {
		return this.winner;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}
}
