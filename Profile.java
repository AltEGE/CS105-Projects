import java.util.ArrayList;

public class Profile {

    private String username;
    private String password;
    private String gender;
    private double muzCoin;

    private ArrayList<String> wardrobe;
    private ArrayList<String> equippedItems;

    private ArrayList<Integer> wardrobeIDs;
    private ArrayList<Integer> equippedItemIDs;

    public Profile(String username, String password, String gender, double muzCoin, ArrayList<Integer> wardrobeIDs, ArrayList<Integer> equippedItemIDs, ArrayList<Abstract_Clothes> clothes) {
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.muzCoin = muzCoin;

        this.wardrobeIDs = new ArrayList<>(wardrobeIDs);
        this.equippedItemIDs = new ArrayList<>(equippedItemIDs);
        this.wardrobe = new ArrayList<>();
        this.equippedItems = new ArrayList<>();

        convertIDsToNames(this.wardrobeIDs, this.wardrobe, clothes);
        convertIDsToNames(this.equippedItemIDs, this.equippedItems, clothes);
    }

    private void convertIDsToNames(ArrayList<Integer> IDs, ArrayList<String> output, ArrayList<Abstract_Clothes> clothes) {
        for (int id : IDs) {
            for (Abstract_Clothes item : clothes) {
                if (item.getID() == id) {
                    output.add(item.getName());
                }
            }
        }
    }

    public void addToWardrobe(int id, ArrayList<Abstract_Clothes> clothes) {
        for (Abstract_Clothes item : clothes) {
            if (item.getID() == id) {
                wardrobeIDs.add(id);
                wardrobe.add(item.getName());
                System.out.println(item.getName() + " has been added to the wardrobe.");
                return;
            }
        }
        System.out.println("Item with ID " + id + " not found.");
    }

    public void equipItem(int id, ArrayList<Abstract_Clothes> clothes) {
        for (Abstract_Clothes item : clothes) {
            if (item.getID() == id) {
                equippedItemIDs.add(id);
                equippedItems.add(item.getName());
                System.out.println(item.getName() + " has been equipped.");
                return;
            }
        }
        System.out.println("Item with ID " + id + " not found.");
    }

    public void unequipItem(int id) {
        int index = equippedItemIDs.indexOf(id);
        if (index != -1) {
            System.out.println(equippedItems.get(index) + " has been unequipped.");
            equippedItemIDs.remove(index);
            equippedItems.remove(index);
        } else {
            System.out.println("Item with ID " + id + " is not equipped.");
        }
    }

    public void viewWardrobe() {
        System.out.println("Wardrobe Contents:");
        if (wardrobe.isEmpty()) {
            System.out.println("  - Wardrobe is empty.");
        } else {
            for (String item : wardrobe) {
                System.out.println("  - " + item);
            }
        }
    }

    public void viewEquippedItems() {
        System.out.println("Equipped Items:");
        if (equippedItems.isEmpty()) {
            System.out.println("  - No items equipped.");
        } else {
            for (String item : equippedItems) {
                System.out.println("  - " + item);
            }
        }
    }

    public void convertNamesToIDs(ArrayList<String> names, ArrayList<Integer> output, ArrayList<Abstract_Clothes> clothes) {
        for (String name : names) {
            for (Abstract_Clothes item : clothes) {
                if (name.equalsIgnoreCase(item.getName())) {
                    output.add(item.getID());
                }
            }
        }
    }
}

