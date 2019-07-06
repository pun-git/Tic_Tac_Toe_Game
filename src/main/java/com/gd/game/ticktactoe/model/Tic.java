package com.gd.game.ticktactoe.model;

public enum Tic {
	
	X("X"), O("O"), N("N") ;
	
	private String symbol;
	
	private Tic(String symbol) {
		this.symbol = symbol;
	}
	
	public String getSymbol() {
		return symbol;
	}

}
