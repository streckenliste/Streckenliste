/**
 * //TODO BWildart parse by name
 */
package de.fhhof.streckenliste.reporting;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

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
import de.fhhof.streckenliste.reporting.daten.Sollabschuss;
import de.fhhof.streckenliste.reporting.daten.Streckenliste;
import de.fhhof.streckenliste.reporting.daten.Verwert;

/**
 * @author ronny
 *
 */
public class JDomParser implements DataIO {

	boolean debug=false;
	long sTime=System.currentTimeMillis();//store start time to measure performance
	private Element root;
	private int jJahr;
	/**
	 * 
	 * @param root root Knoten als Element
	 * @param jJahr gibt das aktuelle Jagt Jahr an
	 */
	public JDomParser(Element root,int jJahr)
	{
		this.jJahr=jJahr;
		this.root=root;
		System.out.println();
	}
	protected AnschrUJB readAnschrift()
	{
		//begin Anschrift
		Element anschrUJB=null;
		AnschrUJB AnschrUJB=null;
		try
		{
			anschrUJB=root.getChild("deckblatt").getChild("anschrUJB");
			AnschrUJB=new AnschrUJB(anschrUJB.getChildText("ujbLRA"),anschrUJB.getChildText("ujbSG"),anschrUJB.getChildText("ujbStr"),anschrUJB.getChildText("ujbPLZ"),anschrUJB.getChildText("ujbOrt"));
		}
		catch (Exception err)
		{
			if(debug)
			{
				System.out.println("Fehler beim parsen der Anschrift des Deckblatt");
				System.out.println(""+anschrUJB.getChildText("ujbLRA"));
			}
		}
		return AnschrUJB;
	}
	protected RevArt readRevArt()
	{
		//begin Revierart
		Element revArt=null;
		RevArt revart=null;
		try
		{
			revArt= root.getChild("deckblatt").getChild("revArt");
			revart=RevArt.getRevArtByID(Integer.parseInt(revArt.getText()));
		}
		catch (Exception err)
		{
			if(debug)
			{
				System.out.println("Fehler beim parsen der Revierart des Deckblatt");

			}
		}
		return revart;
	}
	protected Verwert readVerwert()
	{
		Element Verwerte=null;
		Verwert verwert=null;
		//begin Verwertungsart
		try
		{
			Verwerte=root.getChild("deckblatt").getChild("verwert");
			verwert=Verwert.getVerwertByID(Integer.parseInt(Verwerte.getText()));
		}
		catch (Exception err)
		{
			if(debug)
			{
				System.out.println("Fehler beim parsen der Verwertungsart des Deckblatt");

			}
		}
		return verwert;
	}
	protected String readbSatzart()
	{
		String bSatzart="";
		try
		{
			bSatzart=root.getChild("deckblatt").getChild("bSatzart").getText();
		}
		catch (Exception err)
		{
			if(debug)
			{
				System.out.println("Fehler beim parsen der bSatzart des Deckblatt");

			}
		}
		return bSatzart;
	}
	protected String readAmtID()
	{
		String amtID="";
		try
		{
			amtID=root.getChild("deckblatt").getChild("amtID").getText();
		}
		catch (Exception err)
		{
			if(debug)
			{
				System.out.println("Fehler beim parsen der amtID des Deckblatt");

			}
		}

		return amtID;
	}
	protected String readRevName()
	{
		String revName="";
		try
		{
			revName=root.getChild("deckblatt").getChild("revName").getText();
		}
		catch (Exception err)
		{
			if(debug)
			{
				System.out.println("Fehler beim parsen der Reviernname des Deckblatt");

			}
		}

		return revName;
	}
	protected String readRevNr()
	{
		String revNr="";
		try
		{
			revNr=root.getChild("deckblatt").getChild("revNr").getText();
		}
		catch (Exception err)
		{
			if(debug)
			{
				System.out.println("Fehler beim parsen der Reviernummer des Deckblatt");

			}
		}

		return revNr;
	}
	protected int readDeckblatt(Streckenliste streckenliste)
	{
		streckenliste.setAnschrUJB(readAnschrift());
		streckenliste.setRevArt(readRevArt());
		streckenliste.setVerwert(readVerwert());
		streckenliste.setbSatzart(readbSatzart());
		streckenliste.setAmtID(readAmtID());
		streckenliste.setRevNr(readRevNr());
		streckenliste.setRevName(readRevName());
		if(debug)
			System.out.println("total runtime:"+(System.currentTimeMillis()-sTime));
		return 0;
	}
	/**
	 * 
	 * @return Element Jagt Jahr ListeA
	 */
	protected Element getAListeA()
	{
		try
		{
			List<Element> a=root.getChild("daten").getChild("listeA").getChildren();
			for(Element jahr:a)
			{
				if(jahr.getAttribute("jJahr").getIntValue()==jJahr)
					return jahr;
			}
		}
		catch (Exception err)
		{
			if(debug)
			{
				System.out.println("Fehler beim holen des ListeA Element");
			}
		}
		return null;
	}
	/***
	 * 	
	 * @return Element Liste B altuelles Jagtjahr
	 */
	protected Element getBListeB()
	{
		try
		{
			List<Element> a=root.getChild("daten").getChild("listeB").getChildren();
			for(Element jahr:a)
			{
				if(jahr.getAttribute("jJahr").getIntValue()==jJahr)
					return jahr;
			}
		}
		catch (Exception err)
		{
			if(debug)
			{
				System.out.println("Fehler beim holen des ListeB Element");
			}
		}
		return null;
	}
	protected boolean testGregorian(String line)
	{
		GregorianCalendar a=new GregorianCalendar();
		DateFormat df=new SimpleDateFormat("dd.MM.yyyy");
		try
		{
			a.setTime(df.parse(line));
		}
		catch (Exception err)
		{
			if(debug)
			{
				System.out.println("Fehler bei Test Umwandeln von:"+line+" in GregorianCalendar");
			}
			return false;
		}
		return true;
	}
	protected GregorianCalendar parseGregorian(String line)
	{
		GregorianCalendar a=new GregorianCalendar();
		DateFormat df=new SimpleDateFormat("dd.MM.yyyy");
		try
		{
			a.setTime(df.parse(line));
		}
		catch (Exception err)
		{
			if(debug)
			{
				System.out.println("Fehler beim Umwandeln von:"+line+" in GregorianCalendar");
			}
		}
		return a;
	}
	protected float parseFloat(String line)
	{
		Float e=0F;
		try
		{
			DecimalFormatSymbols nf=new DecimalFormatSymbols();
			nf.setDecimalSeparator(',');
			DecimalFormat format=new DecimalFormat();
			format.setDecimalFormatSymbols(nf);
			e=(format.parse(line)).floatValue();
		}
		catch (Exception err)
		{
			if(debug)
			{
				System.out.println("Fehler beim umwandeln von :"+line+" in Float");
			}
		}
		return e;
	}
	protected AWildart readAWildart(String line)
	{
		AWildart aw=null;
		try
		{
			aw =AWildart.getAWildartByID(Integer.parseInt(line));	
		}
		catch (Exception err)
		{
			if(debug)
			{
				System.out.println("Fehler beim parsen von : "+line+" in AWildart");
			}}
		return aw;
	}
	protected AEintragArt readAEintragArt(String line)
	{
		AEintragArt aea=null;
		try
		{
			aea=AEintragArt.getAEintragArtByID(Integer.parseInt(line));
		}
		catch (Exception err)
		{
			if(debug)
			{
				System.out.println("Fehler beim parsen von : "+line+" in AEintragArt");
			}
		}
		return aea;
	}
	protected AKlasse readAKlasse (String line)
	{
		AKlasse ak=null;
		try
		{
			ak=AKlasse.getAKlasseByID(Integer.parseInt(line));
		}
		catch (Exception err)
		{
			if(debug)
			{
			System.out.println("Fehler beim parsen von : "+line+" in AKlasse");
		}}
		return ak;
	}
	protected int parseAID(String line)
	{
		int i=1;
		try
		{
			i=Integer.parseInt(line);
		}
		catch (Exception err)
		{
			if(debug)
			{
				System.out.println("Fehler beim parsen von aID: "+line+" in int");
			}
		}
		return i;
	}
	protected Vector<AZeile> readAZeile()
	{
		Vector<AZeile> aZeileV=new Vector<AZeile>();
		List <Element> z=getAListeA().getChildren();
		for(Element eintrag:z)
		{
			try
			{
				aZeileV.add(new AZeile(
						parseGregorian(eintrag.getChildText("aDatum")),
						parseFloat(eintrag.getChildText("aGewicht")),
						readAWildart(eintrag.getChildText("aWildart")),
						readAKlasse(eintrag.getChildText("aKlasse")),
						eintrag.getChildText("aBemerk"),
						readAEintragArt(eintrag.getChildText("aEintragArt")),
						parseGregorian(eintrag.getChildText("aMeldedatum")),
						parseAID(eintrag.getAttributeValue("aID"))));
			}
			catch (Exception err)
			{
				if(debug)
				{
					System.out.println("Fehler beim hinzufügen von AZeile in Vector<AZeile>");
				}
			}
		}
		return aZeileV;
	}
	/**
	 * füllen der HashMaps mit den verfügbaren aKlassen
	 */ 
	protected int preFillSums(HashMap<AKlasse, Integer> sumErl,HashMap<AKlasse, Integer> sumFall,HashMap<AKlasse, Integer> sumGes)
	{
		for (int i=0;i<200;i++)
		{
			if (AKlasse.getAKlasseByID(i)!=null)
			{
				sumErl.put(AKlasse.getAKlasseByID(i), (Integer) 0);
				sumFall.put(AKlasse.getAKlasseByID(i), (Integer) 0);
				sumGes.put(AKlasse.getAKlasseByID(i),  (Integer) 0);
			}
		}
		return 0;
	}
	protected void addAKlasseHash(HashMap<AKlasse, Integer> sumErl,Element e)
	{
		sumErl.put(
				AKlasse.getAKlasseByID(
						Integer.parseInt(e.getChildText("aKlasse"))),
						sumErl.get(AKlasse.getAKlasseByID(
								Integer.parseInt(e.getChildText("aKlasse")))));
	}
	/**
	 * adds AKlasse to Hashmaps
	 * @param sumErl Hashmap zur Aufnahme des erlegten Wildes
	 * @param sumFall Hashmap zur Aufnahme des Fallwildes
	 * @param sumGes Hashmap zur Aufnahme der Summe des gemeldeten Wildes
	 * @return not implemented yet
	 */
	protected int calSums(HashMap<AKlasse, Integer> sumErl,HashMap<AKlasse, Integer> sumFall,HashMap<AKlasse, Integer> sumGes)
	{
		try
		{
			List<Element>az=getAListeA().getChildren("aZeile");
			for(Element ae:az)
			{
				switch(Integer.parseInt(ae.getChildText("aEintragArt")))	{
				case 1:addAKlasseHash(sumErl,ae);break;
				case 2:addAKlasseHash(sumFall,ae);break;
				case 3:
				case 4:addAKlasseHash(sumErl,ae);break;
				}
				addAKlasseHash(sumGes,ae);
			}
		}
		catch (Exception err)
		{
			if(debug)
			{
				System.out.println("Fehler beim füllen der HashMap Summen");
			}
		}
		return 0;
	}
	protected void readListeA(Streckenliste str)
	{
		ListeA lista=new ListeA();
		HashMap<AKlasse, Integer> sumErl = new HashMap<AKlasse, Integer>();
		HashMap<AKlasse, Integer> sumFall= new HashMap<AKlasse, Integer>();
		HashMap<AKlasse, Integer> sumGes= new HashMap<AKlasse, Integer>();
		try
		{
			Element aList =getAListeA();
			lista.setJJahr(""+jJahr);
			lista.setAbgDatum(parseGregorian(aList.getChildText("abgDatum")));
			lista.setOrt(aList.getChildText("ort"));
			lista.setAbgUnterschrift(aList.getChildText("abgUnterschrift"));
			lista.setAZeile(readAZeile());
			preFillSums(sumErl,sumFall,sumGes);			//füllen der HashMap mit den verfügbaren Klassen
			calSums(sumErl,sumFall,sumGes);
			lista.setSumErl(sumErl);
			lista.setSumFall(sumFall);
			lista.setSumGes(sumGes);
			str.setListeA(lista);
		}
		catch (Exception err)
		{
			if(debug)
				System.out.println("Fehler beim parsen von ListeA");
		}
	}

