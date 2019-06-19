package com.gd.game.tictactoe;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gd.game.ticktactoe.api.WinningStrategy;
import com.gd.game.ticktactoe.model.Board;
import com.gd.game.tictactoe.impl.WinningStrategyImpl;

public class WinningStrategyImplTest 
{
	private WinningStrategy winningstrategy;
	
	@Before
	public void setUp() {
		winningstrategy = new WinningStrategyImpl(prepareGameBoard());
	}
	
	@Test
	public void testWinWhenNoPatternThere() {
		assertFalse(winningstrategy.checkForWin());
	}
	
	@Test
	public void testWinWhenWithCrossTicPattern() {
		assertTrue(winningstrategy.checkForWin());
	}
	
	@Test
	public void testWinWhenWithCircleTicPattern() {
		assertTrue(winningstrategy.checkForWin());
	}
	
	@After
	public void tearDown() {
		
	}
	
	private Board prepareGameBoard() {
		return new Board(4);
	}
	
}
