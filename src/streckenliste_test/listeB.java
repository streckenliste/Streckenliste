package streckenliste_test;

/*

 * Streckenliste B
 * 
 * In diesem Fenster wird die Streckenliste B tabellarisch dargestellt.
 * Durch die Auswahl eines Datensatzes (eine Zeile) wird ein weiteres
 * Fenster um Einträge dieses Datensatzes zu ändern geöffnet.
 * 
 * Die Einträge der ersten 4 Zeilen werden von der Streckenliste A 
 * automatisch übernommen und ist deshalb nur bei dem Bemerkungsfeld
 * editierbar.
 *  
 */

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.*;

public class listeB
extends javax.swing.JPanel
implements ActionListener
{

	private static final long serialVersionUID = 1L;
	private streckenliste frame;
	private static Dimension d;
	
	
	public listeB(streckenliste Frame)
	{
		
		super();
		frame=Frame;
		
		this.setLayout(new BorderLayout());
				
		 /** PANEL 0 - Überschrift ***/ 
        JPanel p0 = new JPanel();  
        p0.setLayout(new GridLayout(1,0));
        
        JLabel l = new JLabel("Streckenliste B");
        l.setFont(new java.awt.Font("Verdana", 1, 22)); //Formatierung der Schrift
        p0.add(l);
        
        //Tabellen Spalten und Zeilenbeschriftung --> Muss eigentlich automatisch von XML gefüllt werden
    	String[][] rowData = {
            { "Keiler", "101","8","0","3","Bemerkungstext" },
            { "Bachen", "102","1","0","0","Bemerkungstext"},
            { "Überläufer männlich", "103","2","0","3","Bemerkungstext"},
            { "Überläufer weiblich", "104","4","0","2","Bemerkungstext"},
            { "Feldhase", "201","2","","","Bemerkungstext"},
            { "Schneehase", "202","","","",""},
            { "Wildkaninchen", "203","","","","Bemerkungstext"},
            { "Murmeltier", "204","","","",""},
            { "Fuchs", "205","","","5",""},
            { "Steinmarder", "206","","7","",""},
            { "Baummarder", "207","","","",""},
            { "Fischotter", "208","","7","",""},
            { "Iltis", "209","","","",""},
            { "Hermelin", "210","3","","","Bemerkungstext"},
            { "Mauswiesel", "211","","","","Bemerkungstext"},
            { "Dachs", "212","","7","5",""},
            { "Waschbär", "213","","5","",""},
            { "Marderhund", "214","","34","",""},
            { "Sumpfbiber", "215","4","","","Bemerkungstext"},
            { "Luchs", "216","","","","Bemerkungstextkt"},
            { "Wildkatze", "217","","8","",""},
            { "Sonst. Haarwildarten", "218","","3","",""},
            { "Rebhuhn", "301","","","","Bemerkungstext"},
            { "Fasan", "302","","","",""},
            { "Ringeltaube", "303","","","",""},
            { "Türkentaube", "304","","8","",""},
            { "Waldschnepfe", "305","","34","",""},
            { "Bläßhuhn", "306","","","",""},
            { "Höckerschwan", "307","","8","4",""},
            { "Graureiher", "308","","","",""},
            { "Gänsesäger", "309","8","3","","Bemerkungstext"},
            { "Graugans", "401","","","",""},
            { "Saatgans", "402","","","3",""},
            { "Kanadagans", "403","","","","DBemerkungstextt"},
            { "Sonst. Gänsearten", "404","","12","",""},
            { "Stockente", "501","","","",""},
            { "Krickente", "502","2","","",""},
            { "Knäkente", "503","","","",""},
            { "Tafelente", "504","3","","",""},
            { "Reiherente", "505","","","",""},
            { "Sonst. Entenarten", "506","","","",""},
            { "Lachmöwe", "601","","","","Bemerkungstext"},
            { "Silbermöwe", "602","","","",""},
            { "Sonst. Möwenarten", "603","4","","3","Bemerkungstext"},
            { "Mäussebussard", "701","","","",""},
            { "Habicht", "702","4","","",""},
            { "Sperber", "703","","","",""},
            { "Falken", "704","","","",""},
            { "Sonst. Greifvogelarten", "705","","5","",""},
            { "Elster", "801","4","","",""},
            { "Eichelhäher", "802","","","","Bemerkungstext"},
            { "Rabenkrähe", "803","5","","","Bemerkungstext"},
            { "Kolkrabe", "804","","","",""},
            { "Sonst. Federwildarten", "901","5","","","Bemerkungstext Bemerkungstext"}
          };
  
    	// Alle uneditierbaren Felder werden mit grauer Schrift gekennzeichnet
        for(int k = 0;k<=3;k++)
        	for(int j = 0;j<=4;j++)
        		if(rowData[k][j]=="")
        			rowData[k][j]= "<html><div style=\"color:#707070\">0</div></html>";
        		else
        			rowData[k][j]= "<html><div style=\"color:#707070\">"+ rowData[k][j] +"</div></html>";
        
        // Alle Zahlenfelder in denen nichts steht, werden mit 0 vorbelegt
    	for (int i= 0; i < rowData.length; i++)
    		for(int j = 0; j<6 ; j++ )
    				if(j<5 && (rowData[i][j] == null || rowData[i][j].equals("")))
    					rowData[i][j]="0";
    	
    	//Spaltenüberschrift setzen
         String[] columnNames = {
                    "<html><div style=\"color:#000000\"><b>Wildart</b></div></html>", "<html><div style=\"color:#000000\"><b>Wildartklasse</b></div></html>","<html><div style=\"color:#000000\"><b>Anzahl<br>erl./gef.</b></div></html>","<html><div align=\"center\" style=\"color:#000000\"><b>Fallwild<br>verendet gefunden</b></div></html>","<html><div align=\"center\" style=\"color:#000000\"><b>Fallwild<br>Verkehrsunfall</b></div></html>","<html><div style=\"color:#000000\"><b>Bemerkungen</b></div></html>"
         };
         
         
         
         
        /** PANEL 1 - Tabelle ***/ 
        
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(1,0));
		
		//Tabelle erzeugen
		
        final JTable table = new JTable( rowData, columnNames );

        //Listener
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            	
            	//Objekt für modales Fenster erzeugen
                ModalDialog dia = new ModalDialog(this, true);

                //angeklickte Zeile und Spalte holen
                int zeile = zeile(e.getY());
                int spalte = spalte(e.getX());
                
                //Werte des Datensatzes in Variablen übernehmen
                String wildart = (String)table.getValueAt(zeile(e.getY())-1, 0);
                String wildart_klasse = (String)table.getValueAt(zeile(e.getY())-1, 1);
                String anz_erl = (String)table.getValueAt(zeile(e.getY())-1, 2);
                String fall_verendet = (String)table.getValueAt(zeile(e.getY())-1, 3);
                String fall_verkehr = (String)table.getValueAt(zeile(e.getY())-1, 4);
                String bemerkung = (String)table.getValueAt(zeile(e.getY())-1, 5);
                
                System.out.println(e.getPoint());
                
                //Wenn die ersten 4 Zeilen angeklickt wurden, Fenster um Bemerkung zu ändern öffnen
                if(zeile<=4){
                	dia.setModal(true);
                	dia.showJDialog2(wildart,wildart_klasse,bemerkung,zeile,spalte);
                	if(dia.übernehmen()) // Werte übernehmen
                		table.setValueAt(dia.getBemerk_neu(), zeile-1, 5); 
                }
                
                //Ansonsten Fenster öffnen um kompletten Datensatz ändern zu können
                else{
                	dia.setModal(true);
                	dia.showJDialog(wildart,wildart_klasse,anz_erl,fall_verendet,fall_verkehr,bemerkung,zeile,spalte);
                	if(dia.übernehmen()){ //Werte übernehmen

                		if(!dia.getAnz_erl_neu().equals("")){
                			table.setValueAt(dia.getAnz_erl_neu(),zeile-1, 2);
                		}
                		if(!dia.getFall_vere_neu().equals("")){
                			table.setValueAt(dia.getFall_vere_neu(),zeile-1, 3);}
                		if(!dia.getFall_verk_neu().equals("")){
                			table.setValueAt(dia.getFall_verk_neu(),zeile-1, 4);}
                		
                		table.setValueAt(dia.getBemerk_neu(),zeile-1, 5);
                	}
                } 
            }});

        //((DefaultCellEditor)table.getDefaultEditor(String.class)).setClickCountToStart(100); 
        //Inhalt der Tabelle Mittig setzen
        

        ((JLabel)(table.getDefaultRenderer(String.class))).setHorizontalAlignment(JLabel.CENTER);            

        //Scrollbare Größe der Tabelle bestimmen
        table.setPreferredScrollableViewportSize(new Dimension(1110,200));

        //Spaltenbreite bestimmen
        table.getColumnModel().getColumn(0).setPreferredWidth(220);
        table.getColumnModel().getColumn(1).setPreferredWidth(160);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(120);
        table.getColumnModel().getColumn(4).setPreferredWidth(140);
        table.getColumnModel().getColumn(5).setPreferredWidth(300);
        
        //Zeilenhöhe bestimmen
        table.setRowHeight(27);

        //Formatierung der Schrift
        table.setFont(new java.awt.Font("Verdana", 1, 12));

        //Tabellenformatierung
        JTableHeader header = table.getTableHeader();
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)header.getDefaultRenderer();
        renderer.setPreferredSize(new Dimension(0,40));
        
        //Tabelle auf Panel setzen
        p1.add(new JScrollPane(table));
//		p1.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED),
//		BorderFactory.createEtchedBorder()));
		
        /** PANEL 2 - Tabelle ***/
        //von Conny: Brauch ma das wirklich??
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
	 public int zeile(int y){
	    	return (y/27)+1;
	    }
	    public int spalte(int x){
	    	if(x<=159)
	    		return 1;
	    	if(x>159 & x<=259)
	    		return 2;
	    	if(x>259 & x<=360)
	    		return 3;
	    	if(x>360 & x<=510)
	    		return 4;
	    	if(x>510 & x<=711)
	    		return 5;
	    	if(x>711)
	    		return 6;	
	    	else return 0;
	    }
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		
	
	
	
	
}
