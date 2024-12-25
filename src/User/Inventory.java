package User;

import Clothes.Abstract_Clothes;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Inventory {

    protected ArrayList<Abstract_Clothes> clothesList = new ArrayList<>();

    public void  add_clothes (Abstract_Clothes c){
        clothesList.add(c);
    }
    public void display_inventory(){
        for (Abstract_Clothes c : clothesList) {
            c.getInfo();
            System.out.println("-------------------------------------");
        }
    }

    public Abstract_Clothes get_clothes(int id){
        for (Abstract_Clothes c : clothesList) {
            if (c.getID() == id) {
                clothesList.remove(c);
                return c;
            }
        }
        throw new NoSuchElementException("There is no clothes with that Id");
    }

    public String toString(){
        String inventory_ids = "";
        for (Abstract_Clothes c : clothesList) {
            inventory_ids = inventory_ids + c.getID() + "-";
        }
        inventory_ids = inventory_ids.substring(0, inventory_ids.length() - 1);
        return inventory_ids;
    }
}