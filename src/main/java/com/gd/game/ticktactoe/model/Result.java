package com.gd.game.ticktactoe.model;

public class Result {
	
	private Player lastPlayer;
	private Status gameStatus;
	
	public Result(Player lastPlayer, Status gameStatus) {
		this.lastPlayer = lastPlayer;
		this.gameStatus = gameStatus;
	}
	
	public Player getLastPlayer() {
		return lastPlayer;
	}
	
	public Status getGameStatus() {
		return gameStatus;
	}
}
