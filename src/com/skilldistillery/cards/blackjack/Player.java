package com.skilldistillery.cards.blackjack;

import java.util.List;

import com.skilldistillery.cards.Card;

public class Player extends Hand {

	protected Player(List<Card> hand) {
		super(hand);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getHandValue() {
		// TODO Auto-generated method stub
		return 0;
	}

//	Player(List<Card> hand, int playerHandValue) {
//		super(hand, playerHandValue);
//	}
//
//	@Override
//	public int getHandValue() {
//		int lastCards = 0;
//		for (Card card : hand) {
//			handValue += card.getValue();
//			handValue -= lastCards;
//			lastCards = card.getValue();
//			if (isBlackjack()) {
//				System.out.println("BLACKJACK");
//			}
//			if (isBust()) {
//				System.out.println("BUST");
//			}
//		}
//
//		return handValue;
//	}
//
//	public boolean isBlackjack() {
//		boolean blackjack = false;
//		if (handValue == 21) {
//			blackjack = true;
//		}
//		return blackjack;
//	}
//
//	public boolean isBust() {
//		boolean bust = false;
//		if (handValue > 21) {
//			bust = true;
//		}
//		return bust;
//	}
//
//	@Override
//	public String toString() {
//		return "Players value is: " + getHandValue();
//	}

}
