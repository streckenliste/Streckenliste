package streckenliste_test;

import javax.swing.JLabel;
import javax.swing.JPanel;

import de.fhhof.streckenliste.reporting.PrintControlPanel;

public class StreckenlisteMelden extends JPanel {
	
	private static final long serialVersionUID = 1L;

	public StreckenlisteMelden(streckenliste frame)
	 {
	     super();     
	     JPanel panel = new JPanel();
	     //JLabel l = new JLabel("Streckenliste melden");
	     PrintControlPanel l = new PrintControlPanel();
	     panel.add(l);
	     this.add(panel);
	     
	    
	 }

}
