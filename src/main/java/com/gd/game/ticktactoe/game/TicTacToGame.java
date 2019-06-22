package com.gd.game.ticktactoe.game;

import com.gd.game.ticktactoe.api.Console;
import com.gd.game.tictactoe.impl.CommandConsole;

public class TicTacToGame {
	
	public static void main(String[] args) {
		Console console = new CommandConsole();
		console.conf();
		console.start();
		console.stop();
	}
}
