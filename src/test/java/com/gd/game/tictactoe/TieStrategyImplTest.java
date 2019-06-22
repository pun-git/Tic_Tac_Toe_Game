package com.gd.game.tictactoe;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gd.game.ticktactoe.api.Strategy;
import com.gd.game.ticktactoe.model.Board;
import com.gd.game.ticktactoe.model.Tic;
import com.gd.game.tictactoe.impl.StrategyForTie;

public class TieStrategyImplTest 
{
	private Strategy tieStrategy;
	private Board board;
	
	@Before
	public void setUp() {
		board = prepareGameBoard();
		tieStrategy = new StrategyForTie(board);
	}
	
	@Test
	public void test_IfNotMarked() throws Exception{
		assertFalse(tieStrategy.check());
	}
	
	@Test
	public void test_IfMarkedForWin() throws Exception{
		fillForSide(0, 1, board.getCellInSquareSize()-1, Tic.X);
		assertFalse(tieStrategy.check());
	}
	
	@Test
	public void test_IfMarkedForNotCorner() throws Exception{
		fillForSide(1, 1, board.getCellInSquareSize()-2, Tic.X);
		fillForSide(board.getCellInSquareSize(), 1, board.getCellInSquareSize()-1, Tic.X);
		fillForSide(2*board.getCellInSquareSize(), 1, board.getCellInSquareSize()-1, Tic.X);
		fillForSide(3*board.getCellInSquareSize()+1, 1, board.getCellInSquareSize()-2, Tic.X);
		assertFalse(tieStrategy.check());
	}
	
	@Test
	public void test_IfMarkedForNotTie() throws Exception{
		//X X X O
		//O O O X
		//X X X O
		//X X X X
		fillForSide(0, 1, board.getCellInSquareSize()-2, Tic.X);
		fillForSide(board.getCellInSquareSize()-1, 1, 0, Tic.O);
		
		fillForSide(board.getCellInSquareSize(), 1, board.getCellInSquareSize()-2, Tic.O);
		fillForSide(2*board.getCellInSquareSize()-1, 1, 0, Tic.X);
		
		fillForSide(2*board.getCellInSquareSize(), 1, board.getCellInSquareSize()-2, Tic.X);
		fillForSide(3*board.getCellInSquareSize()-1, 1, 0, Tic.O);
	
		fillForSide(3*board.getCellInSquareSize(), 1, board.getCellInSquareSize()-1, Tic.X);
		
		assertTrue(tieStrategy.check());
	}
	
	@After
	public void tearDown() {
		board.reset();
	}
	
	private Board prepareGameBoard() {
		return new Board(4);
	}
	
	private void fillForSide(int start, int increment, int end, Tic tic) throws Exception {
		int count = start;
		for(int i=0; i<= end; i++) {
			board.markCellWithTic(count, tic);
			count += increment;
		}
	}
}
