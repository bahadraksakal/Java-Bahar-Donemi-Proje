package bankacilikuygulamasiproje;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
// impotları özellik uzun uzn tanımladım diğer guı ler .* ile kısaca tanımladım amacım her iki kullanımada değinmekti.
public class GUI_Bank extends JFrame implements ActionListener,ListSelectionListener
{
    JPanel jpnl;
    JButton jbt,jbt1,jbt2,jbt3,jbt4,jbt5,jbt6,jbt7;
    JTextField jtf;
    JTextField jtf1;
    JTextField jtf2;
    JTextField jtf3;
    JTextField jtf4;
    JTextField jtf5;
    JTextField jtf6;
    DefaultListModel<String> MusteriListesiModeli; 
    DefaultListModel<String> PersonelListesiModeli; 
    JList<String> j_list;
    JList<String> j_list1;    
    JLabel jlb;
    JLabel jlb1;
    JLabel jlb2;
    JLabel jlb3;
    JLabel jlb4;
    JLabel jlb5;
    JLabel jlb6;
    JLabel jlb7;
    JLabel jlb8;
    JLabel jlb9;
    JLabel jlb10;
    JLabel jlb11;
    JLabel jlb12;
    JCheckBox jcb;
    // değişkenleri , ile yan yanda tanımlayabilirdim ama bu şekilde yazmayı tercih ettim. Diğer guı lerde aralarına , atarak kullandım.
    
    public static int sayac=0;
    
    public GUI_Bank (String s){
        super(s);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocation(100, 70); // penrenin ilk açıldığı konum (pc ekranına göre).
        
        jpnl=new JPanel();
        jpnl.setBounds(0,10,1280,700); // companentin konumu
        jpnl.setLayout(null);
        this.add(jpnl);
        
        jlb=new JLabel("Ahmet Bahadır Aksakal / 20360859079");
        jlb.setBounds(1000,610,250,20);
        jpnl.add(jlb); //  jpnl e ekleme işlemleri...
        
        jbt=new JButton("Müşteri Ekle");
        jbt.setBounds(20,140,110,30);
        jpnl.add(jbt);
        
        jbt4=new JButton("Personel Ekle");
        jbt4.setBounds(140,140,125,30);
        jpnl.add(jbt4);
        
        jbt3=new JButton("Listeyi Güncelle");
        jbt3.setBounds(350,150,140,30);
        jpnl.add(jbt3);
        
        jlb6=new JLabel("! Var Olan Kişileri Görebilmek İçin Listeleri Güncelleyiniz !");
        jlb6.setBounds(5,190,330,16);
        jpnl.add(jlb6);
        
        jtf=new JTextField("Adı");
        jtf.setBounds(20,10,250,30);
        jpnl.add(jtf);
        
        jtf1=new JTextField("SoyAdı");
        jtf1.setBounds(20,40,250,30);
        jpnl.add(jtf1);
        
        jtf2=new JTextField("Mail Adresi");
        jtf2.setBounds(20,70,250,30);
        jpnl.add(jtf2);
        
        jtf3=new JTextField("Telefon Numarası");
        jtf3.setBounds(20,100,250,30);
        jpnl.add(jtf3);
        
        jbt.addActionListener(this); // butonlara action listener ekleme.
        jbt3.addActionListener(this);
        jbt4.addActionListener(this);
        
        jlb2=new JLabel("Müşteri Listesi");
        jlb2.setBounds(480,0,100,16);
        jpnl.add(jlb2);
        MusteriListesiModeli=new DefaultListModel<>();

        j_list =new JList<>(MusteriListesiModeli);
        j_list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION); 
        j_list.addListSelectionListener(this);
        
        JScrollPane j_list_scroll=new JScrollPane(j_list);
        j_list_scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        j_list_scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        j_list_scroll.setPreferredSize(new Dimension(250, 80));
        j_list_scroll.setBounds(350,18,350,120);
        
        
        jpnl.add(j_list_scroll);
        
        jlb3 =new JLabel("NOT: Müşteriye erişmek için listedeki müşteriye tıklayın.");
        jlb3.setBounds(350,190,380,16);
        jpnl.add(jlb3);
        
        
        jlb1 =new JLabel("Personel Listesi");
        jlb1.setBounds(930,0,100,16);
        jpnl.add(jlb1);
        
