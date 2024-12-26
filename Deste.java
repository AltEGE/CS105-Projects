import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deste {

    private ArrayList<String> deste = new ArrayList<>();
    private ArrayList<String> deste_karıl = new ArrayList<>();
    private ArrayList<String> kullanıcı = new ArrayList<>();
    private ArrayList<String> kullanıcı_ayrılmış = new ArrayList<>();
    private ArrayList<String> kupiyer = new ArrayList<>();
    private int kullanıcı_değer;
    private int kullanıcı_ayrı;
    private int kupiyer_değer;
    private boolean yeterliKart;
    private String[] tipler = {"Karo", "Maça", "Sinek", "Kupa"};
    private String[] kartlar = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    private boolean kartlar_esit;


    // Constructor: Deste'yi oluştur ve doldur
    public Deste() {
       
        for (String tip : tipler) {
            for (String kart : kartlar) {
                deste.add(tip + " " + kart);
            }
        }
    }

    public void desteKar() {
        this.deste_karıl = new ArrayList<>(deste); 
        Collections.shuffle(this.deste_karıl); 
        this.yeterliKart = false;    
    }
    
    public void hesaplaDeger() {
        this.kullanıcı_değer = hesaplaElDegeri(this.kullanıcı);
        this.kupiyer_değer = hesaplaElDegeri(this.kupiyer);

        if (!kullanıcı_ayrılmış.isEmpty()){

            this.kullanıcı_ayrı = hesaplaElDegeri(this.kullanıcı_ayrılmış);
        }
    }

    private int hesaplaElDegeri(ArrayList<String> el) {
        int toplam = 0;
        int asSayisi = 0;

        for (String kart : el) {
            String kartDegeri = kart.split(" ")[1]; 

            if (kartDegeri.equals("J") || kartDegeri.equals("Q") || kartDegeri.equals("K")) {
                toplam += 10;
            } else if (kartDegeri.equals("A")) {
                asSayisi++;
                toplam += 11; // As'ı başlangıçta 11 olarak say
            } else {
                toplam += Integer.parseInt(kartDegeri);
            }
        }

        // Eğer toplam 21'i aşarsa, As'ların değerini 1 olarak say
        while (toplam > 21 && asSayisi > 0) {
            toplam -= 10; // Bir As'ı 11 yerine 1 olarak say
            asSayisi--;
        }

        return toplam;
    }

    public boolean isYeterliKart() {
        return this.yeterliKart;
    }

      public void kart_ver(ArrayList<String> el) {
       
            Random rand = new Random();
            int index = rand.nextInt(deste_karıl.size()); 
            String kart = deste_karıl.remove(index);      
            el.add(kart);                                 

            if (deste_karıl.size() <= 12) {
                this.yeterliKart = true;
            }
        }
         

    public void kart_ayır(ArrayList<String> el){

        String sonKart = el.get(el.size() - 1);
        String ikinciSonKart = el.get(el.size() - 2);

        String sonKartDegeri = sonKart.split(" ")[1];
        String ikinciSonKartDegeri = ikinciSonKart.split(" ")[1];

        if (sonKartDegeri.equals(ikinciSonKartDegeri)) {
            el.remove(el.size() - 1);
            String ara = el.get(el.size() - 1);
            kullanıcı_ayrılmış.add(ara);
        }
    }

    public void  kart_esitmi(ArrayList<String> el){

        String sonKart = el.get(el.size() - 1);
        String ikinciSonKart = el.get(el.size() - 2);

        String sonKartDegeri = sonKart.split(" ")[1];
        String ikinciSonKartDegeri = ikinciSonKart.split(" ")[1];

        if (sonKartDegeri.equals(ikinciSonKartDegeri)) {
            
            this.kartlar_esit = true;
        }

        else{

            this.kartlar_esit = false;
        }

    }

    public ArrayList<String> getDeste() {
        return deste;
    }

    public void setDeste(ArrayList<String> deste) {
        this.deste = deste;
    }

    public ArrayList<String> getDeste_karıl() {
        return deste_karıl;
    }

    public void setDeste_karıl(ArrayList<String> deste_karıl) {
        this.deste_karıl = deste_karıl;
    }

    public ArrayList<String> getKullanıcı() {
        return kullanıcı;
    }

    public void setKullanıcı(ArrayList<String> kullanıcı) {
        this.kullanıcı = kullanıcı;
    }

    public ArrayList<String> getKullanıcı_ayrılmış() {
        return kullanıcı_ayrılmış;
    }

    public void setKullanıcı_ayrılmış(ArrayList<String> kullanıcı_ayrılmış) {
        this.kullanıcı_ayrılmış = kullanıcı_ayrılmış;
    }

    public ArrayList<String> getKupiyer() {
        return kupiyer;
    }

    public void setKupiyer(ArrayList<String> kupiyer) {
        this.kupiyer = kupiyer;
    }

    public int getKullanıcı_değer() {
        return kullanıcı_değer;
    }

    public void setKullanıcı_değer(int kullanıcı_değer) {
        this.kullanıcı_değer = kullanıcı_değer;
    }

    public int getKullanıcı_ayrı() {
        return kullanıcı_ayrı;
    }

    public void setKullanıcı_ayrı(int kullanıcı_ayrı) {
        this.kullanıcı_ayrı = kullanıcı_ayrı;
    }

    public int getKupiyer_değer() {
        return kupiyer_değer;
    }

    public void setKupiyer_değer(int kupiyer_değer) {
        this.kupiyer_değer = kupiyer_değer;
    }

    public String[] getTipler() {
        return tipler;
    }

    public void setTipler(String[] tipler) {
        this.tipler = tipler;
    }

    public String[] getKartlar() {
        return kartlar;
    }

    public void setKartlar(String[] kartlar) {
        this.kartlar = kartlar;
    }

    public void Kartlatı_göster() {
        System.out.print("Kupiyerin Kartları: ");
        System.out.print(kupiyer.get(0) + "--");
        System.out.print("X ");
        System.out.println("\n-------------------------\n");
    
        System.out.print("Kullanıcının Kartları: ");
        for (String kart : kullanıcı) {
            System.out.print(kart + "--");
        }
    
        if (!kullanıcı_ayrılmış.isEmpty()) {
            System.out.print("\nKullanıcının Ayrılmış Kartları: ");
            for (String kart : kullanıcı_ayrılmış) {
                System.out.print(kart + " ");
            }
        }
        System.out.println("\n-------------------------\n");
    }
    
    public void SonKartlatı_göster() {
        System.out.print("Kupiyerin Kartları: ");
        for (String kart : kupiyer) {
            System.out.print(kart + "--");
        }
        System.out.println("\n-------------------------\n");
    
        System.out.print("Kullanıcının Kartları: ");
        for (String kart : kullanıcı) {
            System.out.print(kart + "--");
        }
    
        if (!kullanıcı_ayrılmış.isEmpty()) {
            System.out.print("\nKullanıcının Ayrılmış Kartları: ");
            for (String kart : kullanıcı_ayrılmış) {
                System.out.print(kart + "--");
            }
        }
        System.out.println("\n-------------------------\n");
    }

    public void reset(){
        kullanıcı.clear();
        kullanıcı_ayrılmış.clear();
        kupiyer.clear();
        
        kullanıcı_değer = 0;
        kullanıcı_ayrı = 0;
        kupiyer_değer = 0;
        yeterliKart = false;
        kartlar_esit = false;

    }    

    public boolean isKartlar_esit() {
        return kartlar_esit;
    }

    public void setKartlar_esit(boolean kartlar_esit) {
        this.kartlar_esit = kartlar_esit;
    }
}
