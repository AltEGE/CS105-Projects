package DataBases;

import Clothes.*;
import User.Profile;

import java.util.ArrayList;

public class GameBuilder {
    DataLoader dataLoader = new DataLoader();
    
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

        this.profile = dataLoader.getProfile();
        this.inventory_ids = dataLoader.getInventoryIds();

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
