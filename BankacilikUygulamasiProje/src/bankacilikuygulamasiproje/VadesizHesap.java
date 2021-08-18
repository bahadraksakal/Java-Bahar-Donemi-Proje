
package bankacilikuygulamasiproje;


public class VadesizHesap extends BankaHesabi
{
    private String hesapTuru="Vadesiz Hesap";    
    
    public VadesizHesap(double bakiye){
        super(bakiye);        
    }
    public String get_hesapTuru(){
        return hesapTuru;
    }
    public void set_hesapturu(String YeniHesapTuru){
        this.hesapTuru=YeniHesapTuru;
    }
    public void paraEkle(double eklenecekMebla){
        if(eklenecekMebla>=0){
            set_bakiye(get_bakiye()+eklenecekMebla);
        }else{
            System.out.println("Ekelencek Meblağyı Başında - olmadan yazınız");
        }
    }
    public void paraCek(double  cekilecekMebla){
        
        if(cekilecekMebla>get_bakiye()){
            System.out.println("Hesabınızdaki paradan daha buyuk bir meblağ çekemezsiniz");
        }
        else{
            set_bakiye(get_bakiye()-cekilecekMebla);
        }
    }
    public void ParaTransferi(double tranferEdilecekTutar , int ListedekiIndex , int AliciBankaHesapIndex) // Ibanlar ile indexler match ediliğ IBANA GOREDE yapılabilir .
    {
        //listeki indexleri ekranda goster        
        if(tranferEdilecekTutar>get_bakiye())
            System.out.println("Hesabınızdaki paradan daha buyuk bir meblağ çekemezsiniz");
        else{
            set_bakiye(get_bakiye()-tranferEdilecekTutar);                    
            Musteri.TumMusteriDatasi.get(ListedekiIndex).get_VadesizHesap(AliciBankaHesapIndex).set_bakiye(Musteri.TumMusteriDatasi.get(ListedekiIndex).get_VadesizHesap(AliciBankaHesapIndex).get_bakiye()+tranferEdilecekTutar);            
        }
    }
    public void krediKarti_borc_ode(int index ,double odenecekMiktar, Musteri musteri){
        if( odenecekMiktar >  musteri.getKrediKartiX(index).GetKartBorcu() || odenecekMiktar>get_bakiye() || odenecekMiktar<0){
            System.out.println("Kredi Kartı Ödemesiz Başarısız.\nLütfen geçerli değerler giriniz.\nLütfen Sayısal Değerler Griniz.\nÖdeme Miktarını başında - olmadan yazınız.");
            throw new NumberFormatException();
        }
        else{
            musteri.getKrediKartiX(index).Borc_Ode(odenecekMiktar);
            paraCek(odenecekMiktar);
            System.out.println("Kredi Kartı Ödemesi Başarılı");
        }
       
    }
    @Override
    public String toString(){
        return super.toString()+"\nHesap Türü: "+hesapTuru;
    }
}
