package com.gd.game.ticktactoe.model;

public class Square {

	private int no;
	private Tic tic = Tic.NOTIC;
	
	public Square(int no) {
		this.no = no;
	}
	
	public void setTic(Tic tic) {
		this.tic = tic;
	}
	
	public int getNo() {
		return no;
	}
	
	public Tic getTic() {
		return tic;
	}
	
	@Override
	public String toString() {
		return tic.toString();
	}
	
}
