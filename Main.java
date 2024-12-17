import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void kapat() {
        System.out.println("Program sonlandırılıyor...");
        System.exit(0);
    }

    public static void GüncelleVeKapat(String ad, String sifre, double muz_coin, String gender, ArrayList<Integer> clothes, ArrayList<Integer> character_clothes, boolean yeni_kullanıcı) {
        File dosya = new File("Uygulama_Bilgileri.txt");
        ArrayList<String> satirlar = new ArrayList<>();
        boolean kullaniciBulundu = false;

        // Dosyayı oku ve satırları listeye ekle
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(dosya)))) {
            while (scanner.hasNextLine()) {
                String satir = scanner.nextLine();
                String[] bilgiler = satir.split(",");

                if (bilgiler[0].equals(ad)) {
                    kullaniciBulundu = true;
                    if (!yeni_kullanıcı) {
                        // Mevcut kullanıcı bilgilerini güncelle
                        satir = ad + "," + sifre + "," + muz_coin + "," + gender + "," + listToString(clothes) + "," + listToString(character_clothes);
                    }
                }
                satirlar.add(satir);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Dosya Bulunamadı...");
        } catch (IOException ex) {
            System.out.println("Dosya açılırken hata oluştu.");
        }

        // Yeni kullanıcıysa, listeye yeni bilgileri ekle
        if (!kullaniciBulundu && yeni_kullanıcı) {
            String yeniSatir = ad + "," + sifre + "," + muz_coin + "," + gender + "," + listToString(clothes) + "," + listToString(character_clothes);
            satirlar.add(yeniSatir);
        }

        // Dosyayı yeniden yaz
        try (PrintWriter writer = new PrintWriter(new FileWriter(dosya))) {
            for (String s : satirlar) {
                writer.println(s);
            }
            System.out.println("Bilgiler başarıyla kaydedildi.");
        } catch (IOException ex) {
            System.out.println("Dosya yazılırken hata oluştu.");
        }

        // Programı kapat
        kapat();
    }

    // Yardımcı metod: ArrayList'i "-" ile birleştirilmiş String'e dönüştürür
    private static String listToString(ArrayList<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i < list.size() - 1) {
                sb.append("-");
            }
        }
        return sb.toString();
    }

    private static ArrayList<Integer> parseIDList(String idString) {
        ArrayList<Integer> idList = new ArrayList<>();
        if (!idString.isEmpty()) {
            String[] ids = idString.split("-");
            for (String id : ids) {
                idList.add(Integer.parseInt(id));
            }
        }
        return idList;
    }

    public static String[] uyelik_durumu(String ad, String sifre) {
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("Uygulama_Bilgileri.txt")))) {
            while (scanner.hasNextLine()) {
                String satir = scanner.nextLine();
                String[] bilgiler = satir.split(",");

                if (bilgiler[0].equals(ad) && bilgiler[1].equals(sifre)) {
                    return bilgiler;
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Dosya Bulunamadı...");
        } catch (IOException ex) {
            System.out.println("Dosya açılırken hata oluştu.");
        }

        return null;
    }

    public static void main(String[] args) {
        String ad;
        String sifre;
        String sifre_2;
        String gender = "";
        ArrayList<Integer> clothes = new ArrayList<>();
        ArrayList<Integer> character_clothes = new ArrayList<>();
        double muz_coin = 0;
        boolean yeni_kullanıcı;
        String[] kullaniciBilgileri;

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("------------------------------------------------------\n"
                    + "Muz Cumhuriyeti Karakter Giydirmeceye Hoşgeldiniz.\n"
                    + "Üye girişi yapmak için lütfen 1'e basın\n"
                    + "Yeni kullanıcı oluşturmak için 2'ye basın\n"
                    + "Uygulamadan çıkmak için 3'e basın\n"
                    + "------------------------------------------------------");

            System.out.print("Tercihiniz: ");
            int a = input.nextInt();
            input.nextLine(); // Dummy Scanner

            if (a == 1) {
                System.out.print("Kullanıcı Adınızı giriniz: ");
                ad = input.nextLine();
                System.out.print("Şifreniz: ");
                sifre = input.nextLine();
                kullaniciBilgileri = uyelik_durumu(ad, sifre);

                if (kullaniciBilgileri != null) {
                    System.out.println("Hoşgeldin " + ad);
                    yeni_kullanıcı = false;
                    muz_coin = Double.parseDouble(kullaniciBilgileri[2]);
                    gender = kullaniciBilgileri[3];
                    clothes = parseIDList(kullaniciBilgileri[4]);
                    character_clothes = parseIDList(kullaniciBilgileri[5]);
                    GüncelleVeKapat(ad, sifre, muz_coin, gender, clothes, character_clothes, yeni_kullanıcı);
                } else {
                    System.out.println("Hesabınız bulunamadı. Tekrar deneyiniz ya da hesap oluşturunuz.");
                }

            } else if (a == 2) {
                System.out.print("Kullanıcı Adınızı giriniz: ");
                ad = input.nextLine();

                while (true) {
                    System.out.print("Şifrenizi giriniz: ");
                    sifre = input.nextLine();
                    System.out.print("Şifrenizi tekrar giriniz: ");
                    sifre_2 = input.nextLine();

                    if (!sifre.equals(sifre_2)) {
                        System.out.println("Şifreler eşleşmedi, lütfen tekrar girin.");
                    } else {
                        System.out.println("Kayıt işlemi başarılı");
                        System.out.println("Hoşgeldin " + ad);
                        yeni_kullanıcı = true;
                        muz_coin = 1000;
                        gender = "Unspecified";
                        GüncelleVeKapat(ad, sifre, muz_coin, gender, clothes, character_clothes, yeni_kullanıcı);
                        break;
                    }
                }
            } else if (a == 3) {
                kapat();
            } else {
                System.out.println("Lütfen geçerli bir değer girin.");
            }
        }
    }
}
