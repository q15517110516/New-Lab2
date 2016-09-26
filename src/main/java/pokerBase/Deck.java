
package pokerBase;

import java.util.ArrayList;
import java.util.Collections;

import PokerSub.Rank;
import PokerSub.Suit;

public class Deck {

	private ArrayList<Card> deckCards = new ArrayList<Card>();

	public Card drawCard() {
		return this.deckCards.remove(0);
	}

	public Deck() {
		int CardNum = 1;
		for (Suit Suit : Suit.values()) {
			for (Rank Rank : Rank.values()) {
				deckCards.add(new Card(Suit, Rank, CardNum++));
			}
		}
		Collections.shuffle(deckCards);
	}

}