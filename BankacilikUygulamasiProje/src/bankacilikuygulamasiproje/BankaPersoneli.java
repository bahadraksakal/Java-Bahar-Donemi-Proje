package bankacilikuygulamasiproje;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BankaPersoneli extends Kisi
{
    private int PersonelID;
    public static List<BankaPersoneli> PersonelList = new ArrayList<>() ;   // Tüm banka personelinin bulunduğu liste // banka arayüzü için. 
    private List<Musteri> MusterilerList =new ArrayList<>(); // Personele tanımlı müşterileri tutmak için.
    
    public BankaPersoneli(String Ad, String Soy_Ad, String Email, String Tel_No) {
        super(Ad, Soy_Ad, Email, Tel_No);
        Random rand= new Random();
        PersonelID=rand.nextInt(800000)+100000; // bu fonksiyon ile 800.000 tane farklı numara yazılabilir fakat 800.001 personel ekleneceği zaman programda güncelleme yapılması lazım.
        PersonelList.add(this);
        
    }
    public List getMusteriList(){  // generic tanımlanmadığı için döndürülen listenin metotlarına ulaşmak için casitng işlemi yapılması gerekir.
        return MusterilerList;
    }
    public void addListMusteri(Musteri musteri){ // hem overloading konusuna örnek olsun hemde guıde işimi kolaylaştırır diye 2 adet addmusteri metodu yazdım.
        MusterilerList.add(musteri);
        System.out.println("Bilgeleri aşağıda olan müşteri:\n"+ musteri.toString()+"\n\nbilgilerine sahip Banka personeline tanımlanmıştır.\n"+super.toString());
    }
    public void addListMusteri(int index){
        MusterilerList.add(Musteri.TumMusteriDatasi.get(index));
        System.out.println("Bilgeleri aşağıda olan müşteri:\n"+ Musteri.TumMusteriDatasi.get(index).toString2()+ "\n\nbilgilerine sahip Banka personeline tanımlanmıştır.\n"+super.toString());
    }
    public void DeleteListMusteri(int index){
        MusterilerList.remove(index);
        System.out.println("Bilgeleri aşağıda olan müşteri:\n"+ Musteri.TumMusteriDatasi.get(index).toString2()+ "\n\nbilgilerine sahip Banka personelinden kaldırılmıştır.\n"+super.toString());
    }
    static void DeletePersonel(int index){ // bankadan çıkarılan bir perdonel olursa diye delete personel metodu.
        System.out.println(PersonelList.get(index).toString2()+"\n Bilgilerine Sahip Banka Personeli Bankamızdan Ayrılmıştır.");
        PersonelList.remove(index);              
    }
    public int get_PersonelID(){ // personel ıd ile işlem yapmak istenirse bu metot + bir serach algoritması faydalı olabilir fakat ben guı de kullanmayacağım.
        return PersonelID;
    }
    public Musteri getMusteri(int ListedekiIndex){ // guı de kolaylık olması açısından eklediğim bir metot daha 
        return MusterilerList.get(ListedekiIndex);
    }
    @Override
    public String toString() //  guı textarea için
    {
        return super.toString()+"      Personal ID: "+PersonelID;
    }
    @Override
    public String toString2()
    {
        return super.toString2()+"\nPersonal ID: "+PersonelID;
    }
    
    
}
