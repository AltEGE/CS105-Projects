import java.util.Random;
import java.util.Scanner;

public class heads_or_tails extends Game {

    public heads_or_tails(double muz_coin) {
        super(muz_coin);
    }

    @Override
    public String kurallari_yaz() {
        return "Yazı-Tura Oyunu Kuralları:\n" +
               "1. Yatırmak istediğiniz miktarı seçin.\n" +
               "2. Yazı veya tura tahmininizi yapın.\n" +
               "3. Doğru tahmin ederseniz kazanç sağlarsınız.\n" +
               "4. Yanlış tahmin ederseniz yatırdığınız parayı kaybedersiniz.";
    }

    @Override
    public void oyun_başlat() {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        System.out.println(kurallari_yaz());

        while (true) {
            System.out.print("\nYatırmak istediğiniz miktarı girin: ");
            double yatirilanMiktar = input.nextDouble();
            para_yatir(yatirilanMiktar);

            System.out.print("Tahmininizi yapın (1: Yazı, 2: Tura): ");
            int tahmin = input.nextInt();

            if (tahmin != 1 && tahmin != 2) {
                System.out.println("Geçersiz seçim! Lütfen 1 (Yazı) veya 2 (Tura) girin.");
                continue;
            }

            String[] secenekler = {"Yazı", "Tura"};
            String sonuc = secenekler[random.nextInt(2)];

            System.out.println("Sonuç: " + sonuc);

            if ((tahmin == 1 && sonuc.equals("Yazı")) || (tahmin == 2 && sonuc.equals("Tura"))) {
                System.out.println("Tahmininiz doğru! Kazandınız.");
                win(2.0); // Kazanırsanız 2 katını kazanın
            } else {
                System.out.println("Tahmininiz yanlış! Kaybettiniz.");
            }

            // input.nextLine() ile önceki boşluğu temizle
            input.nextLine();

            System.out.print("\nOyuna devam etmek için 'q' girin, çıkmak için başka bir tuşa basın: ");
            String devam = input.nextLine();
            if (devam.equalsIgnoreCase("q")) {
                System.out.println("Oyun sonlandırıldı.");
                break;
            }
        }
    }
}
