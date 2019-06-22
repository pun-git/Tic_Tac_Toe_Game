package com.gd.game.ticktactoe.model;

public class Move {
	
	private Player player;
	private int cellNo;
	
	public Move(Player player, int cellNo) {
		this.player = player;
		this.cellNo = cellNo;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public int getCellNo() {
		return cellNo;
	}

}
