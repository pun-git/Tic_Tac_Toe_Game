package com.gd.game.ticktactoe.api;

import com.gd.game.ticktactoe.exception.CellAlreadyMarkedException;
import com.gd.game.ticktactoe.exception.InvalidCellException;
import com.gd.game.ticktactoe.model.Board;

public interface Game {
	
	void addPlayer(String playerName);
	void addBoard(Board board);
	void move(Player player, int noOfCell) throws CellAlreadyMarkedException, InvalidCellException;
	boolean won();

}
