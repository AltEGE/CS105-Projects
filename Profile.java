import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Profile {
    private String username;
    private String password;
    private String userId;

    private double muz_coin;
    private List <String> clothes;
    private String character;


    public  Profile(String username, String password, String userId ){
        this.username = username;
        this.password = password;
        this.userId = userId;
        this.muz_coin = 0; //initialize
        this.clothes = new ArrayList<>();
        this.character = "default character";
    }
    public String getUsername(){
        return username;
    }
    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
    public double getMuz_coin(){
        return muz_coin;
    }
    public void addMuz_Coin(int amount){
        if(amount>0) {
            muz_coin += amount;
            System.out.println(amount + "muz_coin added. Total muz_coin: " + muz_coin);
        } else {
            System.out.println("The amount should be positive.");
        }
    }
    public void addClothing(String clothing) {
        clothes.add(clothing);
        System.out.println(clothing + " added.");
    }
    public void updateCharacter(String newCharacter) {
        this.character = newCharacter;
        System.out.println("Character has updated. " + character);
    }








}
