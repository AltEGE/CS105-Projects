package src.Games;

import src.User.Profile;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors implements Games {
    private Profile gamer;

    private final Scanner scanner = new Scanner(System.in);
    private final Random random = new Random();

    private final String[] options = {"Rock", "Paper", "Scissors"};
    boolean playAgain = true;

    public RockPaperScissors(Profile gamer) {
        this.gamer = gamer;
    }

    public void winChecker(int bet, String playerChoice, String computerChoice) {
        if (playerChoice.equalsIgnoreCase(computerChoice)) {
            System.out.println("It's a tie!");
        } else if ((playerChoice.equalsIgnoreCase("Rock") && computerChoice.equals("Scissors")) ||
                (playerChoice.equalsIgnoreCase("Paper") && computerChoice.equals("Rock")) ||
                (playerChoice.equalsIgnoreCase("Scissors") && computerChoice.equals("Paper"))) {
            gamer.win_bet(bet * 3);
            System.out.println("You win!");
        } else {
            System.out.println("You lose!");
            gamer.lose_bet(bet);
        }
    }

    @Override
    public String write_rules() {
        return "Rock-Paper-Scissors Game Rules:\n" +
                "1. Rock beats scissors.\n" +
                "2. Paper beats rock.\n" +
                "3. Scissors beats paper.\n" +
                "4. If the player and the computer make the same choice, the game ends in a draw.";
    }

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
        System.out.println("Welcome to RockPaperScissors!");

        while (playAgain) {
            System.out.println(write_rules());
            boolean betCheck = true;
            int bet = 0;
            while (betCheck) {
                System.out.println("Your current budget: "+gamer.getCoin());
                System.out.println("Enter your bet: ");
                bet = scanner.nextInt();
                scanner.nextLine();
                if (bet <= gamer.getCoin()) {
                    betCheck = false;
                } else {
                    System.out.println("Your coin is not enough for that bet !!!");
                }
            }
            bet = MuzJoeTax(bet);
            System.out.println("Enter your choice (Rock, Paper, Scissors): ");
            String playerChoice = scanner.nextLine().trim();
            System.out.println("Your choice" + playerChoice);

            // Validate input
            if (!playerChoice.equalsIgnoreCase("Rock") &&
                    !playerChoice.equalsIgnoreCase("Paper") &&
                    !playerChoice.equalsIgnoreCase("Scissors")) {
                System.out.println("Invalid choice. Please choose Rock, Paper, or Scissors.");
                continue;
            }

            // Computer choice
            String computerChoice = options[random.nextInt(3)];
            System.out.println("Computer chose: " + computerChoice);

            // Determine winner
            this.winChecker(bet, playerChoice, computerChoice);

            // Play again?
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

        //scanner.close();
    }

}
