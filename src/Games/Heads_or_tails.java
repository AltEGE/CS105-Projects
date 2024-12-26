package src.Games;

import java.util.Random;
import src.User.Profile;
import java.util.Scanner;

public class Heads_or_tails implements Games {

    private Profile gamer;
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();


    public Heads_or_tails(Profile gamer) {
        this.gamer = gamer;
    }

    @Override
    public String write_rules() {
        return "Heads or Tails Game Rules:\n" +
                "1. Choose the amount you want to bet.\n" +
                "2. Predict heads or tails.\n" +
                "3. If your prediction is correct, you win double your bet.\n" +
                "4. If your prediction is wrong, you lose your bet.";
    }

    @Override
    public int MuzJoeTax(int bet) {
        double number = Math.random();

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
        System.out.println("Welcome to Heads or Tails!");

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

            System.out.print("Make your prediction (1 for Heads, 2 for Tails): ");
            int prediction = scanner.nextInt();

            if (prediction != 1 && prediction != 2) {
                System.out.println("Invalid choice! Please choose 1 (Heads) or 2 (Tails). Restarting the round.");
                continue;
            }

            double number = Math.random();
            String result;

            if (number <= 48){
                result="Heads";

            }

            else if (number >= 48 && number <= 96) {
                result = "Tails";
            }

            else{
                System.out.println("Secret Status Upright Arrived !!!!");
                result = "Upright";
            }


            System.out.println("Result: " + result);

            if ((prediction == 1 && result.equals("Heads")) || (prediction == 2 && result.equals("Tails"))) {
                System.out.println("Congratulations! You guessed correctly. You win double your bet.");
                gamer.win_bet(bet * 2);
            }

            else if (result.equals("Upright")) {
                System.out.println("You have won 3 times your bet");
                gamer.win_bet(bet * 3);

            }
            else {
                System.out.println("Sorry, your guess was wrong. You lose your bet.");
                gamer.lose_bet(bet);
            }

            scanner.nextLine();
            System.out.println("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.nextLine().trim();

            while (true) {
                if (playAgainInput.equalsIgnoreCase("no")) {
                    playAgain = false;
                    System.out.println("Thank you for playing Heads or Tails! Goodbye.");
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

