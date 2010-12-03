package streckenliste_test;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

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
public class suche extends javax.swing.JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel jPanel_filter;
	private JButton jButton_weiter;
	private JTable jTable_ergebnisse;
	private JButton jButton_abbrechen;
	private JLabel jLabel_Art;
	private JScrollPane jPanel_ergebniss;
	private streckenliste frame;
	/**
	 * Auto-generated main method to display this
	 * JPanel inside a new JFrame.
	 */

	public suche(streckenliste Frame)
	{
		super();
		frame = Frame;
		initGUI();
	}

	private void initGUI()
	{
		try
		{
			this.setPreferredSize(new java.awt.Dimension(800, 600));
			BorderLayout thisLayout = new BorderLayout();
			this.setSize(800, 600);
			this.setLayout(thisLayout);
			{
				jPanel_filter = new JPanel();
				GridBagLayout jPanel_filterLayout = new GridBagLayout();
				jPanel_filterLayout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1};
				jPanel_filterLayout.rowHeights = new int[] {20, 7, 7, 7, 7, 20, 20};
				jPanel_filterLayout.columnWeights = new double[] {0.1, 0.1, 0.1, 0.0, 0.0};
				jPanel_filterLayout.columnWidths = new int[] {7, 7, 7, 120, 120};
				jPanel_filter.setLayout(jPanel_filterLayout);

				jPanel_filter.add(getJPanel_ergebniss(), new GridBagConstraints(0, 2, 5, 4, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				jPanel_filter.add(getJButton_aktualisieren(), new GridBagConstraints(4, 6, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
//				jPanel_filter.add(getJPanel_button1(), new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				jPanel_filter.add(getJLabel_Art(), new GridBagConstraints(0, 0, 5, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				jPanel_filter.add(getJButton_abbrechen(), new GridBagConstraints(3, 6, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			}
			this.add(jPanel_filter, BorderLayout.CENTER);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	

	private JScrollPane getJPanel_ergebniss()
	{
		if (jPanel_ergebniss == null)
		{
			jPanel_ergebniss = new JScrollPane(getJTable_ergebnisse());
			jPanel_ergebniss.setSize(500, 26);
			jPanel_ergebniss.setPreferredSize(new java.awt.Dimension(739, 470));
			jPanel_ergebniss.setFont(new java.awt.Font("Arial",0,12));
			jPanel_ergebniss.setViewportView(getJTable_ergebnisse());
//			jPanel_ergebniss.add(getJList_ergebnisse());
		}
		return jPanel_ergebniss;
	}

	private JButton getJButton_aktualisieren()
	{
		if (jButton_weiter == null)
		{
			jButton_weiter = new JButton();
			jButton_weiter.setText("Weiter");
			jButton_weiter.setPreferredSize(new java.awt.Dimension(100, 23));
			jButton_weiter.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt)
				{
					jButton_weiterActionPerformed(evt);
				}
			});
		}
		return jButton_weiter;
	}

	private void jButton_weiterActionPerformed(ActionEvent evt)
	{
		frame.panel_aendern(3);
	}

	private JLabel getJLabel_Art() {
		if(jLabel_Art == null) {
			jLabel_Art = new JLabel();
			jLabel_Art.setText("Welche Streckenliste möchten Sie öffnen :");
			jLabel_Art.setPreferredSize(new java.awt.Dimension(400, 16));
			jLabel_Art.setFont(new java.awt.Font("Arial",0,20));
			jLabel_Art.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return jLabel_Art;
	}
	
	private JButton getJButton_abbrechen() {
		if(jButton_abbrechen == null) {
			jButton_abbrechen = new JButton();
			jButton_abbrechen.setText("Abbrechen");
			jButton_abbrechen.setPreferredSize(new java.awt.Dimension(100, 23));
			jButton_abbrechen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButton_abbrechenActionPerformed(evt);
				}
			});
		}
		return jButton_abbrechen;
	}
	
	private void jButton_abbrechenActionPerformed(ActionEvent evt) {
		frame.panel_aendern(0);
	}
	
	private JTable getJTable_ergebnisse() {
		if(jTable_ergebnisse == null) {
			TableModel jTable_ergebnisseModel = 
				new DefaultTableModel(
						new String[][] {  { "2008", "Eigen","Kösching" },{ "2009", "Gemeinschafts","Hepberg" },{ "2010", "Staats","Pföring" } },
						new String[] { "Jagdjahr", "Revierart","Reviername" });
			jTable_ergebnisse = new JTable();
			jTable_ergebnisse.setModel(jTable_ergebnisseModel);
			jTable_ergebnisse.setSize(400, 48);
			jTable_ergebnisse.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			jTable_ergebnisse.setPreferredSize(new java.awt.Dimension(736, 446));
		}
		return jTable_ergebnisse;
	}

}
