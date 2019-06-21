package com.gd.game.ticktactoe.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
	
	private List<Square> squares ;
	private int cellInSquareSize ;
	
	public Board(int size) {
		init(size);
		cellInSquareSize = size;
	}
	
	public Tic getCellStatus(int no) {
		return squares.get(no).getTic();
	}
	
	public void setTickInCell(int no, Tic tic) {
		squares.get(no).setTic(tic);
	}
	
	public int getBoardSize() {
		return squares.size();
	}
	
	public int getCellInSquareSize() {
		return cellInSquareSize;
	}
	
	public void reset() {
		squares = new ArrayList<Square>(squares.size());
	}
	
	private void init(int size) {
		squares = new ArrayList<Square>(size*size);
		int count = 0;
		for(int i = 0; i<size ; i++) {
			for(int j = 0; j<size ; j++) {
				squares.add(new Square(count++));
			}
		}
	}
	
	@Override
	public String toString() {
		int count = 0;
		String print = "";
		for(int i=0 ; i < cellInSquareSize ; i++) {
			for(int j=0 ; j < cellInSquareSize ; j++) {
				print += squares.get(count ++);
			}
			print+=" \n";
		}
		return print;
	}
}
