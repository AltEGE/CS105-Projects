import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Tek bir Scanner nesnesi
        int cipMiktari = 1000;
        int[] coinFiyatlari = {50, 100, 150, 200, 250, 300, 350, 400, 450};
        int[] coinMiktarlari = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        boolean devam = true;

        while (devam) {
            System.out.println("\n--- Muz Cumhuriyeti ---");
            System.out.println("Cipiniz: " + cipMiktari);
            System.out.println("Coin İşlemleri:");
            for (int i = 0; i < coinFiyatlari.length; i++) {
                System.out.println((i + 1) + ".  Muz Coin - Fiyat: " + coinFiyatlari[i] + ", Miktar: " + coinMiktarlari[i]);
            }
            System.out.println((coinFiyatlari.length + 1) + ". Geri Dön");
            System.out.println((coinFiyatlari.length + 2) + ". Flash Muz Joe Kredisi");
            System.out.println((coinFiyatlari.length + 3) + ". Muz Cumhuriyeti Banana Joe Devlet Bankası");
            System.out.print("Seçiminizi yapınız: ");

            int secim = okuSecim(scanner);

            if (secim >= 1 && secim <= coinFiyatlari.length) { // Coin Satın Alma
                int fiyat = coinFiyatlari[secim - 1];
                int miktar = coinMiktarlari[secim - 1];

                if (cipMiktari >= fiyat) {
                    cipMiktari -= fiyat;
                    System.out.println("Başarıyla " + miktar + " adet  Muz Coin satın aldınız. Kalan Cipiniz: " + cipMiktari);
                } else {
                    System.out.println("Yetersiz cip! Lütfen daha fazla cip yükleyin.");
                }
            } else if (secim == coinFiyatlari.length + 1) {
                System.out.println("Geri dönülüyor...");
                devam = false;
            } else if (secim == coinFiyatlari.length + 2) {
                flashMuzJoeKredisi(scanner);
            } else if (secim == coinFiyatlari.length + 3) {
                muzCumhuriyetiBankasi();
            } else {
                System.out.println("Geçersiz seçim! Tekrar deneyin.");
            }
        }
        scanner.close(); // Scanner'ı kapatıyoruz
    }

    // Kullanıcıdan seçim okuma
    public static int okuSecim(Scanner scanner) {
        System.out.print("Lütfen bir seçim yapınız: ");
        while (!scanner.hasNextInt()) { // Giriş geçerli bir sayı mı kontrolü
            System.out.println("Hatalı giriş! Lütfen geçerli bir sayı girin.");
            scanner.next(); // Geçersiz girdiyi temizle
        }
        return scanner.nextInt();
    }

    // Flash Muz Joe Kredisi
    public static void flashMuzJoeKredisi(Scanner scanner) {
        double faizOrani = 2.0; // Faiz oranı %200

        System.out.println("\n=== Flash Muz Joe Kredisi ===");
        System.out.print("İstediğiniz kredi miktarını giriniz: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Hatalı giriş! Lütfen geçerli bir sayı girin.");
            scanner.next(); // Geçersiz girdiyi temizle
        }
        double anapara = scanner.nextDouble();

        System.out.print("Kaç ayda ödeyeceksiniz: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Hatalı giriş! Lütfen geçerli bir sayı girin.");
            scanner.next(); // Geçersiz girdiyi temizle
        }
        int vade = scanner.nextInt();

        double toplamOdeme = anapara * (1 + faizOrani) * vade;

        System.out.println("Toplam Ödenecek Tutar: " + toplamOdeme + " Muz Coin");
        System.out.println("[1] Onayla");
        System.out.println("[2] İptal");
        System.out.print("Seçiminizi yapınız: ");

        int secim = okuSecim(scanner);
        if (secim == 1) {
            System.out.println("Kredi onaylandı! Ana menüye dönülüyor.");
        } else {
            System.out.println("Kredi işlemi iptal edildi. Ana menüye dönülüyor.");
        }
    }

    // Muz Cumhuriyeti Bankası
    public static void muzCumhuriyetiBankasi() {
        System.out.println("\n=== Muz Cumhuriyeti Banana Joe Devlet Bankası ===");
        System.out.println("Bu ülkede başka banka bulunmamaktadır.");
        System.out.println("Muz Cumhuriyeti yasalarına göre tüm finans işlemleri buradan yapılır.");
        System.out.println("Ana menüye dönülüyor...");
    }
}

