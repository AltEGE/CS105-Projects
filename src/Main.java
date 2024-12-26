
import src.Clothes.*;
import src.DataBases.DataLoader;
import src.DataBases.DataSaver;
import src.DataBases.GameBuilder;
import src.Games.Games;
import src.Games.RockPaperScissors;
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
                        + " 1 - Rock Paper Scissors !\n"
                        + " 0 - Back Main Menu\n"
        );

        int option = scanner.nextInt();
        switch(option){
            case 1:
                Games game = new RockPaperScissors(profile);
                game.play();
                break;
        }
    }
    public static void mainMenu(Scanner scanner, Profile profile, Store store){
        System.out.println("Main Menu : \n"
                        + "1 - Visit Inventory\n"
                        + "2 - Visit Store\n"
                        + "3 - Change Clothes\n"
                        + "4 - Play Game\n"
                        + "0 - Exit\n"
        );

        int option = scanner.nextInt();
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
        }
    }

    public static void main(String[] args) {

        DataSaver data_saver = new DataSaver();
        GameBuilder game_builder = new GameBuilder();

        Profile profile = game_builder.getProfile();
        Store store = game_builder.getStore();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Banana Republic");
        while(true){
            mainMenu(scanner, profile, store);
        }



    }

}