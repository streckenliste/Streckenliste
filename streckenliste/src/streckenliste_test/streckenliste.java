package streckenliste_test;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;


public class streckenliste extends javax.swing.JFrame
{
	
	private static final long serialVersionUID = 1L;
	auswahl auswahl;
	suche suche;
	neueliste neue;


	
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				streckenliste inst = new streckenliste();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public streckenliste()
	{
		super();
		initGUI();
	}

	private void initGUI()
	{
		try
		{
			
			this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			this.setTitle("StreckenlistenPC V1.0");
			this.setResizable(false);
			this.setSize(800,600);

			mittig();
			auswahl = new auswahl(this);

			this.add(auswahl);
			suche = new suche(this);
			suche.setFont(new java.awt.Font("Arial",0,16));
			neue = new neueliste(this);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public void panel_aendern(int id)
	{
		switch (id)
		{
		case 0:
			getContentPane().removeAll();
			this.add(auswahl);
			this.setSize(800,600);
			mittig();
			this.validate();
			this.repaint();			
			break;
		case 1:
			getContentPane().removeAll();
			this.add(neue);
			this.setSize(800,600);
			mittig();
			this.validate();
			this.repaint();			
			break;
		case 2:
			getContentPane().removeAll();
			this.add(suche);
			this.setSize(800,600);
			mittig();
			this.validate();
			this.repaint();			
			break;

		default:
			break;
		}
		
	}
	void mittig()
	{
		Dimension pos = new Dimension();
		pos.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.setLocation((pos.width-this.getWidth())/2, (pos.height-this.getHeight())/2);
	}	
	

}
