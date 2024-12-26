package src.DataBases;

import src.Clothes.*;
import src.User.Profile;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class GameBuilder {
    DataLoader dataLoader = new DataLoader();
    Scanner scanner = new Scanner(System.in);
    
    ArrayList<Abstract_Clothes> all_game_clothes = new ArrayList<>();
    
    Hat hat = new Hat(35, "Red" , 1);
    Skirt skirt = new Skirt (80, "Pink", 2);
    Pant pant =  new Pant (85, "Blue", 3);
    Tshirt tshirt = new Tshirt (75, "Yellow", 4);
    Glasses glasses = new Glasses(35,"Black" , 5);
    Shoe shoe = new Shoe (100, "Green", 6);
    Glove glove = new Glove (30, "Orange", 7);


    private Store store = new Store();
    private Profile profile;
    private ArrayList inventory_ids;

    public GameBuilder(){
        all_game_clothes.add(hat);
        all_game_clothes.add(skirt);
        all_game_clothes.add(pant);
        all_game_clothes.add(tshirt);
        all_game_clothes.add(glasses);
        all_game_clothes.add(shoe);
        all_game_clothes.add(glove);

        File f = new File("src/DataBases/profiles.txt");

        if(f.exists()){
            dataLoader.loadData();
            this.profile = dataLoader.getProfile();
            this.inventory_ids = dataLoader.getInventoryIds();
        } else {
            System.out.print("Nickname : ");
            String nickname = scanner.nextLine();

            System.out.print("Gender (male or female): ");
            String gender = scanner.nextLine();

            System.out.println("Welcome " + nickname + "\n"
                                + "You have earned 100 coins as a welcome gift");
            System.out.println("-------------------------------------");
            this.profile = new Profile(nickname, gender, 100);
            this.inventory_ids = profile.getInventory().get_inventory_ids();
        }


        for (Abstract_Clothes c : all_game_clothes){
            if (inventory_ids.contains(c.getID())){
                this.profile.add_clothes(c);
            } else {
                this.store.add_list(c);
            }
        }

    }

    public Store getStore() {return this.store;}
    public Profile getProfile() {return this.profile;}

}
