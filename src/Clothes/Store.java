package Clothes;

import User.Profile;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Store {

    protected ArrayList<Abstract_Clothes> clothesList = new ArrayList<>();

    public void  add_list (Abstract_Clothes c){
        clothesList.add(c);
    }
    public void remove_list (Abstract_Clothes c){clothesList.remove(c);}

    public void display_store_list(){
        for (Abstract_Clothes c : clothesList) {
            c.getInfo();
            System.out.println("-------------------------------------");
        }
    }

    public Abstract_Clothes find_clothes(int id){
        for (Abstract_Clothes c : clothesList) {
            if (c.getID() == id) {
                return c;
            }
        }
        throw new NoSuchElementException("There is no clothes with that Id");
    }

    public void buy_clothes(Profile user, int id){
        try{
            Abstract_Clothes c = find_clothes(id);
            if (user.getCoin() >= c.getPrice()) {
                System.out.println("***************************************");
                System.out.println("You Buy : ");
                c.getInfo();
                System.out.println("You have $" + c.getPrice());
                System.out.println("***************************************");
                this.clothesList.remove(c);
                user.add_clothes(c);
            } else {
                System.out.println("You don't have enough money to buy this cloth.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Invalid ID");
        }
    }

    public void visit_store(Profile user){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Banana Store!");
        System.out.println("Your Current Budge : " + user.getCoin());
        System.out.println("You can select what you want to buy: ");
        this.display_store_list();
        System.out.println("0 : for Nothing" );
        int chosen = scanner.nextInt();
        if (chosen == 0) {
            System.out.println("Thank you for using Banana Store!");
        } else {
            this.buy_clothes(user, chosen);
        }

    }
    public String toString(){
        String store_ids = "";
        for (Abstract_Clothes c : clothesList) {
            store_ids = store_ids + c.getID() + "-";
        }
        store_ids = store_ids.substring(0, store_ids.length() - 1);
        return store_ids;
    }


}
