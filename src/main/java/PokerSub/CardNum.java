package PokerSub;

public enum CardNum {

	FirstCard(0), SecondCard(1), ThirdCard(2), FourthCard(3), FifthCard(4);
	
	private CardNum(final int CardNum){
		this.CardNum = CardNum;
	}

	private int CardNum;
	
	public int getCardNum(){
		return CardNum;
	}
	
}