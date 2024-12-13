public class Bank {
    public static void main(String[] args) {
        int cipMiktari = 1000; // Başlangıç çip miktarı
        int[] coinFiyatlari = {50, 100, 150, 200, 250, 300, 350, 400, 450}; // Coin ücretleri
        int[] coinMiktarlari = {1, 2, 3, 4, 5, 6, 7, 8, 9}; // Coin miktarları
        boolean devam = true;

        while (devam) {// Menü
            System.out.println("\n--- Muz Cumhuriyeti ---");
            System.out.println("Cipiniz: " + cipMiktari);
            System.out.println("Coin İşlemleri:");
            for (int i = 0; i < coinFiyatlari.length; i++) {
                System.out.println((i + 1) + ". X Muz Coin - Fiyat: " + coinFiyatlari[i] + ", Miktar: " + coinMiktarlari[i]);
            }
            System.out.println((coinFiyatlari.length + 1) + ". Geri Dön");
            System.out.print("Seçiminizi yapınız: ");

            int secim = okuSecim();

            if (secim >= 1 && secim <= coinFiyatlari.length) {
                int fiyat = coinFiyatlari[secim - 1];
                int miktar = coinMiktarlari[secim - 1];

                if (cipMiktari >= fiyat) {
                    cipMiktari -= fiyat;
                    System.out.println("Başarıyla " + miktar + " adet X Muz Coin satın aldınız. Kalan Cipiniz: " + cipMiktari);
                } else {
                    System.out.println("Yetersiz cip! Lütfen daha fazla cip yükleyin.");
                }
            } else if (secim == coinFiyatlari.length + 1) {
                System.out.println("Geri dönülüyor...");
                devam = false;
            } else {
                System.out.println("Geçersiz seçim! Tekrar deneyin.");
            }
        }
}
