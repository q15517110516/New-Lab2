package PokerSub;

public enum Suit {

	Hearts(1), Spades(2), Clubs(3), Diamonds(4);
	
	
	private int iSuitNum;

	private Suit(int iSuitNum) {
		this.iSuitNum = iSuitNum;
	}

	public int getiSuitNum() {
		return iSuitNum;
	}
	
	
}