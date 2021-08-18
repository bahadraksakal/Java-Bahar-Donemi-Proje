package bankacilikuygulamasiproje;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUI_KrediKarti extends JFrame implements ActionListener{
    
    private int index;
    private KrediKarti krediKarti;
    JPanel jpnl;
    JLabel jlb,jlb1,jlb2,jlb3,jlb4,jlb5,jlb6,jlb7;
    JTextField jtf,jtf1,jtf2,jtf3;
    JButton jbt,jbt1,jbt2;
    public  GUI_KrediKarti(int index , Musteri musteri)
    {
        super("Kredi Kartı Arayüzü");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(null);
        this.setLocation(140, 50);
        this.index =index;
        krediKarti=musteri.getKrediKartiX(index);
        
        jpnl=new JPanel();
        jpnl.setBounds(20,20,470,580);
        jpnl.setLayout(null);
        this.add(jpnl);
        
        jlb=new JLabel("Kredi Kartının Borcunu Öde");
        jlb.setBounds(20, 0, 200, 16);
        jpnl.add(jlb);
        
        jtf=new JTextField("Ödenecek miktar");
        jtf.setBounds(0,30,200,30);
        jpnl.add(jtf);
        
        jbt=new JButton("Öde");
        jbt.setBounds(50,70, 90, 30);
        jbt.addActionListener(this);
        jpnl.add(jbt);
        
        jlb1=new JLabel("Karttan Geç");
        jlb1.setBounds(280, 0, 200, 16);
        jpnl.add(jlb1);
        
        jtf1=new JTextField("Karttan Ödenecek miktar");
        jtf1.setBounds(220,30,200,30);
        jpnl.add(jtf1);
        
        jbt1=new JButton("Öde");
        jbt1.setBounds(270,70, 90, 30);
        jbt1.addActionListener(this);
        jpnl.add(jbt1);
        
        jlb2=new JLabel("Kart Limiti Güncelle");
        jlb2.setBounds(160, 120, 200, 16);
        jpnl.add(jlb2);
        
        jtf2=new JTextField("Yeni Limit");
        jtf2.setBounds(110,140,200,30);
        jpnl.add(jtf2);
        
        jbt2=new JButton("Limiti Güncelle");
        jbt2.setBounds(150,180, 120, 30);
        jbt2.addActionListener(this);
        jpnl.add(jbt2);
        
        jlb3=new JLabel("Kredi Kartı Limiti: "+krediKarti.GetKartLimiti());
        jlb3.setBounds(0,300, 300, 60);
        jpnl.add(jlb3);
        
        jlb4=new JLabel("Kullanılabilir Limit: "+krediKarti.GetKartKullanilabilirLimit());
        jlb4.setBounds(0,370, 300, 60);
        jpnl.add(jlb4);
        
        jlb5=new JLabel("Güncel Borç: "+krediKarti.GetKartBorcu());
        jlb5.setBounds(0,440, 300, 60);
        jpnl.add(jlb5);
        
        jlb6=new JLabel("Ahmet Bahadır Aksakal / 20360859079");
        jlb6.setBounds(180,500,250,20);
        jpnl.add(jlb6);
        
        jlb7=new JLabel("Not: Ödediğiniz borç, vadesiz hesabınızdan çekilmez. (Bankadan yatırılmış gibi.)");
        jlb7.setBounds(0,250, 470, 16);
        jpnl.add(jlb7);
        
        this.setSize(490, 600);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource().equals(jbt)) {
            double miktar=0;  
            try {
                miktar=Double.parseDouble(jtf.getText());
             } catch (NumberFormatException ne) {
                 
             }
            
            if(miktar<=0 || miktar > krediKarti.GetKartBorcu()){
                JOptionPane.showMessageDialog(null,"Hata: Ödenecek miktar borçtan büyük olamaz\nLütfen ödenecek tutarı başında  - (eksi)  olmadan giriniz !\nSayı Giriniz ! ","Hata",0);
            }else{
                krediKarti.Borc_Ode(miktar);
                JOptionPane.showMessageDialog(null,"Borç Ödendi","Bilgi",1);
                jlb3.setText("Kredi Kartı Limiti: "+krediKarti.GetKartLimiti());
                jlb4.setText("Kullanılabilir Limit: "+krediKarti.GetKartKullanilabilirLimit());
                jlb5.setText("Güncel Borç: "+krediKarti.GetKartBorcu());
            }              
        }else if(e.getSource().equals(jbt1)){                      
            double miktar=0;           
            try {
                miktar=Double.parseDouble(jtf.getText());
             } catch (NumberFormatException ne) {                 
             }
            
            if(miktar<=0 || miktar > krediKarti.GetKartKullanilabilirLimit()){
                JOptionPane.showMessageDialog(null,"Hata: Ödenecek miktar Kullanılabilir Limitten büyük olamaz\nLütfen ödenecek tutarı başında  - (eksi)  olmadan giriniz !\nSayı Giriniz ! ","Hata",0);
            }else{
                krediKarti.Karttan_gec(miktar);
                JOptionPane.showMessageDialog(null,"Karttan Ödeme Yapıldı","Bilgi",1);
                jlb3.setText("Kredi Kartı Limiti: "+krediKarti.GetKartLimiti());
                jlb4.setText("Kullanılabilir Limit: "+krediKarti.GetKartKullanilabilirLimit());
                jlb5.setText("Güncel Borç: "+krediKarti.GetKartBorcu());
            }
            
        }else if(e.getSource().equals(jbt2)){
             try {                
                krediKarti.LimitGuncelle(Integer.parseInt(jtf2.getText()));
                JOptionPane.showMessageDialog(null,"Limit Güncellendi","Bilgi",1);
                jlb3.setText("Kredi Kartı Limiti: "+krediKarti.GetKartLimiti());
                jlb4.setText("Kullanılabilir Limit: "+krediKarti.GetKartKullanilabilirLimit());
                jlb5.setText("Güncel Borç: "+krediKarti.GetKartBorcu());
             } catch (NumberFormatException ne ) {
                   JOptionPane.showMessageDialog(null,"Hata: Yeni Limit Güncel Borçtan Küçük Olamaz.\nLütfen Pozitif Bir Sayı Giriniz !","Hata",0);
             }
            
        }               
    }  
}
