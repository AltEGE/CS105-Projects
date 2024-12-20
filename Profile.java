

import java.util.ArrayList;

public class Profile {

    private String username;
    private String password;
    private String gender;
    private double muzCoin; 

    private ArrayList<String> dolap;
    private ArrayList<String> karakterUstu;

    private ArrayList<Integer> dolapID;
    private ArrayList<Integer> karakterUstuID;

    public Profile(String username, String password, String gender, double muzCoin, ArrayList<Integer> dolapID, ArrayList<Integer> karakterUstuID, ArrayList<Abstract_Clothes> kıyafetler){
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.muzCoin = muzCoin;
        this.dolapID = dolapID;
        this.karakterUstuID = karakterUstuID;
        IdCeviri(this.dolapID,this.dolap,kıyafetler);
        IdCeviri(this.karakterUstuID, this.karakterUstu, kıyafetler);


    }

    public void  IdCeviri(ArrayList<Integer> ID, ArrayList<String> cıktı ,ArrayList<Abstract_Clothes> kıyafetler){

        for (int i = 0; i == ID.size()-1; i++) {
            for (int j = 0; j  == kıyafetler.size()-1; j ++) {
                
                if(ID.get(i) == kıyafetler.get(j).getID()){
                    cıktı.add(kıyafetler.get(j).getName());
                }
            }            
        }
    }

    public void dolapEkle(int id, ArrayList<Abstract_Clothes> kıyafetler) {
        for (Abstract_Clothes kıyafet : kıyafetler) {
            if (kıyafet.getID() == id) {
                dolapID.add(id);
                dolap.add(kıyafet.getName());
                System.out.println(kıyafet.getName() + " dolaba eklendi.");
                return;
            }
        }
    }

    public void karakterUstuEkle(int id, ArrayList<Abstract_Clothes> kıyafetler) {
        for (Abstract_Clothes kıyafet : kıyafetler) {
            if (kıyafet.getID() == id) {
                karakterUstuID.add(id);
                karakterUstu.add(kıyafet.getName());
                System.out.println(kıyafet.getName() + " karakter üstüne eklendi.");
                return;
            }
        }
    }

    public void karakterUstuCikar(int id) {
        int index = karakterUstuID.indexOf(id);
        if (index != -1) {
            System.out.println(karakterUstu.get(index) + " karakter üstünden çıkarıldı.");
            karakterUstuID.remove(index);
            karakterUstu.remove(index);
        } 
    }

    public void dolapGoruntule() {
        System.out.println("Dolap İçeriği:");
        if (dolap.isEmpty()) {
            System.out.println("  - Dolap boş.");
        } else {
            for (String item : this.dolap) {
                System.out.println("  - " + item);
            }
        }
    }
    
    public void karakterUstuGoruntule() {
        System.out.println("Karakter Üstü İçeriği:");
        if (karakterUstu.isEmpty()) {
            System.out.println("  - Karakter üstü boş.");
        } else {
            for (String item : this.karakterUstu) {
                System.out.println("  - " + item);
            }
        }
    }

    public void isimdenIDCevir(ArrayList<String> isimler, ArrayList<Integer> çıktı, ArrayList<Abstract_Clothes> kıyafetler) { //Kodu kapatırken kullanılacak
        for (String isim : isimler) {
            for (Abstract_Clothes kıyafet : kıyafetler) {
                if (isim.equalsIgnoreCase(kıyafet.getName())) {
                    çıktı.add(kıyafet.getID());
                }
            }
        }
    }
    







}

