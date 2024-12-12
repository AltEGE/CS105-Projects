public class Profil {


        private String isim;
        private String sifre;
        private double muz_coin;

    
        public Profil(String isim, double muz_coin, String sifre) {
            this.isim = isim;
            this.muz_coin = muz_coin;
            this.sifre = sifre;
        }
    
        public String getIsim() {
            return isim;
        }
        public void setIsim(String isim) {
            this.isim = isim;
        }
        public String getSifre() {
            return sifre;
        }
        public void setSifre(String sifre) {
            this.sifre = sifre;
        }
        public double getMuz_coin() {
            return muz_coin;
        }
        public void setMuz_coin(double muz_coin) {
            this.muz_coin = muz_coin;
        }
 

}
