package bankacilikuygulamasiproje;

public class YatirimHesabi extends BankaHesabi   // guı den kullanılmayan tek class arayüzden kullanabilirsin guide görebilirsiniz. fakat yatirim hesabı üzerinden işlem yapacanız bir arayüz yoktur.
{
    private String hesapTuru="YatirimHesabi";
    private int faiz=20;
    
    public YatirimHesabi(double bakiye){
        super(bakiye);        
    }
    public int get_faiz(){
        return faiz;
    }
    public String get_hesapTuru(){
        return hesapTuru;
    }
    public void set_hesapturu(String YeniHesapTuru){
        this.hesapTuru=YeniHesapTuru;
    }
    public void set_faiz(int faizOrani){
        this.faiz=faizOrani;
    }
    public void paraEkle(double eklenecekMebla){
        set_bakiye(eklenecekMebla+get_bakiye());
    }
    public void paraCek(double  cekilecekMebla){
       
        if(cekilecekMebla>get_bakiye())
            System.out.println("Hesabınızdaki paradan daha buyuk bir meblağ çekemezsiniz");
        else
            set_bakiye(get_bakiye()-cekilecekMebla);
    }
    @Override
    public String toString(){
        return super.toString()+"\nHesap Türü: "+hesapTuru+"\nReel Faiz:"+faiz;
    }
}
