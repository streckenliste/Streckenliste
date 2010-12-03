package de.fhhof.streckenliste.reporting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import de.fhhof.streckenliste.reporting.daten.AnschrUJB;
import de.fhhof.streckenliste.reporting.daten.RevArt;
import de.fhhof.streckenliste.reporting.daten.Streckenliste;
import de.fhhof.streckenliste.reporting.daten.Verwert;
import de.fhhof.streckenliste.util.Repository;

public class ReportMapFactory {
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
				result.put(Repository.JJAHR[0], streckenliste.getListeA().getJJahr());
			}
			RevArt revArt = streckenliste.getRevArt();
			if (revArt != null)
				switch(revArt) {
				case eigenRev: {result.put(Repository.EIGENREV[0], "1"); break;}
				case gemeinRev: {result.put(Repository.STAATSREV[0], "1"); break;}
				case staatsRev: {result.put(Repository.GEMEINREV[0], "1"); break;}
				}
			result.put(Repository.REVNAME[0], streckenliste.getRevName());

			Verwert verwert = streckenliste.getVerwert();
			if (verwert != null)
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
}
