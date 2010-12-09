package de.fhhof.streckenliste.reporting.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import de.fhhof.streckenliste.reporting.daten.AKlasse;
import de.fhhof.streckenliste.reporting.daten.AWildart;
import de.fhhof.streckenliste.reporting.daten.Sollabschuesse;
import de.fhhof.streckenliste.reporting.daten.Sollabschuss;
import de.fhhof.streckenliste.util.Repository;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class JRSumSollDataSource implements JRDataSource {
	private Map<AKlasse, Integer> aSumErl;
	private Map<AKlasse, Integer> aSumFall;
	private Map<AKlasse, Integer> aSumGes;
	private Sollabschuesse sollabschuesse;
	private AKlasse[] usedAKlasseNames;
	private int count;

	public JRSumSollDataSource(Map<AKlasse, Integer> aSumErl, Map<AKlasse, Integer> aSumFall, Map<AKlasse, Integer> aSumGes, Sollabschuesse sollabschuesse) {
		this.aSumErl = aSumErl;
		this.aSumFall = aSumFall;
		this.aSumGes = aSumGes;
		this.sollabschuesse = sollabschuesse;
		initKeys();
		resetCounter();
	}
	private void initKeys() {
		usedAKlasseNames = addKeys( aSumErl.keySet(), aSumFall.keySet(), aSumGes.keySet() );
	}
	private AKlasse[] addKeys(Set<AKlasse>... keys) {
		usedAKlasseNames = new AKlasse[0];
		
		HashMap<AKlasse, String> tempKeys = new HashMap<AKlasse, String>();
		for (Set<AKlasse> keySet: keys)
			for (AKlasse key: keySet) {
				tempKeys.put(key, "");
			}
		
		return tempKeys.keySet().toArray(usedAKlasseNames);
	}
	private void resetCounter() {
		count = -1;
	}
	@Override
	public boolean next() throws JRException {
		System.out.println(count);
		count++;
		if(count >= usedAKlasseNames.length) {
			resetCounter();
			return false;
		}
		else
			return true;
	}

	@Override
	public Object getFieldValue(JRField jrField) throws JRException {
		Object result = null;
		System.out.println(jrField.getName());

		String fieldName = jrField.getName();
		if (fieldName.equalsIgnoreCase(Repository.AWILDART[0])) {
			AWildart aWildart = usedAKlasseNames[count].getaWildart();
			if (aWildart == null)
				result = null;
			else
				result = aWildart.getaWildartName();
		}
		else if (fieldName.equalsIgnoreCase(Repository.AKLASSE[0])) {
			AKlasse aKlasse = usedAKlasseNames[count];
			if (aKlasse == null)
				result = 0;
			else
				result = aKlasse.getaKlasseName();
		}
		else if (fieldName.equalsIgnoreCase(Repository.SUMERL[0])) {
			Integer i = aSumErl.get(usedAKlasseNames[count]);
			if (i == null)
				result = 0;
			else
				result = i;
		}
		else if (fieldName.equalsIgnoreCase(Repository.SUMFALL[0])) {
			Integer i = aSumFall.get(usedAKlasseNames[count]);
			if (i == null)
				result = 0;
			else
				result = i;
		}
		else if (fieldName.equalsIgnoreCase(Repository.SUMGES[0])) {
			Integer i = aSumGes.get(usedAKlasseNames[count]);
			if (i == null)
				result = 0;
			else
				result = i;
		}
		else if (fieldName.equalsIgnoreCase(Repository.SOLL[0])) {
			for (Sollabschuss sa: sollabschuesse.getSollabschusse()) {
				if (sa.getAKlasse() == usedAKlasseNames[count]) {
					result = sa.getSoll();
					break;
				}
			}
			if (result == null)
				result = 0;
		}

		return result;
	}
}