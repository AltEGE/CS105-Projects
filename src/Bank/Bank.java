package src.Bank;

import src.User.Profile;

import java.util.Scanner;

public class Bank {
    private Profile profile;
    public Bank(Profile profile) {
        this.profile = profile;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your starting coin amount: ");
        double coin = scanner.nextDouble();
        int[] coinPrices = {50, 100, 150, 200, 250, 300, 350, 400, 450};
        int[] coinAmounts = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        boolean continueProgram = true;

        while (continueProgram) {
            System.out.println("\n--- Banana Republic ---");
            System.out.println("Coins: " + profile.getCoin());
            System.out.println("Coin Transactions:");
            for (int i = 0; i < coinPrices.length; i++) {
                System.out.println((i + 1) + ".  Banana Coin - Price: " + coinPrices[i] + ", Amount: " + coinAmounts[i]);
            }
            System.out.println((coinPrices.length + 1) + ". Return");
            System.out.println((coinPrices.length + 2) + ". Flash Banana Joe Credit");
            System.out.println((coinPrices.length + 3) + ". Banana Republic Joe State Bank");
            System.out.print("Please make your selection: ");

            int choice = readSelection(scanner);

            if (choice >= 1 && choice <= coinPrices.length) { // Coin Purchase
                int price = coinPrices[choice - 1];
                int amount = coinAmounts[choice - 1];

                if (profile.getCoin() >= price) {
                    profile.setCoin(profile.getCoin() - price);
                    System.out.println("Successfully purchased " + amount + " Banana Coins. Remaining Coins: " + profile.getCoin());
                } else {
                    System.out.println("Insufficient coins! Please reload your coins.");
                }
            } else if (choice == coinPrices.length + 1) {
                System.out.println("Returning...");
                continueProgram = false;
            } else if (choice == coinPrices.length + 2) {
                flashBananaJoeCredit(scanner, profile);
            } else if (choice == coinPrices.length + 3) {
                bananaRepublicBank();
            } else {
                System.out.println("Invalid selection! Please try again.");
            }
        }
        scanner.close(); // Close the Scanner instance
    }

    // Reading user selection
    public int readSelection(Scanner scanner) {
        System.out.print("Please enter your selection: ");
        while (!scanner.hasNextInt()) { // Check if input is a valid integer
            System.out.println("Invalid input! Please enter a valid number.");
            scanner.next(); // Clear invalid input
        }
        return scanner.nextInt();
    }

    // Flash Banana Joe Credit
    public void flashBananaJoeCredit(Scanner scanner, Profile profile) {
        double interestRate = 2.0; // Interest rate 200%

        System.out.println("\n=== Flash Banana Joe Credit ===");
        System.out.print("Enter the desired credit amount: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input! Please enter a valid number.");
            scanner.next(); // Clear invalid input
        }
        double principal = scanner.nextDouble();

        System.out.print("How many months will you pay back?: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input! Please enter a valid number.");
            scanner.next(); // Clear invalid input
        }
        int term = scanner.nextInt();

        double totalPayment = principal * (1 + interestRate) * term;

        System.out.println("Total Amount to be Paid: " + totalPayment + " Coins");
        System.out.println("[1] Confirm");
        System.out.println("[2] Cancel");
        System.out.print("Please make your selection: ");

        int choice = readSelection(scanner);
        if (choice == 1) {
            profile.setCoin(profile.getCoin() + principal);
            System.out.println("Credit approved! Coins added: " + principal + ". Returning to main menu.");
        } else {
            System.out.println("Credit operation canceled. Returning to main menu.");
        }
    }

    // Banana Republic Bank
    public void bananaRepublicBank() {
        System.out.println("\n=== Banana Republic Joe State Bank ===");
        System.out.println("No other banks exist in this country.");
        System.out.println("According to Banana Republic laws, all financial transactions are conducted here.");
        System.out.println("Returning to main menu...");
    }
}
