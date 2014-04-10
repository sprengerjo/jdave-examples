package de.sprengerj.jdave.game.connectfour;

import static org.hamcrest.Matchers.*;
import jdave.Specification;
import jdave.junit4.JDaveRunner;

import org.junit.runner.RunWith;

@RunWith(JDaveRunner.class)
public class WinAlgorithmTest extends Specification<WinAlgorithm> {

	public class GameTest {

		private WinAlgorithm algo;

		public WinAlgorithm create() {
			return algo = new WinAlgorithm();
		}

		public void initialScoreMustBeZero() {
			Game game = new Game();
			specify(algo.wins(game), is(true));
		}

	}
}
