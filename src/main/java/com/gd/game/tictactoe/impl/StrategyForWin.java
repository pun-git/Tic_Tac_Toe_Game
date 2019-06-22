package com.gd.game.tictactoe.impl;

import com.gd.game.ticktactoe.api.Strategy;
import com.gd.game.ticktactoe.model.Board;
import com.gd.game.ticktactoe.model.Tic;

public class StrategyForWin implements Strategy 
{
	private Board board;
	
	public StrategyForWin(Board board) {
		this.board = board;
	}
	
	public boolean check() {
		boolean won = false;
		
		for(int i =0 ; i< board.getCellInSquareSize() ; i++) {
				int start = i*board.getCellInSquareSize();
				int increment = 1;
				won |= checkForPattern(start, increment);
				if(won) return true;
		}
		for(int i =0 ; i< board.getCellInSquareSize() ; i++) {
			int start = i;
			int increment = board.getCellInSquareSize();
			won |= checkForPattern(start, increment);
			if(won) return true;
		}
		
		won |= checkForPattern(0, board.getCellInSquareSize()+1) || checkForPattern(board.getCellInSquareSize()-1, board.getCellInSquareSize()-1);
		return won;
	}
		
	
	private boolean checkForPattern(int start, int increment) {
		int count = start;
		Tic tic = null;
		int rep = 0;
		for(int i=0; i< board.getCellInSquareSize(); i++) {
			if(board.getCellStatus(count) == Tic.N) {
				return false;
			}
			if(tic == null) {
				tic = board.getCellStatus(count);
			}else if(tic != board.getCellStatus(count)) {
				return false;
			}
			rep++;
			count += increment;
		}
		
		return (tic == null || rep < board.getCellInSquareSize()) ? false : true;
	}
}
