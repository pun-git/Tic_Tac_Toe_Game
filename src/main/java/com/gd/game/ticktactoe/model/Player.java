package com.gd.game.ticktactoe.model;

import com.gd.game.ticktactoe.api.CellSelectionStrategy;

public class Player {
	
	private String name;
	private Tic selectedTic;	
	private CellSelectionStrategy cellSelectionStrategy;
	
	public Player(String name, Tic selectedTic, CellSelectionStrategy cellSelectionStrategy) {
		this.name = name;
		this.selectedTic = selectedTic;
		this.cellSelectionStrategy = cellSelectionStrategy;
	}
	
	public String getName() {
		return name;
	}
	
	public Tic getSelectedTic() {
		return selectedTic;
	}
	
	public int selectNextCell(Board board) {
		return cellSelectionStrategy.nextSelectedCell(board);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(! (obj instanceof Player)) {
			return false;
		}
		Player ticTacToePlayerImpl = (Player)obj;
		return (this.getName().equals(ticTacToePlayerImpl.getName()));
	}
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	
	public String toString() {
		return name+","+selectedTic;
	}

}
