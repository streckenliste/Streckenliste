package steffi.StreckenlistePanel;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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
public class suche2 extends javax.swing.JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel jPanel_filter;
	private JRadioButton jRadioButton_eigenr;
	private JButton jButton_aktualisieren;
	private JTable jTable_ergebnisse;
	private JPanel jPanel_auswahl;
	private JButton jButton_abbrechen;
	private JLabel jLabel_Art;
	private JLabel jLabel_Jahr;
	private JLabel jLabel_Reviername;
	private JScrollPane jPanel_ergebniss;
	private JRadioButton jRadioButton_gemeinschaftr;
	private JRadioButton jRadioButton_staatsr;
	private ButtonGroup buttonGroup1;
	private JComboBox jComboBox_Jahr;
	private JComboBox jComboBox_Revier;
	private DefaultListModel jList_ergebnisseModel;
	private streckenliste frame;
	/**
	 * Auto-generated main method to display this
	 * JPanel inside a new JFrame.
	 */

	public suche2(streckenliste Frame)
	{
		super();
		frame = Frame;
		initGUI();
	}

	private void initGUI()
	{
		try
		{
			this.setPreferredSize(new java.awt.Dimension(500, 500));
			BorderLayout thisLayout = new BorderLayout();
			this.setSize(500, 500);
			this.setLayout(thisLayout);
			{
				jPanel_filter = new JPanel();
				GridBagLayout jPanel_filterLayout = new GridBagLayout();
				jPanel_filterLayout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1};
				jPanel_filterLayout.rowHeights = new int[] {20, 7, 7, 7, 7, 20, 20};
				jPanel_filterLayout.columnWeights = new double[] {0.1, 0.1, 0.1, 0.1, 0.1};
				jPanel_filterLayout.columnWidths = new int[] {7, 7, 7, 7, 20};
				jPanel_filter.setLayout(jPanel_filterLayout);

				this.add(getJPanel_ergebniss(), BorderLayout.SOUTH);
				jPanel_filter.setPreferredSize(new java.awt.Dimension(495, 231));
				{
					jComboBox_Revier = new JComboBox();
					jPanel_filter.add(jComboBox_Revier, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jComboBox_Revier.setPreferredSize(new java.awt.Dimension(100, 23));
					jComboBox_Revier.addItem("Revier A");
					jComboBox_Revier.addItem("Revier B");
					jComboBox_Revier.addItem("Revier C");
				}
				{
					jComboBox_Jahr = new JComboBox();
					jPanel_filter.add(jComboBox_Jahr, new GridBagConstraints(3, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jComboBox_Jahr.setPreferredSize(new java.awt.Dimension(100, 23));
					jComboBox_Jahr.addItem("2005");
					jComboBox_Jahr.addItem("2006");
					jComboBox_Jahr.addItem("2007");
					jComboBox_Jahr.addItem("2008");
					jComboBox_Jahr.addItem("2009");
					jComboBox_Jahr.addItem("2010");
					
				}
				jPanel_filter.add(getJButton_aktualisieren(), new GridBagConstraints(4, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
//				jPanel_filter.add(getJPanel_button1(), new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				jPanel_filter.add(getJLabel_Art(), new GridBagConstraints(1, 1, 4, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				jPanel_filter.add(getJLabel_Reviername(), new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				jPanel_filter.add(getJLabel_Jahr(), new GridBagConstraints(3, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				jPanel_filter.add(getJButton_abbrechen(), new GridBagConstraints(3, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				jPanel_filter.add(getJPanel_auswahl(), new GridBagConstraints(1, 3, 1, 3, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				getButtonGroup1().add(jRadioButton_eigenr);
			}
			this.add(jPanel_filter, BorderLayout.NORTH);
			jPanel_filter.setSize(600, 231);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	private ButtonGroup getButtonGroup1()
	{
		if (buttonGroup1 == null)
		{
			buttonGroup1 = new ButtonGroup();
		}
		return buttonGroup1;
	}

	private JRadioButton getJRadioButton_staatsr()
	{
		if (jRadioButton_staatsr == null)
		{
			jRadioButton_staatsr = new JRadioButton();
			jRadioButton_staatsr.setText("Staats - Jagdrevier");
			jRadioButton_staatsr.setHorizontalAlignment(SwingConstants.LEFT);
			jRadioButton_staatsr.setHorizontalTextPosition(SwingConstants.RIGHT);
			jRadioButton_staatsr.setSize(150, 20);
			jRadioButton_staatsr.setPreferredSize(new java.awt.Dimension(105, 20));
			getButtonGroup1().add(jRadioButton_staatsr);
		}
		return jRadioButton_staatsr;
	}

	private JRadioButton getJRadioButton_gemeinschaftr()
	{
		if (jRadioButton_gemeinschaftr == null)
		{
			jRadioButton_gemeinschaftr = new JRadioButton();
			jRadioButton_gemeinschaftr.setText("Gemeinschafts - Jagdrevier");
			jRadioButton_gemeinschaftr.setHorizontalAlignment(SwingConstants.LEFT);
			jRadioButton_gemeinschaftr.setHorizontalTextPosition(SwingConstants.RIGHT);
			jRadioButton_gemeinschaftr.setSize(150, 20);
			jRadioButton_gemeinschaftr.setPreferredSize(new java.awt.Dimension(188, 20));
			jRadioButton_gemeinschaftr.setOpaque(false);
			getButtonGroup1().add(jRadioButton_gemeinschaftr);
		}
		return jRadioButton_gemeinschaftr;
	}

	private JScrollPane getJPanel_ergebniss()
	{
		if (jPanel_ergebniss == null)
		{
			jPanel_ergebniss = new JScrollPane(getJTable_ergebnisse());
			jPanel_ergebniss.setSize(600, 369);
			jPanel_ergebniss.setPreferredSize(new java.awt.Dimension(500, 278));
			jPanel_ergebniss.setViewportView(getJTable_ergebnisse());
//			jPanel_ergebniss.add(getJList_ergebnisse());
		}
		return jPanel_ergebniss;
	}

	private JButton getJButton_aktualisieren()
	{
		if (jButton_aktualisieren == null)
		{
			jButton_aktualisieren = new JButton();
			jButton_aktualisieren.setText("Suchen");
			jButton_aktualisieren.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt)
				{
					jButton_aktualisierenActionPerformed(evt);
				}
			});
		}
		return jButton_aktualisieren;
	}

	private void jButton_aktualisierenActionPerformed(ActionEvent evt)
	{
		jList_ergebnisseModel.addElement("naechster");
		jList_ergebnisseModel.addElement("...");
		repaint();
	}

	private JLabel getJLabel_Reviername() {
		if(jLabel_Reviername == null) {
			jLabel_Reviername = new JLabel();
			jLabel_Reviername.setText("Revier Name");
		}
		return jLabel_Reviername;
	}
	
	private JLabel getJLabel_Jahr() {
		if(jLabel_Jahr == null) {
			jLabel_Jahr = new JLabel();
			jLabel_Jahr.setText("Jagd Jahr");
		}
		return jLabel_Jahr;
	}
	
	private JLabel getJLabel_Art() {
		if(jLabel_Art == null) {
			jLabel_Art = new JLabel();
			jLabel_Art.setText("Welche Streckenliste möchten Sie öffnen :");
			jLabel_Art.setPreferredSize(new java.awt.Dimension(400, 16));
			jLabel_Art.setFont(new java.awt.Font("Arial",0,16));
			jLabel_Art.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return jLabel_Art;
	}
	
	private JButton getJButton_abbrechen() {
		if(jButton_abbrechen == null) {
			jButton_abbrechen = new JButton();
			jButton_abbrechen.setText("Abbrechen");
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
						new String[][] {  { "2008", "Eigen","Revier A" },{ "2008", "Eigen","Revier B" },{ "2009", "Eigen","Revier A" } },
						new String[] { "Jahr", "Typ","Jagdrevier" });
			jTable_ergebnisse = new JTable();
			jTable_ergebnisse.setModel(jTable_ergebnisseModel);
			jTable_ergebnisse.setSize(600, 48);
		}
		return jTable_ergebnisse;
	}

	private JPanel getJPanel_auswahl() {
		if(jPanel_auswahl == null) {
			jPanel_auswahl = new JPanel();
			GridLayout jPanel_auswahlLayout = new GridLayout(3, 1);
			jPanel_auswahlLayout.setColumns(1);
			jPanel_auswahlLayout.setHgap(5);
			jPanel_auswahlLayout.setVgap(5);
			jPanel_auswahlLayout.setRows(3);
			jPanel_auswahl.setLayout(jPanel_auswahlLayout);
			jPanel_auswahl.add(getJRadioButton_staatsr());
			{
				jRadioButton_eigenr = new JRadioButton();
				jPanel_auswahl.add(jRadioButton_eigenr);
				jRadioButton_eigenr.setText("Eigen - Jagdrevier");
				jRadioButton_eigenr.setHorizontalAlignment(SwingConstants.LEFT);
				jRadioButton_eigenr.setHorizontalTextPosition(SwingConstants.RIGHT);
				jRadioButton_eigenr.setPreferredSize(new java.awt.Dimension(103, 20));
			}
			jPanel_auswahl.add(getJRadioButton_gemeinschaftr());
		}
		return jPanel_auswahl;
	}

}
//private JList getJList_ergebnisse()
//{
//	if (jList_ergebnisse == null)
//	{
//		jList_ergebnisseModel = new DefaultListModel();
//		jList_ergebnisseModel.addElement("Revier A 2008");
//		jList_ergebnisseModel.addElement("Revier B 2009");
//		jList_ergebnisseModel.addElement("Revier C 2009");
//		jList_ergebnisseModel.addElement("Revier A 2010");
//		jList_ergebnisseModel.addElement("Revier C 2010");
//		jList_ergebnisse = new JList();
//		jList_ergebnisse.setModel(jList_ergebnisseModel);
//		jList_ergebnisse.setVisibleRowCount(14);
//		jList_ergebnisse.ensureIndexIsVisible(14);
//	
//	}
//	return jList_ergebnisse;
//}