/**
  * Quinn Freas
  * Final Project: High Card
  * @author: Quinn Freas
  */

import java.util.ArrayList;

public class Player {
	private static int win = 0, lose = 0, tie = 0;

// constructor
	Player() {
		win = 0;
		lose = 0;
		tie = 0;
	}

// adds one to win
	public void setWinCount() {
		win++;
	}

// adds one to lose
	public void setLoseCount() {
		lose++;
	}

// adds one to tie
	public void setTieCount() {
		tie++;
	}

// returns win
	public int getWin() {
		return win;
	}

// returns lose
	public int getLoss() {
		return lose;
	}

// returns tie
	public int getTie() {
		return tie;
	}
}