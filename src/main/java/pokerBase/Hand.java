package pokerBase;

import PokerSub.CardNum;
import PokerSub.HandStrength;
import PokerSub.Rank;
import PokerSub.Suit;
import java.util.ArrayList;
import java.util.Collections;
import pokerBase.Card;
import pokerBase.HandScore;

public class Hand {
	private ArrayList<Card> CardsInHand = new ArrayList();

	private ArrayList<Card> getCardsInHand() {
		return this.CardsInHand;
	}

	public void evalHand() {
		Collections.sort(this.CardsInHand);
	}

	private static boolean isHandFlush(ArrayList<Card> cards) {
		boolean bIsFlush = true;
		int i = 0;
		while (i <= cards.size()) {
			if (cards.get(i).getSuit() != cards.get(i + 1).getSuit()) {
				return false;
			}
			++i;
		}
		return bIsFlush;
	}

	private static boolean isStraight(ArrayList<Card> cards) {
		boolean bIsStraight = true;
		int i = 0;
		while (i <= cards.size()) {
			if (cards.get(i).compareTo(cards.get(i + 1)) != -1) {
				return false;
			}
			++i;
		}
		return bIsStraight;
	}

	public static boolean isHandRoyalFlush(Hand h, HandScore hs) {
		boolean isRoyalFlush = false;
		int suit = h.getCardsInHand().get(CardNum.FirstCard.getCardNum()).getSuit().getiSuitNum();
		if (h.getCardsInHand().get(CardNum.FirstCard.getCardNum()).getRank().getiRankNum() == 10
				&& h.getCardsInHand().get(CardNum.FifthCard.getCardNum()).getRank().getiRankNum() == 14
				&& suit == h.getCardsInHand().get(CardNum.FifthCard.getCardNum()).getSuit().getiSuitNum()
				&& h.getCardsInHand().get(CardNum.SecondCard.getCardNum()).getSuit().getiSuitNum() == suit
				&& h.getCardsInHand().get(CardNum.ThirdCard.getCardNum()).getSuit().getiSuitNum() == suit
				&& h.getCardsInHand().get(CardNum.FourthCard.getCardNum()).getSuit().getiSuitNum() == suit
				&& h.getCardsInHand().get(CardNum.FirstCard.getCardNum()).getRank().getiRankNum() < h.getCardsInHand()
						.get(CardNum.SecondCard.getCardNum()).getRank().getiRankNum()
				&& h.getCardsInHand().get(CardNum.SecondCard.getCardNum()).getRank().getiRankNum() < h.getCardsInHand()
						.get(CardNum.ThirdCard.getCardNum()).getRank().getiRankNum()
				&& h.getCardsInHand().get(CardNum.ThirdCard.getCardNum()).getRank().getiRankNum() < h.getCardsInHand()
						.get(CardNum.FourthCard.getCardNum()).getRank().getiRankNum()
				&& h.getCardsInHand().get(CardNum.FourthCard.getCardNum()).getRank().getiRankNum() < h.getCardsInHand()
						.get(CardNum.FifthCard.getCardNum()).getRank().getiRankNum()) {
			isRoyalFlush = true;
		}
		return isRoyalFlush;
	}

	public static boolean isHandStraightFlush(Hand h, HandScore hs) {
		boolean CheckFlush = Hand.isHandFlush(h.getCardsInHand());
		boolean CheckStraight = Hand.isStraight(h.getCardsInHand());
		boolean isStraightFlush = CheckFlush && CheckStraight;
		return isStraightFlush;
	}

