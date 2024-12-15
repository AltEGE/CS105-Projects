public abstract class Game {

    private double muz_coin;
    private double yatirilan_para;
    protected boolean blackjack;

    public Game (double muz_coin){
        this.muz_coin = muz_coin;
    }
          
    public   void  win(double oran){
        double kazanc = this.yatirilan_para * oran;
        this.muz_coin = this.muz_coin + kazanc;
        System.out.println("Kazancınız: " + kazanc);
        System.out.println("Güncel muz coin bakiyeniz: " + this.muz_coin);
    };


    public void win_blackjake(double oran){
        if(blackjack){
            double kazanc = this.yatirilan_para/2 * oran;
            this.muz_coin = this.muz_coin + kazanc;
        } 
        else{
            double kazanc = this.yatirilan_para * oran;
            this.muz_coin = this.muz_coin + kazanc;
        }
        System.out.println("Güncel muz coin bakiyeniz: " + this.muz_coin);
    }

    public abstract String kurallari_yaz();
    
    public double getMuz_coin() {
        return muz_coin;
    }

    public void setMuz_coin(double muz_coin) {
        this.muz_coin = muz_coin;
    }

    public double getYatirilan_para() {
        return yatirilan_para;
    }

    public void setYatirilan_para(double yatirilan_para) {
        this.yatirilan_para = yatirilan_para;
    }

    public abstract void oyun_başlat();

    public void  para_yatir (double yatirilan_para){

        this.muz_coin = this.muz_coin - yatirilan_para;
        this.yatirilan_para = yatirilan_para;
        Muz_joe_vergisi();

    }

    public void draw(){
        this.muz_coin = this.muz_coin + this.yatirilan_para;
    }

    public void  Muz_joe_vergisi() {
        double sayi = Math.random(); // 0 ile 1 arasında rastgele bir sayı üretir
        if (sayi > 0.035) {
            System.out.println("Muz Joe vergi istiyor");
            double vergi_katsıyısı = Math.random();
            double vergi = this.yatirilan_para * vergi_katsıyısı; 
            this.yatirilan_para = this.yatirilan_para - vergi;
            System.out.println("Yatırdığınız paradana alınan vergi : " + vergi);
            System.out.println("Yatırılan pardan kalan : " + this.yatirilan_para);

        }
        else {
            System.out.println("Muz Joe seni bağışladı vergi yok");
        }
    }
    
    public String Oyunlari_yaz() {
        return "q.....Geri Dön\n"
                + "1....Blackjack\n"
                + "2....Yazı/Tura\n"
                + "3....Yüksek Zar\n"
                + "4....Rulet\n"
                + "5....Çark\n"
                + "6....Bul parayı al karayı\n"
                + "7....Taş kağıt makas\n"
                + "8....Kart eşleştirme\n";
    }
    

    







}
