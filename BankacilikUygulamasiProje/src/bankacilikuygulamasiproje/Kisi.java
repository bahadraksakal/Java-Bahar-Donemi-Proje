package bankacilikuygulamasiproje;

public class Kisi 
{
    private String Ad;
    private String Soy_Ad;
    private String Email;
    private String Tel_No;
    
    public Kisi(String Ad,String Soy_Ad,String Email,String Tel_No){ // nesne yaratılırken constructor bu 4 nesneyide almak zorundadır.
        this.Ad=Ad;
        this.Soy_Ad=Soy_Ad;
        this.Email=Email;
        this.Tel_No=Tel_No;
        
    }
    public String get_Ad(){  //  verileri getirmek için get fonksiyonları
        return Ad;
    }
    public String get_Soyad(){
        return Soy_Ad;
    }
    public String get_Mail(){
        return Email;
    }
    public String get_TelNo(){
        return Tel_No;
    }
    public void set_Ad(String ad){ // verileri değiştirmek için set fonksiyonları 
        this.Ad=ad;   
    }
    public void set_Soyad(String soyad_ad){
       this.Soy_Ad=soyad_ad;
    }
    public void set_Mail(String mail){
        this.Email=mail;
    }
    public void set_TelNo(String TelNo){
        this.Tel_No=TelNo;
    }
    @Override
    public String toString() // GUI de kullanmak için ToString
    {
        return "Ad: "+Ad+"      SoyAd: "+Soy_Ad+"       Email: "+Email+"        TelefonNumarası: "+Tel_No;
    }
    public String toString2() //  Consol da kullanmak için ToString
    {
        return "Ad: "+Ad+"\nSoyAd: "+Soy_Ad+"\nEmail: "+Email+"\nTelefonNumarası: "+Tel_No;
    }
            
    
}
