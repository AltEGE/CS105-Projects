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
    public void play() {
        System.out.println("Welcome to RockPaperScissors!");

        while (playAgain) {
            // Player choice
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


            System.out.println("Enter your choice (Rock, Paper, Scissors): ");
            String playerChoice = scanner.nextLine().trim();

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
            if (!playAgainInput.equalsIgnoreCase("yes")) {
                playAgain = false;
                System.out.println("Thank you for playing!");
            }
        }

        //scanner.close();
    }

}
