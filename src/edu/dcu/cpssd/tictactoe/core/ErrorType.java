package edu.dcu.cpssd.tictactoe.core;

import org.json.JSONObject;

public enum ErrorType {

	ErrorType100("Other error", 100),
	ErrorType101("Missing parameter in request", 101),
	ErrorType102("Unknown parameter in request", 102),
	UNKNOWN_REQUEST("UnKnown request", 103),
	SERVER_NOT_READY("Server not ready or busy", 104),
	NOT_PLAYERS_TURN("Not players turn", 105);

	private String errorMessage;
	private Integer errorCode;

	ErrorType(final String errorMessage, final int errorCode) {
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
	}
	
	public JSONObject toJson() {
		return new JSONObject().put("status", "error")
				.put("code", errorCode)
				.put("message", errorMessage);
	}
}
