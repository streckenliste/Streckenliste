package streckenliste_test;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.Scrollbar;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

public class SollAbschuesse extends JPanel{

	private static final long serialVersionUID = 1L;
	private streckenliste frame;
	private static Dimension d;

	public SollAbschuesse(streckenliste Frame)
	 {
	     super(); 
	     frame =Frame;
	     this.setLayout(new BorderLayout());
			
		 /** PANEL 0 - Überschrift ***/ 
        JPanel p0 = new JPanel();  
        p0.setLayout(new GridLayout(1,0));
       
        
        JLabel l = new JLabel("Sollabschüsse Jahr 2010-2013");
        l.setFont(new java.awt.Font("Verdana", 1, 22)); //Formatierung der Schrift
        p0.add(l);
        
        //Tabellen Spalten und Zeilenbeschriftung --> Muss eigentlich automatisch von XML gefüllt werden
     	String[][] rehwild = {
             { "Bock", "8","5","3"},
             { "Geiss", "8","5","3"},
             { "Kitz", "2","0","2"},
            	    
     		};
     	
     	String[][] schwarzwild = {
                 { "Keiler", "8","5","3"},
                 { "Bache", "8","5","3"},
                 { "Ueberlauefer", "2","0","2"},
                	    
     	 	};
           	
   	    
//     	//Spaltenüberschrift setzen
//        String[] columnNames1 = {
//                   "<html><div style=\"color:#000000\"><b>Wildart</b></div></html>", "<html><div style=\"color:#000000\"><b>Sollabschuss</b></div></html>","<html><div style=\"color:#000000\"><b>erledigt</b></div></html>","<html><div align=\"center\" style=\"color:#000000\"><b>noch<br>offen</b></div></html>"
//        };
        
//      //Spaltenüberschrift setzen
//        String[] columnNames2 = {
//        		"<html><div style=\"color:#000000\"><b>Wildart</b></div></html>", "<html><div style=\"color:#000000\"><b>Soll</b></div></html>", "<html><div style=\"color:#000000\"><b>erl</b></div></html>", "<html><div style=\"color:#000000\"><b>offen</b></div></html>"
//        };
      
     	//Spaltenüberschrift setzen
        String[] columnNames1 = {
                   "Wildart", "Soll","erl","offen"
        };
        
        
        //Spaltenüberschrift setzen
        String[] columnNames2 = {
        		"Wildart", "Soll", "erl", "offen"
        };
         
         /** PANEL 1 - Tabelle ***/ 
         
 		JPanel p1 = new JPanel();
 		p1.setLayout(new GridLayout(6,0));
 		
 		
 		//Tabelle erzeugen 		
         final JTable table_reh = new JTable( rehwild, columnNames1 );
         final JTable table_schwarz = new JTable( schwarzwild, columnNames2 );
                  
         
         //Inhalt der Tabelle Mittig setzen
         ((JLabel)(table_reh.getDefaultRenderer(String.class))).setHorizontalAlignment(JLabel.CENTER); 
         ((JLabel)(table_schwarz.getDefaultRenderer(String.class))).setHorizontalAlignment(JLabel.CENTER); 

         
//         //Scrollbare Größe der Tabelle bestimmen
//         table_reh.setPreferredScrollableViewportSize(new Dimension(1110,200));
//         table_schwarz.setPreferredScrollableViewportSize(new Dimension(1110,200));

         //Spaltenbreite bestimmen
         table_reh.getColumnModel().getColumn(0).setPreferredWidth(220);
         table_reh.getColumnModel().getColumn(1).setPreferredWidth(160);
         table_reh.getColumnModel().getColumn(2).setPreferredWidth(100);
         table_reh.getColumnModel().getColumn(3).setPreferredWidth(120);
        
         table_schwarz.getColumnModel().getColumn(0).setPreferredWidth(220);
         table_schwarz.getColumnModel().getColumn(1).setPreferredWidth(160);
         table_schwarz.getColumnModel().getColumn(2).setPreferredWidth(100);
         table_schwarz.getColumnModel().getColumn(3).setPreferredWidth(120);
        
         
         //Zeilenhöhe bestimmen
         table_reh.setRowHeight(27);         
         table_schwarz.setRowHeight(27);

         //Formatierung der Schrift
         table_reh.setFont(new java.awt.Font("Verdana", 1, 12));         
         table_schwarz.setFont(new java.awt.Font("Verdana", 1, 12));

         //Tabellenformatierung
         JTableHeader header = table_reh.getTableHeader();
         DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)header.getDefaultRenderer();
         renderer.setPreferredSize(new Dimension(0,40));
         
         JTableHeader header1 = table_schwarz.getTableHeader();
         DefaultTableCellRenderer renderer1 = (DefaultTableCellRenderer)header1.getDefaultRenderer();
         renderer1.setPreferredSize(new Dimension(0,40));
         
         //Tabelle Rehwild und Überschrift auf Panel setzen auf Panel setzen
         JLabel l1 = new JLabel("Rehwild");
         l1.setFont(new java.awt.Font("Verdana", 1, 15)); //Formatierung der Schrift
         p1.add(l1);
       
         p1.add(new JScrollPane(table_reh));
         
         
         //Tabelle Schwarzwild und Überschrift auf Panel setzen         
         JLabel l2 = new JLabel("Schwarzwild");
         l2.setFont(new java.awt.Font("Verdana", 1, 15)); //Formatierung der Schrift
         p1.add(l2);
         
         p1.add(table_schwarz);         
                

         /** PANEL 2 - Tabelle ***/
        JPanel p2 = new JPanel();
 		p2.setLayout(new FlowLayout());
 		JButton b1 = new JButton("Abbrechen");
 		b1.addActionListener(new ActionListener()
 		{
 			public void actionPerformed(ActionEvent evt)
 			{
 				frame.panel_aendern(2);
 			}
 		});
 		
 		JButton b2 = new JButton("Speichern");
 		b2.addActionListener(new ActionListener()
 		{
 			public void actionPerformed(ActionEvent evt)
 			{
 				
 			}
 		});
 		
 		p2.add(b1);
 		p2.add(b2);
 		
 		JPanel p3 = new JPanel();
 		p3.setLayout(new BorderLayout());
 		p3.add(p2,BorderLayout.EAST);
 			
 		//Hinzufügen zum Frame; siehe oben beim Layout					
 		this.add(p0, BorderLayout.NORTH);
 	    this.add(p1, BorderLayout.CENTER);
 	    this.add(p3, BorderLayout.SOUTH);
 	    
 	    
	        d = new Dimension();
 	        d.setSize(Toolkit.getDefaultToolkit().getScreenSize());
 		    d.width=(int) (750);
 	        d.height= (int) (450);
 	        
 	        
 	        //Größe des Panels mit der Tabelle am Fenster anpassen
 	        p1.setPreferredSize(d);	        
 	           
 	}
 	  		
 	    public void actionPerformed(ActionEvent e) {
 			// TODO Auto-generated method stub
 			
 		};
	
         
         }
	
