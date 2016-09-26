package pokerBase;

import java.util.Comparator;
import PokerSub.Rank;
import PokerSub.Suit;

public class Card implements Comparable {

	private Suit Suit;
	private Rank Rank;
	private int CardNum;

	public Card(PokerSub.Suit Suit, PokerSub.Rank Rank, int CardNum) {
		super();
		this.Suit = Suit;
		this.Rank = Rank;
		this.CardNum = CardNum;
	}

	public Suit getSuit() {
		return Suit;
	}

	public Rank getRank() {
		return Rank;
	}

	public int getCardNum() {
		return CardNum;
	}

	public static Comparator<Card> CardRank = new Comparator<Card>() {

		public int compare(Card c1, Card c2) {

			int Cno1 = c1.getRank().getiRankNum();
			int Cno2 = c2.getRank().getiRankNum();

			
			return Cno2 - Cno1;

		}
	};

	public int compareTo(Object o) {
		Card c = (Card) o;
		return c.getRank().compareTo(this.getRank());

	}

}