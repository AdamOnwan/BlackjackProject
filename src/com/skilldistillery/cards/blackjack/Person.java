package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cards.Card;

public class Person {
	private List<Card> personHand = new ArrayList<>();
	private Hand player = new BlackjackHand(personHand);

	public Person(List<Card> personHand, Hand player) {
		super();
		this.personHand = personHand;
		this.player = player;
	}
	public List<Card> getPersonHand() {
		return personHand;
	}
	public void setPersonHand(List<Card> personHand) {
		this.personHand = personHand;
	}
	public Hand getPlayer() {
		return player;
	}
	public void setPlayer(Hand player) {
		this.player = player;
	}
	@Override
	public String toString() {
		return "Person [personHand=" + personHand + ", player=" + player + "]";
	}
	
}
