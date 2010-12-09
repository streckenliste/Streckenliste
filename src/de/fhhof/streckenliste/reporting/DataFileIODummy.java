package de.fhhof.streckenliste.reporting;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Vector;

import de.fhhof.streckenliste.reporting.daten.AEintragArt;
import de.fhhof.streckenliste.reporting.daten.AKlasse;
import de.fhhof.streckenliste.reporting.daten.AWildart;
import de.fhhof.streckenliste.reporting.daten.AZeile;
import de.fhhof.streckenliste.reporting.daten.AnschrUJB;
import de.fhhof.streckenliste.reporting.daten.BWildart;
import de.fhhof.streckenliste.reporting.daten.BZeile;
import de.fhhof.streckenliste.reporting.daten.ListeA;
import de.fhhof.streckenliste.reporting.daten.ListeB;
import de.fhhof.streckenliste.reporting.daten.RevArt;
import de.fhhof.streckenliste.reporting.daten.Sollabschuesse;
import de.fhhof.streckenliste.reporting.daten.Sollabschuss;
import de.fhhof.streckenliste.reporting.daten.Streckenliste;
import de.fhhof.streckenliste.reporting.daten.Verwert;

public class DataFileIODummy implements DataIO {

	@Override
	public Streckenliste readStreckenliste() {
		Streckenliste s = new Streckenliste();
		
		s.setAmtID("Amt Dummy 4711");
		s.setAnschrUJB(new AnschrUJB("LRA", "SG", "Straﬂe 12", "0815", "Testtown"));
		s.setbSatzart("08");
		ListeA listeA = new ListeA(); {
			listeA.setAbgDatum(new GregorianCalendar(2010, 12, 1));
			listeA.setAbgUnterschrift(new String("Unter-Oben-Ausser"));
			Vector<AZeile> aZeile = new Vector<AZeile>(); {
				aZeile.add(new AZeile(new GregorianCalendar(2010, 1, 1), 12, AWildart.aAuerhahn, AKlasse.aAuerhahn, "tot",
						AEintragArt.aErlegt, new GregorianCalendar(2010, 1, 1), 1));
				aZeile.add(new AZeile(new GregorianCalendar(2010, 1, 2), 13, AWildart.aDam, AKlasse.aHirschIDam, "auch tot", AEintragArt.aErlegt,
						new GregorianCalendar(2010, 1, 2), 2));
				aZeile.add(new AZeile(new GregorianCalendar(2010, 1, 3), 27, AWildart.aAuerhahn, AKlasse.aAuerhahn, "hab dich",
						AEintragArt.aGefangen, new GregorianCalendar(2010, 1, 3), 3));
			}
			listeA.setAZeile(aZeile);
			listeA.setJJahr("2010");
			listeA.setOrt("Abschussstadt");			
			HashMap<AKlasse, Integer> sumErl = new HashMap<AKlasse, Integer>(); {
				sumErl.put(AKlasse.aAuerhahn, 1);
				sumErl.put(AKlasse.aHirschIDam, 1);
			}
			listeA.setSumErl(sumErl);
			HashMap<AKlasse, Integer> sumFall = new HashMap<AKlasse, Integer>(); {
				
			}
			listeA.setSumFall(sumFall );			
			HashMap<AKlasse, Integer> sumGes = new HashMap<AKlasse, Integer>(); {
				sumGes.put(AKlasse.aAuerhahn, 2);
				sumGes.put(AKlasse.aHirschIDam, 1);
			}
			listeA.setSumGes(sumGes);
		}
		s.setListeA(listeA);
		ListeB listeB = new ListeB(); {
			listeB.setjJahr(new GregorianCalendar(2010, 12, 31));
			for (BWildart bw: BWildart.values()) {
				listeB.getbZeile().add(new BZeile(bw, 1, 1, 1, "generated Entry"));
			}
		}
		s.setListeB(listeB );
		s.setRevArt(RevArt.eigenRev);
		s.setRevName("DummyRevier");
		s.setRevNr("1234567890");
		Sollabschuesse sollabschuesse = new Sollabschuesse(); {
			sollabschuesse.setjJahr("2010");
			int i=0;
			for (AKlasse ak: AKlasse.values()) {
				sollabschuesse.getSollabschusse().add(new Sollabschuss(ak, i));
				i++;
			}
		}
		s.setSollabschuesse(sollabschuesse);
		s.setVerwert(Verwert.erzeugnis);
		
		return s;
	}

	@Override
	public Streckenliste readStreckenliste(int jahr, String revier) {
		return readStreckenliste();
	}

	@Override
	public void streckenlisteAbschliessen(int jahr, String revier) {

	}

	@Override
	public void streckenlisteZwischenmeldung(int jahr, String revier) {
	}

}
