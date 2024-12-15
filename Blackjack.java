public class Blackjack extends Game{

<<<<<<< Updated upstream
=======
    private Deste deste1 = new Deste();
    private Scanner input = new Scanner(System.in);



    public Blackjack(double muz_coin) {
        super(muz_coin);
    }


    @Override
    public String kurallari_yaz() {
        return "Blackjack Kuralları:\n" +
               "- Amacınız, kartlarınızın toplam değeri 21'e en yakın olacak şekilde kupiyeri yenmektir.\n" +
               "- Kartların değeri: 2-10 arasındaki kartlar sayı değerinde, J/Q/K 10 puan ve A 1 veya 11 puan sayılır.\n" +
               "- İlk iki kart dağıtıldıktan sonra \"Hit\" (kart çek) veya \"Stand\" (kart çekmeyi bırak) seçebilirsiniz.\n" +
               "- Kupiyer 17 veya daha yüksek bir değere ulaşana kadar kart çeker.\n" +
               "- 21 yaparak kazanırsanız yatırdığınız paranın 2.5 katını kazanırsınız.\n";
    }

    @Override
    public void oyun_başlat() {
        System.out.println(kurallari_yaz());
        System.out.println("Oyun için deste karılıyor");
        deste1.desteKar();
        System.out.println("---------------------------------");
        System.out.println("Muz coin'iniz : " + getMuz_coin());
        System.out.println("---------------------------------");
        while (true) {
            
            System.out.print("\nKaç muz coin yatırmak istiyorsunuz?  ");
            double yatirilanPara = input.nextDouble();
            para_yatir(yatirilanPara);

            deste1.kart_ver(deste1.getKullanıcı());
            deste1.kart_ver(deste1.getKullanıcı());
            deste1.kart_ver(deste1.getKupiyer());
            deste1.kart_ver(deste1.getKupiyer());

            deste1.Kartlatı_göster();
            deste1.kart_esitmi(deste1.getKullanıcı());
            
            if(deste1.isKartlar_esit()){
                System.out.println("Kartlar Eşit Bölelim Mi ? (y)");
                String x = input.nextLine();

                if (x.equalsIgnoreCase("y")) {
                    deste1.kart_ayır(deste1.getKullanıcı());
                    deste1.Kartlatı_göster(); 
                    para_yatir(yatirilanPara); 
                    super.blackjack = true;
                }
            } 

            while (deste1.getKullanıcı_değer() < 21) {
                System.out.println("1. Hit (Kart Çek)\n2. Stand (Yeter)");
                int secim = input.nextInt();
        
                if (secim == 1) {
                    deste1.kart_ver(deste1.getKullanıcı());
                    deste1.hesaplaDeger();
                    deste1.Kartlatı_göster();
        
                    if (deste1.getKullanıcı_değer() > 21) {
                        System.out.println("Bust! 21'i geçtiniz, kupiyer kazandı.");
                        return;
                    }
                } else if (secim == 2) {
                    break;
                } else {
                    System.out.println("Geçersiz seçim! Lütfen 1 veya 2 seçin.");
                }
            }

            if(deste1.isKartlar_esit()){

                while (deste1.getKullanıcı_ayrı() < 21) {
                    System.out.println("1. Hit (Kart Çek)\n2. Stand (Yeter)");
                    int secim = input.nextInt();
            
                    if (secim == 1) {
                        deste1.kart_ver(deste1.getKullanıcı_ayrılmış());
                        deste1.hesaplaDeger();
                        deste1.Kartlatı_göster();
            
                        if (deste1.getKullanıcı_ayrı() > 21) {
                            System.out.println("Bust! 21'i geçtiniz, kupiyer kazandı.");
                            return;
                        }
                    } else if (secim == 2) {
                        break;
                    } else {
                        System.out.println("Geçersiz seçim! Lütfen 1 veya 2 seçin.");
                    }
                }
            }

            deste1.hesaplaDeger();
            deste1.SonKartlatı_göster();

            System.out.println("Kupiyerin Kartları Açılıyor:");
            deste1.SonKartlatı_göster();
            while (deste1.getKupiyer_değer() < 17) {
                deste1.kart_ver(deste1.getKupiyer());
                deste1.hesaplaDeger();
                deste1.SonKartlatı_göster();
            }

            if (deste1.getKullanıcı_değer() <= 21) {
                if (deste1.getKullanıcı_değer() == 21 && deste1.getKupiyer_değer() != 21) {
                    System.out.println("Ana el ile 21 yaptınız! Kazandınız.");
                    win_blackjake(2.5);
                } else if (deste1.getKupiyer_değer() > 21 || deste1.getKullanıcı_değer() > deste1.getKupiyer_değer()) {
                    System.out.println("Ana el ile kazandınız!");
                    win_blackjake(2);
                } else if (deste1.getKullanıcı_değer() == deste1.getKupiyer_değer()) {
                    System.out.println("Ana el için berabere! Yatırdığınız para iade edildi.");
                    draw();
                } else {
                    System.out.println("Ana el ile kupiyer kazandı!");
                }
            }

            // Ayrılmış el için sonucu değerlendir
            if (deste1.getKullanıcı_ayrı() > 0 && deste1.getKullanıcı_ayrı() <= 21) {
                if (deste1.getKullanıcı_ayrı() == 21 && deste1.getKupiyer_değer() != 21) {
                    System.out.println("Ayrılmış el ile 21 yaptınız! Kazandınız.");
                    win_blackjake(2.5);
                } else if (deste1.getKupiyer_değer() > 21 || deste1.getKullanıcı_ayrı() > deste1.getKupiyer_değer()) {
                    System.out.println("Ayrılmış el ile kazandınız!");
                    win_blackjake(2);
                } else if (deste1.getKullanıcı_ayrı() == deste1.getKupiyer_değer()) {
                    System.out.println("Ayrılmış el için berabere! Yatırdığınız para iade edildi.");
                    draw();
                } else {
                    System.out.println("Ayrılmış el ile kupiyer kazandı!");
                }

                System.out.print("\nÇıkmak için 'q' tuşuna basın, yeni oyun için herhangi bir tuşa");
                String devam = input.nextLine();
                if (devam.equalsIgnoreCase("q")) {
                System.out.println("Oyun sonlandırıldı.");
                break;
                }

                if(deste1.isYeterliKart()){
                    System.out.println("Deste Karılıyor");
                    deste1.desteKar();
                }



            }
        }
    }
>>>>>>> Stashed changes
}
