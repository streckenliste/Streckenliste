
package steffi.StreckenlistePanel;
/*
  Eintrag in Streckenliste B ändern
 
 In diesem Fenster wird der Inhalt
 des Datensatzes angezeigt. In den entsprechenden
 Textfeldern kann die aktuelle Anzahl eingetragen
 werden, die dann durch das Betätigen des
 Ändern-Button in die Tabelle der Streckenliste B
 übernommen werden.
*/
 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ModalDialog
extends JDialog
implements ActionListener
{
	private JPanel contentPane,Panel1,Panel2,Panel3,Panel4;
	private JTextField t_anz_neu,t_vere_neu,t_verk_neu;
	private JTextArea ta_bem;
	private JLabel l_wildart,l_wildid,l_anz,l_anz_akt,l_vere,l_vere_akt,l_verk,l_verk_akt,l_bem, l_anz_neu, l_vere_neu, l_verk_neu;
	private JButton b_aendern,b_abbruch;
	private static final long serialVersionUID = 1L;
	private boolean übernehmenFlag;
	public ModalDialog(MouseAdapter mouseAdapter, boolean modal)
	{
		super();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
	}
	
	//Fenser um alle Werte zu ändern
	public void showJDialog(String wildart,String wildid,String anz_akt,String vere_akt,String verk_akt,String bem,int zeile,int spalte)
	{

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setTitle("Eintrag in Streckenliste B ändern");
		setSize(700, 350);
		setLocation(dim.width/2, dim.height/2);
		
		contentPane = new JPanel(new GridLayout(4,1)); 
		
		/** PANEL 1 - Überschrift **/
		
		Panel1 = new JPanel(new FlowLayout());
		l_wildart = new JLabel(wildart);
		l_wildid = new JLabel(wildid);
		Panel1.add(l_wildart);
		Panel1.add(l_wildid);
		contentPane.add(Panel1);
		
		/** PANEL 2 - Einträge **/
		
		Panel2 = new JPanel(new GridLayout(3,4));
		l_anz = new JLabel("Anzahl erlegt gefunden ");
		l_anz_akt = new JLabel("      bisher:   "+anz_akt);
		l_anz_neu = new JLabel("                                   neu:");
		t_anz_neu = new JTextField("",5);
		l_vere = new JLabel("Fallwild verendet gefunden ");
		l_vere_akt = new JLabel("      bisher:   "+vere_akt);
		l_vere_neu = new JLabel("                                   neu:");
		t_vere_neu = new JTextField(null, 5);
		l_verk = new JLabel("Fallwild Verkehrsunfall ");
		l_verk_akt = new JLabel("      bisher:   "+verk_akt);
		l_verk_neu = new JLabel("                                   neu:");
		t_verk_neu = new JTextField(null, 5);
		t_verk_neu.setEnabled(true);
		Panel2.add(l_anz);
		Panel2.add(l_anz_akt);
		Panel2.add(l_anz_neu);
		Panel2.add(t_anz_neu);
		Panel2.add(l_vere);
		Panel2.add(l_vere_akt);
		Panel2.add(l_vere_neu );
		Panel2.add(t_vere_neu );
		Panel2.add(l_verk);
		Panel2.add(l_verk_akt);
		Panel2.add(l_verk_neu);
		Panel2.add(t_verk_neu);
		contentPane.add(Panel2);
		
		/** PANEL 3 - Bemerkung **/
		
		Panel3 = new JPanel(new GridLayout(2,1));
		l_bem  = new JLabel("Bemerkung:");
		ta_bem = new JTextArea(bem);
		ta_bem.setRows(2);
		ta_bem.setLineWrap(true);
		
		JScrollPane bem_scroll=new JScrollPane(ta_bem);
		Panel3.add(l_bem);
		Panel3.add(bem_scroll);
		contentPane.add(Panel3);
		
		
		/** PANEL 4 - Ändern und Abbrechen **/
		
		Panel4 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		b_abbruch = new JButton("Abbrechen");	
		b_abbruch.addActionListener(this);
		b_aendern = new JButton("Ändern");
		b_aendern.addActionListener(this);
		Panel4.add(b_abbruch);
		Panel4.add(b_aendern);	
		contentPane.add(Panel4);
		
		setContentPane(contentPane);
		
		übernehmenFlag = false;
		setVisible(true);
	}
	
	
	//Fenster um Bemerkung zu ändern
	public void showJDialog2(String wildart,String wildid,String bem,int zeile,int spalte)
	{
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setTitle("Eintrag in Streckenliste B ändern");
		setSize(700, 300);
		setLocation(dim.width/2, dim.height/2);
		setResizable(false);
		JPanel contentPane = new JPanel(new GridLayout(3,1)); 
		
		/** PANEL 1 - Überschrift **/
		
		Panel1 = new JPanel(new FlowLayout());
		l_wildart = new JLabel(wildart);
		l_wildid = new JLabel(wildid);
		Panel1.add(l_wildart);
		Panel1.add(l_wildid);
		contentPane.add(Panel1);
		
		/** PANEL 2 - Bemerkung **/
		
		Panel2 = new JPanel(new GridLayout(2,1));
		l_bem = new JLabel("Bemerkung:");
		ta_bem = new JTextArea(bem);
		ta_bem.setRows(3);
		ta_bem.setLineWrap(true);
		
		JScrollPane bem_scroll=new JScrollPane(ta_bem);
		Panel2.add(l_bem);
		Panel2.add(bem_scroll);
		
		contentPane.add(Panel2);
		
		/** PANEL 3 - Ändern und Abbrechen **/
		
		Panel3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		b_abbruch = new JButton("Abbrechen");	
		b_abbruch.addActionListener(this);
		b_aendern = new JButton("Ändern");	
		b_aendern.addActionListener(this);
		Panel3.add(b_abbruch);
		Panel3.add(b_aendern);	
		contentPane.add(Panel3);
	
		setContentPane(contentPane); 
		

		übernehmenFlag = false;
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals("Ändern"))
		{
			übernehmenFlag = true;
			this.dispose();
		}
		
		if(e.getActionCommand().equals("Abbrechen"))
		{
			this.dispose();
		}
	}
	
	
	//Getter und Setter um auf Datensätze zugreifen zu könnnen
	public String getAnz_erl_neu()
	{
		return t_anz_neu.getText();
	}
	
	public String getFall_vere_neu()
	{
		return t_vere_neu.getText();
	}
	
	public String getFall_verk_neu()
	{
		return t_verk_neu.getText();
	}
	
	public String getBemerk_neu()
	{
		return ta_bem.getText();
	}
	public boolean übernehmen()
	{
		return übernehmenFlag;
	}
}