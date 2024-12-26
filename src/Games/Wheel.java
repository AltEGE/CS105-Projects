package src.Games;

import java.util.Random;
import src.User.Profile;
import java.util.Scanner;

public class Wheel implements Games {

    private Profile gamer;
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

    private double[] cak_guvenli = {1, 2, 2, 3, 3, 1, 1, 0, 0, 0};
    private double[] cak_orta = {0, 0, 1, 1, 1, 0, 2, 0, 4, 5};
    private double[] cak_riskli = {0, 0, 2, 0, 21, 0, 1, 0, 0, 13};

    // Constructor
    public Wheel(Profile gamer) {
        this.gamer = gamer;
    }

    @Override
    public String write_rules() {
        return "Wheel Game Rules:\n" +
                "1. Choose the amount of money to bet.\n" +
                "2. Select a wheel based on risk level (Safe, Medium, or Risky).\n" +
                "3. Spin the wheel and see your results!";
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
        System.out.println("Welcome to the Wheel Game!");

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

            // Select the wheel
            System.out.println("1. Safe Wheel\n2. Medium Wheel\n3. Risky Wheel");
            System.out.print("Choose a wheel (1 for Safe, 2 for Medium, 3 for Risky): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            double[] selectedWheel;
            switch (choice) {
                case 1:
                    selectedWheel = cak_guvenli;
                    break;
                case 2:
                    selectedWheel = cak_orta;
                    break;
                case 3:
                    selectedWheel = cak_riskli;
                    break;
                default:
                    System.out.println("Invalid choice, defaulting to Safe Wheel.");
                    selectedWheel = cak_guvenli;
                    break;
            }

            // Spin the wheel
            int index = random.nextInt(selectedWheel.length);
            double result = selectedWheel[index];

            System.out.println("Wheel result: " + result);

            if (result > 1) {
                System.out.println("You win: " + (bet * result) + "!");
                gamer.win_bet((int) (bet * result));
            }

            else if (result == 1) {
                System.out.println("You got what you gave. Good luck.");

            } else {
                System.out.println("You lose your bet.");
                gamer.lose_bet(bet);
            }

            // Ask if the player wants to play again
            System.out.println("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.nextLine().trim();

            while (true) {
                if (playAgainInput.equalsIgnoreCase("no")) {
                    playAgain = false;
                    System.out.println("Thank you for playing the Wheel Game! Goodbye.");
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
