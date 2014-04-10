package de.sprengerj.jdave.game;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameOfLife {

	private List<Point> data;

	public List<Point> neighbours() {
		List<Point> result = new ArrayList<Point>();
		for (Point point : data) {
			result.addAll(neighbours(point));
		}
		
		return result;
	}

	private List<Point> neighbours(Point point) {
		List<Point> result = new ArrayList<Point>();
		int [] inc = new int []{-1, 0, 1};
		for (int x : inc) {
			for (int y : inc) {
			result.add(new Point(point.x + x, point.y + y));
			}
		}
		return result;
	}

	public void setPattern(List<Point> data) {
		this.data = data;
	}

	public List<Point> nextGeneration() {
		return Collections.emptyList();
	}

}
