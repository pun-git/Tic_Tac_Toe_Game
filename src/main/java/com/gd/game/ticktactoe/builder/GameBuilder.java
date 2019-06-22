package com.gd.game.ticktactoe.builder;

import java.lang.reflect.InvocationTargetException;

import com.gd.game.ticktactoe.api.Game;
import com.gd.game.ticktactoe.api.Strategy;
import com.gd.game.ticktactoe.model.Board;
import com.gd.game.tictactoe.impl.TicTacToeGameImpl;

public class GameBuilder {

	private int sideOfSquare ;
	private Class<?> winningStrategy;
	private Class<?> tieStrategy;
	private Board board;
	
	public GameBuilder addBoardSideSize(int sideSizeOfSquare) {
		this.sideOfSquare = sideSizeOfSquare;
		return this;
	}
	
	public GameBuilder buildWinningStrategy(Class<?> winningStrategy) {
		this.winningStrategy = winningStrategy;
		return this;
	}
	
	public GameBuilder buildTieStrategy(Class<?> tieStrategy) {
		this.tieStrategy = tieStrategy;
		return this;
	}
	
	public Game buildGame() {
		validate();
		return new TicTacToeGameImpl(board, buildWinningStrategy(), buildTieStrategy());
	}

	public GameBuilder buildBoard(Board board) {
		this.board = board;
		return this;
	}
	
	public void buildBoard() {
		board = new Board(sideOfSquare);
	}
	
	private Strategy buildWinningStrategy() {
		try {
			return (Strategy)winningStrategy.getConstructor(Board.class).newInstance(board);
		}catch(NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
			throw new RuntimeException("Can not instantiate winning strategy object, "+ e.getMessage());
		}
	}
	
	private Strategy buildTieStrategy() {
		try {
			return (Strategy)tieStrategy.getConstructor(Board.class).newInstance(board);
		}catch(NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
			throw new RuntimeException("Can not instantiate tie strategy object, "+ e.getMessage());
		}
	}
	
	private void validate() {
		if(sideOfSquare <= 0) {
			throw new IllegalArgumentException("Board is a square and size must be greater than 1");
		}
	}
	
}
