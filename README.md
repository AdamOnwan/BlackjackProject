### Overview
This program simulates a game of Blackjack
### How to run
#### Installation
1. Copy the package and paste it into your own eclipse instance
2. Ensure the class and package names match
3. Click Run Java Application
#### Using the app
1. The game starts out asking if you would like to play some Blackjack
2. If yes, both the player and dealer is dealt 2 cards.
3. Then the game checks to see if anyone has a Blackjack or bust.
4. Next it asks the player to check cards, hit, stay, or quit
5. If check card, that will just show the cards on the table. If hit the player is dealt another
card. If stay, the dealer draws cards until they get card value 17 or higher. Quit just ends game with dealer telling the person what would have happened with the current cards.
6. After player either wins or loses, the game goes to the next switch and asks if the player would like to play again, use another deck of cards, sneak peak at the current deck, or quit the game.
7. Play again restarts the game with current deck of cards, play with another deck refreshes the deck, sneak peak is a cheat code which allows for looking at the cards in the current deck, and quit terminates the game.

### Technologies/topics used
1. Packages, this was used to sort the card classes from the Blackjack classes, so that
in the future, if making something else that uses cards like Poker, I can easily find the
files related to cards.
2. Objects, such as the cards are taken from a deck object, has a suit, and rank. Then communicating through the application to the hand object which is what the player or dealer has in their hand, and the Blackjack hand object being specific to the particular type of game, which is Blackjack.
3. Constructors, used to allow objects to do certain things, like print out information
4. Encapsulation, used to hide private or protect parts of data
5. Inheritance, used to build upon a class using inherited methods so that it is quick and easy to make something new that is going to do the same things. Such as a hand holding cards, all I had to do was make a blackjack hand inheriting the class, Hand, for a blackjack game.
6. Polymorphism, used by converting a Hand of cards to a BlackjackHand of cards, since, it is a card game of Blackjack.
7. Array list along with list interface, was used to store the deck and the hand of cards.
8. Enumerated Types, was used to define a fix set of constants such as suits and ranks of cards.


### Lessons learned
1.  A good portion of the difficulty was trying to go off a current UML or start expanding it, I originally chose to expand it by making a player extend blackjack hand, but decided to just get it working with the current UML given to me.
2. Very annoying to me is making methods in BlackjackHand and for some reason I cannot figure out why its not allowing me to call upon those methods, such as isBlackjack. So I just put those methods into the ToString before it does the return, so it checks if the booleans are true.
3. Learned how to play Blackjack and that there is a lot of if statements to the game.
4. Feel as if I'm getting better at understanding objects and arrays from struggling with this project.
