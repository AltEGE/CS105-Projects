import src.Bank.Bank;
import src.Clothes.*;
import src.DataBases.DataLoader;
import src.DataBases.DataSaver;
import src.DataBases.GameBuilder;
import src.Games.*;
import src.User.Profile;

import java.security.cert.CertStoreSpi;
import java.util.Scanner;

public class Main {
    public static void exit() {
        System.out.println("Goodbye!");
        System.exit(0);
    }

    public static void playGameMenu(Scanner scanner, Profile profile){
        System.out.println("Game Menu : \n"
                + "1 - Rock Paper Scissors\n"
                + "2 - Heads or Tails\n"
                + "3 - High Dice\n"
                + "4 - Roulette\n"
                + "5 - Wheel\n"
                + "6 - Find the Lady\n"
                + "7 - Blackjack\n"
                + "0 - Back Main Menu\n"
        );

        System.out.print("Please enter the tab you want to go to: ");
        int option = scanner.nextInt();
        System.out.println("--------------------------------------------------------");

        switch(option){
            case 1:
                Games game1 = new RockPaperScissors(profile);
                game1.play();
                break;
            case 2:
                Games game2 = new Heads_or_tails(profile);
                game2.play();
                break;
            case 3:
                Games game3 = new HighDice(profile);
                game3.play();
                break;
            case 4:
                Games game4 = new Roulette(profile);
                game4.play();
                break;
            case 5:
                Games game5 = new Wheel(profile);
                game5.play();
                break;
            case 6:
                Games game6 = new Follow_the_lady(profile);
                game6.play();
                break;
            case 7:
                Games game7 = new Blackjack(profile);
                game7.play();
                break;
            case 0:
                System.out.println("Returning to the main menu...");
                return;
            default:
                System.out.println("Invalid option. Please select a valid option.");
        }
    }
    public static void mainMenu(Scanner scanner, Profile profile, Store store, Bank bank){
        System.out.println("Main Menu : \n"
                        + "1 - Visit Inventory\n"
                        + "2 - Visit Store\n"
                        + "3 - Change Clothes\n"
                        + "4 - Play Game\n"
                        + "5 - Bank\n"
                        + "0 - Exit\n"
        );

        System.out.print("Please enter the tab you want to go to: ");
        int option = scanner.nextInt();
        System.out.println("--------------------------------------------------------");

        switch(option){
            case 0:
                DataSaver data_saver = new DataSaver();
                data_saver.save(profile);
                data_saver.save(store);
                exit();
                break;
            case 1:
                profile.display_clothes();
                break;
            case 2:
                store.visit_store(profile);
                break;
            case 3:
                profile.wear_clothes();
                break;
            case 4:
                playGameMenu(scanner, profile);
                break;
            case 5:
                bank.run();
                break;
        }
    }

    public static void main(String[] args) {

        DataSaver data_saver = new DataSaver();
        GameBuilder game_builder = new GameBuilder();

        Profile profile = game_builder.getProfile();
        Store store = game_builder.getStore();
        Bank bank = new Bank(profile);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Banana Republic");
        while(true){
            mainMenu(scanner, profile, store, bank);
        }



    }

}
