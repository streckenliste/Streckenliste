package streckenliste_test;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
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
public class neueliste extends javax.swing.JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel jPanel1;
	private JLabel jLabel_revier;
	private JButton jButton_weiter;
	private JLabel jLabel1;
	private JLabel jLabel_str;
	private JLabel jLabel_abt;
	private JLabel jLabel_LRA;
	private JTextField jTextField_ort;
	private JTextField jTextField_Strasse;
	private JTextField jTextField_Abt;
	private JTextField jTextField_LRA;
	private JPanel jPanel_adresse;
	private JTextField jTextField_amtID;
	private JLabel jLabel_amtID;
	private JTextField jTextField_lfd;
	private JEditorPane jLabel_vortext;
	private JPanel jPanel_text3;
	private JPanel jPanel_text2;
	private JPanel jPanel_text1;
	private JLabel jLabel_text1_1;
	private JLabel jLabel_text3_2;
	private JLabel jLabel_text2_2;
	private JEditorPane jLabel_endtext;
	private JLabel jLabel_text3;
	private JCheckBox jCheckBox_erzeugniss;
	private JLabel jLabel_text2;
	private JLabel jLabel_Text1;
	private JCheckBox jCheckBox_zerwirkt;
	private JCheckBox jCheckBox_weitergabe;
	private JPanel jPanel_Lebensmittel;
	private JLabel jLabel_uebrschrift2;
	private JPanel jPanel_Eingabefelder;
	private JPanel jPanel_Felder;
	private JPanel jPanelText;
	private JTextField jTextField_reviernummer;
	private JLabel jLabel_Reviernummer;
	private JPanel jPanel_radio_button;
	private JButton jButton_Abbrechen;
	private JTextField jTextField_Jahr;
	private JTextField jTextField_revier;
	private JLabel jLabel_jahr;
	private JRadioButton jRadioButton_gemeinschaftsr;
	private JRadioButton jRadioButton_staatsr;
	private JRadioButton jRadioButtoneigenr;
	private ButtonGroup buttonGroup1;
	private streckenliste frame;
	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	
	public neueliste(streckenliste Frame) {
		super();
		frame= Frame;
		initGUI();
	}
	
	private void initGUI() {
		try {
			BorderLayout thisLayout = new BorderLayout();
			this.setLayout(thisLayout);
			this.setPreferredSize(new java.awt.Dimension(800, 600));
			{
				jPanel1 = new JPanel();
				this.add(jPanel1, BorderLayout.CENTER);
				GridBagLayout jPanel1Layout = new GridBagLayout();
				jPanel1.setPreferredSize(new java.awt.Dimension(800, 230));
				jPanel1Layout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1};
				jPanel1Layout.rowHeights = new int[] {7, 20, 20, 7, 20, 7, 20, 7, 7};
				jPanel1Layout.columnWeights = new double[] {0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.0, 0.0, 0.0, 0.1};
				jPanel1Layout.columnWidths = new int[] {20, 7, 20, 20, 7, 20, 7, 7, 100, 120, 120, 7};
				jPanel1.setLayout(jPanel1Layout);
				{
					jButton_weiter = new JButton();
					jPanel1.add(getJPanel_adresse(), new GridBagConstraints(1, 1, 5, 2, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jPanel1.add(jButton_weiter, new GridBagConstraints(10, 8, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jPanel1.add(getJButton_Abbrechen(), new GridBagConstraints(9, 8, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jPanel1.add(getJPanel2(), new GridBagConstraints(6, 1, 5, 2, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jPanel1.add(getJPanel3(), new GridBagConstraints(1, 3, 10, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jPanel1.add(getJLabel_uebrschrift2(), new GridBagConstraints(0, 0, 12, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jPanel1.add(getJPanel_Lebensmittel(), new GridBagConstraints(1, 4, 10, 4, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 30));
					jButton_weiter.setText("Weiter");
					jButton_weiter.setPreferredSize(new java.awt.Dimension(100, 23));
					jButton_weiter.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jButton_weiterActionPerformed(evt);
						}
					});
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	private void jButton_weiterActionPerformed(ActionEvent evt) {
		System.exit(0);
	}

	private JButton getJButton_Abbrechen() {
		if(jButton_Abbrechen == null) {
			jButton_Abbrechen = new JButton();
			jButton_Abbrechen.setText("Abbrechen");
			jButton_Abbrechen.setPreferredSize(new java.awt.Dimension(100, 23));
			jButton_Abbrechen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButton_AbbrechenActionPerformed(evt);
				}
			});
		}
		return jButton_Abbrechen;
	}
	
	private JPanel getJPanel2() {
		if(jPanel_radio_button == null) {
			jPanel_radio_button = new JPanel();
			GridLayout jPanel2Layout = new GridLayout(3, 1);
			jPanel2Layout.setColumns(1);
			jPanel2Layout.setHgap(5);
			jPanel2Layout.setVgap(5);
			jPanel2Layout.setRows(3);
			jPanel_radio_button.setBorder(BorderFactory.createTitledBorder(null, "Revierart", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,12)));
			jPanel_radio_button.setLayout(jPanel2Layout);
			jPanel_radio_button.setSize(360, 116);
			jPanel_radio_button.setPreferredSize(new java.awt.Dimension(363, 116));
			{
				jRadioButtoneigenr = new JRadioButton();
				jPanel_radio_button.add(jRadioButtoneigenr);
				jRadioButtoneigenr.setText("Eigen - Jagdrevier");
				jRadioButtoneigenr.setPreferredSize(new java.awt.Dimension(103, 20));
				jRadioButtoneigenr.setFont(new java.awt.Font("Arial",0,12));
				getButtonGroup1().add(jRadioButtoneigenr);
			}
			{
				jRadioButton_staatsr = new JRadioButton();
				jPanel_radio_button.add(jRadioButton_staatsr);
				jRadioButton_staatsr.setText("Staats - Jagdrevier");
				jRadioButton_staatsr.setPreferredSize(new java.awt.Dimension(200, 17));
				jRadioButton_staatsr.setFont(new java.awt.Font("Arial",0,12));
				getButtonGroup1().add(jRadioButton_staatsr);
			}
			{
				jRadioButton_gemeinschaftsr = new JRadioButton();
				jPanel_radio_button.add(jRadioButton_gemeinschaftsr);
				jRadioButton_gemeinschaftsr.setText("Gemeinschafts - Jagdrevier");
				jRadioButton_gemeinschaftsr.setPreferredSize(new java.awt.Dimension(200, 17));
				jRadioButton_gemeinschaftsr.setFont(new java.awt.Font("Arial",0,12));
				jRadioButton_gemeinschaftsr.setSelected(true);
				getButtonGroup1().add(jRadioButton_gemeinschaftsr);
			}
		}
		return jPanel_radio_button;
	}
	
	private JLabel getJLabel_Reviernummer() {
		if(jLabel_Reviernummer == null) {
			jLabel_Reviernummer = new JLabel();
			jLabel_Reviernummer.setText("Lfd. Nr. der Revierliste des Kreises");
			jLabel_Reviernummer.setFont(new java.awt.Font("Arial",0,12));
			jLabel_Reviernummer.setPreferredSize(new java.awt.Dimension(216, 15));
		}
		return jLabel_Reviernummer;
	}
	
	private JTextField getJTextField_reviernummer() {
		if(jTextField_reviernummer == null) {
			jTextField_reviernummer = new JTextField();
			jTextField_reviernummer.setText("201");
			jTextField_reviernummer.setFont(new java.awt.Font("Arial",0,12));
			jTextField_reviernummer.setPreferredSize(new java.awt.Dimension(209, 21));
			jTextField_reviernummer.setHorizontalAlignment(SwingConstants.LEFT);
		}
		return jTextField_reviernummer;
	}
	
	private void jButton_AbbrechenActionPerformed(ActionEvent evt) {
		frame.panel_aendern(0);
	}
	
	private JPanel getJPanelText() {
		if(jPanelText == null) {
			jPanelText = new JPanel();
			GridBagLayout jPanelTextLayout = new GridBagLayout();
			jPanelTextLayout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1};
			jPanelTextLayout.rowHeights = new int[] {7, 7, 7, 7};
			jPanelTextLayout.columnWeights = new double[] {0.1, 0.1};
			jPanelTextLayout.columnWidths = new int[] {7, 7};
			jPanelText.setLayout(jPanelTextLayout);
			jPanelText.setPreferredSize(new java.awt.Dimension(294, 105));
			jPanelText.setSize(350, 105);
			{
				jLabel_revier = new JLabel();
				jPanelText.add(getJTextField_lfd(), new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				jPanelText.add(jLabel_revier, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				jPanelText.add(getJLabel_Reviernummer(), new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				jLabel_revier.setText("Name des Jagdreviers");
				jLabel_revier.setFont(new java.awt.Font("Arial",0,12));
				jLabel_revier.setPreferredSize(new java.awt.Dimension(216, 15));
			}
			{
				jLabel_jahr = new JLabel();
				jPanelText.add(jLabel_jahr, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				jPanelText.add(getJLabel_amtID(), new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				jLabel_jahr.setText("Jagdjahr");
				jLabel_jahr.setFont(new java.awt.Font("Arial",0,12));
				jLabel_jahr.setPreferredSize(new java.awt.Dimension(216, 15));
			}
		}
		return jPanelText;
	}
	
	private JPanel getJPanel_Felder() {
		if(jPanel_Felder == null) {
			jPanel_Felder = new JPanel();
			GridBagLayout jPanel_FelderLayout = new GridBagLayout();
			jPanel_FelderLayout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1};
			jPanel_FelderLayout.rowHeights = new int[] {7, 7, 7, 7};
			jPanel_FelderLayout.columnWeights = new double[] {0.1};
			jPanel_FelderLayout.columnWidths = new int[] {7};
			jPanel_Felder.setLayout(jPanel_FelderLayout);
			jPanel_Felder.setPreferredSize(new java.awt.Dimension(209, 105));
			jPanel_Felder.setSize(100, 105);
			{
				jTextField_revier = new JTextField();
				jPanel_Felder.add(jTextField_revier, new GridBagConstraints(-1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				jPanel_Felder.add(getJTextField_reviernummer(), new GridBagConstraints(-1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				jTextField_revier.setText("Kösching");
				jTextField_revier.setPreferredSize(new java.awt.Dimension(209, 21));
				jTextField_revier.setFont(new java.awt.Font("Arial",0,12));
				jTextField_revier.setHorizontalAlignment(SwingConstants.LEFT);
			}
			{
				jTextField_Jahr = new JTextField();
				jPanel_Felder.add(jTextField_Jahr, new GridBagConstraints(-1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				jPanel_Felder.add(getJTextField_amtID(), new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				Integer now = new Date().getYear()+1900;
				jTextField_Jahr.setText(now.toString());
				jTextField_Jahr.setPreferredSize(new java.awt.Dimension(209, 21));
				jTextField_Jahr.setFont(new java.awt.Font("Arial",0,12));
				jTextField_Jahr.setHorizontalAlignment(SwingConstants.LEFT);
			}
		}
		return jPanel_Felder;
	}

	private JPanel getJPanel3() {
		if(jPanel_Eingabefelder == null) {
			jPanel_Eingabefelder = new JPanel();
			GridBagLayout jPanel3Layout = new GridBagLayout();
			jPanel3Layout.rowWeights = new double[] {0.1};
			jPanel3Layout.rowHeights = new int[] {7};
			jPanel3Layout.columnWeights = new double[] {0.0, 0.0, 0.1};
			jPanel3Layout.columnWidths = new int[] {288, 214, 20};
			jPanel_Eingabefelder.setLayout(jPanel3Layout);
			jPanel_Eingabefelder.setPreferredSize(new java.awt.Dimension(743, 138));
			jPanel_Eingabefelder.setBorder(BorderFactory.createTitledBorder(null, "Stammdaten", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,12)));
			jPanel_Eingabefelder.add(getJPanelText(), new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			jPanel_Eingabefelder.add(getJPanel_Felder(), new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		}
		return jPanel_Eingabefelder;
	}
	
	private ButtonGroup getButtonGroup1() {
		if(buttonGroup1 == null) {
			buttonGroup1 = new ButtonGroup();
		}
		return buttonGroup1;
	}

	private JLabel getJLabel_uebrschrift2() {
		if(jLabel_uebrschrift2 == null) {
			jLabel_uebrschrift2 = new JLabel();
			jLabel_uebrschrift2.setText("Neue Streckenliste anlegen");
			jLabel_uebrschrift2.setFont(new java.awt.Font("Arial",0,22));
		}
		return jLabel_uebrschrift2;
	}
	
	private JPanel getJPanel_Lebensmittel() {
		if(jPanel_Lebensmittel == null) {
			jPanel_Lebensmittel = new JPanel();
			GridBagLayout jPanel_LebensmittelLayout = new GridBagLayout();
			jPanel_LebensmittelLayout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1, 0.1};
			jPanel_LebensmittelLayout.rowHeights = new int[] {7, 7, 7, 7, 7};
			jPanel_LebensmittelLayout.columnWeights = new double[] {0.0, 0.1};
			jPanel_LebensmittelLayout.columnWidths = new int[] {47, 7};
			jPanel_Lebensmittel.setLayout(jPanel_LebensmittelLayout);
			jPanel_Lebensmittel.setPreferredSize(new java.awt.Dimension(743, 223));
			jPanel_Lebensmittel.setBorder(BorderFactory.createTitledBorder("Angaben im Zusammenhang mit der Registrierungspflicht als Lebensmittelunternehmer (für die Veterinärverwaltung) "));
			jPanel_Lebensmittel.add(getJCheckBox_weitergabe(), new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			jPanel_Lebensmittel.add(getJCheckBox_zerwirkt(), new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			jPanel_Lebensmittel.add(getJCheckBox_erzeugniss(), new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			jPanel_Lebensmittel.add(getJLabel_endtext(), new GridBagConstraints(0, 4, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			jPanel_Lebensmittel.add(getJPanel_text1(), new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			jPanel_Lebensmittel.add(getJPanel_text2(), new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			jPanel_Lebensmittel.add(getJPanel_text3(), new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			jPanel_Lebensmittel.add(getJLabel_vortext(), new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		}
		return jPanel_Lebensmittel;
	}
	
	private JCheckBox getJCheckBox_weitergabe() {
		if(jCheckBox_weitergabe == null) {
			jCheckBox_weitergabe = new JCheckBox();
		}
		return jCheckBox_weitergabe;
	}
	
	private JCheckBox getJCheckBox_zerwirkt() {
		if(jCheckBox_zerwirkt == null) {
			jCheckBox_zerwirkt = new JCheckBox();
		}
		return jCheckBox_zerwirkt;
	}
	
	private JLabel getJLabel_Text1() {
		if(jLabel_Text1 == null) {
			jLabel_Text1 = new JLabel();
			jLabel_Text1.setText("Ich gebe in meinem Revier erlegtes Wild in der Decke / im Federkleid an");
			jLabel_Text1.setSize(470, 16);
			jLabel_Text1.setPreferredSize(new java.awt.Dimension(485, 16));
			jLabel_Text1.setFont(new java.awt.Font("Arial",0,12));
			jLabel_Text1.setHorizontalTextPosition(SwingConstants.LEFT);
			jLabel_Text1.setHorizontalAlignment(SwingConstants.LEFT);
		}
		return jLabel_Text1;
	}
	
	private JLabel getJLabel_text2() {
		if(jLabel_text2 == null) {
			jLabel_text2 = new JLabel();
			jLabel_text2.setText("Ich gebe in meinem Revier erlegtes Wild enthäutet/gerupft/zerwirkt in kleinen Mengen an");
			jLabel_text2.setSize(470, 16);
			jLabel_text2.setPreferredSize(new java.awt.Dimension(485, 16));
			jLabel_text2.setFont(new java.awt.Font("Arial",0,12));
			jLabel_text2.setHorizontalTextPosition(SwingConstants.LEFT);
			jLabel_text2.setHorizontalAlignment(SwingConstants.LEFT);
		}
		return jLabel_text2;
	}
	
	private JCheckBox getJCheckBox_erzeugniss() {
		if(jCheckBox_erzeugniss == null) {
			jCheckBox_erzeugniss = new JCheckBox();
		}
		return jCheckBox_erzeugniss;
	}
	
	private JLabel getJLabel_text3() {
		if(jLabel_text3 == null)
			jLabel_text3 = new JLabel();
			jLabel_text3.setSize(470, 16);
			jLabel_text3.setPreferredSize(new java.awt.Dimension(485, 16));
			jLabel_text3.setFont(new java.awt.Font("Arial",0,12));
			jLabel_text3.setHorizontalTextPosition(SwingConstants.LEFT);
			jLabel_text3.setHorizontalAlignment(SwingConstants.LEFT);
		return jLabel_text3;
	}
	
	private JEditorPane getJLabel_endtext() {
		if(jLabel_endtext == null) {
			jLabel_endtext = new JEditorPane();
			jLabel_endtext.setText("und komme hiermit meiner Verfplichtung zur Meldung als Lebensmittelunternehmer nach.");
			jLabel_endtext.setPreferredSize(new java.awt.Dimension(712, 20));
			jLabel_endtext.setFont(new java.awt.Font("Arial",0,12));
			jLabel_endtext.setBackground(this.getBackground());

		}
		return jLabel_endtext;
	}
	
	private JLabel getJLabel_text2_2() {
		if(jLabel_text2_2 == null) {
			jLabel_text2_2 = new JLabel();
			jLabel_text2_2.setText("Endverbraucher oder örtliche Einzelhandelsunternehmer (z.B. Gaststätten) ab");
			jLabel_text2_2.setSize(470, 16);
			jLabel_text2_2.setPreferredSize(new java.awt.Dimension(485, 16));
			jLabel_text2_2.setFont(new java.awt.Font("Arial",0,12));
			jLabel_text2_2.setHorizontalTextPosition(SwingConstants.LEFT);
			jLabel_text2_2.setHorizontalAlignment(SwingConstants.LEFT);
		}
		return jLabel_text2_2;
	}
	
	private JLabel getJLabel_text3_2() {
		if(jLabel_text3_2 == null) {
			jLabel_text3_2 = new JLabel();
			jLabel_text3_2.setText("gebe diese an Endverbraucher ab");
			jLabel_text3_2.setSize(470, 16);
			jLabel_text3_2.setPreferredSize(new java.awt.Dimension(485, 16));
			jLabel_text3_2.setFont(new java.awt.Font("Arial",0,12));
			jLabel_text3_2.setHorizontalTextPosition(SwingConstants.LEFT);
			jLabel_text3_2.setHorizontalAlignment(SwingConstants.LEFT);
		}
		return jLabel_text3_2;
	}
	
	private JLabel getJLabel_text1_1() {
		if(jLabel_text1_1 == null) {
			jLabel_text1_1 = new JLabel();
			jLabel_text1_1.setText("zugelassene Wildbearbeitungsbetriebe ab");
			jLabel_text1_1.setPreferredSize(new java.awt.Dimension(485, 16));
			jLabel_text1_1.setSize(470, 16);
			jLabel_text1_1.setFont(new java.awt.Font("Arial",0,12));
			jLabel_text1_1.setHorizontalTextPosition(SwingConstants.LEFT);
			jLabel_text1_1.setHorizontalAlignment(SwingConstants.LEFT);
		}
		return jLabel_text1_1;
	}
	
	private JPanel getJPanel_text1() {
		if(jPanel_text1 == null) {
			jPanel_text1 = new JPanel();
			GridLayout jPanel_text1Layout = new GridLayout(2, 1);
			jPanel_text1Layout.setColumns(1);
			jPanel_text1Layout.setRows(2);
			jPanel_text1Layout.setHgap(1);
			jPanel_text1Layout.setVgap(1);
			jPanel_text1.setLayout(jPanel_text1Layout);
			jPanel_text1.setPreferredSize(new java.awt.Dimension(558, 33));
			jPanel_text1.add(getJLabel_Text1());
			jPanel_text1.add(getJLabel_text1_1());
		}
		return jPanel_text1;
	}
	
	private JPanel getJPanel_text2() {
		if(jPanel_text2 == null) {
			jPanel_text2 = new JPanel();
			GridLayout jPanel_text2Layout = new GridLayout(2, 1);
			jPanel_text2Layout.setColumns(1);
			jPanel_text2Layout.setRows(2);
			jPanel_text2Layout.setHgap(1);
			jPanel_text2Layout.setVgap(1);
			jPanel_text2.setLayout(jPanel_text2Layout);
			jPanel_text2.setPreferredSize(new java.awt.Dimension(558, 33));
			jPanel_text2.add(getJLabel_text2());
			jPanel_text2.add(getJLabel_text2_2());
		}
		return jPanel_text2;
	}
	
	private JPanel getJPanel_text3() {
		if(jPanel_text3 == null) {
			jPanel_text3 = new JPanel();
			GridLayout jPanel_text3Layout = new GridLayout(2, 1);
			jPanel_text3Layout.setColumns(1);
			jPanel_text3Layout.setRows(2);
			jPanel_text3Layout.setHgap(1);
			jPanel_text3Layout.setVgap(1);
			jPanel_text3.setLayout(jPanel_text3Layout);
			jPanel_text3.setPreferredSize(new java.awt.Dimension(558, 33));
			{
				jLabel_text3 = new JLabel();
				jPanel_text3.add(getJLabel_text3());
				jPanel_text3.add(getJLabel_text3_2());
				jLabel_text3.setText("Ich verarbeite das in meinem Revier erlegtes Wild zu Erzeugnissen aus Wildfleich und");
			}
		}
		return jPanel_text3;
	}
	
	private JEditorPane getJLabel_vortext() {
		if(jLabel_vortext == null) {
			jLabel_vortext = new JEditorPane();
			jLabel_vortext.setText("Sofern Sie ihr erlegtes Wild ausschließlich in der Decke / im Federkleid in kleinen Mengen und nur an Endverbraucher oder\r\nörtliche Einzelhandelsunternehmer (z.B. Gaststätten) abgeben, entfallen für Sie die folgenden Angaben.\r\nAnsonsten kreuzen Sie bitte die auf Sie zutreffenden Punkte an :");
			jLabel_vortext.setPreferredSize(new java.awt.Dimension(698, 48));
			jLabel_vortext.setBackground(this.getBackground());
			jLabel_vortext.setEditable(false);
			jLabel_vortext.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
			jLabel_vortext.setFont(new java.awt.Font("Arial",0,12));
		}
		return jLabel_vortext;
	}

	private JTextField getJTextField_lfd() {
		if(jTextField_lfd == null) {
			jTextField_lfd = new JTextField();
			jTextField_lfd.setText("001");
			jTextField_lfd.setPreferredSize(new java.awt.Dimension(74, 22));
			jTextField_lfd.setEditable(false);
			jTextField_lfd.setHorizontalAlignment(SwingConstants.RIGHT);
			jTextField_lfd.setFont(new java.awt.Font("Arial",0,12));
		}
		return jTextField_lfd;
	}
	
	private JLabel getJLabel_amtID() {
		if(jLabel_amtID == null) {
			jLabel_amtID = new JLabel();
			jLabel_amtID.setText("Amtliche Schlüsselnummer");
			jLabel_amtID.setPreferredSize(new java.awt.Dimension(216, 15));
			jLabel_amtID.setFont(new java.awt.Font("Arial",0,12));
		}
		return jLabel_amtID;
	}
	
	private JTextField getJTextField_amtID() {
		if(jTextField_amtID == null) {
			jTextField_amtID = new JTextField();
			jTextField_amtID.setText("001122");
			jTextField_amtID.setPreferredSize(new java.awt.Dimension(209, 21));
			jTextField_amtID.setFont(new java.awt.Font("Arial",0,12));
			jTextField_amtID.setHorizontalAlignment(SwingConstants.LEFT);
		}
		return jTextField_amtID;
	}
	
	private JPanel getJPanel_adresse() {
		if(jPanel_adresse == null) {
			jPanel_adresse = new JPanel();
			GridBagLayout jPanel_adresseLayout = new GridBagLayout();
			jPanel_adresseLayout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1};
			jPanel_adresseLayout.rowHeights = new int[] {7, 7, 7, 7};
			jPanel_adresseLayout.columnWeights = new double[] {0.0, 0.1};

			jPanel_adresseLayout.columnWidths = new int[] {125, 7};
			jPanel_adresse.setLayout(jPanel_adresseLayout);
			jPanel_adresse.setPreferredSize(new java.awt.Dimension(363, 116));
			jPanel_adresse.setBorder(BorderFactory.createTitledBorder("Landratsamt"));
			jPanel_adresse.add(getJLabel_LRA(), new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			jPanel_adresse.add(getJLabel_Abt(), new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			jPanel_adresse.add(getJLabel_Strasse(), new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			jPanel_adresse.add(getJLabel_ort(), new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			jPanel_adresse.add(getJLabel_LRAx(), new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			jPanel_adresse.add(getJLabel_abt(), new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			jPanel_adresse.add(getJLabel_str(), new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			jPanel_adresse.add(getJLabel1(), new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		}
		return jPanel_adresse;
	}
	
	private JTextField getJLabel_LRA() {
		if(jTextField_LRA == null) {
			jTextField_LRA = new JTextField();
			jTextField_LRA.setFont(new java.awt.Font("Arial",0,12));
			jTextField_LRA.setPreferredSize(new java.awt.Dimension(184, 22));
			jTextField_LRA.setText("Landratsamt Hof");
			jTextField_LRA.setHorizontalAlignment(SwingConstants.LEFT);
		}
		return jTextField_LRA;
	}
	
	private JTextField getJLabel_Abt() {
		if(jTextField_Abt == null) {
			jTextField_Abt = new JTextField();
			jTextField_Abt.setText("- Untere Jagdbehörde -");
			jTextField_Abt.setHorizontalAlignment(SwingConstants.LEFT);
			jTextField_Abt.setFont(new java.awt.Font("Arial",0,12));
			jTextField_Abt.setPreferredSize(new java.awt.Dimension(184, 22));
		}
		return jTextField_Abt;
	}
	
	private JTextField getJLabel_Strasse() {
		if(jTextField_Strasse == null) {
			jTextField_Strasse = new JTextField();
			jTextField_Strasse.setText("Schaumbergstraße 14");
			jTextField_Strasse.setHorizontalAlignment(SwingConstants.LEFT);
			jTextField_Strasse.setFont(new java.awt.Font("Arial",0,12));
			jTextField_Strasse.setPreferredSize(new java.awt.Dimension(184, 22));
		}
		return jTextField_Strasse;
	}
	
	private JTextField getJLabel_ort() {
		if(jTextField_ort == null) {
			jTextField_ort = new JTextField();
			jTextField_ort.setText("95032 Hof");
			jTextField_ort.setHorizontalAlignment(SwingConstants.LEFT);
			jTextField_ort.setFont(new java.awt.Font("Arial",0,12));
			jTextField_ort.setPreferredSize(new java.awt.Dimension(184, 22));
		}
		return jTextField_ort;
	}
	
	private JLabel getJLabel_LRAx() {
		if(jLabel_LRA == null) {
			jLabel_LRA = new JLabel();
			jLabel_LRA.setText("Landratsamt");
			jLabel_LRA.setPreferredSize(new java.awt.Dimension(160, 16));
		}
		return jLabel_LRA;
	}
	
	private JLabel getJLabel_abt() {
		if(jLabel_abt == null) {
			jLabel_abt = new JLabel();
			jLabel_abt.setText("Abteilung");
			jLabel_abt.setPreferredSize(new java.awt.Dimension(160, 16));
		}
		return jLabel_abt;
	}
	
	private JLabel getJLabel_str() {
		if(jLabel_str == null) {
			jLabel_str = new JLabel();
			jLabel_str.setText("Straße");
			jLabel_str.setPreferredSize(new java.awt.Dimension(160, 16));
		}
		return jLabel_str;
	}
	
	private JLabel getJLabel1() {
		if(jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("PLZ / Ort");
			jLabel1.setPreferredSize(new java.awt.Dimension(160, 16));
		}
		return jLabel1;
	}

}
