import java.util.Random;
import java.util.Scanner;

public class follow_the_lady extends Game {

    public follow_the_lady(double muz_coin) {
        super(muz_coin);
    }

    @Override
    public String kurallari_yaz() {
        return "Follow the Lady Oyunu Kuralları:\n" +
               "1. Üç kart arasından 'Lady' (Bayan) kartını bulmaya çalışın.\n" +
               "2. Kartlar karıştırılır ve sizden 'Lady' kartının yerini tahmin etmeniz istenir.\n" +
               "3. Doğru tahmin ederseniz yatırdığınız miktarın 3 katını kazanırsınız.\n" +
               "4. Yanlış tahmin ederseniz yatırdığınız miktarı kaybedersiniz.";
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

            // Kartların karıştırılması
            int ladyPosition = random.nextInt(3) + 1; // 1 ile 3 arasında rastgele bir pozisyon

            System.out.println("Kartlar karıştırılıyor...");
            System.out.println("1   2   3"); // Kartların pozisyonları
            System.out.print("Lady'nin (Bayan) kartının hangi pozisyonda olduğunu tahmin ediyorsunuz? (1/2/3): ");
            int tahmin = input.nextInt();

            if (tahmin == ladyPosition) {
                System.out.println("Tebrikler! Doğru tahmin ettiniz. Lady kartı pozisyon " + ladyPosition + "’daydı.");
                win(3.0); // Kazanırsanız 3 katını kazanın
            } else {
                System.out.println("Üzgünüm! Yanlış tahmin. Lady kartı pozisyon " + ladyPosition + "’daydı.");
            }

            // input.nextLine() ile önceki boşluğu temizle
            input.nextLine();

            // Oyunun devamı için kullanıcıya sor
            System.out.print("\nÇıkmak için 'q' tuşuna basın, yeni oyun için herhangi bir tuşa");
            String devam = input.nextLine();
            if (devam.equalsIgnoreCase("q")) {
                System.out.println("Oyun sonlandırıldı.");
                break;
            }
        }
    }
}