	/* (non-Javadoc)
	 * @see de.fhhof.streckenliste.reporting.DataFileIO#readStreckenliste()
	 */
	/**
	 * took jJahr from Konstructor
	 */
	protected BWildart readBWildart(String line)
	{
		BWildart bw= null;
		try
		{
			bw=BWildart.getBWildartByID(Integer.parseInt(line));
		}
		catch (Exception err)
		{
			if(debug)
			{
				System.out.println("Fehler beim parsen von: "+line+" nach BWildart");
			}
		}
		return bw;
	}
	protected int readInt(String line)
	{
		int i=0;
		try
		{
			i=Integer.parseInt(line);
		}
		catch (Exception err)
		{
			if(debug)
			{
				System.out.println("Fehler beim parsen von: "+line+" nach int");
			}
		}
		return i;
	}
	protected String readString(String line)
	{
		String l="";
		try
		{
			l+=line;
		}
		catch (Exception err)
		{
			if(debug)
			{
				System.out.println("Fehler beim parsen von: "+line+" nach String");
			}
		}
		return l;
	}
	protected Vector<BZeile> readBZeile()
	{
		Vector<BZeile> bZeileV=new Vector();
		List <Element> z=getBListeB().getChildren();
		for(Element eintrag:z)
		{
			try
			{
				bZeileV.add(new BZeile(
						readBWildart(eintrag.getAttributeValue("wildartID")),
						readInt(eintrag.getChildText("bAnzErlegt")),
						readInt(eintrag.getChildText("bAnzFallVerend")),
						readInt(eintrag.getChildText("bAnzFallVerkehr,")),
						readString(eintrag.getChildText("bVerkehr"))));
			}
			catch (Exception err)
			{
				if(debug)
				{
					System.out.println("Fehler beim hinzufügen von AZeile in Vector<AZeile>");
				}
			}

		}
		return bZeileV;
	}
	protected void readSollAbsch(Streckenliste st)
	{
		Vector<Sollabschuss> sa=new  Vector<Sollabschuss>();
	}
	/**
	 * since only jJahr is given, "1.1.jJahr" is parsed to GregorianCalendar
	 */ 
	protected void readListeB(Streckenliste str)

