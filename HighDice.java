import java.util.Random;
import java.util.Scanner;

public class HighDice extends Game {

    public HighDice(double muz_coin) {
        super(muz_coin);
    }

    @Override
    public String kurallari_yaz() {
        return "High Dice Oyunu Kuralları:\n" +
               "1. Oyuncu ve bilgisayar zar atar.\n" +
               "2. En yüksek zar atan kazanır.\n" +
               "3. Beraberlik durumunda oyun tekrar oynanır.\n" +
               "4. Kazanırsanız yatırdığınız miktarın 2 katını kazanırsınız.";
    }

    @Override
    public void oyun_başlat() {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        System.out.println(kurallari_yaz());
        System.out.println("---------------------------------");
        System.out.println("Muz coin'iniz : " + getMuz_coin());
        System.out.println("---------------------------------");

        while (true) {
            System.out.print("\nYatırmak istediğiniz miktarı girin: ");
            double yatirilanMiktar = input.nextDouble();
            para_yatir(yatirilanMiktar);

            int oyuncuZar = random.nextInt(6) + 1; // 1 ile 6 arasında rastgele zar atar
            int bilgisayarZar = random.nextInt(6) + 1;

            System.out.println("Oyuncunun zarı: " + oyuncuZar);
            System.out.println("Bilgisayarın zarı: " + bilgisayarZar);

            if (oyuncuZar > bilgisayarZar) {
                System.out.println("Kazandınız!");
                win(2.0); // Kazanırsanız 2 katını kazanın
            } else if (oyuncuZar < bilgisayarZar) {
                System.out.println("Kaybettiniz!");
            } else {
                System.out.println("Berabere! Oyun tekrar ediliyor.");
                continue; // Beraberlikte oyunu tekrar ettirir
            }

            // input.nextLine() ile önceki boşluğu temizle
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
