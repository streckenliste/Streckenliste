package de.fhhof.streckenliste.reporting.util;

import java.util.Calendar;
import java.util.GregorianCalendar;

import de.fhhof.streckenliste.reporting.daten.AEintragArt;
import de.fhhof.streckenliste.reporting.daten.AKlasse;
import de.fhhof.streckenliste.reporting.daten.AWildart;
import de.fhhof.streckenliste.reporting.daten.AZeile;
import de.fhhof.streckenliste.reporting.daten.ListeA;
import de.fhhof.streckenliste.util.Repository;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class JRListeADataSource implements JRDataSource {
	private ListeA listeA;
	
	private int counter;
	private boolean moveReverse;
	
	public JRListeADataSource(ListeA listeA) {
		this(listeA, false);
	}
	public JRListeADataSource(ListeA liste, boolean moveReverse) {
		this.listeA = liste;
		this.moveReverse = moveReverse;
		resetCounter();
	}
	
	private void resetCounter() {
		if (moveReverse) {
			if (listeA.getAZeile() != null)
				counter = listeA.getAZeile().size();
		}
		else {
			counter = -1;
		}
	}
	private void stepCounter() {
		if (moveReverse) {
			counter--;
		}
		else {
			counter++;
		}
	}

	@Override
	public Object getFieldValue(JRField jrField) throws JRException {
		System.out.println("JRListeADataSource: "+jrField.getName());
		Object result = null;
		
		if (listeA != null) {
			String fieldName = jrField.getName();
			if (fieldName.equalsIgnoreCase(Repository.JJAHR[0])) {
				result = listeA.getJJahr();
			}
			else if (fieldName.equalsIgnoreCase(Repository.ABGDATUM[0])) {
				GregorianCalendar calender = listeA.getAbgDatum();
				String datum = calender.get(Calendar.YEAR)+"-"+calender.get(Calendar.MONTH)+"-"+calender.get(Calendar.DAY_OF_MONTH);
				result = datum;
			}
			else if (fieldName.equalsIgnoreCase(Repository.ORT[0])) {
				result = listeA.getOrt();
			}
			else if (fieldName.equalsIgnoreCase(Repository.ABGUSCHRIFT[0])) {
				result = listeA.getAbgUnterschrift();
			}
			else if (listeA.getAZeile() != null) {
				AZeile aZeile = listeA.getAZeile().get(counter);
				
				if (fieldName.equalsIgnoreCase(Repository.ADATUM[0])) {
					GregorianCalendar calender = aZeile.getaDatum();
					String datum = calender.get(Calendar.YEAR)+"-"+calender.get(Calendar.MONTH)+"-"+calender.get(Calendar.DAY_OF_MONTH);
					
					result = datum;
				}
				else if (fieldName.equalsIgnoreCase(Repository.AGEWICHT[0])) {
					result = String.valueOf(aZeile.getaGewicht())+ "kg";
				}
				else if (fieldName.equalsIgnoreCase(Repository.AWILDART[0])) {
					AWildart aWildart = aZeile.getaWildart();
					if (aWildart != null)
						result = aWildart.getaWildartName();
				}
				else if (fieldName.equalsIgnoreCase(Repository.AKLASSE[0])) {
					AKlasse aKlasse = aZeile.getaKlasse();
					if (aKlasse != null)
						result = aKlasse.getaKlasseName();
				}
				else if (fieldName.equalsIgnoreCase(Repository.ABEMERK[0])) {
					result = aZeile.getaBemerk();
				}
				else if (fieldName.equalsIgnoreCase(Repository.AEINTRAGART[0])) {
					AEintragArt aEintragArt = aZeile.getaEintragArt();
					if (aEintragArt != null)
						result = aEintragArt.getAEintragName();
				}
				else if (fieldName.equalsIgnoreCase(Repository.AERLEGT[0])) {
					AEintragArt aEintragArt = aZeile.getaEintragArt();
					if (aEintragArt != null)
						result = aEintragArt.getAEintragName();
				}
				else if (fieldName.equalsIgnoreCase(Repository.AVERKEHR[0])) {
					AEintragArt aEintragArt = aZeile.getaEintragArt();
					if (aEintragArt != null)
						result = aEintragArt.getAEintragName();
				}
				else if (fieldName.equalsIgnoreCase(Repository.ASONSTFALL[0])) {
					AEintragArt aEintragArt = aZeile.getaEintragArt();
					if (aEintragArt != null)
						result = aEintragArt.getAEintragName();					
				}
				else if (fieldName.equalsIgnoreCase(Repository.AGEFANGEN[0])) {
					AEintragArt aEintragArt = aZeile.getaEintragArt();
					if (aEintragArt != null)
						result = aEintragArt.getAEintragName();
				}
				else if (fieldName.equalsIgnoreCase(Repository.AID[0])) {
					result = aZeile.getid();
				}
				else if (fieldName.equalsIgnoreCase(Repository.AMELDEDATUM[0])) {
					GregorianCalendar calender = aZeile.getaMeldedatum();
					String datum = calender.get(Calendar.YEAR)+"-"+calender.get(Calendar.MONTH)+"-"+calender.get(Calendar.DAY_OF_MONTH);
					
					result = datum;
				}
			}
		}
		
		return result;
	}

	@Override
	public boolean next() throws JRException {
		System.out.println("JRListeADataSource - next: "+ (counter >= listeA.getAZeile().size()) );
		if (moveReverse) {
			if (counter == 0) {
				resetCounter();
				return false;
			}
			else {
				stepCounter();
				return true;
			}
		}
		else {
			if (listeA.getAZeile() != null) {
				if (counter >= listeA.getAZeile().size()-1) {
					resetCounter();
					return false;
				}
				else {
					stepCounter();
					return true;
				}
			}
			else {
				return false;
			}
		}
	}

	public ListeA getListeA() {
		return listeA;
	}
	public void setListeA(ListeA listeA) {
		this.listeA = listeA;
	}

	public boolean isMoveReverse() {
		return moveReverse;
	}
	public void setMoveReverse(boolean moveReverse) {
		this.moveReverse = moveReverse;
	}
}
