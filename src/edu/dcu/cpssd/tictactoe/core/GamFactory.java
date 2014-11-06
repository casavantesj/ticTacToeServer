package edu.dcu.cpssd.tictactoe.core;

import java.util.HashMap;
import java.util.Map;

public class GamFactory {
	
	private Map<String, Game> games = new HashMap<>();
	private Map<User, Game> users = new HashMap<>();
	private int id = 0;
	
	public Game newGame(User user) {
		Game game = new Game("id");
		game.addUser(user);
		games.put("id-1", game);
		users.put(user, game);
		return game;
	}
	
	
	
	

}
