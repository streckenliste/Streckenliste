package de.fhhof.streckenliste.reporting.util;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;

import de.fhhof.streckenliste.reporting.daten.BWildart;
import de.fhhof.streckenliste.reporting.daten.BZeile;
import de.fhhof.streckenliste.reporting.daten.ListeB;
import de.fhhof.streckenliste.reporting.daten.Streckenliste;
import de.fhhof.streckenliste.util.Repository;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class JRListeBDataSource implements JRDataSource {
	private ListeB listeB;
	private String amtID;
	private String revNr;
	private String abgJahr;

	private int counter;

	public JRListeBDataSource(ListeB listeB) {
		this(listeB, "", "", "");
	}
	public JRListeBDataSource(Streckenliste streckenliste) {
		this(streckenliste.getListeB(),
				streckenliste.getAmtID(),
				streckenliste.getRevNr(),
				String.valueOf(streckenliste.getListeA().getAbgDatum().get(Calendar.YEAR))
		);
	}
	public JRListeBDataSource(ListeB listeB, String amtID, String revNr, String abgJahr) {
		this.listeB = listeB;
		this.amtID = amtID;
		this.revNr = revNr;
		this.abgJahr = abgJahr;

		resetCounter();
	}

	private void resetCounter() {
		counter = -1;
	}
	private void stepCounter()  {
		counter++;
	}

	@Override
	public Object getFieldValue(JRField jrField) throws JRException {
		Object result = "";

		if (jrField != null && listeB != null) {
			String fieldName = jrField.getName();

			if (fieldName.equalsIgnoreCase(Repository.JJAHR[0])) {
				GregorianCalendar jJahr = listeB.getjJahr();
				if (jJahr != null) {
					String datum = jJahr.get(Calendar.YEAR)+"-"+jJahr.get(Calendar.MONTH)+"-"+jJahr.get(Calendar.DAY_OF_MONTH);
					result = datum;
				}
			}
			else if (fieldName.equalsIgnoreCase(Repository.AMTID[0])) {
				result = amtID;
			}
			else if (fieldName.equalsIgnoreCase(Repository.REVNR[0])) {
				result = revNr;
			}
			else if (fieldName.equalsIgnoreCase(Repository.ABGJAHR[0])) {
				result = abgJahr;
			}
			else {
				Vector<BZeile> bZeilen = listeB.getbZeile();
				if (bZeilen != null) {
					if (fieldName.equalsIgnoreCase(Repository.BWILDART[0])) {
						BWildart bWildart = bZeilen.get(counter).getbWildart();
						if (bWildart != null) {
							result = bWildart.getbWildartName();
						}
					}
					else if (fieldName.equalsIgnoreCase(Repository.BANZERLEGT[0])) {
						Integer i = bZeilen.get(counter).getbAnzErlegt();
						if (i != null)
							result = i;
						else
							result = 0;
					}
					else if (fieldName.equalsIgnoreCase(Repository.BANZFALLVEREND[0])) {
						Integer i = bZeilen.get(counter).getbAnzFallVerend();
						if (i != null)
							result = i;
						else
							result = 0;
					}
					else if (fieldName.equalsIgnoreCase(Repository.BANZFALLVERKEHR[0])) {
						Integer i = bZeilen.get(counter).getbAnzFallVerkehr();
						if (i != null)
							result = i;
						else
							result = 0;
					}
					else if (fieldName.equalsIgnoreCase(Repository.BBEMERK[0])) {
						String bBemerk = bZeilen.get(counter).getbBemerk();
						if (bBemerk != null)
							result = bBemerk;
						else
							result = "";
					}
					else if (fieldName.equalsIgnoreCase(Repository.WILDARTID[0])) {
						BWildart bWildart = bZeilen.get(counter).getbWildart();
						if (bWildart != null) {
							result = bWildart.getbWildartWert();
						}
					}
				}
			}
		}
		return result;
	}

	@Override
	public boolean next() throws JRException {
		stepCounter();
		if (counter < listeB.getbZeile().size())
			return true;
		else
			return false;
	}

	public ListeB getListeB() {
		return listeB;
	}
	public void setListeB(ListeB listeB) {
		this.listeB = listeB;
	}

}
