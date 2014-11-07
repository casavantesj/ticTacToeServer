package edu.dcu.cpssd.tictactoe.core;

import java.util.HashMap;
import java.util.Map;

public class GameFactory {
	private Game incompleteGame = null;
	private Map<String, Game> games = new HashMap<>();
	private Map<User, Game> users = new HashMap<>();
	int count = 1;

	public Game newGame(User user) {
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
		
		game.addUser(user);
		games.put(id, game);
		users.put(user, game);
		return game;
	}

	public Game getGameWithId(String id) {
		return games.get(id);
	}

	public Game getGameByUser(User user) {
		return users.get(user);
	}

	public String getNextId() {
		return "id " + count++;
	}
}