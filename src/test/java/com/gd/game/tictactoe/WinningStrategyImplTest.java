package com.gd.game.tictactoe;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gd.game.ticktactoe.api.WinningStrategy;
import com.gd.game.ticktactoe.model.Board;
import com.gd.game.ticktactoe.model.Tic;
import com.gd.game.tictactoe.impl.WinningStrategyImpl;

public class WinningStrategyImplTest 
{
	private WinningStrategy winningstrategy;
	private Board board;
	
	@Before
	public void setUp() {
		board = prepareGameBoard();
		winningstrategy = new WinningStrategyImpl(board);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testWinWithNull() {
		winningstrategy.checkForWin(null);
	}
	
	@Test
	public void testWinWhenNoPattern() {
		for(Tic tic : Tic.values()) {
			if(tic != Tic.NOTIC) {
				assertFalse(winningstrategy.checkForWin(tic));
			}
		}
	}
	
	@Test
	public void testWinWhenNoPattern1() {
		fillForSide(0, board.getCellInSquareSize()-1, Tic.CROSS_TIC);
		assertFalse(winningstrategy.checkForWin(Tic.CROSS_TIC));
	}
	
	@Test
	public void testWinWhenWithCrossTopTicPattern() {
		fillForSide(0, 1, Tic.CROSS_TIC);
		assertTrue(winningstrategy.checkForWin(Tic.CROSS_TIC));
	}
	
	@Test
	public void testWinWhenWithCrossBottomTicPattern() {
		fillForSide(board.getBoardSize() - board.getCellInSquareSize(), 1, Tic.CROSS_TIC);
		assertTrue(winningstrategy.checkForWin(Tic.CROSS_TIC));
	}
	
	@Test
	public void testWinWhenWithCrossLeftTicPattern() {
		fillForSide(0, board.getCellInSquareSize(), Tic.CROSS_TIC);
		assertTrue(winningstrategy.checkForWin(Tic.CROSS_TIC));
	}
	
	@Test
	public void testWinWhenWithCrossRightTicPattern() {
		fillForSide(board.getCellInSquareSize()-1, board.getCellInSquareSize(), Tic.CROSS_TIC);
		assertTrue(winningstrategy.checkForWin(Tic.CROSS_TIC));
	}
	
	@Test
	public void testWinWhenWithCrossDiagonalLRTBPattern() {
		fillForSide(0, board.getCellInSquareSize()+1, Tic.CROSS_TIC);
		assertTrue(winningstrategy.checkForWin(Tic.CROSS_TIC));
	}
	
	@Test
	public void testWinWhenWithCrossDiagonalRLTBPattern() {
		fillForSide(board.getCellInSquareSize()-1, board.getCellInSquareSize()-1, Tic.CROSS_TIC);
		assertTrue(winningstrategy.checkForWin(Tic.CROSS_TIC));
	}
	
	@Test
	public void testWinWhenNoPattern2() {
		fillForSide(0, board.getCellInSquareSize()-1, Tic.CIRCLE_TIC);
		assertFalse(winningstrategy.checkForWin(Tic.CIRCLE_TIC));
	}
	
	@Test
	public void testWinWhenWithCircleTopTicPattern() {
		fillForSide(0, 1, Tic.CIRCLE_TIC);
		assertTrue(winningstrategy.checkForWin(Tic.CIRCLE_TIC));
	}
	
	@Test
	public void testWinWhenWithCircleBottomTicPattern() {
		fillForSide(board.getBoardSize() - board.getCellInSquareSize(), 1, Tic.CIRCLE_TIC);
		assertTrue(winningstrategy.checkForWin(Tic.CIRCLE_TIC));
	}
	
	@Test
	public void testWinWhenWithCircleLeftTicPattern() {
		fillForSide(0, board.getCellInSquareSize(), Tic.CIRCLE_TIC);
		assertTrue(winningstrategy.checkForWin(Tic.CIRCLE_TIC));
	}
	
	@Test
	public void testWinWhenWithCircleRightTicPattern() {
		fillForSide(board.getCellInSquareSize()-1, board.getCellInSquareSize(), Tic.CIRCLE_TIC);
		assertTrue(winningstrategy.checkForWin(Tic.CIRCLE_TIC));
	}
	
	@Test
	public void testWinWhenWithCircleDiagonalLRTBPattern() {
		fillForSide(0, board.getCellInSquareSize()+1, Tic.CIRCLE_TIC);
		assertTrue(winningstrategy.checkForWin(Tic.CIRCLE_TIC));
	}
	
	@Test
	public void testWinWhenWithCircleDiagonalRLTBPattern() {
		fillForSide(board.getCellInSquareSize()-1, board.getCellInSquareSize()-1, Tic.CIRCLE_TIC);
		assertTrue(winningstrategy.checkForWin(Tic.CIRCLE_TIC));
	}	
	
	@After
	public void tearDown() {
		
	}
	
	private Board prepareGameBoard() {
		return new Board(4);
	}
	
	private void fillForSide(int start, int increment, Tic tic) {
		int count = start;
		for(int i=0; i< board.getCellInSquareSize(); i++) {
			board.setTickInCell(count, tic);
			count += increment;
		}
	}
}
