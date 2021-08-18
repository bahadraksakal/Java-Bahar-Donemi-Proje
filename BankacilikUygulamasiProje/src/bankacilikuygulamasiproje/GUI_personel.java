package bankacilikuygulamasiproje;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
// gerekli açıklamalar guı_musteri ve guı_bankta yapılmıştır kodlar benzerlik göstermektedir.
public class GUI_personel extends JFrame implements ActionListener
{
    JPanel jpnl;
    JTextArea jta;
    JTextArea jta1;
    JLabel jlb;
    JLabel jlb2;
    JLabel jlb1;
    JLabel jlb3;
    JLabel jlb4;
    JButton jbt;
    JButton jbt1;
    JButton jbt2;
    JTextField jtf;
    private BankaPersoneli selected_personel;
    private Musteri musteri;
    private KrediKarti krediKarti;
    private VadesizHesap vadesizHesap;
    private YatirimHesabi yatirimHesabi;
    
    private int index; //Listedeki_Personel_indexi
    public GUI_personel(int index){
        super("Personel Arayüzü");              
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(null);
        this.setLocation(150, 50);
        this.index=index;  
        selected_personel=BankaPersoneli.PersonelList.get(index);        
        jpnl=new JPanel();
        jpnl.setBounds(0,10,840,700);
        jpnl.setLayout(null);
        this.add(jpnl);
                
        jbt=new JButton("Listeyi Güncelle");
        jbt.setBounds(215,450,140,30);
        jbt.addActionListener(this);
        jpnl.add(jbt);
        
        jlb4=new JLabel("! Var Olan Bilgileri Görebilmek İçin Listeyi Güncelleyiniz !");
        jlb4.setBounds(120,500,330,16);
        jpnl.add(jlb4);
        
        jta=new JTextArea();
        jta.setEditable(false);    
        
        JScrollPane scroll = new JScrollPane(jta);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setPreferredSize(new Dimension(250, 80));
        scroll.setBounds(20, 30, 500, 400);
        jpnl.add(scroll);
        
        jtf=new JTextField("Müşteri Index");
        jtf.setBounds(570, 30, 150, 30);
        jpnl.add(jtf);
        
        jbt1=new JButton("Ekle");
        jbt1.setBounds(570,70,70,20);
        jbt1.addActionListener(this);
        jpnl.add(jbt1);
        
        jbt2=new JButton("Sil");
        jbt2.setBounds(655,70,65,20);
        jbt2.addActionListener(this);
        jpnl.add(jbt2);
        
        jlb=new JLabel("Personelin Tüm Bilgileri");
        jlb.setBounds(200, 0, 200, 16);
        jpnl.add(jlb);
        
        jlb1=new JLabel("Uyarı:"); //"Ekleme Indexinizi Bankanın Var Olan Müşteri Listesinden yapınız
        jlb1.setBounds(570, 90, 100, 16);
        jpnl.add(jlb1);
        
        jta1=new JTextArea();
        jta1.setBounds(570, 110, 250, 160);
        jta1.append("1)\nMüşteri eklerken index\nnumarasını bankanın müşteri\nlistesine göre yazınız\n");
        jta1.append("2)\nSilme İşlemini, personelin\nkendi müşteri listesindeki\nindex'e göre yazınız\n");
        jta1.setEditable(false);
        jpnl.add(jta1);
        
        jlb=new JLabel("Personelin Müşterileri");
        jlb.setBounds(580, 0, 200, 16);
        jpnl.add(jlb);
        
        jlb3=new JLabel("Ahmet Bahadır Aksakal / 20360859079");
        jlb3.setBounds(580,610,250,20);
        jpnl.add(jlb3);        
        
        this.setSize(860, 720);
        this.setVisible(true);       
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(jbt)){
            JOptionPane.showMessageDialog(null, "Personelin Bilgi Listesi Güncellendi", "Bilgi", 1);
            jta.setText(null);
            jta.append(selected_personel.toString2());
            jta.append("\n\n        PERSONELE TANIMLI "+selected_personel.getMusteriList().size()+" ADET MÜŞTERİ VAR\n\n");
        
            for (int i = 0; i < selected_personel.getMusteriList().size(); i++) 
            {
            
                jta.append((i+1)+".müşterinin tüm bilgileri:\n\n");

                musteri=selected_personel.getMusteri(i);            
                jta.append(musteri.toString2()+"\n"); 
                jta.append("\n"+((Kisi)musteri).get_Ad()+" "+((Kisi)musteri).get_Soyad()+" isimli müşteriye ait kredi kartlari:\n\n");
                for (int j = 0; j< musteri.getKrediKartlari().size(); j++) 
                {
                    krediKarti=musteri.getKrediKartiX(j);
                    jta.append(krediKarti.toString()+"\n\n");
                }

                jta.append("\n"+((Kisi)musteri).get_Ad()+" "+((Kisi)musteri).get_Soyad()+" isimli müşteriye ait vadesiz hesaplar:\n\n");
                for (int j = 0; j < musteri.get_BankaHesaplari_List(0).size(); j++) 
                {
                    vadesizHesap=musteri.get_VadesizHesap(j);
                    jta.append(vadesizHesap.toString()+"\n\n");
                }

                jta.append("\n"+((Kisi)musteri).get_Ad()+" "+((Kisi)musteri).get_Soyad()+" isimli müşteriye ait yatırım hesapları:\n\n");
                for (int j = 0; j < musteri.get_BankaHesaplari_List(1).size(); j++) 
                {
                   yatirimHesabi=musteri.get_YatirimHesabi(j);
                   jta.append(yatirimHesabi.toString()+"\n\n");
                }
        }       
            
        } else if(e.getSource().equals(jbt1)){
            try {
                if( Musteri.TumMusteriDatasi.get(Integer.parseInt(jtf.getText()))!=null  ){
                selected_personel.addListMusteri(Integer.parseInt(jtf.getText()));
                JOptionPane.showMessageDialog(null, "Müşteri Personele Başarıyla eklendi, Lütfen listeyi güncelleyiniz", "Bilgi", 1);
                } else{
                    JOptionPane.showMessageDialog(null, "Bu Indexe sahip bir müşteri yok Index i küçült yada müşteri tanımla !", "Hata", 0);
                }
            }catch (IndexOutOfBoundsException | NumberFormatException ne) {
                JOptionPane.showMessageDialog(null, "Bu Indexe sahip bir müşteri yok Index i küçült yada müşteri tanımla !", "Hata", 0);
            }
            jtf.setText("Müşteri Index");
            
        } else if(e.getSource().equals(jbt2)){
            
            try {
                if( Musteri.TumMusteriDatasi.get(Integer.parseInt(jtf.getText()))!=null  ){
                selected_personel.DeleteListMusteri(Integer.parseInt(jtf.getText()));
                JOptionPane.showMessageDialog(null, "Müşteri Personelden Başarıyla Kaldırıldı, Lütfen listeyi güncelleyiniz", "Bilgi", 1);                
                } else{
                    JOptionPane.showMessageDialog(null, "Bu Indexe sahip bir müşteri yok!", "Hata", 0);
                }
            } catch (IndexOutOfBoundsException | NumberFormatException ne ) {
                JOptionPane.showMessageDialog(null, "Bu Indexe sahip bir müşteri yok!", "Hata", 0);
            }
            jtf.setText("Müşteri Index");
            
        }
        
    }
}
