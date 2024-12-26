package src.DataBases;
import src.User.Profile;
import src.Clothes.Store;

import java.io.FileWriter;
import java.io.IOException;

public class DataSaver {

    public void save(Profile profile) {
        String profile_info = profile.toString();
        try{
            FileWriter file = new FileWriter("src/DataBases/profiles.txt");
            file.write(profile_info);
            file.close();
        } catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void save(Store store) {
        String store_info = store.toString();
        try{
            FileWriter file = new FileWriter("src/DataBases/store.txt");
            file.write(store_info);
            file.close();
        } catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
