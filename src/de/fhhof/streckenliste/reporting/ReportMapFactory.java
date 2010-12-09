package de.fhhof.streckenliste.reporting;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import de.fhhof.streckenliste.reporting.daten.AEintragArt;
import de.fhhof.streckenliste.reporting.daten.AKlasse;
import de.fhhof.streckenliste.reporting.daten.AWildart;
import de.fhhof.streckenliste.reporting.daten.AZeile;
import de.fhhof.streckenliste.reporting.daten.AnschrUJB;
import de.fhhof.streckenliste.reporting.daten.ListeA;
import de.fhhof.streckenliste.reporting.daten.Streckenliste;
import de.fhhof.streckenliste.util.Repository;

@Deprecated
public class ReportMapFactory {
	public static Map<String, String> createMapAZeile(AZeile aZeile) {
		HashMap<String, String> result = new HashMap<String, String>();
		if (aZeile != null) {
			StringBuffer aDatumStr = new StringBuffer(); 
			GregorianCalendar aDatum = aZeile.getaDatum();
			aDatumStr.append( String.valueOf(aDatum.get(Calendar.YEAR)+"-") );
			aDatumStr.append( String.valueOf(aDatum.get(Calendar.MONTH)+"-") );
			aDatumStr.append( String.valueOf(aDatum.get(Calendar.DAY_OF_MONTH)) );
			result.put(Repository.ADATUM[0], aDatumStr.toString());
			
			AWildart aWildart = aZeile.getaWildart();
			if (aWildart != null) {
				result.put(Repository.AWILDART[0], aWildart.getaWildartName());
			}
			
			AKlasse aKlasse = aZeile.getaKlasse();
			if (aKlasse != null) {
				result.put(Repository.AKLASSE[0], aKlasse.getaKlasseName());
			}
			
			result.put(Repository.ABEMERK[0], aZeile.getaBemerk());
			
			AEintragArt aEintragArt = aZeile.getaEintragArt();
			if (aEintragArt != null) {
				switch (aEintragArt) {
				case aErlegt: { result.put(Repository.AERLEGT[0], "1"); break;}
				case aSonstFall: { result.put(Repository.ASONSTFALL[0], "1"); break;}
				case aGefangen: { result.put(Repository.AGEFANGEN[0], "1"); break;}
				case aVerkehr: { result.put(Repository.AVERKEHR[0], "1"); break;}
				case aCustom: { result.put(aEintragArt.getAEintragName(), "1"); break;}
				}
			}
			
			StringBuffer aMeldDatumStr = new StringBuffer();
			GregorianCalendar aMeldedatum = aZeile.getaMeldedatum();
			if (aMeldedatum != null) {
				aMeldDatumStr.append( String.valueOf(aDatum.get(Calendar.YEAR)+"-") );
				aMeldDatumStr.append( String.valueOf(aDatum.get(Calendar.MONTH)+"-") );
				aMeldDatumStr.append( String.valueOf(aDatum.get(Calendar.DAY_OF_MONTH)) );
				result.put(Repository.AMELDEDATUM[0], aMeldDatumStr.toString());
			}
		}
		
		return result;
	}
	
	public static ArrayList<Map<String, String>> createListListeAEntries(ListeA listeA) {
		ArrayList<Map<String, String>> result = new ArrayList<Map<String,String>>();
		
		if (listeA != null) {
			HashMap<String, String> mapListeA = new HashMap<String, String>();
			mapListeA.put(Repository.JJAHR[0], listeA.getJJahr());
			
			GregorianCalendar abgDatum = listeA.getAbgDatum();
			StringBuffer datum = new StringBuffer();
			if (abgDatum != null) {
				datum.append( String.valueOf(abgDatum.get(Calendar.YEAR)+"-") );
				datum.append( String.valueOf(abgDatum.get(Calendar.MONTH)+"-") );
				datum.append( String.valueOf(abgDatum.get(Calendar.DAY_OF_MONTH)) );
			}
			mapListeA.put(Repository.ABGDATUM[0], datum.toString());
			
			mapListeA.put(Repository.ORT[0], listeA.getOrt());
			Object abgUSchrift = listeA.getAbgUnterschrift();
			if (abgUSchrift != null)
				mapListeA.put(Repository.ABGUSCHRIFT[0], abgUSchrift.toString());
			
			//Zeilen
			for (AZeile aZeile: listeA.getAZeile()) {
				result.add(createMapAZeile(aZeile));
			}
			
			result.add(mapListeA);
		}
		
		return result;
	}

	public static Map<String, String> createMapDeckblatt(Streckenliste streckenliste) {
		HashMap<String, String> result = new HashMap<String, String>();
		if (streckenliste != null) {
			AnschrUJB anschrujb = streckenliste.getAnschrUJB();
			if (anschrujb != null) {
				result.put(Repository.UJBLRA[0], anschrujb.getUjbLRA());
				result.put(Repository.UJBSG[0], anschrujb.getUjbSG());
				result.put(Repository.UJBSTR[0], anschrujb.getUjbStr());
				result.put(Repository.UJBPLZ[0], anschrujb.getUjbPLZ());
				result.put(Repository.UJBORT[0], anschrujb.getUjbOrt());
			}

			ListeA la = streckenliste.getListeA();
			if (la != null) {
				result.put(Repository.JJAHR[0], la.getJJahr());
			}
			switch(streckenliste.getRevArt()) {
			case eigenRev: {result.put(Repository.EIGENREV[0], "1"); break;}
			case gemeinRev: {result.put(Repository.STAATSREV[0], "1"); break;}
			case staatsRev: {result.put(Repository.GEMEINREV[0], "1"); break;}
			}
			result.put(Repository.REVNAME[0], streckenliste.getRevName());
			switch(streckenliste.getVerwert()) {
			case erzeugnis: {result.put(Repository.ERZEUGNIS[0], "1"); break;}
			case weitergabe: {result.put(Repository.WEITERGABE[0], "1"); break;}
			case zerwirk: {result.put(Repository.ZERWIRKT[0], "1"); break;}
			}
		}
		return result;
	}

	public static ArrayList<Map<String, String>> createMapArrayList(Map<String, String>... maps) {
		ArrayList<Map<String, String>> result = new ArrayList<Map<String, String>>();
		for (Map<String, String> map: maps)
			if (map!= null)
				result.add(map);
		return result;
	}
	public static void addMapToArrayList(ArrayList<Map<String, String>> ar, Map<String, String>...maps) {
		if (ar != null) {
			for (Map<String, String> map: maps) {
				if (map != null)
					ar.add(map);
			}
		}
	}
}
