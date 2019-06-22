package com.gd.game.ticktactoe.api;

import java.util.Optional;

import com.gd.game.ticktactoe.exception.InvalidMoveException;
import com.gd.game.ticktactoe.model.Move;
import com.gd.game.ticktactoe.model.Result;

public interface Game {
	Optional<Result> move(Move move) throws InvalidMoveException;
}
