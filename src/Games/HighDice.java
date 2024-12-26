package src.Games;

import java.util.Random;
import src.User.Profile;
import java.util.Scanner;

public class HighDice implements Games {

    private Profile gamer;
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();


    public HighDice(Profile gamer) {
        this.gamer = gamer;
    }

    @Override
    public String write_rules() {
        return "High Dice Game Rules:\n" +
                "1. The player and the computer roll the dice.\n" +
                "2. The highest roll wins.\n" +
                "3. In case of a tie, the game is replayed.\n" +
                "4. If you win, you earn double the amount you bet.";
    }

    @Override
    public int MuzJoeTax(int bet) {
        double number = Math.random(); // Generates a random number between 0 and 1

        if (number < 0.035) {
            System.out.println("Banana Joe demands a tax");
            int randomNumber1 = random.nextInt(100) + 1;

            int tax = (int) Math.round(randomNumber1 * (bet / 100.0));
            int remaining = bet - tax;

            System.out.println("Tax taken from your deposited money: " + tax);
            System.out.println("Remaining deposited money: " + remaining);

            return remaining;
        } else {
            System.out.println("Banana Joe spared you, no tax this time");
            return bet;
        }
    }

    @Override
    public void play() {
        System.out.println("Welcome to High Dice!");

        boolean playAgain = true;

        while (playAgain) {
            System.out.println(write_rules());
            System.out.println("Your current balance: " + gamer.getCoin());

            // Get the bet amount
            int bet;
            while (true) {
                System.out.println("Enter your bet amount: ");
                bet = scanner.nextInt();
                scanner.nextLine(); // Consume the newline

                if (bet > 0 && bet <= gamer.getCoin()) {
                    break;
                } else {
                    System.out.println("Invalid bet amount! Make sure it's positive and within your balance.");
                }
            }

            // Apply Banana Joe's tax
            bet = MuzJoeTax(bet);

            // Roll the dice
            int playerRoll = random.nextInt(6) + 1; // Dice roll between 1-6
            int computerRoll = random.nextInt(6) + 1;

            System.out.println("You rolled: " + playerRoll);
            System.out.println("Computer rolled: " + computerRoll);

            // Determine the winner
            if (playerRoll > computerRoll) {
                System.out.println("You win!");
                gamer.win_bet(bet * 2);
            } else if (playerRoll < computerRoll) {
                System.out.println("You lose!");
                gamer.lose_bet(bet);
            } else {
                System.out.println("It's a tie! No one wins or loses. Play again.");
                continue; // Replay the game in case of a tie
            }

            // Ask if the player wants to play again
            System.out.println("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.nextLine().trim();

            while (true) {
                if (playAgainInput.equalsIgnoreCase("no")) {
                    playAgain = false;
                    System.out.println("Thank you for playing High Dice! Goodbye.");
                    break;
                } else if (playAgainInput.equalsIgnoreCase("yes")) {
                    break;
                } else {
                    System.out.println("Please enter 'yes' or 'no':");
                    playAgainInput = scanner.nextLine().trim();
                }
            }

        }
    }
}
