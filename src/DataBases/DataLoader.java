package DataBases;
import Clothes.Store;
import User.Profile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataLoader {
    private Profile profile;
    private ArrayList inventory_ids = new ArrayList();
    private ArrayList store_ids = new ArrayList();

    private File profile_file;
    private File store_file;
    private Scanner scanner;

    public DataLoader(){
        this.readProfileFile();
        this.readStoreFile();
    }

    public ArrayList converter(String[] stringNumbers){
        ArrayList<Object> intList = new ArrayList<>();

        for (String numStr : stringNumbers) {
            intList.add(Integer.parseInt(numStr.trim()));
        }
        return intList;
    }

    public void readProfileFile() {
        String line = null;
        try {
            this.profile_file = new File("src/DataBases/profiles.txt");
            scanner = new Scanner(profile_file);
            line = scanner.nextLine();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        String[] profile_infos = line.split(",");

        this.profile = new Profile(profile_infos[0], profile_infos[1],Double.parseDouble(profile_infos[2]));
        if (profile_infos.length >= 3){

            String[] tmp_prifile_infos = profile_infos[3].split("-");
            this.inventory_ids = converter(tmp_prifile_infos);
        }
    }

    public void readStoreFile() {
        String line = null;
        try {
            this.store_file = new File("src/DataBases/store.txt");
            scanner = new Scanner(store_file);
            line = scanner.nextLine();
        }catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        String[] store_infos = line.split("-");

        this.store_ids = converter(store_infos);
    }

    public Profile getProfile(){
        return this.profile;
    }
    public ArrayList getInventoryIds() {
        return this.inventory_ids;
    }
    public ArrayList getStoreIds() {
        return this.store_ids;
    }
}
