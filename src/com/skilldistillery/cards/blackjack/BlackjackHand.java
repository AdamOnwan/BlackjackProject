package com.skilldistillery.cards.blackjack;

import java.util.List;

import com.skilldistillery.cards.Card;

public class BlackjackHand extends Hand {

	protected BlackjackHand(List<Card> hand) {
		super(hand);
	}

	@Override
	public int getHandValue() {
		int handValue = 0;
//		int faceDownValue = handValue;
//		if (handValue == 0) { System.out.println("Card face down"); }
//		int lastCards = 0;
		for (Card card : hand) {
			handValue += card.getValue();
//			handValue -= lastCards;
//			lastCards = card.getValue();
		
		}
		return handValue;
	}

	public boolean isBlackjack() {
		boolean blackjack = false;
		if (getHandValue() == 21 && hand.size() == 2) {
			blackjack = true;
		}
		return blackjack;
	}

	public boolean isBust() {
		boolean bust = false;
		if (getHandValue() > 21) {
			bust = true;
		}
		return bust;
	}

	@Override
	public String toString() {
		
		return " hand is: " + hand + " value: " + getHandValue();
	}

	public List<Card> dealerHand() {
		for (int i = 1; i < hand.size(); i++) {
			System.out.println(hand);
		}
		return hand;
	}

}
