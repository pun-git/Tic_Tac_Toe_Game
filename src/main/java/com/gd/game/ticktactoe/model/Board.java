package com.gd.game.ticktactoe.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
	
	private List<Square> squares ;
	
	public Board(int noOfSquares) {
		squares = new ArrayList<Square>(noOfSquares);
	}
	
	public Tic getCellStatus(int no) {
		return squares.get(no).getTic();
	}
	
	public void setTickInCell(int no, Tic tic) {
		squares.get(no).setTic(tic);
	}
	
	public void reset() {
		squares = new ArrayList<Square>(squares.size());
	}
}
