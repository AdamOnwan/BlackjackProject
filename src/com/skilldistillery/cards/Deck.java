package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

public class Deck {

	private List<Card> cards;

	public Deck() {
		cards = new ArrayList<>();
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				cards.add(new Card(suit, rank));
			}
		}
	}

	public int checkDeckSize() {
		return cards.size();
	}

	public Card dealCard() {
		return cards.remove(0);
	}

	public void shuffle() {
		Collections.shuffle(cards);
	}
	public void deckReset() {
		cards = new ArrayList<>();
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				cards.add(new Card(suit, rank));
			}
		}
	}
	public void inspectCards() {
		for (Card card : cards) {
			System.out.println(card.toString());
		}
	}
}
