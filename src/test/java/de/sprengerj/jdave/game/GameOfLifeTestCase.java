package de.sprengerj.jdave.game;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jdave.Specification;
import jdave.junit4.JDaveRunner;

import org.junit.runner.RunWith;

import de.sprengerj.jdave.game.GameOfLife;

@RunWith(JDaveRunner.class)
public class GameOfLifeTestCase extends Specification<GameOfLife> {

	public class ZeroGame {

		private GameOfLife game;
		private List<Point> data = new ArrayList<Point>();
		
		public GameOfLife create() {
			game = new GameOfLife();
			game.setPattern(data);
			return game;
		}

		public void neighboursMustBeValid() {
			specify(game.neighbours(), 
					must.containExactly(Collections.emptyList()));
		}

		public void worldAfterNIteratonsMustBeEmpty() {
			specify(game.nextGeneration(), 
					must.containExactly(Collections.emptyList()));
		}
	}

	public class OneCellGame {
		
		private GameOfLife game;
		private List<Point> data = new ArrayList<Point>();
		
		public GameOfLife create() {
			data.add(new Point(1, 1));
			game = new GameOfLife();
			game.setPattern(data);
			return game;
		}
		
		public void neighboursMustBeValid() {
			List<Point> expected = new ArrayList<Point>();
			expected.add(new Point(0, 1));
			expected.add(new Point(0, 1));
			expected.add(new Point(0, 1));
			expected.add(new Point(0, 1));
			expected.add(new Point(0, 1));
			expected.add(new Point(0, 1));
			specify(game.neighbours(), 
					must.containExactly(expected));
		}
		
	}
}
