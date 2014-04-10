package de.sprengerj.jdave.game;

import jdave.Specification;
import jdave.junit4.JDaveRunner;

import org.junit.runner.RunWith;

import de.sprengerj.jdave.game.Game;

@RunWith(JDaveRunner.class)
public class GameTestCase extends Specification<Game> {

	public class SimpleGame {

		private Game game;

		public Game create() {
			return game = new Game();
		}

		public void initialScoreMustBeZero() {
			specify(game.score(), must.equal(0));
		}

		public void oneRollsScoring0MustBeZero() {
			game.roll(0);
			specify(game.score(), must.equal(0));
		}
		
		public void twentyRollsScoring0MustBeZero() {
			rollMany(20, 0);
			specify(game.score(), must.equal(0));
		}

		public void twentyRollsScoring1MustBe29() {
			rollMany(20, 1);
			specify(game.score(), must.equal(20));
		}

		public void spareBonusMustBeAdded() {
			game.roll(5);
			game.roll(5);
			rollMany(18, 1);
			specify(game.score(), must.equal(5+5+1+18*1));
		}

		public void strikeBonusMustBeAdded() {
			game.roll(10);
			rollMany(18, 1);
			specify(game.score(), must.equal(10+1+1+18*1));
		}

		private void rollMany(int rolls, int pins) {
			for (int i = 0; i < rolls; i++) {
				game.roll(pins);
			}
		}
	}
}
