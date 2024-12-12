import java.util.Random;
import java.util.Scanner;

public class rock_paper_scissors extends Game {

    public rock_paper_scissors(double muz_coin) {
        super(muz_coin);
    }

   
    @Override
    public String kurallari_yaz() {
        return "Taş-Kağıt-Makas Oyunu Kuralları:\n" +
               "1. Taş makası yener.\n" +
               "2. Kağıt taşı yener.\n" +
               "3. Makas kağıdı yener.\n" +
               "4. Oyuncu ve bilgisayar aynı seçimi yaparsa oyun berabere biter.";
    }
    

    @Override
    public void oyun_başlat() {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        String[] secenekler = {"Taş", "Kağıt", "Makas"};

        System.out.println(kurallari_yaz());

        while (true) {
            System.out.print("\nYatırmak istediğiniz miktarı girin: ");
            double yatirilanMiktar = input.nextDouble();
            para_yatir(yatirilanMiktar);

            System.out.print("Seçiminizi yapın (1: Taş, 2: Kağıt, 3: Makas): ");
            int oyuncuSecimi = input.nextInt();

            if (oyuncuSecimi < 1 || oyuncuSecimi > 3) {
                System.out.println("Geçersiz seçim! Lütfen 1, 2 veya 3 girin.");
                continue;
            }

            String oyuncuHamlesi = secenekler[oyuncuSecimi - 1];
            String bilgisayarHamlesi = secenekler[random.nextInt(3)];

            System.out.println("Oyuncu seçimi: " + oyuncuHamlesi);
            System.out.println("Bilgisayar seçimi: " + bilgisayarHamlesi);

            if (oyuncuHamlesi.equals(bilgisayarHamlesi)) {
                System.out.println("Oyun berabere!");
                draw();
            } else if ((oyuncuHamlesi.equals("Taş") && bilgisayarHamlesi.equals("Makas")) ||
                       (oyuncuHamlesi.equals("Kağıt") && bilgisayarHamlesi.equals("Taş")) ||
                       (oyuncuHamlesi.equals("Makas") && bilgisayarHamlesi.equals("Kağıt"))) {
                System.out.println("Kazandınız!");
                win(2.0); 
            } else {
                System.out.println("Kaybettiniz!");
            }

            // input.nextLine() kullanarak önceki satırdaki boşluğu temizle
            input.nextLine();

            System.out.print("\nOyundan çıkmak için q tuşuna basın : ");
            String devam = input.nextLine();
            if (devam.equalsIgnoreCase("q")) {
                System.out.println("Oyun sonlandırıldı.");
                break;
            }
        }
    }
}
