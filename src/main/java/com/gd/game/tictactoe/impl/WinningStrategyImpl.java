package com.gd.game.tictactoe.impl;

import com.gd.game.ticktactoe.api.WinningStrategy;
import com.gd.game.ticktactoe.model.Board;

public class WinningStrategyImpl implements WinningStrategy 
{
	private Board board;
	
	public WinningStrategyImpl(Board board) {
		this.board = board;
	}
	
	public boolean checkForWin() {
		return false;
	}
    
}
