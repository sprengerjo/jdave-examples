package de.sprengerj.jdave.game.connectfour;

import static org.junit.Assert.*;

import org.junit.Test;

import jdave.Specification;
import jdave.junit4.JDaveRunner;

import org.junit.runner.RunWith;

@RunWith(JDaveRunner.class)
public class GameTest extends Specification<Game> {

	public class EmptyGame {

		private Game game;
		
		public Game create() {
			return game = new Game();
		}

		public void initialScoreMustBeZero() {
			specify(game.score(4), must.equal(0));
		}

		public void playerOnePutsScoreMustBe1() {
			game.playerOnePut(4);
			specify(game.score(4), must.equal(1));
		}

		public void playerOneAndTwoPutsScoreMustBe1() {
			game.playerOnePut(4);
			game.playerTwoPut(4);
			specify(game.score(4), must.equal(2));
		}

		public void playerOneWins() {
			game.playerOnePut(4);
			game.playerOnePut(4);
			game.playerOnePut(4);
			game.playerOnePut(4);
			specify(game.score(4), must.equal(4));
		}

		
		public void lastPutedMustBe4() {
			game.playerOnePut(4);
			specify(game.lastPutted(), must.equal(4));
		}
	}
}
