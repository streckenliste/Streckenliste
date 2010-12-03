/**
 * 
 */
package de.fhhof.streckenliste.reporting;

import org.jdom.Element;

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
	private Element root;
	private int jJahr;
	public JDomParser(Element root,int jJahr)
	{
		this.jJahr=jJahr;
		this.root=root;
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
		return 0;
	}
	protected ListeA readListeA(Streckenliste str)
	{
		ListeA lista=null;
		return lista;
	}
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
