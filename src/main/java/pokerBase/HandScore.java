package pokerBase;

import java.util.ArrayList;
import pokerBase.Card;

public class HandScore {
	private int HandStrength;
	private int HiHand;
	private int LoHand = 0;
	private ArrayList<Card> Kickers = new ArrayList();
	private boolean Natural = true;

	public HandScore() {
	}

	public HandScore(int handStrength, int hiHand, int loHand, ArrayList<Card> kickers) {
		this.HandStrength = handStrength;
		this.HiHand = hiHand;
		this.LoHand = loHand;
		this.Kickers = kickers;
	}

	public int getHandStrength() {
		return this.HandStrength;
	}

	public void setHandStrength(int handStrength) {
		this.HandStrength = handStrength;
	}

	public int getHiHand() {
		return this.HiHand;
	}

	public void setHiHand(int hiHand) {
		this.HiHand = hiHand;
	}

	public int getLoHand() {
		return this.LoHand;
	}

	public void setLoHand(int loHand) {
		this.LoHand = loHand;
	}

	public ArrayList<Card> getKickers() {
		return this.Kickers;
	}

	public void setKickers(ArrayList<Card> kickers) {
		this.Kickers = kickers;
	}

	boolean isNatural() {
		return this.Natural;
	}

	void setNatural(boolean natural) {
		this.Natural = natural;
	}
}
