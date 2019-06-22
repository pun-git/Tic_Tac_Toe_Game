package com.gd.game.ticktactoe.model;

public enum Tic {
	
	X("X"), O("O"), N("N") ;
	
	private Tic(String symbol) {
		this.symbol = symbol;
	}
	
	private String symbol;
	
	public String getSymbol() {
		return symbol;
	}

}
