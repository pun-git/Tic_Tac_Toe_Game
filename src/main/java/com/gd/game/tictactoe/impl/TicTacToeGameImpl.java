package com.gd.game.tictactoe.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import com.gd.game.ticktactoe.api.Game;
import com.gd.game.ticktactoe.api.Strategy;
import com.gd.game.ticktactoe.exception.CellAlreadyMarkedException;
import com.gd.game.ticktactoe.exception.InvalidCellException;
import com.gd.game.ticktactoe.exception.InvalidMoveException;
import com.gd.game.ticktactoe.model.Board;
import com.gd.game.ticktactoe.model.Move;
import com.gd.game.ticktactoe.model.Player;
import com.gd.game.ticktactoe.model.Result;
import com.gd.game.ticktactoe.model.Status;

public class TicTacToeGameImpl implements Game {
	
	private Board board;
	private Strategy strategyForWin;
	private Strategy strategyForTie;
	private List<Move> gameHistory = new LinkedList<>();
	
	public TicTacToeGameImpl(Board board, Strategy strategyForWin, Strategy strategyForTie) {
		this.board = board;
		this.strategyForWin = strategyForWin;
		this.strategyForTie = strategyForTie;
	}
	
	@Override
	public Optional<Result> move(Move move) throws InvalidMoveException{
		makeMove(move);
		recordGameHistory(move);
		return Optional.of(buildResult(move.getPlayer()));
	}
	
	private void makeMove(Move move) throws InvalidMoveException {
		try {
			validateMove(move);
			board.markCellWithTic(move.getCellNo(), move.getPlayer().getSelectedTic());
		}catch(CellAlreadyMarkedException| InvalidCellException e) {
			throw new InvalidMoveException(e.getMessage());
		}
	}
	
	
	private void validateMove(Move move) throws InvalidMoveException{
		if(checkForTie()) {
			throw new InvalidMoveException("Game is a tie");
		}else if(checkForWin()) {
			throw new InvalidMoveException("Game is a win");
		}
	}
	
	private void recordGameHistory(Move move) {
		gameHistory.add(move);
	}
	
	private Result buildResult(Player lastPlayer) {
		return new Result(lastPlayer, buildStatus(lastPlayer));
	}
	
	private Status buildStatus(Player lastPlayer) {
		boolean won = checkForWin();
		return (won)? Status.WIN : ((checkForTie())?Status.TIE:Status.ACTIVE);
	}
	
	private boolean checkForWin() {
		return strategyForWin.check();
	}
	
	private boolean checkForTie() {
		return strategyForTie.check();
	}
	
}
