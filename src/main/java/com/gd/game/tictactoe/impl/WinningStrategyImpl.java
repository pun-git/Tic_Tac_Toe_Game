package com.gd.game.tictactoe.impl;

import java.util.HashMap;
import java.util.Map;

import com.gd.game.ticktactoe.api.WinningStrategy;
import com.gd.game.ticktactoe.model.Board;
import com.gd.game.ticktactoe.model.Tic;

public class WinningStrategyImpl implements WinningStrategy 
{
	private Board board;
	
	public WinningStrategyImpl(Board board) {
		this.board = board;
	}
	
	public boolean checkForWin(Tic tic) {
		if(tic == null) {
			throw new IllegalArgumentException("Tic should be not null value");
		}
		return checkForSide(0, 1, tic) || 
				checkForSide(0, board.getCellInSquareSize(), tic) || 
				checkForSide(board.getCellInSquareSize()-1, board.getCellInSquareSize(), tic) || 
				checkForSide(board.getBoardSize() - board.getCellInSquareSize(), 1, tic) ||
				checkForSide(0, board.getCellInSquareSize()+1, tic) ||
				checkForSide(board.getCellInSquareSize()-1, board.getCellInSquareSize()-1, tic);
	}
	
	private boolean checkForSide(int start, int increment, Tic tic) {
		Map<Tic, Integer> countOfTics = new HashMap<>();
		int count = start;
		for(int i=0; i< board.getCellInSquareSize(); i++) {
			if(board.getCellStatus(count) == tic) {
				countOfTics.put(board.getCellStatus(count), countOfTics.getOrDefault(board.getCellStatus(count), 0)+1);
			}
			count += increment;
		}
		
		return checkTicForWinCondition(countOfTics);
	}
	
	private boolean checkTicForWinCondition(Map<Tic, Integer> countOfTics) {
		if(countOfTics.size() == 0) {
			return false;
		}
		for(Tic tic : countOfTics.keySet()) {
			if(countOfTics.get(tic) != board.getCellInSquareSize()) {
				return false;
			}
		}
		return true;
	}
    
}
