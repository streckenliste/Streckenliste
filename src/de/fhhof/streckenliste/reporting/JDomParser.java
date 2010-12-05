/**
 * 
 */
package de.fhhof.streckenliste.reporting;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import org.jdom.Element;

import de.fhhof.streckenliste.reporting.daten.AEintragArt;
import de.fhhof.streckenliste.reporting.daten.AKlasse;
import de.fhhof.streckenliste.reporting.daten.AWildart;
import de.fhhof.streckenliste.reporting.daten.AZeile;
import de.fhhof.streckenliste.reporting.daten.AnschrUJB;
import de.fhhof.streckenliste.reporting.daten.ListeA;
import de.fhhof.streckenliste.reporting.daten.RevArt;
import de.fhhof.streckenliste.reporting.daten.Streckenliste;
import de.fhhof.streckenliste.reporting.daten.Verwert;

/**
 * @author ronny
 *
 */
public class JDomParser implements DataFileIO {

	boolean debug=true;
	long perf=System.currentTimeMillis();
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
			System.out.println("total runtime:"+(System.currentTimeMillis()-perf));
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
			System.out.println("Fehler beim parsen von : "+line+" in AWildart");
		}
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
			System.out.println("Fehler beim parsen von : "+line+" in AKlasse");
		}
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
		Vector<AZeile> aZeileV=new Vector();
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
	HashMap<AKlasse, Integer> sumErl = new HashMap();
	HashMap<AKlasse, Integer> sumFall= new HashMap();
	HashMap<AKlasse, Integer> sumGes= new HashMap();
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
	/*protected int readListeA(Streckenliste str)
	{
		ListeA lista=new ListeA();
		Element liste_a =root.getChild("daten").getChild("listeA");
		List  <Element>JJahr=liste_a.getChildren();
		//	String year =""+GregorianCalendar.getInstance().get(1);
		//Variablen für die aktuelle Streckenliste A deklarienen
		GregorianCalendar abgDatum=new GregorianCalendar();
		String ort="";
		Object abgUnterschrift="";
		Vector<AZeile> aZeileV=new Vector();;
		HashMap<AKlasse, Integer> sumErl = new HashMap();
		HashMap<AKlasse, Integer> sumFall= new HashMap();
		HashMap<AKlasse, Integer> sumGes= new HashMap();
		preFillSums(sumErl,sumFall,sumGes);			//füllen der HashMap mit den verfügbaren Klassen
		//Format für Datum angeben
		DateFormat df=new SimpleDateFormat("dd.MM.yyyy");
		//aktuelles  Jagt Jahr finden und parsen
		for (Element o:JJahr)
		{
			if(Integer.parseInt(o.getAttributeValue("jJahr"))==jJahr)
			{
				try {
					abgDatum.setTime(df.parse(o.getChildText("abgDatum")));
				} catch (ParseException e) {
					System.out.println("Fehler beim parsen von abgDatum im Jahr "+jJahr);
					e.printStackTrace();
				}
				ort=o.getChildText("ort");
				abgUnterschrift=o.getChildText("abgUschrift");
				List <Element> aZeilea=o.getChildren("aZeile");

				for(Element e:aZeilea)
				{
					GregorianCalendar aDate=new GregorianCalendar();
					GregorianCalendar aMeld=new GregorianCalendar();
					int r=0;//aErlegt(1), aVerkehr(2), aSonstFall(3), aGefangen(4)
					try{
						aDate.setTimeInMillis(df.parse(e.getChild("aDatum").getText()).getTime());

						try
						{
							aMeld.setTimeInMillis(df.parse(e.getChild("aMeldedatum").getText()).getTime());
						}
						catch (Exception err)
						{
							aMeld=null;
						}


						//sumErl; sumFall;sumGes;
						if (e.getChildText("aaZeileArt")!=null)
						{
							if (e.getChildText("aaZeileArt").equalsIgnoreCase("1"))
							{
								r=1;
								try
								{
									sumErl.put(AKlasse.getAKlasseByID(Integer.parseInt(e.getChildText("aKlasse"))), (Integer)sumErl.get(AKlasse.getAKlasseByID(Integer.parseInt(e.getChildText("aKlasse"))))+1);
									//	System.out.println(sumErl.get(AKlasse.getAKlasseByID(Integer.parseInt(e.getChildText("aKlasse"))))+1);
								}
								catch (Exception err)
								{
									System.out.println("**********************");
									System.out.println("err sumErl");
									System.out.println("aKlasse="+AKlasse.getAKlasseByID(Integer.parseInt(e.getChildText("aKlasse"))));
									System.out.println("Klasse="+e.getChildText("aKlasse"));
									System.out.println("sumErl:"+(Integer)sumErl.get(AKlasse.getAKlasseByID(Integer.parseInt(e.getChildText("aKlasse")))));
									System.out.println("****************");

								}
							}
							else if (e.getChildText("aaZeileArt").equalsIgnoreCase("2")||e.getChildText("aaZeileArt").equalsIgnoreCase("3"))
							{
								r=2;
								if(e.getChildText("aaZeileArt").equalsIgnoreCase("sonstFallwild"))
									r=3;
								try
								{
									sumFall.put(AKlasse.getAKlasseByID(Integer.parseInt(e.getChildText("aKlasse"))), (Integer)sumFall.get(AKlasse.getAKlasseByID(Integer.parseInt(e.getChildText("aKlasse"))))+1);
								}
								catch (Exception err)
								{
									System.out.println("**********************");
									System.out.println("err sumFall");
									System.out.println("aKlasse:"+AKlasse.getAKlasseByID(Integer.parseInt(e.getChildText("aKlasse"))));
									System.out.println("**********************");
								}
							}
						}
						try{
							sumGes.put(AKlasse.getAKlasseByID(Integer.parseInt(e.getChildText("aKlasse"))), (Integer)sumGes.get(AKlasse.getAKlasseByID(Integer.parseInt(e.getChildText("aKlasse"))))+1);
						}

						catch (Exception err)
						{
							System.out.println("err sumGes");
						}}
					catch (Exception err)
					{
						System.out.println("Err parsing Azeile Date");
					}
					if (e.getChild("aEintragArt").getText().equals("4"))
						r=4;
					//da aGewicht mit Komma angegeben ist muss mit einem Formatierer gearbeitet werden
					Float aGwe=0F;
					try
					{
						DecimalFormatSymbols nf=new DecimalFormatSymbols();
						nf.setDecimalSeparator(',');
						DecimalFormat format=new DecimalFormat();
						format.setDecimalFormatSymbols(nf);
						aGwe=(format.parse(e.getChildText("aGewicht"))).floatValue();
					}
					catch (Exception err)
					{
						System.out.println("Fehler beim umwandeln von aGewicht in Float");
					}

					try
					{
						aZeileV.add(new AZeile(
								aDate,
								aGwe,
								AWildart.getAWildartByID(Integer.parseInt(e.getChildText("aWildart"))),
								AKlasse.getAKlasseByID(Integer.parseInt(e.getChildText("aKlasse"))),
								""+e.getChildText("aBemerk"),AEintragArt.getAEintragArtByID(r),
								aMeld,
								Integer.parseInt(e.getAttributeValue("aID"))));
					}
					catch (Exception err)
					{
						System.out.println("err in add aZeile Vector");
						err.getStackTrace();
					}
				}}}

		lista=new ListeA(""+jJahr, abgDatum,  ort, abgUnterschrift, aZeileV, sumErl, sumFall, sumGes);
		str.setListeA(lista);
		return 0;
	}
	*/
	/* (non-Javadoc)
	 * @see de.fhhof.streckenliste.reporting.DataFileIO#readStreckenliste()
	 */
	@Override
	public Streckenliste readStreckenliste() {
		// TODO Auto-generated method stub
		Streckenliste st=new Streckenliste();
		readDeckblatt(st);
		readListeA(st);
		
		return st;
	}

	/* (non-Javadoc)
	 * @see de.fhhof.streckenliste.reporting.DataFileIO#readStreckenliste(int, java.lang.String)
	 */
	@Override
	public Streckenliste readStreckenliste(int jahr, String revier) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see de.fhhof.streckenliste.reporting.DataFileIO#streckenlisteAbschliessen(int, java.lang.String)
	 */
	@Override
	public void streckenlisteAbschliessen(int jahr, String revier) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see de.fhhof.streckenliste.reporting.DataFileIO#streckenlisteZwischenmeldung(int, java.lang.String)
	 */
	@Override
	public void streckenlisteZwischenmeldung(int jahr, String revier) {
		// TODO Auto-generated method stub

	}

}