	{
		ListeB listb=new ListeB();
		try
		{
			listb.setjJahr(parseGregorian("1.1."+jJahr));
			listb.setbZeile(readBZeile());
		}
		catch(Exception err)
		{
			if(debug)
			{
				System.out.println("Fehler beim parsen von ListeB");
			}
		}
		str.setListeB(listb);
	}
	/**
	 * inserts the current date into > root.daten.listeA.jJahr<jJahr>.aZeile.aMeldedatum
	 * if there is a Date in  aMeldedatum testGregorian(...) will pass the line will be skipped 
	 * @return not implemented yet
	 */
	protected boolean reportSt()
	{
		Element lista=getAListeA(); 
		try
		{
			List<Element> f=lista.getChildren("aZeile");
			Element aMeldedatum=new Element("d","fef");
			String date=(new GregorianCalendar().get(4)+"."+new GregorianCalendar().get(2)+"."+new GregorianCalendar().get(1));
			aMeldedatum.setName("aMeldedatum");
			aMeldedatum.setText(date);
			for(Element zeile:f)
			{
				if(zeile.getChild("aMeldedatum")!=null)
				{
					if(testGregorian(zeile.getChildText("aMeldedatum")))
					{
						;
					}
					else
					{
						zeile.getChild("aMeldedatum").setText(date);
					}
				}
				else
				{
					zeile.addContent(aMeldedatum);
				}
			}
		}
		catch (Exception err)
		{
			if(debug)
			{
				System.out.println("Fehler beim Abschliessen");
			}
		}
		return true;
	}

	@Override
	public Streckenliste readStreckenliste() {
		// TODO Auto-generated method stub
		Streckenliste st=new Streckenliste();
		readDeckblatt(st);
		readListeA(st);
		readListeB(st);
		readSollAbsch(st);
		return st;
	}

	/* (non-Javadoc)
	 * @see de.fhhof.streckenliste.reporting.DataFileIO#readStreckenliste(int, java.lang.String)
	 */
	@Override
	public Streckenliste readStreckenliste(int jahr, String revier) {
		// TODO Auto-generated method stub
		return readStreckenliste();
	}

	/* (non-Javadoc)
	 * @see de.fhhof.streckenliste.reporting.DataFileIO#streckenlisteAbschliessen(int, java.lang.String)
	 */
	@Override
	public void streckenlisteAbschliessen(int jahr, String revier) {
		// TODO Auto-generated method stub
		reportSt();
		//createNewNodes();

	}

	/* (non-Javadoc)
	 * @see de.fhhof.streckenliste.reporting.DataFileIO#streckenlisteZwischenmeldung(int, java.lang.String)
	 */
	@Override
	public void streckenlisteZwischenmeldung(int jahr, String revier) {
		// TODO Auto-generated method stub
		reportSt();
	}

}
