package bankacilikuygulamasiproje;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUI_musteri extends JFrame implements ActionListener
{
    // bu class ile Guı_Bank arasından tek yönlü ilişki vardır . Ana arayüz bank tır diğer arayüzlere ordan erişilir.
    JPanel jpnl;
    JLabel jlb,jlb1,jlb2,jlb3,jlb4,jlb5;
    JTextArea jta;
    JTextField jtf,jtf1,jtf2,jtf3,jtf4;
    JButton jbt,jbt1,jbt2,jbt3,jbt4,jbt5,jbt6,jbt7,jbt8;
    private Musteri selected_Musteri; // islemleri uzun uzun yazmamak  için tanımlandı
    private KrediKarti krediKarti; // islemleri uzun uzun yazmamak  için tanımlandı
    private VadesizHesap vadesizHesap; // islemleri uzun uzun yazmamak  için tanımlandı
    private YatirimHesabi yatirimHesabi; // islemleri uzun uzun yazmamak  için tanımlandı
    private int index; // seçili müşterinin listedeki indexi.
    
    public  GUI_musteri(int index)
    {
        super("Müşteri Arayüzü");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); // sadece bu penceryi kapatır
        this.setLayout(null);
        this.setLocation(130, 40);
        this.index =index;
        selected_Musteri=Musteri.TumMusteriDatasi.get(index);      
        
        
        
        jpnl=new JPanel();
        jpnl.setBounds(0, 10, 940, 680);
        jpnl.setLayout(null);
        jpnl.setVisible(true);
        this.add(jpnl);
        
        jlb=new JLabel("Müşteri Bilgileri");
        jlb.setBounds(110, 10, 100, 16);
        jpnl.add(jlb);
        
        jta = new JTextArea();
        jta.setEditable(false);
        
        JScrollPane scroll = new JScrollPane(jta);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setPreferredSize(new Dimension(250, 80));
        scroll.setBounds(10, 35, 300, 300);
        jpnl.add(scroll);  
        
        jbt =new JButton("Listeyi Güncelle");
        jbt.setBounds(10, 345, 140, 30);
        jbt.addActionListener(this);
        jpnl.add(jbt);
        
        jlb2=new JLabel("! Var Olan Bilgileri Görebilmek İçin Listeyi Güncelleyiniz !");
        jlb2.setBounds(10,385,330,16);
        jpnl.add(jlb2);
        
        jlb1=new JLabel("Kredi Kartı Ekleme");
        jlb1.setBounds(400, 10, 200, 16);
        jpnl.add(jlb1);
        
        jtf=new JTextField("Kredi Kartı Limit");
        jtf.setBounds(350, 35, 200, 30);
        jpnl.add(jtf);
        
        jtf1=new JTextField("Güncel Borç");
        jtf1.setBounds(350, 70, 200, 30);
        jpnl.add(jtf1);
        
        jbt1=new JButton("Ekle");
        jbt1.setBounds(420, 110, 60, 30);
        jbt1.addActionListener(this);
        jpnl.add(jbt1);
        
        jlb3=new JLabel("Vadesiz / Yatırım - Hesabı Ekleme");
        jlb3.setBounds(610, 10, 250, 16);
        jpnl.add(jlb3);
        
        jtf2=new JTextField("Bakiye");
        jtf2.setBounds(600, 35, 200, 30);
        jpnl.add(jtf2);
        
        jbt2 =new JButton("Vadesiz Hesap Ekle");
        jbt2.setBounds(600, 75, 200, 30);
        jbt2.addActionListener(this);
        jpnl.add(jbt2);
        
        jbt3 =new JButton("Yatırım Hesabı Ekle");
        jbt3.setBounds(600, 110, 200, 30);
        jbt3.addActionListener(this);
        jpnl.add(jbt3);
        
        jlb4=new JLabel("Kredi Kartı Sil:");
        jlb4.setBounds(530, 170, 200, 30);
        jpnl.add(jlb4);
        
        jtf3=new JTextField("Kredi Kartı Index || Numarası");
        jtf3.setBounds(450, 195, 250, 30);
        jpnl.add(jtf3);
        
        jbt4=new JButton("Kartı Sil Index");
        jbt4.setBounds(450, 235, 120, 30);
        jbt4.addActionListener(this);
        jpnl.add(jbt4);
        
        jbt5=new JButton("Kartı Sil Numara");
        jbt5.setBounds(575, 235, 125, 30);
        jbt5.addActionListener(this);
        jpnl.add(jbt5);
        
        jlb5=new JLabel("Kredi Kart - Vadesiz/Yatırım  Giriş: ");
        jlb5.setBounds(480, 315, 200, 30);
        jpnl.add(jlb5);
        
        jtf4=new JTextField("Kredi Kart - Vadesiz/Yatırım Hesabı Index");
        jtf4.setBounds(425, 340, 290, 30);
        jpnl.add(jtf4);
        
        jbt6=new JButton("Kart");
        jbt6.setBounds(425, 380, 90, 30);
        jbt6.addActionListener(this);
        jpnl.add(jbt6);
                
        jbt7=new JButton("Vadesiz");
        jbt7.setBounds(525, 380, 90, 30);
        jbt7.addActionListener(this);
        jpnl.add(jbt7);
        
        jbt8=new JButton("Yatırım");
        jbt8.setBounds(625, 380,90, 30);
        jbt8.addActionListener(this);
        jpnl.add(jbt8);      
        
        
        this.setSize(960, 700);
        this.setVisible(true); 
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(jbt)){
            
            JOptionPane.showMessageDialog(null, "Müşterinin Bilgileri Güncellendi", "Bilgi", 1);
            jta.setText(null);
            jta.append(selected_Musteri.toString2());
            jta.append("\n\nMüşterinin Vadesiz hessapları:");
            for (int i = 0; i < selected_Musteri.get_BankaHesaplari_List(0).size(); i++) {             
                vadesizHesap=(VadesizHesap)(selected_Musteri.get_BankaHesaplari_List(0).get(i));
                jta.append("\n\n"+"Index: "+i+"\n"+vadesizHesap.toString());

            }
            jta.append("\n\nMüşterinin Yatırım hesapları:");
            for (int i = 0; i < selected_Musteri.get_BankaHesaplari_List(1).size(); i++) {               
                yatirimHesabi=(YatirimHesabi)(selected_Musteri.get_BankaHesaplari_List(1).get(i));
                jta.append("\n\n"+"Index: "+i+"\n"+yatirimHesabi.toString());

            }
            jta.append("\n\nMüşterinin Kredi kartları:");
            for (int i = 0; i < selected_Musteri.getKrediKartlari().size(); i++) {                
                krediKarti=(KrediKarti)(selected_Musteri.getKrediKartlari().get(i));
                jta.append("\n\n"+"Index: "+i+"\n"+krediKarti.toString());

            }
        }else if(e.getSource().equals(jbt1)){
            try{                 
                selected_Musteri.KrediKartiEkle(Double.parseDouble(jtf.getText()),Double.parseDouble(jtf1.getText()) );
                JOptionPane.showMessageDialog(null, "Kredi Kartı Başarıyla Eklendi", "Bilgi", 1);
            }catch(NumberFormatException ne){
                JOptionPane.showMessageDialog(null, "Hata: Limit, güncel borçtan büyük ve potifiz bir sayı olmalıdır \nNot: Lütfen sadece int değer giriniz.\nNot: Güncel borcu başında - (eksi)  olmadan giriniz !", "Bilgi", 0);
            }
            jtf.setText("Kredi Kartı Limit");
            jtf1.setText("Güncel Borç");
        }else if(e.getSource().equals(jbt2)){
            try{
                if (Double.parseDouble(jtf2.getText())<=0) {
                    throw new NumberFormatException();
                }
                selected_Musteri.BankaHesabıEkle(0, Double.parseDouble(jtf2.getText()));
                JOptionPane.showMessageDialog(null, "Vadesiz Hesap Eklendi", "Bilgi", 1);
            }catch(NumberFormatException ne){
                JOptionPane.showMessageDialog(null, "Vadesiz Hesap Eklenemedi Lütfen Sayı Giriniz.", "Bilgi", 0);
            }
        }else if(e.getSource().equals(jbt3)){
            try{
                if (Double.parseDouble(jtf2.getText())<=0) {
                    throw new NumberFormatException();
                }
                selected_Musteri.BankaHesabıEkle(1, Double.parseDouble(jtf2.getText()));
                JOptionPane.showMessageDialog(null, "Yatırım Hesabı Eklendi", "Bilgi", 1);
            }catch(NumberFormatException ne){
                JOptionPane.showMessageDialog(null, "Yatırım Hesabı Eklenemedi Lütfen Sayı Giriniz.", "Bilgi", 0);
            }
            jtf2.setText("Bakiye");
        }else if(e.getSource().equals(jbt4)){
            
            try{
                int hata_kodu=selected_Musteri.KrediKartiSil2(Integer.parseInt(jtf3.getText()));
                if(hata_kodu==0){
                    JOptionPane.showMessageDialog(null, "Kart Silindi", "Bilgi", 1);
                }
                else{
                     JOptionPane.showMessageDialog(null, "Lütfen Kartınız Borcunu Ödeyin. Kart Silinemedi.", "Hata", 0);
                }
            }catch(NumberFormatException | IndexOutOfBoundsException ne){
                JOptionPane.showMessageDialog(null, "Bu Index te bir Kredi Kartı yok!", "Bilgi", 0);
            }
            
            jtf3.setText("Kredi Kartı Index || Numarası");
            
        }else if(e.getSource().equals(jbt5)){
            try {
                int hata_kodu=selected_Musteri.KrediKartiSil(Integer.parseInt(jtf3.getText()));
                
                switch (hata_kodu) {
                    case 0 -> JOptionPane.showMessageDialog(null, "Kart Silindi", "Bilgi", 1);
                    case 1 -> JOptionPane.showMessageDialog(null, "Lütfen Kartınız Borcunu Ödeyin. Kart Silinemedi.", "Bilgi", 1);
                    default -> JOptionPane.showMessageDialog(null, "Bu numaraya sahip bir kart bulunamadı.", "Bilgi", 1);
                }
                
            } catch (NumberFormatException ne) {
                JOptionPane.showMessageDialog(null, "Hata Lütfen Var Olan Bir Numara Giriniz", "Bilgi", 1);
            }
            
            jtf3.setText("Kredi Kartı Index || Numarası");
        }else if(e.getSource().equals(jbt6)){
            try {
                GUI_KrediKarti krediKarti=new GUI_KrediKarti(Integer.parseInt(jtf4.getText()),selected_Musteri);
            } catch (NumberFormatException | IndexOutOfBoundsException ne) {
                JOptionPane.showMessageDialog(null, "Hata Lütfen Var Olan Bir Index Giriniz", "Hata", 0);
            }
            
        }else if(e.getSource().equals(jbt7)){
            try {
                GUI_vadesizHesap vadesizHesap= new GUI_vadesizHesap(Integer.parseInt(jtf4.getText()), selected_Musteri);
            } catch (NumberFormatException | IndexOutOfBoundsException ne) {
                JOptionPane.showMessageDialog(null, "Hata Lütfen Var Olan Bir Index Giriniz", "Hata", 0);
            }
        }else if(e.getSource().equals(jbt8)){          
               JOptionPane.showMessageDialog(null, "Tek Çalışmayan Buton Budur . Zamanım Yetmedi :(  ", "Uyarı", 2);           
        }
    }   
}
