// AHMET BAHADIR AKSAKAL 
// ÖĞRENCİ NO: 20360859079
// BURSA TEKNİK ÜNİVERSİTESİ BİLGİSAYAR MÜHENDİSLİĞİ 1. SINIF ÖĞRENCİSİ
// NESNEYE YÖNELİK PROGRAMLAMA LAB DERSİ PROJE ÖDEVİ
package bankacilikuygulamasiproje;

import java.util.ArrayList;
import java.util.List;

public class BankacilikUygulamasiProje 
{

    public static void main(String[] args) 
    {
        BankaPersoneli Beyza_hanim = new BankaPersoneli("Beyza","Akça","Beyza_akça27@gmail.com","05359996677" );   // peronel 0    
        
        Musteri Ali_bey=new Musteri("Ali","Çiftçi", "aliçiftçi@gmail.com", "05455778314"); // musteri 0
        Ali_bey.KrediKartiEkle(20000, 0);   // kart 0      
        Ali_bey.KrediKartiEkle(17512, 100); // kart 1
        Ali_bey.BankaHesabıEkle(1, 1000);   // yatırım 0
        Ali_bey.BankaHesabıEkle(0, 500);// vadesiz 0
        
        Beyza_hanim.addListMusteri(Ali_bey);  // beyza hanıma tanımlı musteri --0
        
        BankaPersoneli Sanem_hanim = new BankaPersoneli("sanem","kiraz","sanemkiraz@gmail.com","05354495311" ); // personel 1
       
        Musteri ayse_hanim = new Musteri("Ayse", "Bosdan", "aysebostan_@gmail.com", "0555999999"); // musteri 1
        ayse_hanim.KrediKartiEkle(100999.0, 0); // kart 0
        ayse_hanim.KrediKartiEkle(33333.0, 5001); // kart 1
        ayse_hanim.BankaHesabıEkle(0, 11111);   // vadesiz     
        ayse_hanim.BankaHesabıEkle(1, 666); // yatırım
        
        Beyza_hanim.addListMusteri(ayse_hanim); // beyza hanıma tanımlı musteri --1
        
        Ali_bey.get_VadesizHesap(0).ParaTransferi(100, 1, 0); //100 tl listede 1 numarali kisinin 0 numarali vadeli hesabına tranfer edilir.
        
        Musteri merve_hanim = new Musteri("Merve", "Kıran", "merve*_Kıran@gmail.com", "0555000000"); // musteri 2
        // merve hanimin kredi kartı yoktur gui üzerinden eklenebilir.
        merve_hanim.BankaHesabıEkle(0, 88888);  // vadesiz      
        merve_hanim.BankaHesabıEkle(1, 123); // yatırım
        
        Beyza_hanim.addListMusteri(merve_hanim);  // beyza hanıma tanımlı musteri --2
        
        GUI_Bank arayuz=new GUI_Bank("Tosuncuk Bank Created By Baho"); // GUI çalıştı.
        
        Musteri lale_hanim = new Musteri("lale", "ayan", "laleayan@gmail.com", "05555555555"); // musteri 3
        lale_hanim.BankaHesabıEkle(0, 4444);       // vadesiz 0 
        lale_hanim.BankaHesabıEkle(1, 1234);   // yatırım 0
        
        Beyza_hanim.addListMusteri(lale_hanim); // beyza hanıma tanımlı musteri --3
        
        Ali_bey.BankaHesabıEkle(0, 900); // ali bey vadesiz 1
        
        Musteri semih_Bey = new Musteri("Semih", "Uzun", "semihuzun@gmail.com", "05359873456");  // musteri 4
        // vadesiz hesabı yok // yatırm hesabı yok
        semih_Bey.KrediKartiEkle(200, 10); // kredi kartı 0
        
        try {
            semih_Bey.KrediKartiEkle(-200, 30); // kredi kartı 1 olucaktı fakat işlem iptal edildi.limit negatif olamaz.
        } catch (Exception e) {
            System.out.println("Hata!------negatif limitle kart tanımlama"); // konsola basılır.
        }
        
        
       
        
    }
    
}
