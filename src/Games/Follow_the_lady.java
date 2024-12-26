package src.Games;

import java.util.Random;
import src.User.Profile;
import java.util.Scanner;

public class Follow_the_lady implements Games {

    private Profile gamer;
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();


    public Follow_the_lady(Profile gamer) {
        this.gamer = gamer;
    }

    @Override
    public String write_rules() {
        return "Follow the Lady Game Rules:\n" +
                "1. Try to find the 'Lady' card among three cards.\n" +
                "2. The cards are shuffled, and you are asked to guess the position of the 'Lady' card.\n" +
                "3. If you guess correctly, you win 2 times your bet.\n" +
                "4. If you guess incorrectly, you lose your bet.";
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
        System.out.println("Welcome to Follow the Lady!");

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

            bet = MuzJoeTax(bet);

            int ladyPosition = random.nextInt(3) + 1; // Random position between 1 and 3

            System.out.println("Shuffling the cards...");
            System.out.println("1-2-3"); //
            System.out.print("Which position do you think the 'Lady' card is in? (1/2/3): ");
            int guess = scanner.nextInt();

            if (guess == ladyPosition) {
                System.out.println("Congratulations! You guessed correctly. The 'Lady' card was in position " + ladyPosition + ".");
                gamer.win_bet(bet * 2);
            } else {
                System.out.println("Sorry! Wrong guess. The 'Lady' card was in position " + ladyPosition + ".");
                gamer.lose_bet(bet);
            }

            scanner.nextLine();
            System.out.println("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.nextLine().trim();

            while (true) {
                if (playAgainInput.equalsIgnoreCase("no")) {
                    playAgain = false;
                    System.out.println("Thank you for playing Follow the Lady! Goodbye.");
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
