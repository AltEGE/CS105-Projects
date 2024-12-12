import java.util.Scanner;

public class Wheel extends  Game{


    private double [] cak_guvenli = {1, 1.5, 2, 1.2, 1.7, 1, 1, 0, 0, 0};
    private double[] cak_orta = {0, 0, 1, 1, 1, 0, 1.5, 0, 4, 5};
    private double[] cak_riskli = {0, 0, 2, 0, 21, 0, 1, 0, 0, 13};

    public Wheel(double muz_coin) {
        super(muz_coin);
    }

  
    @Override
    public String kurallari_yaz() {

    return "1. Lütfen yatıracağınız parayı seçin\n" +
           "2. Risk seviyesine göre çarklardan birini seçin\n";
    }


    @Override
    public void oyun_başlat() {
        Scanner input = new Scanner(System.in);
        double[] seçilen_çark;

        System.out.println("\nÇark Oyununa Hoş Geldiniz!");

        while (true) {
            System.out.println(kurallari_yaz());
            System.out.print("Yatıracağınız miktarı girin: ");
            setYatirilan_para(input.nextDouble());
    
            System.out.println("1. Güvenli Çark\n2. Orta Çark\n3. Riskli Çark");
            System.out.print("Seçiminizi yapın ((1)..Güvenli/ (2)..Normal/ (3)..Riskli): ");
            int secim = input.nextInt();
    
            switch (secim) {
                case 1:
                    seçilen_çark = cak_guvenli;
                    break;
                case 2:
                    seçilen_çark = cak_orta;
                    break;
                case 3:
                    seçilen_çark = cak_riskli;
                    break;
                default:
                    System.out.println("Geçersiz seçim, güvenli çark seçildi.");
                    seçilen_çark = cak_guvenli;
                    break;
            }
    
            int indeks = (int) (Math.random() * seçilen_çark.length);
            double sonuc = seçilen_çark[indeks];
    
            System.out.println("Çark sonucu: " + sonuc);
            win(sonuc);
    
            // input.nextLine() kullanarak önceki satırdaki boşluğu temizliyoruz
            input.nextLine();
    
            System.out.print("\nÇıkmak için 'q' tuşuna basın, yeni oyun için herhangi bir tuşa");
            String devam = input.nextLine();
            if (devam.equalsIgnoreCase("q")) {
                System.out.println("Oyun sonlandırıldı.");
                break;
            }
        }
    }
    


}
