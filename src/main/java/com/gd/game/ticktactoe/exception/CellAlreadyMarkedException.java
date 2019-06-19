package com.gd.game.ticktactoe.exception;

public class CellAlreadyMarkedException extends Exception{
	
	private static final long serialVersionUID = -205980016774578559L;

	public CellAlreadyMarkedException(String message) {
		super(message);
	}

}
