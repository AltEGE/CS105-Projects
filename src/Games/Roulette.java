package src.Games;

import java.util.ArrayList;
import java.util.Random;
import src.User.Profile;
import java.util.Scanner;

public class Roulette implements Games {

    private Profile gamer;
    private ArrayList<String> bets = new ArrayList<>();
    private ArrayList<Integer> amounts = new ArrayList<>();
    private String color;
    private String result;
    private String range;
    private int totalBet;
    private int totalWin;
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

    public Roulette(Profile gamer) {
        this.gamer = gamer;
    }

    @Override
    public String write_rules() {
        return "Roulette Game Rules:\n" +
                "1. Place a bet on a number (0-36), color (Red/Black/Green), or range (1-12, 13-24, 25-36).\n" +
                "2. If your color guess is correct, you win 2x your bet.\n" +
                "3. If your range guess is correct, you win 3x your bet.\n" +
                "4. If your number guess is correct, you win 36x your bet.";
    }

    private void spin_wheel() {
        int number = random.nextInt(37); // Random number between 0 and 36

        // Determine the color
        if (number == 0) {
            this.color = "Green";
        } else if (number % 2 == 0) {
            this.color = "Red";
        } else {
            this.color = "Black";
        }

        this.result = String.valueOf(number);

        // Determine the range
        if (number >= 1 && number <= 12) {
            this.range = "1-12";
        } else if (number >= 13 && number <= 24) {
            this.range = "13-24";
        } else if (number >= 25 && number <= 36) {
            this.range = "25-36";
        } else {
            this.range = "0";
        }

        System.out.println("Wheel result: " + result + " (" + color + "), Range: " + range);
    }

    @Override
    public int MuzJoeTax(int bet) {
        System.out.println("No tax is applied in Roulette.");
        System.out.println("Regards to Banana Joe");
        return bet;
    }

    @Override
    public void play() {
        System.out.println("Welcome to Roulette!");

        boolean playAgain = true;

        while (playAgain) {
            System.out.println(write_rules());

            bets.clear();
            amounts.clear();
            totalBet = 0;
            totalWin = 0;

            System.out.println("---------------------------------");
            System.out.println("Your current balance: " + gamer.getCoin());
            System.out.println("---------------------------------");

            while(true){

                System.out.print("Please choose where to place your bet (Number/Color/Range): ");
                String bet = scanner.nextLine();
                System.out.print("Enter your bet amount: ");
                int betAmount = scanner.nextInt();

                if (betAmount > gamer.getCoin()){
                    System.out.println("Your coin is not enough for that bet !!!");
                    continue;
                }


                scanner.nextLine();

                bets.add(bet);
                amounts.add((int) betAmount);
                totalBet += betAmount;

                System.out.print("Enter 'y' to place another bet, or any other key to spin the wheel: ");
                String moreBets = scanner.nextLine();
                if (!moreBets.equalsIgnoreCase("y")) {
                    break;
                }
            }

            System.out.println("\nLet the game begin!");
            spin_wheel();

            for (int i = 0; i < bets.size(); i++) {
                String bet = bets.get(i);
                int betAmount = amounts.get(i);

                if (bet.equalsIgnoreCase(color)) {
                    totalWin += betAmount * 2;
                }

                if (bet.equalsIgnoreCase(range)) {
                    totalWin += betAmount * 3;
                }

                if (bet.equals(result)) {
                    totalWin += betAmount * 36;
                    gamer.win_bet(betAmount* 36);
                }
            }

            System.out.println();

            if (totalWin > 0) {
                System.out.println("Congratulations! You won " + totalWin + "!");
                gamer.win_bet(totalWin);
            } else {
                System.out.println("Sorry, no winnings this time.");
            }



        }


    }
}
