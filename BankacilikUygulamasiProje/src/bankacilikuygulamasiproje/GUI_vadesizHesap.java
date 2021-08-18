package bankacilikuygulamasiproje;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUI_vadesizHesap extends JFrame implements ActionListener
{
    private int index;
    private VadesizHesap vadesizHesap;
    private  Musteri musteri;
    JPanel jpnl;
    JLabel jlb,jlb1,jlb2,jlb3,jlb4,jlb5,jlb6;
    JTextField jtf,jtf1,jtf2,jtf3,jtf4,jtf5;
    JButton jbt,jbt1,jbt2,jbt3;
    public  GUI_vadesizHesap(int index , Musteri musteri)
    {
        super("Vadesiz Hesap Arayüzü");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(null);
        this.setLocation(140, 50);
        this.index =index;
        this.musteri=musteri;
        vadesizHesap=musteri.get_VadesizHesap(index);
        
        jpnl=new JPanel();
        jpnl.setBounds(20,20,470,580);
        jpnl.setLayout(null);
        this.add(jpnl);
        
        jlb=new JLabel("Para Yatır/Çek");
        jlb.setBounds(50, 0, 200, 16);
        jpnl.add(jlb);
        
        jtf=new JTextField("Meblağ");
        jtf.setBounds(0,30,200,30);
        jpnl.add(jtf);
        
        jbt=new JButton("Yatır");
        jbt.setBounds(0,70, 90, 30);
        jbt.addActionListener(this);
        jpnl.add(jbt);
        
        jbt1=new JButton("Çek");
        jbt1.setBounds(110,70, 90, 30);
        jbt1.addActionListener(this);
        jpnl.add(jbt1);
        
        jlb1=new JLabel("Para Tranferi");
        jlb1.setBounds(280, 0, 200, 16);
        jpnl.add(jlb1);
        
        jtf1=new JTextField("Tranfer Edilecek Miktar");
        jtf1.setBounds(220,30,200,30);
        jpnl.add(jtf1);
        
        jtf2=new JTextField("Alıcının Index i");
        jtf2.setBounds(220,70,200,30);
        jpnl.add(jtf2);
        
        jtf3=new JTextField("Alıcının Vadesiz Hesap Index i");
        jtf3.setBounds(220,110,200,30);
        jpnl.add(jtf3);
        
        jbt2=new JButton("Transfer Et");
        jbt2.setBounds(270,155, 100, 30);
        jbt2.addActionListener(this);
        jpnl.add(jbt2);

        jlb2=new JLabel("Kredi Kartı Borç Ödeme");
        jlb2.setBounds(145, 210, 200, 16);
        jpnl.add(jlb2);
        
        jtf4=new JTextField("Kartın Index i");
        jtf4.setBounds(115, 240, 200, 30);
        jpnl.add(jtf4);
        
        jtf5=new JTextField("Ödenecek Miktar");
        jtf5.setBounds(115, 280, 200, 30);
        jpnl.add(jtf5);
        
        jbt3=new JButton("Öde");
        jbt3.setBounds(190, 320, 70, 30);
        jbt3.addActionListener(this);
        jpnl.add(jbt3);
    
        jlb3=new JLabel("Hesap IBAN: "+vadesizHesap.get_IBAN());
        jlb3.setBounds(0,400, 300, 60);
        jpnl.add(jlb3);
        
        jlb4=new JLabel("Bakiyeniz: "+vadesizHesap.get_bakiye());
        jlb4.setBounds(0,420, 300, 60);
        jpnl.add(jlb4);
        
        jlb5=new JLabel("Hesap Türü: "+vadesizHesap.get_hesapTuru());
        jlb5.setBounds(0,440, 300, 60);
        jpnl.add(jlb5);
        
        jlb6=new JLabel("Ahmet Bahadır Aksakal / 20360859079");
        jlb6.setBounds(200,510,250,20);
        jpnl.add(jlb6);
        
        this.setSize(490, 600);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource().equals(jbt)) {
            int miktar=0;  
            try {
                miktar=Integer.parseInt(jtf.getText());
             } catch (NumberFormatException ne) {
                 
             }
            
            if(miktar<=0 ){
                JOptionPane.showMessageDialog(null,"Hata: Lütfen meblağnın başında  - (eksi)  olmadan giriniz !\nSayı Giriniz ! ","Hata",0);
            }else{
                vadesizHesap.paraEkle(miktar);
                JOptionPane.showMessageDialog(null,"Para Yatırıldı","Bilgi",1);
               
            }  
            jlb4.setText("Bakiyeniz: "+vadesizHesap.get_bakiye());  
            jtf.setText("Meblağ");
        }else if(e.getSource().equals(jbt1)){                      
            int miktar=0;           
            try {
                miktar=Integer.parseInt(jtf.getText());
             } catch (NumberFormatException ne) {                 
             }
            
            if(miktar<=0 || miktar > vadesizHesap.get_bakiye()){
                JOptionPane.showMessageDialog(null,"Hata: Ödenecek miktar Kullanılabilir Limitten büyük olamaz\nLütfen ödenecek tutarı başında  - (eksi)  olmadan giriniz !\nSayı Giriniz ! ","Hata",0);
            }else{
                vadesizHesap.paraCek(miktar);
                JOptionPane.showMessageDialog(null,"Para Başarıyla Çekildi","Bilgi",1);
                 jtf.setText("Meblağ");
                
            }
            jlb4.setText("Bakiyeniz: "+vadesizHesap.get_bakiye());
        }else if(e.getSource().equals(jbt2)){
             try {                
                double miktar= Double.parseDouble(jtf1.getText());
                     if(miktar<0 || miktar>vadesizHesap.get_bakiye()){
                         throw new NumberFormatException();
                     }
                 vadesizHesap.ParaTransferi(miktar, Integer.parseInt(jtf2.getText()), Integer.parseInt(jtf3.getText()));
                JOptionPane.showMessageDialog(null,"Tranfer Tamamlandı","Bilgi",1);
                jlb4.setText("Bakiyeniz: "+vadesizHesap.get_bakiye());
             } catch (NumberFormatException |IndexOutOfBoundsException ne ) {
                   JOptionPane.showMessageDialog(null,"Hata: Yeni Limit Güncel Borçtan Küçük Olamaz.\nLütfen Pozitif Bir Sayı Giriniz !\nLütfen  Indexlere Dikkat ediniz.","Hata",0);
             }
            jtf1.setText("");
            jtf2.setText("");
            jtf3.setText("");
        }else if(e.getSource().equals(jbt3)){
             try {
                 double di;
                 int i;
                 di=Double.parseDouble(jtf5.getText());
                 i=Integer.parseInt(jtf4.getText());                 
                 vadesizHesap.krediKarti_borc_ode(i, di, musteri);
                 jlb4.setText("Bakiyeniz: "+vadesizHesap.get_bakiye());
                 JOptionPane.showMessageDialog(null,"Kart Borcu Ödendi","Bilgi",1);                 
             } catch (NumberFormatException | IndexOutOfBoundsException en) {
                  JOptionPane.showMessageDialog(null,"Kredi Kartı Ödemesiz Başarısız.\nLütfen geçerli Index değerleri giriniz.\nLütfen Sayısal Değerler Griniz.\nÖdeme Miktarını başında - olmadan yazınız.\n","Hata",0);
             }
             jtf4.setText("");
             jtf5.setText("");
             
        }               
        
    }
}
