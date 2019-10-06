package com.skilldistillery.cards.blackjack;

import java.util.*;

import com.skilldistillery.cards.Card;

public abstract class Hand {
	protected List<Card> hand = new ArrayList<Card>();

	protected Hand(List<Card> hand) {
		super();
		this.hand = hand;
	}

	public void addCard(Card card) {
		hand.add(card);
	}

	public void clear() {
		hand.clear();
	}

	public abstract int getHandValue();

	@Override
	public String toString() {
		return "Hand [hand=" + hand + "]";
	}
}