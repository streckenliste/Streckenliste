package steffi.StreckenlistePanel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * This code was edited or generated using CloudGarden's Jigloo
 * SWT/Swing GUI Builder, which is free for non-commercial
 * use. If Jigloo is being used commercially (ie, by a corporation,
 * company or business for any purpose whatever) then you
 * should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details.
 * Use of Jigloo implies acceptance of these licensing terms.
 * A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
 * THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
 * LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class eingabe extends javax.swing.JPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Auto-generated main method to display this
	 * JPanel inside a new JFrame.
	 */

	private JLabel jLabel_Jahr;
	private JLabel jLabel_Revier_inhaber;
	private JTextField jTextField_Jahr;
	private JTextField jTextField_Revier;

	public eingabe()
	{
		super();
		initGUI();
	}

	private void initGUI()
	{
		try
		{
			GridBagLayout jPanel_MainLayout = new GridBagLayout();
			jPanel_MainLayout.columnWeights = new double[]
			{ 0.1, 0.1, 0.1, 0.1, 0.1 };
			jPanel_MainLayout.columnWidths = new int[]
			{ 7, 7, 7, 7, 7 };
			jPanel_MainLayout.rowWeights = new double[]
			{ 0.1, 0.1, 0.1, 0.1, 0.1 };
			jPanel_MainLayout.rowHeights = new int[]
			{ 7, 7, 7, 7, 7 };
			this.setLayout(jPanel_MainLayout);
			this.setPreferredSize(new java.awt.Dimension(800, 600));
			{
				jTextField_Jahr = new JTextField("Jahr");
				this.add(jTextField_Jahr, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
						new Insets(0, 0, 0, 0), 0, 0));
			}
			{
				jTextField_Revier = new JTextField("Revier");
				this.add(jTextField_Revier, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
						GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				this.add(getJLabel_Revier_inhaber(), new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
						GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				this.add(getJLabel_Jahr(), new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
						new Insets(0, 0, 0, 0), 0, 0));
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	private JLabel getJLabel_Revier_inhaber()
	{
		if (jLabel_Revier_inhaber == null)
		{
			jLabel_Revier_inhaber = new JLabel();
			jLabel_Revier_inhaber.setText("Name des Revierinhabers");
		}
		return jLabel_Revier_inhaber;
	}

	private JLabel getJLabel_Jahr()
	{
		if (jLabel_Jahr == null)
		{
			jLabel_Jahr = new JLabel();
			jLabel_Jahr.setText("Jahr der erstellung");
		}
		return jLabel_Jahr;
	}

}
