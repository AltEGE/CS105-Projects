package src.User;

import src.Clothes.Abstract_Clothes;

import java.util.ArrayList;
import java.util.Scanner;

public class Profile {
    Scanner input = new Scanner(System.in);

    private String nickname;
    private String gender;
    private double coin;
    private Abstract_Clothes clothes;

    private Inventory inventory = new Inventory();

    public Profile(String nickname, String gender, double coin){
        this.nickname = nickname;
        this.gender = gender;
        this.coin = coin;

    }

    public void add_clothes(Abstract_Clothes c){inventory.add_clothes(c);}
    public void buy_clothes(Abstract_Clothes c){
        this.coin -= c.getPrice();
        inventory.add_clothes(c);
    }
    public void display_clothes(){
        if (clothes != null){
            System.out.println("You are wearing : ");
            clothes.getInfo();
        }

        System.out.println("Clothes in your Inventory: ");
        inventory.display_inventory();
    }

    public void wear_clothes(){
        System.out.println("Clothes in your Inventory: ");
        inventory.display_inventory();
        ArrayList inventory_ids = inventory.get_inventory_ids();

        System.out.println("Select one of them : ");
        int option = input.nextInt();

        if(inventory_ids.contains(option)){
            System.out.println("You are wearing : ");
            Abstract_Clothes c = inventory.get_clothes(option);
            this.clothes = c;
            this.clothes.getInfo();

        } else {
            System.out.println("Invalid ID");
            System.out.println("-------------------------------------");
        }
    }

    public void setClothes(Abstract_Clothes c){
        this.clothes = c;
    }

    public double getCoin(){return this.coin;}
    public void setCoin(double coin){this.coin = coin;}

    public Inventory getInventory(){return this.inventory;}

    public void win_bet(int bet){
        this.coin += bet;
    }

    public void lose_bet(int bet){
        this.coin -= bet;
    }

    public String toString(){
        return nickname + "," + gender + "," + coin + "," + inventory.toString();
    }

}

