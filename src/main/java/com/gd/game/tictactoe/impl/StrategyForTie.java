package com.gd.game.tictactoe.impl;

import java.util.HashMap;
import java.util.Map;

import com.gd.game.ticktactoe.api.Strategy;
import com.gd.game.ticktactoe.model.Board;
import com.gd.game.ticktactoe.model.Tic;

public class StrategyForTie implements Strategy 
{
	private Board board;
	
	public StrategyForTie(Board board) {
		this.board = board;
	}
	
	public boolean check() {
		boolean tie = false;
		
		for(Tic tic : Tic.values()) {
			tie = tie ||  isAllCellMarked() &&
				!checkForSide(0, 1, tic) &&
				!checkForSide(0, board.getCellInSquareSize(), tic) && 
				!checkForSide(board.getCellInSquareSize()-1, board.getCellInSquareSize(), tic) && 
				!checkForSide(board.getBoardSize() - board.getCellInSquareSize(), 1, tic) &&
				!checkForSide(0, board.getCellInSquareSize()+1, tic) &&
				!checkForSide(board.getCellInSquareSize()-1, board.getCellInSquareSize()-1, tic);
		}
		
		return tie;
	}
	
	private boolean isAllCellMarked() {
		for(int i=0 ; i<board.getBoardSize() ; i++) {
			if(board.getCellStatus(i) == Tic.N) {
				return false;
			}
		}
		return true;
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
