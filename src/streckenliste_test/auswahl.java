package streckenliste_test;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

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
public class auswahl extends javax.swing.JPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel jPanel1;
	private JRadioButton jRadioButton_letzte;
	private JLabel jLabel_bild;
	private JButton jButton_abbrechen;
	private ButtonGroup buttonGroup1;
	private JRadioButton jRadioButton_oeffnen;
	private JRadioButton jRadioButton_neue;
	private JButton jButton_weiter_1;
	private streckenliste frame;

	public auswahl(streckenliste Frame)
	{
		super();
		frame = Frame;
		initGUI();
	}

	private void initGUI()
	{
		try
		{
			GridBagLayout jPanel_MainLayout = new GridBagLayout();
			jPanel_MainLayout.columnWeights = new double[] {0.1, 0.1, 0.1, 0.0, 0.0, 0.0};
			jPanel_MainLayout.columnWidths = new int[] {7, 7, 7, 147, 120, 120};
			jPanel_MainLayout.rowWeights = new double[] {0.1, 0.1, 0.1};
			jPanel_MainLayout.rowHeights = new int[] {7, 7, 7};
			this.setLayout(jPanel_MainLayout);
			this.setPreferredSize(new java.awt.Dimension(800, 600));
			this.setSize(800, 600);
			this.add(getJPanel1(), new GridBagConstraints(0, 1, 6, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			this.add(getJButton_weiter_1(), new GridBagConstraints(5, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			this.add(getJButton_abbrechen(), new GridBagConstraints(4, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			this.add(getJLabel_bild(), new GridBagConstraints(0, 0, 6, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	
	private JPanel getJPanel1() {
		if(jPanel1 == null) {
			jPanel1 = new JPanel();
			GridLayout jPanel1Layout = new GridLayout(3, 1);
			jPanel1Layout.setColumns(1);
			jPanel1Layout.setRows(3);
			jPanel1Layout.setHgap(5);
			jPanel1Layout.setVgap(5);
			jPanel1.setLayout(jPanel1Layout);
			jPanel1.setBorder(BorderFactory.createTitledBorder(null, "Auswahl", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI",1,18)));
			jPanel1.setFont(new java.awt.Font("Dialog",0,12));
			jPanel1.add(getJRadioButton_letzte());
			jPanel1.add(getJRadioButton_oeffnen());
			jPanel1.add(getJRadioButton_neue());
		}
		return jPanel1;
	}
	
	private JRadioButton getJRadioButton_neue() {
		if(jRadioButton_neue == null) {
			jRadioButton_neue = new JRadioButton();
			jRadioButton_neue.setText("Neue Streckenliste anlegen");
			jRadioButton_neue.setFont(new java.awt.Font("Arial",0,16));
			jRadioButton_neue.setPreferredSize(new java.awt.Dimension(242, 23));
			getButtonGroup1().add(jRadioButton_neue);
		}
		return jRadioButton_neue;
	}
	
	private JRadioButton getJRadioButton_oeffnen() {
		if(jRadioButton_oeffnen == null) {
			jRadioButton_oeffnen = new JRadioButton();
			jRadioButton_oeffnen.setText("Bestehende Streckenliste öffnen");
			jRadioButton_oeffnen.setFont(new java.awt.Font("Arial",0,16));
			jRadioButton_oeffnen.setPreferredSize(new java.awt.Dimension(250, 23));
			getButtonGroup1().add(jRadioButton_oeffnen);
			getButtonGroup1().add(jRadioButton_oeffnen);
		}
		return jRadioButton_oeffnen;
	}
	
	private JRadioButton getJRadioButton_letzte() {
		if(jRadioButton_letzte == null) {
			jRadioButton_letzte = new JRadioButton();
			jRadioButton_letzte.setText("Letzte Streckenliste öffnen");
			jRadioButton_letzte.setFont(new java.awt.Font("Arial",0,16));
			jRadioButton_letzte.setSelected(true);
			getButtonGroup1().add(jRadioButton_letzte);
			getButtonGroup1().add(jRadioButton_letzte);
		}
		return jRadioButton_letzte;
	}
	
	private ButtonGroup getButtonGroup1() {
		if(buttonGroup1 == null) {
			buttonGroup1 = new ButtonGroup();
		}
		return buttonGroup1;
	}
	private void jButton_weiter_1ActionPerformed(ActionEvent evt)
	{
		if (jRadioButton_oeffnen.isSelected())
		{
			frame.panel_aendern(2);
		}else if (jRadioButton_neue.isSelected())
		{
			frame.panel_aendern(1);
		}
			
	}
	private JButton getJButton_weiter_1()
	{
		if (jButton_weiter_1 == null)
		{
			jButton_weiter_1 = new JButton();
			jButton_weiter_1.setText("Weiter");
			jButton_weiter_1.setPreferredSize(new java.awt.Dimension(100, 23));
			jButton_weiter_1.setSize(100, 23);
			jButton_weiter_1.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt)
				{
					jButton_weiter_1ActionPerformed(evt);
				}
			});
		}
		return jButton_weiter_1;
	}
	
	private JButton getJButton_abbrechen() {
		if(jButton_abbrechen == null) {
			jButton_abbrechen = new JButton();
			jButton_abbrechen.setText("Abbrechen");
			jButton_abbrechen.setSize(100, 23);
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
		System.exit(0);
		frame.panel_aendern(0);
	}
	
	private JLabel getJLabel_bild() {
		if(jLabel_bild == null) {
			jLabel_bild = new JLabel();
			jLabel_bild.setIcon(new ImageIcon(getClass().getClassLoader().getResource("streckenliste_test/Neu.JPG")));
		}
		return jLabel_bild;
	}
}
