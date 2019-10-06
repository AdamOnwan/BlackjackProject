package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Deck;

import java.util.*;

public class BlackjackApp {
	Scanner kb = new Scanner(System.in);
	private List<Card> playerHand = new ArrayList<>();
	private List<Card> dealerHand = new ArrayList<>();
	private Deck deck = new Deck();
	private Hand player = new BlackjackHand(playerHand);
	private Hand dealer = new BlackjackHand(dealerHand);

	public static void main(String[] args) {
		BlackjackApp bja = new BlackjackApp();
		bja.launch();
	}

	public void launch() {
		blackjackGame();
	}

	public void blackjackGame() {
		boolean keepGoing = true;
		int input;
		System.out.println(deck.checkDeckSize());
		deck.shuffle();
		blackJackStart();

		while (keepGoing) {
			if (player.getHandValue() == 21 || dealer.getHandValue() == 21) {
				keepGoing = false;
				System.out.println("Player has " + player.toString());
				System.out.println("Dealer has " + dealer.toString());
			} else if (player.getHandValue() != 21 || dealer.getHandValue() != 21) {

				System.out.println("What do you want to do");
				System.out.println("(1) check stats ");
				System.out.println("(2) hit  ");
				System.out.println("(3) stay ");
				System.out.println("(4) quit game ");
				input = kb.nextInt();
				switch (input) {
				case 1:
					System.out.println("Deck size: " + deck.checkDeckSize());
					System.out.println("Player's cards " + playerHand.toString());
					System.out.println("Dealer's cards " + dealerHand.get(1) + " and a face down card");
					break;
				case 2:
					playerHand.add(deck.dealCard());
					System.out.println("Player draws and " + player.toString());
					if (player.getHandValue() > 20 || playerHand.size() > 4) {
						keepGoing = false;
					}
					break;
				case 3:
					if (dealer.getHandValue() > 16) {
						keepGoing = false;
					} else if (dealer.getHandValue() < 17) {
						do {
							dealerHand.add(deck.dealCard());
							System.out.println("Dealer draws and " + dealer.toString());
						} while ((dealer.getHandValue() < 17) || (dealer.getHandValue() < 17 && dealerHand.size() < 5));
						keepGoing = false;
					}
					break;

				default:
					keepGoing = false;
					break;
				}
			}
		}
		checkWin();
		System.out.println("Press 1 to play again or any other number to quit");
		input = kb.nextInt();
		if (input == 1) {
			playerHand.clear();
			dealerHand.clear();
			blackjackGame();
		} else
			System.out.println("Bye");
	}

	public void checkWin() {
		System.out.println(
				"Player's hand value: " + player.getHandValue() + " Dealer's hand value: " + dealer.getHandValue());
		if (player.getHandValue() < 22 && dealer.getHandValue() > 21) {
			System.out.println("Player wins! Dealer BUST");
		} else if (player.getHandValue() > dealer.getHandValue() && player.getHandValue() < 22) {
			System.out.println("Player wins!");
		} else if (player.getHandValue() > 21) {
			System.out.println("Player BUST, you DID NOT win");
		} else if (player.getHandValue() < dealer.getHandValue() && dealer.getHandValue() < 22) {
			System.out.println("Player's hand " + playerHand.toString() + "\ndealer's hand " + dealerHand.toString());
			System.out.println("Player DID NOT win");
		}
	}

	public void blackJackStart() {
		for (int i = 0; i < 2; i++) {
			playerHand.add(deck.dealCard());
			System.out.println("Dealer gives player card, and player's" + player.toString());
			dealerHand.add(deck.dealCard());
			System.out.println("Dealer gives himself a card");
		}
		System.out.println("Dealer's keeps one of his cards face down and shows the: " + dealerHand.get(1));
		System.out.println("You notice \nYour card value is: " + player.getHandValue()
				+ ", and the dealer's card value is: " + dealer.hand.get(1).getValue() + " plus a face down card");
	}

}
