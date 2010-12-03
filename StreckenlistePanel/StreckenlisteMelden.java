package steffi.StreckenlistePanel;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class StreckenlisteMelden extends JPanel {
	
	private static final long serialVersionUID = 1L;

	public StreckenlisteMelden(streckenliste frame)
	 {
	     super();     
	     JPanel panel = new JPanel();
	     JLabel l = new JLabel("Streckenliste melden");
	     panel.add(l);
	     this.add(panel);
	     
	    
	 }

}