        PersonelListesiModeli=new DefaultListModel<>();
        j_list1 =new JList<>(PersonelListesiModeli);
        j_list1.addListSelectionListener(this);
        j_list1.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);        
        
        JScrollPane j_list_scroll1=new JScrollPane(j_list1);
        j_list_scroll1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        j_list_scroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        j_list_scroll1.setPreferredSize(new Dimension(250, 80));
        j_list_scroll1.setBounds(800,18,350,120);
        
        jpnl.add(j_list_scroll1);
        
        jbt1=new JButton("Listeyi Güncelle");
        jbt1.setBounds(800,150,140,30);
        jbt1.addActionListener(this);
        jpnl.add(jbt1);
        
        jlb4 =new JLabel("NOT: Personele erişmek için listedeki personele tıklayın.");
        jlb4.setBounds(800,190,380,16);
        jpnl.add(jlb4);
        
        jlb7=new  JLabel("Bilgi: Program çökmeyecek şekilde tasarlanmıştır farklı şeyler deneyebilirsiniz :) ");
        jlb7.setBounds(20,610,500,20);
        jpnl.add(jlb7);
        
        jlb8 = new JLabel("Personel Giriş:");
        jlb8.setBounds(885,250,100,16);
        jpnl.add(jlb8);
        
        jtf4=new JTextField("Personel ID");
        jtf4.setBounds(800,270,250,30);
        jpnl.add(jtf4);
        
        jbt5=new JButton("Login");
        jbt5.setBounds(880,310,90,30);
        jbt5.addActionListener(this);
        jpnl.add(jbt5);
        
        jbt2=new JButton("Login");
        jbt2.setBounds(430,310,90,30);
        jbt2.addActionListener(this);
        jpnl.add(jbt2);
        
        jlb9=new JLabel("Müşteri Giriş:");
        jlb9.setBounds(435,250,100,16);
        jpnl.add(jlb9);
        
        jtf5=new JTextField("Müşteri Numarası");
        jtf5.setBounds(350,270,250,30);
        jpnl.add(jtf5);
        
        jlb10=new JLabel("NOT: Listeden tıklamak yada Personel ID ile giriş yapmak aynı pencereyi açar.");
        jlb10.setBounds(800,350,450,30);
        jpnl.add(jlb10);
        
        jlb11=new JLabel("NOT: Listeden tıklamak yada müşteri no ile giriş yapmak aynı pencereyi açar.");
        jlb11.setBounds(350,350,450,30);
        jpnl.add(jlb11);
        
        jtf6=new JTextField("Genel Listesindeki Index");
        jtf6.setBounds(20,270,240,30);
        jpnl.add(jtf6);
        
        jlb12=new JLabel("Müşteri/Personel Sil: ");
        jlb12.setBounds(75,250,130,16);
        jpnl.add(jlb12);
        
        jbt6=new JButton("Müşteri Sil");
        jbt6.setBounds(20,310,115,30);
        jbt6.addActionListener(this);
        jpnl.add(jbt6);
        
        jbt7=new JButton("Personel Sil");
        jbt7.setBounds(145,310,115,30);
        jbt7.addActionListener(this);
        jpnl.add(jbt7);
        
        this.setSize(1280, 720);
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource().equals(jbt3)) {
             JOptionPane.showMessageDialog(null, "Müşteri Listesi Güncellendi", "Bilgi", 1);
             MusteriListesiModeli.clear();
             for (int i = 0; i < Musteri.TumMusteriDatasi.size(); i++) {
                 MusteriListesiModeli.add(i, i+"- "+Musteri.TumMusteriDatasi.get(i).toString()); 
             }         
            jtf.setText("Adı");
            jtf1.setText("SoyAdı");
            jtf2.setText("Mail Adresi");
            jtf3.setText("Telefon Numarası");
        }
        else if(e.getSource().equals(jbt4)){
            JOptionPane.showMessageDialog(null,"Personel Eklendi","Bilgi",1);
            BankaPersoneli yeni_banka_personeli = new BankaPersoneli(jtf.getText(), jtf1.getText(), jtf2.getText(), jtf3.getText());
            PersonelListesiModeli.clear();
            for (int i = 0; i < BankaPersoneli.PersonelList.size(); i++) {
                PersonelListesiModeli.add(i, i+"-"+BankaPersoneli.PersonelList.get(i).toString());
            }
            
        }
        else if(e.getSource().equals(jbt))
        {
            
            JOptionPane.showMessageDialog(null, "Müşteri Eklendi", "Bilgi", 1);
            Musteri yeni_musteri=new Musteri(jtf.getText(), jtf1.getText(), jtf2.getText(), jtf3.getText());
            MusteriListesiModeli.clear();
            for (int i = 0; i < Musteri.TumMusteriDatasi.size(); i++) {
                 MusteriListesiModeli.add(i, i+"- "+Musteri.TumMusteriDatasi.get(i).toString()); 
            }        
            
            jtf.setText("Adı");
            jtf1.setText("SoyAdı");
            jtf2.setText("Mail Adresi");
            jtf3.setText("Telefon Numarası");
            
        }
        else if(e.getSource().equals(jbt2)){
            for (int i = 0; i < Musteri.TumMusteriDatasi.size()+1; i++) {
              try{
                  if(Musteri.TumMusteriDatasi.get(i).get_Musteri_Numarasi() == Integer.parseInt(jtf5.getText()))
                  {
                      JOptionPane.showMessageDialog(null, Musteri.TumMusteriDatasi.get(i).get_Musteri_Numarasi()+" Numaralı Müşteri Giriş Yapıyor Ok butonuna tıklayınız." , "Bilgi", 1); //ok demeyi bekler
                      GUI_musteri gUI_musteri=new GUI_musteri(i);
                      jtf5.setText("Müşteri Numarası");
                      break;
                  }
                  else
                      continue;
              }catch(IndexOutOfBoundsException | NumberFormatException error){
                  jtf5.setText("Müşteri Numarası");
                  JOptionPane.showMessageDialog(null, "Bu ID ye sahip bir müşteri yok!", "Hata", 0);
                  break;

              }                
          }             
        }        
        else if(e.getSource().equals(jbt1))
        {            
             JOptionPane.showMessageDialog(null, "Personel Listesi Güncellendi", "Bilgi", 1);
             PersonelListesiModeli.clear();
             for (int i = 0; i < BankaPersoneli.PersonelList.size(); i++) {
                 PersonelListesiModeli.add(i, i+"- "+BankaPersoneli.PersonelList.get(i).toString()); 
             } 
        }
        else if(e.getSource().equals(jbt5)){
            for (int i = 0; i < BankaPersoneli.PersonelList.size()+1; i++) {
                try{
                    if(BankaPersoneli.PersonelList.get(i).get_PersonelID() == Integer.parseInt(jtf4.getText()))
                    {
                        JOptionPane.showMessageDialog(null,BankaPersoneli.PersonelList.get(i).get_PersonelID()+" ID li Personel Giriş Yapıyor Ok butonuna tıklayınız." , "Bilgi", 1); //ok demeyi bekler
                        GUI_personel personel_arayuzu=new GUI_personel(i);  
                        jtf4.setText("Personel ID");
                        break;
                    }
                    else
                        continue;
                }catch(IndexOutOfBoundsException | NumberFormatException error){
                    jtf4.setText("Personel ID");
                    JOptionPane.showMessageDialog(null, "Bu ID ye sahip bir Personel yok!", "Hata", 0);
                    break;
                    
                }                
            }  
            
        }
        else if(e.getSource().equals(jbt6)){
            try {                
                int hata_kodu=Musteri.musteri_sil(Integer.parseInt(jtf6.getText()));
                if(hata_kodu==0)
                    JOptionPane.showMessageDialog(null, "Personel Başarıyla Silindi Lütfen Personel Listesini Güncelleyiniz", "Bilgi", 1);
                else if(hata_kodu==1)                    
                    JOptionPane.showMessageDialog(null, "Lütfen Vadesiz Hesaplarınızdaki Paranın Tamamını Çekiniz", "Hata", 0);
                else if(hata_kodu==2)
                    JOptionPane.showMessageDialog(null, "Lütfen Tüm Yatırım Hesaplarınızdaki  Paranın Tamamını Çekiniz ", "Hata", 0);
                else
                    JOptionPane.showMessageDialog(null, "Lütfen Tüm Kredi Kartlarınızdaki Borçlarınızın Tamamını Kapayınız", "Hata", 0);
                jtf6.setText("Genel Listesindeki Index");
            } catch (NumberFormatException | IndexOutOfBoundsException Ie) {
                JOptionPane.showMessageDialog(null, "Bu Index te bir Personel yok!", "Hata", 0);
                jtf6.setText("Genel Listesindeki Index");
            }
        }
        else if(e.getSource().equals(jbt7)){
            try {
                BankaPersoneli.DeletePersonel(Integer.parseInt(jtf6.getText()));
                JOptionPane.showMessageDialog(null, "Personel Başarıyla Silindi Lütfen Personel Listesini Güncelleyiniz", "Bilgi", 1);
                jtf6.setText("Genel Listesindeki Index");
            } catch (NumberFormatException | IndexOutOfBoundsException ee) {               
                JOptionPane.showMessageDialog(null, "Bu Index te bir Personel yok!", "Hata", 0);     
                jtf6.setText("Genel Listesindeki Index");
            }
           
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(e.getSource().equals(j_list1) && j_list1.getSelectedIndex()!=-1 ){
            JOptionPane.showMessageDialog(null,j_list1.getSelectedIndex()+". indexteki banka personeline tıkladınız \n"+ j_list1.getSelectedValue()+"\nPersonele Giriş Yapılıyor Ok butonuna tıklayınız." , "Bilgi", 1); //ok demeyi bekler    
            GUI_personel personel_arayuzu=new GUI_personel(j_list1.getSelectedIndex());            
        }
        else if(e.getSource().equals(j_list) && j_list.getSelectedIndex()!=-1 ){
            JOptionPane.showMessageDialog(null,j_list.getSelectedIndex()+". indexteki banka müşterisine tıkladınız \n"+ j_list.getSelectedValue()+"\nMüşteriye Giriş Yapılıyor Ok butonuna tıklayınız." , "Bilgi", 1); //ok demeyi bekler    
            GUI_musteri gUI_musteri = new GUI_musteri(j_list.getSelectedIndex());
        }
    }
    
     

}

    
