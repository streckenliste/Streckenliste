/**
 * 
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
import de.fhhof.streckenliste.reporting.daten.Sollabschuesse;
import de.fhhof.streckenliste.reporting.daten.Sollabschuss;
import de.fhhof.streckenliste.reporting.daten.Streckenliste;
import de.fhhof.streckenliste.reporting.daten.Verwert;

/**
 * @author ronny
 *
 */
public class JDomParser implements DataIO {
	/**
	 * 	variable to enable debug messages
	 * if set to true debug messages will be send to console
	 */
	boolean debug=false;
	/**
	 * variable to hold the start time of class to measure performance
	 */
	long sTime=System.currentTimeMillis();
	/**
	 * root Element of Streckenliste to be set by Konstructor
	 */
	private Element root;
	/**
	 * jJahr to be set by Konstructor to to set the used year
	 */
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
	}
	/**
	 * takes AnschrUJB from root.deckblatt.anschrUJB and returns it  
	 * @return AnschrUJB
	 */
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
	/**
	 * 
	 * @return Verwertungs-Art from root.deckblatt.verwert
	 * @exception return Verwert=null
	 * @throws nothing
	 */
	protected Verwert readVerwert()
	{
		Element Verwerte=null;
		Verwert verwert=null;
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
	/**
	 * @exception returns empty String ""
	 * @return String bSatzArt
	 * @throws nothing
	 */
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
	/**
	 * @exception returns empty String ""
	 * @return Srting AmtID
	 * @throws nothing
	 */
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
	/**
	 * @exception returns empty String ""
	 * @return String RevName
	 * @throws nothing
	 */
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
	/**
	 * @exception returns empty String ""
	 * @return String RevNr
	 * @throws nothing
	 */
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
	/**
	 * 
	 * @param streckenliste to be filled with Deckblatt
	 * @return 0 nothing implemented 
	 * @exception streckenliste does not get filled with Deckblatt
	 */
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
	 * @return Element Jagt Jahr ListeA root.daten.listeA.<jJahr> from Contructor (root,jJahr)
	 */
	protected Element getAListeA()
	{
		try
		{
			@SuppressWarnings("unchecked")
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
	 * @return Element Liste B aktuelles Jagtjahr
	 */
	protected Element getBListeB()
	{
		try
		{
			@SuppressWarnings("unchecked")
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
	/**
	 * 
	 * @return Element Sollabschüsse root.sollabschuesse
	 */
	protected Element getSoll()
	{
		Element a=new Element("a","b");
		try
		{
			a=root.getChild("sollabschuesse");
			return a;
		}
		catch (Exception err)
		{
			if(debug)
			{
				System.out.println("Fehler beim holen des Sollabschüsse Element");
			}
		}
		return null;
	}
	/**
	 * 
	 * @param line String "dd.MM.yyyy"
	 * @return when able to parse true
	 */
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
	/**
	 * 
	 * @param line String "dd.MM.yyyy"
	 * @return GregorianCalendar 
	 * @exception returns null
	 */
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
			a=null;
		}
		return a;
	}
	/**
	 * try to parse a String to float with DecimalSererator ','
	 * @param line String  like "0,001"
	 * @return float Value of String  if Exception occurs returns 0F
	 * @throws nothing
	 */
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
	/**
	 * 
	 * @param Sting line AWildart 
	 * @return AWildart
	 * @exception return null
	 */
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
	/**
	 * 
	 * @param String line AEintragArt of type int
	 * @return AEintragArt
	 * @exception returns AEintragArt=null
	 */
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
	/**
	 * read String of Type AKlasse int  
	 * @param String line AKlasse int like "11" equals aBock 
	 * @return
	 */
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
	/**
	 * reads Sting into int 
	 * @param line
	 * @return
	 * @exception
	 */
	protected int parseAID(String line)
	{
		int i=-1;
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
	/**
	 * reads root.daten.listeA.jJahr<jJahr>.aZeile into a Vector<AZeile> that is returned
	 * to be inserted into Streckenliste
	 * @return Vector<AZeile> root.daten.listeA.jJahr<jJahr>.aZeile 
	 * @exception empty root.daten.listeA.jJahr<jJahr>.aZeile 
	 */
	protected Vector<AZeile> readAZeile()
	{
		Vector<AZeile> aZeileV=new Vector<AZeile>();
		@SuppressWarnings("unchecked")
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
	 * füllen der HashMaps mit den verfügbaren aKlassen 0-200
	 * @return int 0 nothing implemented yet
	 * @param (HashMap<AKlasse, Integer>,HashMap<AKlasse, Integer>,HashMap<AKlasse, Integer>) to be filled available AKlasse.getAKlasseByID(0-200)
	 * 
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
	/**
	 * used to count the fallen AKlasse types into a HashMap<AKlasse, Integer>
	 * the HashMap<AKlasse, Integer> is usually initialized by preFillSums(...) with <AKlasse,0>
	 * takes a Element parses the Child "aKlasse" to Class AKlasse 
	 * AKlasse Integer is then looked up in HashMap and it's value  is incremented by 1
	 * @param sum HashMap<AKlasse, Integer>
	 * @param e Element
	 */
	protected void addAKlasseHash(HashMap<AKlasse, Integer> sum,Element e)
	{
		sum.put(
				AKlasse.getAKlasseByID(
						Integer.parseInt(e.getChildText("aKlasse"))),
						sum.get(AKlasse.getAKlasseByID(
								Integer.parseInt(e.getChildText("aKlasse"))+1)));
	}
	/**iterates in root.daten.listeA.jJahr<jJahr>.aZeile* and * adds AKlasse to Hashmaps
	 * @param sumErl Hashmap zur Aufnahme des erlegten Wildes
	 * @param sumFall Hashmap zur Aufnahme des Fallwildes
	 * @param sumGes Hashmap zur Aufnahme der Summe des gemeldeten Wildes
	 * @return not implemented yet
	 */
	protected int calSums(HashMap<AKlasse, Integer> sumErl,HashMap<AKlasse, Integer> sumFall,HashMap<AKlasse, Integer> sumGes)
	{
		try
		{
			@SuppressWarnings("unchecked")
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
	/**
	 * <h1>calls functions to fill ListeA into Streckenliste</h1>
	 * @param Streckenliste str to be filled with ListeA   
	 * throws nothing ListeA is not inserted into Streckenliste
	 */
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
	/**
	 *@param line String to be parsed into BWildart
	 *  
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
	/**
	 * 
	 * @param line String to be parsed into int 
	 * @return int of String or 0 if not able to parse
	 */
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
	/**
	 * read String into String for safety purposes 
	 * @param line String
	 * @return String
	 */
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
	/**
	 * returns Vector<BZeile> from root.daten.listeB.jJahr<jJahr>
	 * <jJahr> is from Konstructor
	 * 
	 * @return Vector<BZeile>
	 */
	protected Vector<BZeile> readBZeile()
	{
		Vector<BZeile> bZeileV=new Vector<BZeile>();
		@SuppressWarnings("unchecked")
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
	/**
	 * calls getSoll() to get Element Sollabschuesse 
	 * @return not implemented yet
	 */
	@SuppressWarnings("unchecked")
	protected boolean readSollabsch(Vector<Sollabschuss> sa)
	{
		int jjahr=0;
		int pJahre=0;
		try
		{
		Element soll=getSoll();
		List<Element> jahr=soll.getChildren();
		for (Element t:jahr)
		{
			pJahre=readInt(t.getAttribute("jAbschPlan").getValue());
			jjahr=readInt(t.getAttributeValue("pJahre"));
			//AKlasse aKlasse, int soll, int pJahre, int jahr
			for (Element wa:(List<Element>)t.getChildren())
			{
				sa.add(new Sollabschuss(
						readAKlasse(wa.getAttributeValue("wildartID")),
						readInt(wa.getChildText("soll")),
						pJahre,
						jjahr
					));
		}}
		
		}
		catch (Exception err)
		{
			if (debug)
			{
				System.out.println("Fehler beim lesen der Sollabschüsse");
			}
		}
		return true;
	}
	/**
	 * calls readSollabsch(Vector) to get Vector Sollabschuss filled
	 * @param st fills Sollabschuesse into Streckenliste st
	 */
	protected void readSollAbsch(Streckenliste st)
	{
		Sollabschuesse soll=new Sollabschuesse();
		Vector<Sollabschuss> sa=new  Vector<Sollabschuss>();
		readSollabsch(sa);
		st.setSollabschuesse(soll);
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
	protected Element getRoot(String file)
{
	Document doc = new Document();
	Element root=null;
	try
	{
	//versuche XML-File zu öffnen	
		doc = (new SAXBuilder()).build(file);
		root=doc.getRootElement();
	}
	catch(Exception err)
	{
		if (debug)
		{
			System.out.println("Fehler beim öffnen der XML Datei: "+file);
		}
	}
	return root;
}
	protected boolean setaMeldSt()
	{
		Element lista=getAListeA(); 
		try
		{
			@SuppressWarnings("unchecked")
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
 	protected boolean setMeldeDatum()
 	{
 		try
 		{
 		Element a=getAListeA();
 		String date=(new GregorianCalendar().get(4)+"."+new GregorianCalendar().get(2)+"."+new GregorianCalendar().get(1));
 		a.getChild("abgDatum").setText(date);
 		}
 		catch (Exception err)
 		{
 			if(debug)
 			{
 				System.out.println("Fehler beim setzen des MeldeDatum");
 			}
 		}
 		return true;
 	}
	
 	@Override
 	public Streckenliste readStreckenliste() {
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
		
		return (new JDomParser(getRoot(revier+".xml"),jahr)).readStreckenliste();
	}

	/* (non-Javadoc)
	 * @see de.fhhof.streckenliste.reporting.DataFileIO#streckenlisteAbschliessen(int, java.lang.String)
	 */
	@Override
	public void streckenlisteAbschliessen(int jahr, String revier) {
		
		new JDomParser(getRoot(revier+".xml"),jahr).setaMeldSt();
		new JDomParser(getRoot(revier+".xml"),jahr).setMeldeDatum();
		

	}

	/* (non-Javadoc)
	 * @see de.fhhof.streckenliste.reporting.DataFileIO#streckenlisteZwischenmeldung(int, java.lang.String)
	 */
	@Override
	public void streckenlisteZwischenmeldung(int jahr, String revier) {
		new JDomParser(getRoot(revier+".xml"),jahr).setaMeldSt();
	}

}
