package streckenliste_test;
import java.awt.Color;

import javax.swing.*;

 public class reiter extends JPanel
{
  private static final long serialVersionUID = 1L;
  
  private JTabbedPane tp;
  

  public reiter(ListeA liste_a,listeB liste_b,StreckenlisteMelden melden,SollAbschuesse soll)
 {
      super();
      tp = new JTabbedPane();
   
      JPanel panel1 = new JPanel();
      panel1.add(liste_a);
      tp.addTab("Streckenliste A" , panel1);
      
      JPanel panel2 = new JPanel();
      panel2.add(liste_b);
      tp.addTab("Streckenliste B" , panel2);
      
      JPanel panel3 = new JPanel();
      panel3.add(soll);
      tp.addTab("Sollabschüsse" , panel3);
      
      JPanel panel4 = new JPanel();
      panel4.add(melden);
      tp.addTab("Streckenliste melden" , panel4);
      tp.setBackground(Color.white);   
      tp.setFont(new java.awt.Font("Arial",0,16));
      
      this.add(tp);
 }




 }