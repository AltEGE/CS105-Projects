package User;

import Clothes.Abstract_Clothes;

public class Profile {

    private String nickname;
    private String gender;
    private double coin;

    private Inventory inventory = new Inventory();

    public Profile(String nickname, String gender, double coin){
        this.nickname = nickname;
        this.gender = gender;
        this.coin = coin;

    }

    public void add_clothes(Abstract_Clothes c){inventory.add_clothes(c);}
    public void display_clothes(){
        System.out.println("Clothes in your Inventory: ");
        inventory.display_inventory();
    }

    public double getCoin(){return this.coin;}
    public void setCoin(double coin){this.coin = coin;}

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

