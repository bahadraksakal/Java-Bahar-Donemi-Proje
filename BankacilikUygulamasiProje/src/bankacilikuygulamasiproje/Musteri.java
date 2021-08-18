package bankacilikuygulamasiproje;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;


public class Musteri extends Kisi
{
    private int MusteriNumarasi;
    private List<KrediKarti> KrediKartlari= new ArrayList<>();
    private List<YatirimHesabi> yatirimHesaplari= new ArrayList<>();
    private List<VadesizHesap> VadesizHesapalar= new ArrayList<>(); // 
    public  static List<Musteri> TumMusteriDatasi=new ArrayList<>(); // bankanın tüm müştelerinin bulunduğu liste sınıfa ait.
    
    public Musteri(String Ad, String Soy_Ad, String Email, String Tel_No){
        super(Ad, Soy_Ad, Email, Tel_No);
        Random rand= new Random();
        MusteriNumarasi=rand.nextInt(90000000)+10000000;   
        TumMusteriDatasi.add(this);
        GUI_Bank.sayac++;
        
    }
    public void KrediKartiEkle(double Limit,double GuncelBorc){
        KrediKartlari.add(new KrediKarti(Limit, GuncelBorc)); // özellikle referans kullanmadım listeye ekleneceği için boşuna referans tanımlamaya gerek yok.
        System.out.println("Kredi Kartı Başarıyla Oluşturuldu"); //  kod hem guı de hemde konsolda çalıştırılacağı için print yapısını sıkça kullandım.
    }
    public int KrediKartiSil(int KartNumarasi){  /*  iteratör yapısına örnek olması açısından ve en az bir Index e göre değilde nesnenin özelliğine göre işlem 
         yapmak için  bu metodu yazdım ve guı de kullandım*/
        KrediKarti card;
        ListIterator<KrediKarti> KartlarIterator = KrediKartlari.listIterator();  
        int i=0;
        while(KartlarIterator.hasNext()){
            card=KartlarIterator.next();
            if(card.GetKartNumarasi() == KartNumarasi){
                
                if(card.GetKartBorcu()!=0.0)
                    return 1;
                
                KrediKartlari.remove(KartlarIterator.nextIndex()-1);
                i=1;
                return 0;
            }
        }        
        System.out.println("İşleminiz Tamamlanmadı lütfen kart numarasını kontrol ediniz yada karta ait borcu ödeyiniz. bu numaraya ait bir kart yok.");
        return 2;
        
    }
     public int KrediKartiSil2(int Listedekiİndexi){
         /* normalde void metotardı fakat guıde işleri uzadığından geri dönüş değeri alarak bu sorunu çzödüm. fakat projedeki sabit fonksiyonları
         sürekli değiştirmemek adına bu işlemi sadece bir kere yaptım ve geri kalan bu tarz fonksiyonlar için guı yi uzun uzun try-catch ler ile yazdım*/
         if(KrediKartlari.get(Listedekiİndexi).GetKartBorcu()==0.0){
             KrediKartlari.remove(Listedekiİndexi);
             System.out.println("Kartınız Silindi");
             return 0; 
         }            
         else{
             System.out.println("Kartınıza ait borc var lutfen borcu ödeyin guncel borcunuz: "+KrediKartlari.get(Listedekiİndexi).GetKartBorcu());
             return 1;
         }
    }
    public List getKrediKartlari(){
        return KrediKartlari;
    }
    public KrediKarti getKrediKartiX(int kartIndex){
        return KrediKartlari.get(kartIndex);
    }
    
    public void BankaHesabıEkle(int zero_or_one , double bakiye) // 0 ise vadesiz 1 ise yatırım
    {
        if(zero_or_one==0){
            VadesizHesap yeni_vadesiz_hesab = new VadesizHesap(bakiye);
            VadesizHesapalar.add(yeni_vadesiz_hesab);
        }
        else{
            YatirimHesabi yeni_yatirim_hesabi = new YatirimHesabi(bakiye);
            yatirimHesaplari.add(yeni_yatirim_hesabi);
        }
    }
    public List get_BankaHesaplari_List(int zero_or_one ){ // 0 değeri vadesiz hesap 1 değeri yatırım hesabı listesini döndürür. 
        //listelerden işlem yapmadan önce bazen casting uygulamak gerekeblir.
        if (zero_or_one==0) {
            return VadesizHesapalar;
        }
        else
            return yatirimHesaplari;
    }
    public YatirimHesabi get_YatirimHesabi(int HesapIndex){
        return yatirimHesaplari.get(HesapIndex);
    }
    public VadesizHesap get_VadesizHesap(int HesapIndex){
        return VadesizHesapalar.get(HesapIndex);
    }
    public int get_Musteri_Numarasi(){
        return  MusteriNumarasi;
    }
    static int musteri_sil(int index)  // bu fonskiyon musterinin tüm bakiyelrini borçların vb.. kontrol eder.            
    {  // her şey uygunsa o zaman silme işlemi yapar değilse ekrana uyarı verir(guı de :)  ).
        Musteri selected_Musteri=Musteri.TumMusteriDatasi.get(index);
        KrediKarti krediKarti;
        VadesizHesap vadesizHesap;
        YatirimHesabi yatirimHesabi;
        for (int i = 0; i < selected_Musteri.get_BankaHesaplari_List(0).size(); i++) {             
            vadesizHesap=(VadesizHesap)(selected_Musteri.get_BankaHesaplari_List(0).get(i));
            if (vadesizHesap.get_bakiye() != 0.0) {
                return 1;
            }

        }

        for (int i = 0; i < selected_Musteri.get_BankaHesaplari_List(1).size(); i++) {               
            yatirimHesabi=(YatirimHesabi)(selected_Musteri.get_BankaHesaplari_List(1).get(i));
            if(yatirimHesabi.get_bakiye() !=0.0){
                return 2;
            }
                
        }

        for (int i = 0; i < selected_Musteri.getKrediKartlari().size(); i++) {                
            krediKarti=(KrediKarti)(selected_Musteri.getKrediKartlari().get(i));
            if(krediKarti.GetKartBorcu()!=0.0){
                return 3;
            }
        }
        
        TumMusteriDatasi.remove(index);
        
        return 0;
    }
    @Override
    public String toString()
    {
        return super.toString()+"       Musteri Numarası: "+MusteriNumarasi;
    }
    @Override
    public String toString2()
    {
        return super.toString2()+"\nMusteri Numarası: "+MusteriNumarasi;
    }
    
}
