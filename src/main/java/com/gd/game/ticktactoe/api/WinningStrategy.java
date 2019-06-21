package com.gd.game.ticktactoe.api;

import com.gd.game.ticktactoe.model.Tic;

public interface WinningStrategy {

	public boolean checkForWin(Tic tic);
	
}
