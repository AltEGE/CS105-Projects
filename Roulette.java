import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Roulette extends Game {

    private ArrayList<String> bahisler = new ArrayList<>();
    private ArrayList<Double> miktar = new ArrayList<>();
    private String renk;
    private String sonuc;
    private String aralık;
    private double topbahis;
    private double topkazanc;

    public Roulette(double muz_coin) {
        super(muz_coin);
    }

    public void cark_cevir() {
        Random random = new Random();
        int sayı = random.nextInt(37); // 0 ile 36 arasında rastgele sayı

        // Renk belirleme
        if (sayı == 0) {
            this.renk = "Yeşil";
        } else if (sayı % 2 == 0) {
            this.renk = "Kırmızı";
        } else {
            this.renk = "Siyah";
        }

        this.sonuc = String.valueOf(sayı);

        // Aralık belirleme
        if (sayı >= 1 && sayı <= 12) {
            this.aralık = "1-12";
        } else if (sayı >= 13 && sayı <= 24) {
            this.aralık = "13-24";
        } else if (sayı >= 25 && sayı <= 36) {
            this.aralık = "25-36";
        } else {
            this.aralık = "0";
        }

        System.out.println("Çark sonucu: " + sonuc + " (" + renk + "), Aralık: " + aralık);
    }

    @Override
    public String kurallari_yaz() {
        return "Rulet Oyunu Kuralları:\n" +
               "1. Bir sayı (0-36), renk (Kırmızı/Siyah/Yeşil) veya aralık (1-12, 13-24, 25-36) üzerine bahis yapabilirsiniz.\n" +
               "2. Renk tahmininiz doğruysa yatırdığınız miktarın 2 katını kazanırsınız.\n" +
               "3. Aralık tahmininiz doğruysa yatırdığınız miktarın 3 katını kazanırsınız.\n" +
               "4. Sayı tahmininiz doğruysa yatırdığınız miktarın 36 katını kazanırsınız.";
    }
    

    @Override
    public void oyun_başlat() {
        Scanner input = new Scanner(System.in);

        while (true) {
            bahisler.clear();
            miktar.clear();
            topbahis = 0;
            topkazanc = 0;

            System.out.println(kurallari_yaz());

            while (true) {
                System.out.print("Lütfen bahisinizi nereye yapacağınızı seçin (Sayı/Renk/Aralık): ");
                String bahis = input.nextLine();
                System.out.print("Lütfen bahis miktarını girin: ");
                double miktarDegeri = input.nextDouble();

                bahisler.add(bahis);
                miktar.add(miktarDegeri);
                topbahis += miktarDegeri;

                input.nextLine(); // Boşluğu temizle

                System.out.print("Başka bahis yatırmak için 'y' girin, tamamlamak için başka bir tuşa basın: ");
                String devam = input.nextLine();
                if (!devam.equalsIgnoreCase("y")) {
                    break;
                }
            }

            System.out.println("\nEğlence Başlasın!");
            cark_cevir();
            para_yatir(topbahis);

            for (int i = 0; i < bahisler.size(); i++) {
                String bahis = bahisler.get(i);
                double bahisMiktari = miktar.get(i);

                if (bahis.equalsIgnoreCase(renk)) {
                    topkazanc += bahisMiktari * 2;
                }

                if (bahis.equalsIgnoreCase(aralık)) {
                    topkazanc += bahisMiktari * 3;
                }

                if (bahis.equals(sonuc)) {
                    topkazanc += bahisMiktari * 36;
                }
            }

            if (topkazanc > 0) {
                win(topkazanc / topbahis); // Oran olarak kazanç hesaplanır
            }

            this.topbahis =0 ;
            this.topkazanc=0;

            // Oyunun devamı için kullanıcıya sor
            System.out.print("\nÇıkmak için 'q' tuşuna basın, yeni oyun için herhangi bir tuşa");
            String cikis = input.nextLine();
            if (cikis.equalsIgnoreCase("q")) {
                System.out.println("Oyun sonlandırıldı.");
                break;
            }
        }
    }
}
