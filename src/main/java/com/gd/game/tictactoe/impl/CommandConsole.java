package com.gd.game.tictactoe.impl;

import java.util.Scanner;

import com.gd.game.ticktactoe.api.Console;
import com.gd.game.ticktactoe.api.Game;
import com.gd.game.ticktactoe.builder.GameBuilder;
import com.gd.game.ticktactoe.exception.InvalidMoveException;
import com.gd.game.ticktactoe.model.Board;
import com.gd.game.ticktactoe.model.Move;
import com.gd.game.ticktactoe.model.Player;
import com.gd.game.ticktactoe.model.Result;
import com.gd.game.ticktactoe.model.Status;
import com.gd.game.ticktactoe.model.Tic;

public class CommandConsole implements Console{
	
	private Player player1;
	private Player player2;
	private Game game;
	private Scanner scanner;
	private Board board;
	
	@Override
	public void conf() {
		System.out.println("============Welcome to Tic Tac Toe==============");
		System.out.println("Please let me know the board size");
		
		try {
			scanner = new Scanner(System.in);
			String size = scanner.nextLine();
			System.out.println("Do you want to play with ");
			System.out.println("1. Human");
			System.out.println("2. Machine");
			
			String option = scanner.nextLine();
			
			player1 = playWithHuman(scanner);
			
			while(true) {
				switch (option) {
				case "1":
					player2 = playWithHuman(scanner);
					break;
				case "2":
					player2 = playWithMachine();
					break;
				default:
					break;
				}
				if(player1.getSelectedTic() == player2.getSelectedTic()) {
					System.out.println("Tic "+player1.getSelectedTic()+" is already selected");
				}else {
					break;
				}
			}
			
			game = buildGame(Integer.parseInt(size));
		}finally {
			
		}
	}
	
	@Override
	public void start() {
		int i = 1;
		Result result;
		board.display(System.out);
		while(true) {
			try {
				if((i & 1) == 1) {
					System.out.println(player1.getName()+" - ");
					result = game.move(new Move(player1, player1.selectNextCell(board))).get();
				}else {
					System.out.println(player2.getName()+" - ");
					result = game.move(new Move(player2, player2.selectNextCell(board))).get();
				}
				System.out.flush();
				board.display(System.out);
				if(result.getGameStatus() == Status.WIN) {
					System.out.println(result.getLastPlayer().getName() + " won the game");
					break;
				} else if(result.getGameStatus() == Status.TIE) {
					System.out.println("Hey its a tie");
					break;
				}
				System.out.flush();
				i++;
			}catch(InvalidMoveException e) {
				System.out.println("Invalid move");
			}
		}
		
	}
	
	@Override
	public void stop() {	
		scanner.close();
	}
	
	private Player playWithHuman(Scanner scanner) {
		System.out.println("Enter player name");
		String playerName = scanner.nextLine();
		System.out.println("Enter Tick symbol (O or X)");
		while(true) {
			try {
				String tic = scanner.nextLine();
				return new Player(playerName, Tic.valueOf(tic.toUpperCase()), (b) -> {return nextCellByHuman();});
			}catch(IllegalArgumentException e) {
				System.out.println("Tic symbol O or X supported");
			}
		}
	}
	
	private Player playWithMachine() {
		return new Player("Human", (player1.getSelectedTic() == Tic.X)?Tic.O : Tic.X, (b) -> {return nextCellByMachine();});
	}

	private int nextCellByHuman() {
		System.out.println("Cell No");
		
		while(true) {
			try {
				String cellNo = scanner.nextLine();
				return Integer.valueOf(cellNo);
			}catch(NumberFormatException e) {
				System.out.println("Invalid Cell No");
			}
		}
	}
	
	private int nextCellByMachine() {
		System.out.println("Cell No");
		return Integer.valueOf(scanner.nextLine());
	}
	
	private Game buildGame(int size) {
		board = new Board(size);
		return new GameBuilder().addBoardSideSize(size).
		buildBoard(board).		
		buildWinningStrategy(StrategyForWin.class).
		buildTieStrategy(StrategyForTie.class).
		buildGame();
	}
}
