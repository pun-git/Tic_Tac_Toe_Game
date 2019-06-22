package com.gd.game.ticktactoe.api;

import com.gd.game.ticktactoe.model.Board;

@FunctionalInterface
public interface CellSelectionStrategy {
	
	int nextSelectedCell(Board board);

}
