package edu.dcu.cpssd.tictactoe.core;

import org.json.JSONObject;

public class User {
	private String name;

	public User(JSONObject jsonObject) {
		this.name = jsonObject.getString("name");
	}

	public User(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
