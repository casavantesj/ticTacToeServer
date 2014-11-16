package edu.dcu.cpssd.tictactoe.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import edu.dcu.cpssd.tictactoe.core.exceptions.GameException;

public class GameFactory {
	private Game incompleteGame = null;
	private Map<String, Game> games = new HashMap<>();
	private Map<User, Game> users = new HashMap<>();
	private ArrayList<User>userList = new ArrayList<User>();
	int count = 1;

	public Game newGame(User user) throws GameException {
		Game game;
		String id;
		if (incompleteGame == null) {
			id = getNextId();
			game = new Game(id);
			incompleteGame = game;
		} else {
			game = incompleteGame;
			id = incompleteGame.getId();
			incompleteGame = null;
		}
		user.setId(userList.size());
		game.addUser(user);
		games.put(id, game);
		users.put(user, game);
		userList.add(user);
		return game;
	}

	public Game getGameWithId(String id) throws GameException {
		if(id == null || id.isEmpty()) {
			throw new GameException(ErrorType.MISSING_PARAMETER_IN_REQUEST);
		}
		
		Game game = games.get(id);
		if (game == null) {
			throw new GameException(ErrorType.UNKNOWN_PARAMETER_IN_REQUEST);
		}
		return game;
	}

	public Game getGameByUser(User user) {
		return users.get(user);
	}

	public String getNextId() {
		return "game-" + count++;
	}
	
	public User getUserById(String gameId) throws GameException {
		try {
			int id = Integer.valueOf(gameId.substring(5));
			return userList.get(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new GameException(ErrorType.UNKNOWN_PARAMETER_IN_REQUEST);
		}
	}
	
	public Game getGameForUser(User user) {
		return users.get(user);
	}
}