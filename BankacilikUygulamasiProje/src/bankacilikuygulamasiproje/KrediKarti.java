package bankacilikuygulamasiproje;

import java.util.Random;

public class KrediKarti 
{
    private int KartNumarasi;
    private double Limit;
    private double GuncelBorc;
    private double KullanilabilirLimit;
    
    public KrediKarti(double Limit, double GuncelBorc){
        // gerekli kontrollü yaptım sadece uygun şartlar kart oluşturabilir ve metotları kullanılabilir.
        if(Limit>=0 && Limit>=GuncelBorc && GuncelBorc>=0){
            this.Limit=Limit;
            this.GuncelBorc=GuncelBorc;
            KullanilabilirLimit=this.Limit-this.GuncelBorc;
            Random rand=new Random();
            KartNumarasi=rand.nextInt(800000000)+100000000;
        }else {
            System.out.println("Hata: Limit, güncel borçtan büyük ve potifiz bir sayı olmalıdır.\nNot: Güncel borcu başında - olmadan giriniz !");
            throw new NumberFormatException();
        }
        
    }
    public void Borc_Ode(double odenecekMiktar){
        if(odenecekMiktar>GuncelBorc){
            System.out.println("Borcunuzdan daha büyük bir meblağ yatıramazsınız. İşlem yapılamadı ");
        }
        else{
            KullanilabilirLimit+=odenecekMiktar;
            GuncelBorc-=odenecekMiktar;
            System.out.println("Kalan Borcunuz: "+GuncelBorc);
            System.out.println("Kullanılabilir Limit: "+KullanilabilirLimit);
        }
        
    }
    public void Karttan_gec(double fiyat){
        if(fiyat>KullanilabilirLimit){
            System.out.println("Limit yetersiz işlem iptal edildi. Lutfen Limitinizi yükseltin yada borcunuzu ödeyin");
        }
        else{
             KullanilabilirLimit-=fiyat;
             GuncelBorc+=fiyat;
            System.out.println("Yeni Borcunuz: "+GuncelBorc);
            System.out.println("Kullanılabilir Limit: "+KullanilabilirLimit);
        }
    }
    public void LimitGuncelle(double yeniLimit){
        
        if(yeniLimit>=0 && yeniLimit>=GuncelBorc){
             
             this.Limit=yeniLimit;
             KullanilabilirLimit=Limit-GuncelBorc;
             System.out.println("Yeni Limit: "+Limit);
             System.out.println("Kullanılabilir Limit: "+KullanilabilirLimit);
        }else {
            System.out.println("Hata: Yeni Limit, güncel borçtan büyük ve potifiz bir sayı olmalıdır.\nNot: Güncel borcu başında - olmadan giriniz !");
            throw new NumberFormatException();
        }
            
    }
    public int GetKartNumarasi(){
        return KartNumarasi;
    }
    public double GetKartBorcu(){
        return GuncelBorc;
    }
    public double GetKartLimiti(){
        return Limit;
    }
    public double GetKartKullanilabilirLimit(){
        return KullanilabilirLimit;
    }
    @Override
    public String toString()
    {
        return "Kart Numarası: "+KartNumarasi+"\nLimit: "+Limit+"\nGuncel Borc: "+GuncelBorc+"\nKullanılabilir Limit: "+KullanilabilirLimit;
    }

    
}