	public static boolean isHandFourOfAKind(Hand h, HandScore hs) {
		boolean isFourOfAKind = false;
		if (h.getCardsInHand().get(CardNum.FirstCard.getCardNum()).getRank() == h.getCardsInHand()
				.get(CardNum.FourthCard.getCardNum()).getRank()) {
			isFourOfAKind = true;
			hs.setHandStrength(HandStrength.FourOfAKind.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(CardNum.FirstCard.getCardNum()).getRank().getiRankNum());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(CardNum.FifthCard.getCardNum()));
			hs.setKickers(kickers);
		} else if (h.getCardsInHand().get(CardNum.SecondCard.getCardNum()).getRank() == h.getCardsInHand()
				.get(CardNum.FifthCard.getCardNum()).getRank()) {
			isFourOfAKind = true;
			hs.setHandStrength(HandStrength.FourOfAKind.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(CardNum.SecondCard.getCardNum()).getRank().getiRankNum());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(CardNum.FirstCard.getCardNum()));
			hs.setKickers(kickers);
		}
		return isFourOfAKind;
	}

	public static boolean isHandFullHouse(Hand h, HandScore hs) {
		boolean isFullHouse = false;
		if (h.getCardsInHand().get(CardNum.FirstCard.getCardNum()).getRank() == h.getCardsInHand()
				.get(CardNum.ThirdCard.getCardNum()).getRank()
				&& h.getCardsInHand().get(CardNum.FourthCard.getCardNum()).getRank() == h.getCardsInHand()
						.get(CardNum.FifthCard.getCardNum()).getRank()) {
			isFullHouse = true;
			hs.setHandStrength(HandStrength.FullHouse.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(CardNum.FirstCard.getCardNum()).getRank().getiRankNum());
			hs.setLoHand(0);
		} else if (h.getCardsInHand().get(CardNum.FirstCard.getCardNum()).getRank() == h.getCardsInHand()
				.get(CardNum.SecondCard.getCardNum()).getRank()
				&& h.getCardsInHand().get(CardNum.ThirdCard.getCardNum()).getRank() == h.getCardsInHand()
						.get(CardNum.FifthCard.getCardNum()).getRank()) {
			isFullHouse = true;
			hs.setHandStrength(HandStrength.TwoPair.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(CardNum.ThirdCard.getCardNum()).getRank().getiRankNum());
			hs.setLoHand(0);
		}
		return isFullHouse;
	}

	public static boolean isHandFlush(Hand h, HandScore hs) {
		boolean bIsFlush = false;
		int i = 0;
		if (i < 5) {
			if (h.getCardsInHand().get(i).getSuit() != h.getCardsInHand().get(i + 1).getSuit()) {
				bIsFlush = true;
				hs.setHandStrength(HandStrength.Flush.getHandStrength());
				hs.setHiHand(h.getCardsInHand().get(CardNum.FifthCard.getCardNum()).getRank().getiRankNum());
				hs.setLoHand(0);
				ArrayList<Card> kickers = new ArrayList<Card>();
				kickers.add(h.getCardsInHand().get(CardNum.FifthCard.getCardNum()));
				hs.setKickers(kickers);
			}
			return false;
		}
		return bIsFlush;
	}

	public static boolean isHandStraight(Hand h, HandScore hs) {
		boolean bIsStraight = false;
		int i = 0;
		if (i < 4) {
			if (h.getCardsInHand().get(i).getRank() != h.getCardsInHand().get(i + 1).getRank()) {
				bIsStraight = true;
				hs.setHandStrength(HandStrength.Straight.getHandStrength());
				hs.setHiHand(h.getCardsInHand().get(CardNum.FifthCard.getCardNum()).getRank().getiRankNum());
				hs.setLoHand(0);
				ArrayList<Card> kickers = new ArrayList<Card>();
				kickers.add(h.getCardsInHand().get(CardNum.FirstCard.getCardNum()));
				hs.setKickers(kickers);
			}
			return bIsStraight;
		}
		return bIsStraight;
	}

	public static boolean isHandThreeOfAKind(Hand h, HandScore hs) {
		boolean isThreeOfAKind = false;
		if (h.getCardsInHand().get(CardNum.FirstCard.getCardNum()).getRank() == h.getCardsInHand()
				.get(CardNum.ThirdCard.getCardNum()).getRank()) {
			isThreeOfAKind = true;
			hs.setHandStrength(HandStrength.ThreeOfAKind.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(CardNum.FirstCard.getCardNum()).getRank().getiRankNum());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(CardNum.FourthCard.getCardNum()));
			kickers.add(h.getCardsInHand().get(CardNum.FifthCard.getCardNum()));
			hs.setKickers(kickers);
		} else if (h.getCardsInHand().get(CardNum.SecondCard.getCardNum()).getRank() == h.getCardsInHand()
				.get(CardNum.FourthCard.getCardNum()).getRank()) {
			isThreeOfAKind = true;
			hs.setHandStrength(HandStrength.ThreeOfAKind.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(CardNum.SecondCard.getCardNum()).getRank().getiRankNum());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(CardNum.FirstCard.getCardNum()));
			kickers.add(h.getCardsInHand().get(CardNum.FifthCard.getCardNum()));
			hs.setKickers(kickers);
		} else if (h.getCardsInHand().get(CardNum.ThirdCard.getCardNum()).getRank() == h.getCardsInHand()
				.get(CardNum.FifthCard.getCardNum()).getRank()) {
			isThreeOfAKind = true;
			hs.setHandStrength(HandStrength.ThreeOfAKind.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(CardNum.ThirdCard.getCardNum()).getRank().getiRankNum());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(CardNum.FifthCard.getCardNum()));
			kickers.add(h.getCardsInHand().get(CardNum.SecondCard.getCardNum()));
			hs.setKickers(kickers);
		}
		return isThreeOfAKind;
	}

	public static boolean isHandTwoPair(Hand h, HandScore hs) {
		boolean isTwoPair = false;
		if (h.getCardsInHand().get(CardNum.FirstCard.getCardNum()).getRank() == h.getCardsInHand()
				.get(CardNum.SecondCard.getCardNum()).getRank()
				&& h.getCardsInHand().get(CardNum.ThirdCard.getCardNum()).getRank() == h.getCardsInHand()
						.get(CardNum.FourthCard.getCardNum()).getRank()) {
			isTwoPair = true;
			hs.setHandStrength(HandStrength.TwoPair.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(CardNum.FirstCard.getCardNum()).getRank().getiRankNum());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(CardNum.FifthCard.getCardNum()));
			hs.setKickers(kickers);
		} else if (h.getCardsInHand().get(CardNum.SecondCard.getCardNum()).getRank() == h.getCardsInHand()
				.get(CardNum.ThirdCard.getCardNum()).getRank()
				&& h.getCardsInHand().get(CardNum.FourthCard.getCardNum()).getRank() == h.getCardsInHand()
						.get(CardNum.FifthCard.getCardNum()).getRank()) {
			isTwoPair = true;
			hs.setHandStrength(HandStrength.TwoPair.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(CardNum.SecondCard.getCardNum()).getRank().getiRankNum());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(CardNum.FirstCard.getCardNum()));
			hs.setKickers(kickers);
		} else if (h.getCardsInHand().get(CardNum.FirstCard.getCardNum()).getRank() == h.getCardsInHand()
				.get(CardNum.SecondCard.getCardNum()).getRank()
				&& h.getCardsInHand().get(CardNum.FourthCard.getCardNum()).getRank() == h.getCardsInHand()
						.get(CardNum.FifthCard.getCardNum()).getRank()) {
			isTwoPair = true;
			hs.setHandStrength(HandStrength.TwoPair.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(CardNum.FirstCard.getCardNum()).getRank().getiRankNum());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(CardNum.ThirdCard.getCardNum()));
			hs.setKickers(kickers);
		}
		return isTwoPair;
	}

	public static boolean isHandPair(Hand h, HandScore hs) {
		boolean isPair = false;
		if (h.getCardsInHand().get(CardNum.FirstCard.getCardNum()).getRank() == h.getCardsInHand()
				.get(CardNum.SecondCard.getCardNum()).getRank()) {
			isPair = true;
			hs.setHandStrength(HandStrength.Pair.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(CardNum.FirstCard.getCardNum()).getRank().getiRankNum());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(CardNum.ThirdCard.getCardNum()));
			kickers.add(h.getCardsInHand().get(CardNum.FourthCard.getCardNum()));
			kickers.add(h.getCardsInHand().get(CardNum.FifthCard.getCardNum()));
			hs.setKickers(kickers);
		} else if (h.getCardsInHand().get(CardNum.SecondCard.getCardNum()).getRank() == h.getCardsInHand()
				.get(CardNum.ThirdCard.getCardNum()).getRank()) {
			isPair = true;
			hs.setHandStrength(HandStrength.Pair.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(CardNum.SecondCard.getCardNum()).getRank().getiRankNum());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(CardNum.FirstCard.getCardNum()));
			kickers.add(h.getCardsInHand().get(CardNum.FourthCard.getCardNum()));
			kickers.add(h.getCardsInHand().get(CardNum.FifthCard.getCardNum()));
			hs.setKickers(kickers);
		} else if (h.getCardsInHand().get(CardNum.ThirdCard.getCardNum()).getRank() == h.getCardsInHand()
				.get(CardNum.FourthCard.getCardNum()).getRank()) {
			isPair = true;
			hs.setHandStrength(HandStrength.Pair.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(CardNum.ThirdCard.getCardNum()).getRank().getiRankNum());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(CardNum.FirstCard.getCardNum()));
			kickers.add(h.getCardsInHand().get(CardNum.SecondCard.getCardNum()));
			kickers.add(h.getCardsInHand().get(CardNum.FifthCard.getCardNum()));
			hs.setKickers(kickers);
		} else if (h.getCardsInHand().get(CardNum.FourthCard.getCardNum()).getRank() == h.getCardsInHand()
				.get(CardNum.FifthCard.getCardNum()).getRank()) {
			isPair = true;
			hs.setHandStrength(HandStrength.Pair.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(CardNum.FourthCard.getCardNum()).getRank().getiRankNum());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(CardNum.FirstCard.getCardNum()));
			kickers.add(h.getCardsInHand().get(CardNum.SecondCard.getCardNum()));
			kickers.add(h.getCardsInHand().get(CardNum.ThirdCard.getCardNum()));
			hs.setKickers(kickers);
		}
		return isPair;
	}

	public static boolean isHandHighCard(Hand h, HandScore hs) {
		hs.setHandStrength(HandStrength.HighCard.getHandStrength());
		hs.setHiHand(h.getCardsInHand().get(CardNum.FirstCard.getCardNum()).getRank().getiRankNum());
		hs.setLoHand(0);
		ArrayList<Card> kickers = new ArrayList<Card>();
		kickers.add(h.getCardsInHand().get(CardNum.SecondCard.getCardNum()));
		kickers.add(h.getCardsInHand().get(CardNum.ThirdCard.getCardNum()));
		kickers.add(h.getCardsInHand().get(CardNum.FourthCard.getCardNum()));
		kickers.add(h.getCardsInHand().get(CardNum.FifthCard.getCardNum()));
		hs.setKickers(kickers);
		return true;
	}
}
