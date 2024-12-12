import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;



public class Main {

    public static void kapat(){
        System.out.println("Program sonlandırılıyor...");
            System.exit(0); // Başarıyla çıkış yap
    }


    public static void GüncelleVeKapat(Profil kullanici){
        //Text dosyası güncelle ve kapat
    }

    public static double  uyelik_durumu(String ad, String sifre) {
    
        double muz_coin =  -1.0;
        
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("Uygulama_Bilgileri.txt")))) {
             //BufferReader küme halinde okuyor FileReader tek tek okuyor o yüzden filerider'dan daha verimli
             //Bu şekilde yazdığımıda işlem bitince otomatik dosya kapanıyor (Programın verimi için önemli)
            while (scanner.hasNextLine()) {
                String satir = scanner.nextLine();
                String[] bilgiler = satir.split(",");
                
                if (bilgiler[0].equals(ad) && bilgiler[1].equals(sifre)){
                
                    muz_coin = Double.valueOf(bilgiler[2]);
                }
                
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Dosya Bulunamadı....");
        } catch (IOException ex) {
            System.out.println("Dosya açılırken hata oluştu");
        }
        return muz_coin;
    }
    

    public static void main(String[] args) {

        String ad;
        String sifre;
        String sifre_2;

        Scanner input = new Scanner(System.in);

        while (true) { 
            
        

        System.out.println("------------------------------------------------------\n"
        +"Muz Cumhuriyetti Karakter Giydirmeceye Hoşgeldiniz.\n"
        + "Üye girişi yapmak için lütfen 1'e basın\n"
        + "Yeni kulanıcı oluşturmak için 2'ye basın\n"
        + "Uygulamadan çıkmak için 3'e basın\n"
        + "------------------------------------------------------");

        System.out.print("Tercihiniz");
        int a =input.nextInt();
        input.nextLine(); // Dummy Scanner aşaığıdaki nextline'ı bozmasın diye

        if (a== 1){
  
            System.out.print("Kullanıcı Adınız giriniz : ");
            ad = input.nextLine();
            System.out.print("Şifreniz : ");
            sifre = input.nextLine();
            double muz_coin= uyelik_durumu(ad,sifre);

            if (muz_coin != -1.0) {
                System.out.println("Hoşgeldin " + ad);  
                Profil kullanici = new Profil(ad, muz_coin, sifre);
                
            }

            else{
                System.out.println("Hesabınız bulnamadı. Tekrar deneyiniz ya da hesap oluşturunuz");
            }

        }

        else if (a == 2){
            System.out.print("Kullanıcı Adınız giriniz : ");
            ad = input.nextLine();

            while (true) { 
            System.out.print("Şifreniz giriniz : ");
            sifre = input.nextLine();
            System.out.print("Şifreniz tekrar giriniz : ");
            sifre_2 = input.nextLine();

            if (sifre.equals(sifre_2)) {

                System.out.println("Şifreler eşleşmedi lütfen tekrar girin");
            } else {

                System.out.println("Kayıt işlemi başarılı");
                System.out.println("Hoşgeldin " + ad); 
                Profil kullanici = new Profil(ad, 0.00, sifre);
                System.out.println("------------------------------------------------------");

                
                System.out.print("Öğretici metni görmek ister misin (Yes/No) (Sonunda bonus olabilir) : ");
                while (true) { 
                String ogretici =input.nextLine();
                ogretici = ogretici.toLowerCase();
                if (ogretici.equals("y") || ogretici.equals("yes")) {
                    System.out.println("------------------------------------------------------");
                    
                    System.out.println("Uygulmamamıza kayıt olduğunuz için teşekkür ederiz. Ekranda görünen bölümlere gitmek için yanında yazan sayıyı girebilirsiniz eğer bir önceki sayfaya dönmek isterseniz lütfen q tuşuna basınız. Programı kapatmak içinde -+-'yi tuşlayın\n"
                    + "Başkanımız Banana Joe oynadığınız oyunlardan belli oranda vergi alabilir, yaşasın Muz Cumhuriyeti");

                    System.out.println("Tebrikler 1000 Muz_coin kazandınız");
                    kullanici.setMuz_coin( kullanici.getMuz_coin() + 1000.00);

                    System.out.println("------------------------------------------------------");

                }
                

            }

            }

        } 

        }

        else if (a==3){
            kapat();
        }

        else{
            System.out.println("Lütfen Geçerli bir değer girin");
        }

    }


    }
}
