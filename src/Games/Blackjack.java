package src.Games;

import java.util.Random;
import src.User.Profile;
import java.util.Scanner;
import src.Games.Deck;
public class Blackjack implements Games {

    private Profile gamer;
    private Deck deck = new Deck();
    private Scanner scanner = new Scanner(System.in);

    // Constructor
    public Blackjack(Profile gamer) {
        this.gamer = gamer;
    }

    @Override
    public String write_rules() {
        return "Blackjack Rules:\n" +
                "1. Your goal is to have a card total closest to 21 without exceeding it.\n" +
                "2. Card values: 2-10 as face value, J/Q/K as 10 points, and A as 1 or 11.\n" +
                "3. Choose 'Hit' to draw a card or 'Stand' to stop drawing.\n" +
                "4. Dealer draws cards until reaching 17 or higher.\n" +
                "5. A Blackjack (21) pays 3x your bet.";
    }

    @Override
    public int MuzJoeTax(int bet) {
        System.out.println("No tax is applied in Blackjack.");
        System.out.println("Regards to Banana Joe");
        return bet;
    }

    @Override
    public void play() {
        System.out.println("Welcome to Blackjack!");
        System.out.println(write_rules());
        deck.shuffleDeck();

        while (true) {
            System.out.println("---------------------------------");
            System.out.println("Your current balance: " + gamer.getCoin());
            System.out.println("---------------------------------");

            // Get the bet amount
            System.out.print("Enter your bet amount: ");
            int bet = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            if (bet < 0 || bet > gamer.getCoin()) {
                System.out.println("Invalid bet amount. Try again.");
                continue;
            }

            bet = MuzJoeTax(bet);

            // Initial card dealing
            deck.dealCard(deck.getPlayer());
            deck.dealCard(deck.getPlayer());
            deck.dealCard(deck.getDealer());
            deck.dealCard(deck.getDealer());

            deck.showCards();

            while (deck.calculateHandValue(deck.getPlayer()) < 21) {
                System.out.println("1. Hit (Draw a card)\n2. Stand (Stop drawing)");
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice == 1) {
                    deck.dealCard(deck.getPlayer());
                    deck.calculateValue();
                    deck.showCards();

                    if (deck.calculateHandValue(deck.getPlayer()) > 21) {
                        System.out.println("Bust! You exceeded 21. The dealer wins.");
                        gamer.lose_bet(bet);
                        break;
                    }
                } else if (choice == 2) {
                    break;
                } else {
                    System.out.println("Invalid choice! Please select 1 or 2.");
                }
            }

            if (deck.calculateHandValue(deck.getPlayer()) <= 21) {
                System.out.println("Revealing the dealer's cards:");
                deck.showFinalCards();

                while (deck.calculateHandValue(deck.getDealer()) < 17) {
                    deck.dealCard(deck.getDealer());
                    deck.calculateValue();
                    deck.showFinalCards();
                }

                // Determine the outcome
                int playerValue = deck.calculateHandValue(deck.getPlayer());
                int dealerValue = deck.calculateHandValue(deck.getDealer());

                if (playerValue == 21 && dealerValue != 21) {
                    System.out.println("Blackjack! You win.");
                    gamer.win_bet(bet * 3);
                } else if (dealerValue > 21 || playerValue > dealerValue) {
                    System.out.println("You win!");
                    gamer.win_bet(bet * 2);
                } else if (playerValue == dealerValue) {
                    System.out.println("It's a draw! Your bet is returned.");
                } else {
                    System.out.println("The dealer wins!");
                    gamer.lose_bet(bet);
                }
            }

            // Ask if the player wants to play again
            System.out.print("\nPress 'q' to quit, or any other key to play again: ");
            String continueGame = scanner.nextLine().trim();
            if (continueGame.equalsIgnoreCase("q")) {
                System.out.println("Thank you for playing Blackjack! Goodbye.");
                break;
            }

            if (deck.hasSufficientCards()) {
                System.out.println("Shuffling the deck.");
                deck.shuffleDeck();
            }
        }
    }
}
