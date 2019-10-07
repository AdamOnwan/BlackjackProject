package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Deck;

import java.util.*;

public class BlackjackApp {
	private Scanner kb = new Scanner(System.in);
	private List<Card> playerHand = new ArrayList<>();
	private List<Card> dealerHand = new ArrayList<>();
	private Deck deck = new Deck();
	private Hand player = new BlackjackHand(playerHand);
	private Hand dealer = new BlackjackHand(dealerHand);

	public static void main(String[] args) {
		BlackjackApp bja = new BlackjackApp();
		bja.launch();
	}

	private void launch() {
		System.out.println("You see a fresh desk being shuffled by a dealer at a Blackjack table");
		deck.shuffle();
		blackjackGame();
	}

	private void blackjackGame() {
		boolean keepGoing = true;
		int input;
		System.out.println("Dealer says \"Do you want to play some Blackjack?\" (1) yes (2) no");
		input = kb.nextInt();
		if (input == 1) {
			System.out.println(deck.checkDeckSize());
			blackJackStart();

			while (keepGoing) {
				if (player.getHandValue() == 21 || dealer.getHandValue() == 21) {
					keepGoing = false;
					System.out.println("Player has " + player.toString());
					System.out.println("Dealer has " + dealer.toString());
				} else if (player.getHandValue() != 21 || dealer.getHandValue() != 21) {

					System.out.println("What do you want to do");
					System.out.println("(1) check cards ");
					System.out.println("(2) hit  ");
					System.out.println("(3) stay ");
					System.out.println("(4) quit ");
					input = kb.nextInt();
					switch (input) {
					case 0:
						System.out.println("****DEALER DISTRACTED*****");
						deck.inspectCards();
						System.out.println("Dealer hidden card: " + dealerHand.get(0));
					case 1:
						System.out.println("Deck size: " + deck.checkDeckSize());
						System.out.println("Player's cards " + playerHand.toString());
						System.out.println("Dealer's cards " + dealerHand.get(1) + " and a face down card");
						break;
					case 2:
						playerHand.add(deck.dealCard());
						System.out.println("Player draws and" + player.toString());
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
								System.out.println("Dealer draws and" + dealer.toString());
							} while ((dealer.getHandValue() < 17)
									|| (dealer.getHandValue() < 17 && dealerHand.size() < 5));
							keepGoing = false;
						}
						break;
					case 4:
					default:
						System.out.println("Dealer takes your cards and declares himself winner");
						playerHand.clear();
						keepGoing = false;
						break;
					}
				}
			}

			checkWin();
			System.out.println(
					"(1) Ask to play again, (2) Ask to play with fresh deck of cards, (3) Sneak peak at current deck and play again, or any other number to quit");
			input = kb.nextInt();
			if (input == 1) {
				playerHand.clear();
				dealerHand.clear();
				blackjackGame();
			} else if (input == 2) {
				playerHand.clear();
				dealerHand.clear();
				deck.deckReset();
				deck.shuffle();
				blackjackGame();
			} else if (input == 3) {
				playerHand.clear();
				dealerHand.clear();
				deck.inspectCards();
				blackjackGame();
			} else
				System.out.println("Dealer says \"Bye\"");
		}
		else 
			System.out.println("Dealer says \"Bye\"");
	}

	private void checkWin() {
		if (player.getHandValue() < 22 && dealer.getHandValue() > 21) {
			System.out.println("Player's hand value: " + player.getHandValue() + " Dealer's hand value: " + dealer.getHandValue());
			System.out.println("Dealer says \"Player wins! Dealer BUST!!\" ");
		} else if (player.getHandValue() > dealer.getHandValue() && player.getHandValue() < 22) {
			System.out.println("Player's hand value: " + player.getHandValue() + " Dealer's hand value: " + dealer.getHandValue());
			System.out.println("Dealer says \"Player wins!\"");
		} else if (player.getHandValue() > 21) {
			System.out.println("Player's cards were: " + player.toString());
			System.out.println("Dealer's cards were: face down card and " + dealer.toString());
			System.out.println("Dealer says \"Player BUST!!, you DID NOT win\"");
		} else if (player.getHandValue() < dealer.getHandValue() && dealer.getHandValue() < 22) {
			System.out.println("Player's hand value: " + player.getHandValue() + " Dealer's hand value: " + dealer.getHandValue());
			System.out.println("Player's hand: " + playerHand.toString());
			System.out.println("Dealer's hand: " + dealerHand.toString());
			System.out.println("Dealer says \"Player DID NOT win\"");
		} else if (player.getHandValue() == dealer.getHandValue()) {
			System.out.println("Player's hand value: " + player.getHandValue() + " Dealer's hand value: " + dealer.getHandValue());
			System.out.println("Dealer say's \"Player and Dealer tie/push\"");
		}
	}

	private void blackJackStart() {
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
