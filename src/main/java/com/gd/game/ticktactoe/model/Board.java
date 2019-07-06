package com.gd.game.ticktactoe.model;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.gd.game.ticktactoe.exception.CellAlreadyMarkedException;
import com.gd.game.ticktactoe.exception.InvalidCellException;

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
	
	public void markCellWithTic(int no, Tic tic) throws CellAlreadyMarkedException, InvalidCellException{
		validate(no);
		squares.get(no).setTic(tic);
	}
	
	public int getBoardSize() {
		return squares.size();
	}
	
	public int getCellInSquareSize() {
		return cellInSquareSize;
	}
	
	public void reset() {
		squares.clear();
		init(cellInSquareSize);
	}
	
	public void display(OutputStream out) {
		int count = 0;
		try(PrintWriter writer = new PrintWriter(out)){
			String print = "";
			for(int i=0 ; i < cellInSquareSize ; i++) {
				for(int j=0 ; j < cellInSquareSize ; j++) {
					if(squares.get(count).getTic() != Tic.N) {
						print += "   " + squares.get(count ++);
					}else {
						print += "   " + count++;
					}
				}
				writer.println(print);
				print = "";
			}
			writer.flush();
		}
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
	
	private void validate(int noOfCell)  throws CellAlreadyMarkedException, InvalidCellException{
		if(noOfCell < 0 || squares.size() - 1 < noOfCell) {
			throw new InvalidCellException("Invalid Cell No");
		}
		if(squares.get(noOfCell).getTic() != Tic.N) {
			throw new CellAlreadyMarkedException("Cell already marked");
		}
	}
}
