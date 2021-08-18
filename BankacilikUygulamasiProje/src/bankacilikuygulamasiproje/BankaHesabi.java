package bankacilikuygulamasiproje;


import java.util.Random;

public class BankaHesabi 
{
    private StringBuilder IBAN=new StringBuilder(); // string builder sınıfına örnek olması açısından nbu yapıyı kullandım.
    private double bakiye;
    
    public BankaHesabi(double bakiye)
    {
        this.bakiye=bakiye;
        Random rast = new Random();
        IBAN.append("TR");
        for (int i = 0; i < 5; i++) {
            IBAN.append((rast.nextInt(3000)+1000)); 
        }
       
    }
    public StringBuilder get_IBAN(){
        return IBAN;
    }
    public double get_bakiye(){
        return bakiye;
    }
    public void set_bakiye(double bakiye){
        this.bakiye=bakiye;
    }
    @Override
    public String toString(){
        return "IBAN: "+IBAN+"\nBakiye: "+bakiye;
    }
}
