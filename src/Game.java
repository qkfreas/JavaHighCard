/**
  * Quinn Freas
  * Final Project: High Card
  * @author: Quinn Freas
  */
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import java.util.ArrayList;

public class Game extends Deck {
	private static int[] dealerCard = null;
	private static int[] currentCard = null;
	private static ImageView currentCardImg;
	private static ImageView dealerCardImg;
	private static int currentID = 0;
	private static int roundsRemaining;
	public static Player player;
	private static GameFiles files;
	private static boolean imageError = false;

// constructor for Game
	Game() {
		player = new Player();
		cardsRemaining = 52;
		roundsRemaining = 13;
// sets default card image
		dealerCardImg = getCardImage();
		currentCardImg = getCardImage();
	}

// establishes a card
	public void setCard() {
		currentCard = new int[3];
	}

// counts win
	public void countWin() {
		player.setWinCount();
	}

// sets the dealer and player cards
// recursion
	public void deal() {
		subtractCard();
		currentID = getCardID(getCardsRemaining());
		currentCard = getCard(getCardsRemaining());
		currentCardImg = getCardImage();

		if (dealerCard == null) {
			subtractRound();
			dealerCard = currentCard;
			dealerCardImg = currentCardImg;
			deal();
		}
	}

// returns the card image
// sets imageError to true if no images can be found
	private ImageView getCardImage() {
		try {
			Image img = new Image("file:../images/deck02/" + (currentID) + ".gif");
			if (img.isError() == true) {
				img = new Image("file:../images/deck02/" + (currentID) + ".bmp");
				if (img.isError() == true) {
					imageError = true;
				}
			}

			ImageView iv = new ImageView();
			iv.setImage(img);
			iv.setFitHeight(150);
			iv.setPreserveRatio(true);
			iv.setSmooth(true);
			iv.setCache(true);

			return iv;
		}
		catch(Exception e) {
			return null;
		}
	}

// returns a Stack Pane with images in the form of a deck
	public ImageView getDeckImage() {
		try {
			Image img = new Image("file:../images/deck02/" + 0 + ".bmp");
			
			if (img.isError() == true) {
				imageError = true;
			}

			ImageView iv = new ImageView();
			iv.setImage(img);
			iv.setFitHeight(150);
			iv.setPreserveRatio(true);
			iv.setSmooth(true);
			iv.setCache(true);

			return iv;
		}
		catch(Exception e) {
			return null;
		}
	}

// returns whether there was an image error
	public boolean getImageError() {
		return imageError;
	}

// returns player card image
	public ImageView getPlayerCardImage() {
		return currentCardImg;
	}

// returns dealer card image
	public ImageView getDealerCardImage() {
		return dealerCardImg;
	}

// determines the winner of the round
	public void getWinner() {

		if (Integer.valueOf(dealerCard[2]) < Integer.valueOf(currentCard[2])) {
			setWinCount();
		}
		else if (Integer.valueOf(dealerCard[2]) == Integer.valueOf(currentCard[2])) {
			setTieCount();
		}
		else
			setLoseCount();
// resets dealer card for next round
		dealerCard = null;
	}

// returns rounds remaining
	public int getRoundsRemaining() {
		return roundsRemaining;
	}

// resets rounds remaining
	public void resetRounds() {
		roundsRemaining = 13;
	}

// sets win count
	private void setWinCount() {
		player.setWinCount();
	}

// set loss count
	private void setLoseCount() {
		player.setLoseCount();
	}

// set tie count
	private void setTieCount() {
		player.setTieCount();
	}

// subtracts one from rounds remaining
	public void subtractRound() {
		roundsRemaining--;
	}

// resets current ID
	public void resetCurrentID() {
		currentID = 0;
	}
}