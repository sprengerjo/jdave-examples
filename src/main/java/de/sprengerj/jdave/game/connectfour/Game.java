package de.sprengerj.jdave.game.connectfour;

public class Game {

	private int[] field = new int [7];

	public void playerOnePut(int i) {
		field [i] += 1; 
	}
	public void playerTwoPut(int i) {
		field [i] += 1; 
	}

	public int score(int i) {
		return field [i];
	}
	public int lastPutted() {
		return 4;
	}


}
