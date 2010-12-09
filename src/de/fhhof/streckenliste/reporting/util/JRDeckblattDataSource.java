package de.fhhof.streckenliste.reporting.util;

import de.fhhof.streckenliste.reporting.daten.AnschrUJB;
import de.fhhof.streckenliste.reporting.daten.RevArt;
import de.fhhof.streckenliste.reporting.daten.Streckenliste;
import de.fhhof.streckenliste.reporting.daten.Verwert;
import de.fhhof.streckenliste.util.Repository;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class JRDeckblattDataSource implements JRDataSource {
	private Streckenliste streckenliste;
	private boolean read = false;

	public JRDeckblattDataSource(Streckenliste streckenliste) {
		this.streckenliste = streckenliste;
	}

	@Override
	public Object getFieldValue(JRField jrField) throws JRException {		
		Object result = null;
		if (streckenliste != null && jrField != null) {
			String fieldName = jrField.getName();

			//Abfrage: Anschrift
			AnschrUJB anschrUJB = streckenliste.getAnschrUJB();
			if (anschrUJB != null) {
				if (fieldName.equalsIgnoreCase(Repository.UJBLRA[0])) {
					result = anschrUJB.getUjbLRA();
				}
				else if (fieldName.equalsIgnoreCase(Repository.UJBORT[0])) {
					result = anschrUJB.getUjbOrt();
				}
				else if (fieldName.equalsIgnoreCase(Repository.UJBPLZ[0])) {
					result = anschrUJB.getUjbPLZ();
				}
				else if (fieldName.equalsIgnoreCase(Repository.UJBSG[0])) {
					result = anschrUJB.getUjbSG();
				}
				else if (fieldName.equalsIgnoreCase(Repository.UJBSTR[0])) {
					result = anschrUJB.getUjbStr();
				}
			}

			//Reviertart abgefragt
			if (fieldName.equalsIgnoreCase(Repository.REVART[0])) {
				if (streckenliste.getRevArt() != null) {
					result = streckenliste.getRevArt().getRevArtName();
				}
			}
			else if (fieldName.equalsIgnoreCase(Repository.EIGENREV[0])) {
				if (streckenliste.getRevArt() == RevArt.eigenRev)
					result = streckenliste.getRevArt().getRevArtName();
			}
			else if (fieldName.equalsIgnoreCase(Repository.STAATSREV[0])) {
				if (streckenliste.getRevArt() == RevArt.staatsRev)
					result = streckenliste.getRevArt().getRevArtName();
			}
			else if (fieldName.equalsIgnoreCase(Repository.GEMEINREV[0])) {
				if (streckenliste.getRevArt() == RevArt.gemeinRev)
					result = streckenliste.getRevArt().getRevArtName();
			}

			//Abfrage: Reviername
			else if (fieldName.equalsIgnoreCase(Repository.REVNAME[0])) {
				result = streckenliste.getRevName();
			}

			//Abfrage: Verwertung
			else if (fieldName.equalsIgnoreCase(Repository.VERWERT[0])) {
				if (streckenliste.getVerwert() != null)
					result = streckenliste.getVerwert().getValue();
			}
			else if (fieldName.equalsIgnoreCase(Repository.ZERWIRKT[0])) {
				if (streckenliste.getVerwert() == Verwert.zerwirk)
					result = streckenliste.getVerwert().getValue();
			}
			else if (fieldName.equalsIgnoreCase(Repository.ERZEUGNIS[0])) {
				if (streckenliste.getVerwert() == Verwert.erzeugnis)
					result = streckenliste.getVerwert().getValue();
			}
			else if (fieldName.equalsIgnoreCase(Repository.WEITERGABE[0])) {
				if (streckenliste.getVerwert() == Verwert.weitergabe)
					result = streckenliste.getVerwert().getValue();
			}

			//Abfrage: bSatzart
			else if (fieldName.equalsIgnoreCase(Repository.BSATZART[0])) {
				result = streckenliste.getbSatzart();
			}

			//Abfrage: amtID
			else if (fieldName.equalsIgnoreCase(Repository.AMTID[0])) {
				result = streckenliste.getAmtID();
			}

			//Abfrage: revNr
			else if (fieldName.equalsIgnoreCase(Repository.REVNR[0])) {
				result = streckenliste.getRevNr();
			}
			
			else if (fieldName.equalsIgnoreCase(Repository.JJAHR[0])) {
				result = streckenliste.getListeA().getJJahr();
			}
		}

		return result;
	}

	@Override
	public boolean next() throws JRException {
		// TODO Auto-generated method stub
		if (!read) {
			read = true;
			return true;
		}
		else {
			read = false;
			return false;
		}
	}

	public Streckenliste getStreckenliste() {
		return streckenliste;
	}
	public void setStreckenliste(Streckenliste streckenliste) {
		this.streckenliste = streckenliste;
	}	
}
