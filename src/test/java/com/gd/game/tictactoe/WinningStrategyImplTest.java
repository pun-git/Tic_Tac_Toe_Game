package com.gd.game.tictactoe;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gd.game.ticktactoe.api.Strategy;
import com.gd.game.ticktactoe.model.Board;
import com.gd.game.ticktactoe.model.Tic;
import com.gd.game.tictactoe.impl.StrategyForWin;

public class WinningStrategyImplTest 
{
	private Strategy winningstrategy;
	private Board board;
	
	@Before
	public void setUp() {
		board = prepareGameBoard();
		winningstrategy = new StrategyForWin(board);
	}
	
	@Test
	public void testWhenNotMarked() throws Exception{
		assertFalse(winningstrategy.check());
	}
	
	@Test
	public void testWhennOnceCellMarked() throws Exception{
		fillForSide(0, 1, 1, Tic.X);
		assertFalse(winningstrategy.check());
	}
	
	@Test
	public void testWinWhenWithCrossTopTicPattern()  throws Exception{
		fillForSide(0, 1, board.getCellInSquareSize()-1, Tic.X);
		assertTrue(winningstrategy.check());
	}
	
	@Test
	public void testWinWhenWithCrossMiddleHorizontalTicPattern()  throws Exception{
		fillForSide(board.getCellInSquareSize(), 1, board.getCellInSquareSize()-1, Tic.X);
		assertTrue(winningstrategy.check());
	}
	
	@Test
	public void testWinWhenWithCrossMiddleVerticalTicPattern()  throws Exception{
		fillForSide(1, board.getCellInSquareSize(), board.getCellInSquareSize()-1, Tic.X);
		assertTrue(winningstrategy.check());
	}
	
	@Test
	public void testWinWhenWithCrossBottomTicPattern()  throws Exception{
		fillForSide(board.getBoardSize() - board.getCellInSquareSize(), 1, board.getCellInSquareSize()-1, Tic.X);
		assertTrue(winningstrategy.check());
	}
	
	@Test
	public void testWinWhenWithCrossLeftTicPattern()  throws Exception{
		fillForSide(0, board.getCellInSquareSize(), board.getCellInSquareSize()-1, Tic.X);
		assertTrue(winningstrategy.check());
	}
	
	@Test
	public void testWinWhenWithCrossRightTicPattern()  throws Exception{
		fillForSide(board.getCellInSquareSize()-1, board.getCellInSquareSize(), board.getCellInSquareSize()-1, Tic.X);
		assertTrue(winningstrategy.check());
	}
	
	@Test
	public void testWinWhenWithCrossDiagonalLRTBPattern()  throws Exception{
		fillForSide(0, board.getCellInSquareSize()+1, board.getCellInSquareSize()-1, Tic.X);
		assertTrue(winningstrategy.check());
	}
	
	@Test
	public void testWinWhenWithCrossDiagonalRLTBPattern()  throws Exception{
		fillForSide(board.getCellInSquareSize()-1, board.getCellInSquareSize()-1, board.getCellInSquareSize()-1, Tic.X);
		assertTrue(winningstrategy.check());
	}
	
	@Test
	public void testWinWhenWithCircleTopTicPattern()  throws Exception{
		fillForSide(0, 1, board.getCellInSquareSize()-1, Tic.O);
		assertTrue(winningstrategy.check());
	}
	
	@Test
	public void testWinWhenWithCircleBottomTicPattern()  throws Exception{
		fillForSide(board.getBoardSize() - board.getCellInSquareSize(), 1, board.getCellInSquareSize()-1, Tic.O);
		assertTrue(winningstrategy.check());
	}
	
	@Test
	public void testWinWhenWithCircleLeftTicPattern()  throws Exception{
		fillForSide(0, board.getCellInSquareSize(), board.getCellInSquareSize()-1, Tic.O);
		assertTrue(winningstrategy.check());
	}
	
	@Test
	public void testWinWhenWithCircleRightTicPattern()  throws Exception{
		fillForSide(board.getCellInSquareSize()-1, board.getCellInSquareSize(), board.getCellInSquareSize()-1, Tic.O);
		assertTrue(winningstrategy.check());
	}
	
	@Test
	public void testWinWhenWithCircleDiagonalLRTBPattern()  throws Exception{
		fillForSide(0, board.getCellInSquareSize()+1, board.getCellInSquareSize()-1, Tic.O);
		assertTrue(winningstrategy.check());
	}
	
	@Test
	public void testWinWhenWithCircleDiagonalRLTBPattern()  throws Exception{
		fillForSide(board.getCellInSquareSize()-1, board.getCellInSquareSize()-1, board.getCellInSquareSize()-1, Tic.O);
		assertTrue(winningstrategy.check());
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
