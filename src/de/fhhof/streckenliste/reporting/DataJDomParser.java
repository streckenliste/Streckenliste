package de.fhhof.streckenliste.reporting;

import java.io.FileWriter;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import de.fhhof.streckenliste.reporting.daten.Streckenliste;
/**
 *  
 * @author ronny
 *	Class to call the jDomParser with an xml File "xmlfile" and a "int jJahr" until the other groups have finished their work 
 *@deprecated
 */
public class DataJDomParser implements DataIO {

	private boolean debug=true;
	/**
	 * öffnet eine Streckenliste (String xmlFile) 
	 * ruft dann eine neue Instanz von JDomParser(Element root,int jJahr).readStreckenliste() auf um eine gefüllte Streckenliste Klasse zu bekommen
	 *  @return Streckenliste gefüllte aus Konstruktor(Element root,int jJahr)
	 */
	int jJahr=2010;
	String xmlFile="etc/StreckenlistePC_V5.1.xml";
	@Override
	public Streckenliste readStreckenliste() {
		
		Document doc = new Document();
		Element root=null;
		try
		{
		//versuche XML-File zu öffnen	
			doc = (new SAXBuilder()).build(xmlFile);
			root=doc.getRootElement();
		}
		catch(Exception err)
		{
			if (debug)
			{
				System.out.println("Fehler beim öffnen der XML Datei");
			}
		}
		Streckenliste st=new JDomParser(root,jJahr).readStreckenliste();
		return st;
	}

	@Override
	public Streckenliste readStreckenliste(int jahr, String revier) {
		this.jJahr=jahr;
		this.xmlFile=revier+".xml";
		Document doc = new Document();
		Element root=null;
		try
		{
		//versuche XML-File zu öffnen	
			doc = (new SAXBuilder()).build(xmlFile);
			root=doc.getRootElement();
		}
		catch(Exception err)
		{
			if (debug)
			{
				System.out.println("Fehler beim öffnen der XML Datei: "+revier);
			}
		}
		Streckenliste st=new JDomParser(root,jJahr).readStreckenliste();

		return st;
	}

	

	@Override
	public void streckenlisteAbschliessen(int jahr, String revier) {
		if(debug)
		{
			System.out.println("versuche "+revier+".xml zu öffnen jJahr ist "+jahr);
		}
		int jJahr=2010;
		xmlFile=revier+".xml";
		Document doc = new Document();
		new XMLOutputter().getFormat();
		Format form=Format.getPrettyFormat();
		XMLOutputter out=new XMLOutputter();
		Element root=null;
		try
		{
		//versuche XML-File zu öffnen	
			doc = (new SAXBuilder()).build(xmlFile);
			root=doc.getRootElement();
		}
		catch(Exception err)
		{
			if (debug)
			{
				System.out.println("Fehler beim öffnen der XML Datei: "+revier);
			}
		}
		new JDomParser(root,jJahr).setaMeldSt();
		new JDomParser(root,jJahr).setMeldeDatum();
		
		out.setFormat(form);
		try 
		{
			out.output(root,new FileWriter( xmlFile+"new.xml"));
		} 
		catch (Exception err)
		{
			if(debug)
			{
				System.out.println("Fehler beim schreiben von "+xmlFile+"new.xml");
			}
		}
	}

	@Override
	public void streckenlisteZwischenmeldung(int jahr, String revier) {
		//FIXME just wanted to try this
		xmlFile=revier+".xml";
		Document doc = new Document();
		new XMLOutputter().getFormat();
		Format form=Format.getPrettyFormat();
		XMLOutputter out=new XMLOutputter();
		Element root=null;
		try
		{
		//versuche XML-File zu öffnen	
			doc = (new SAXBuilder()).build(xmlFile);
			root=doc.getRootElement();
		}
		catch(Exception err)
		{
			if (debug)
			{
				System.out.println("Fehler beim öffnen der XML Datei: "+revier);
			}
		}
		new JDomParser(root,jJahr).setaMeldSt();
		out.setFormat(form);
		try 
		{
			out.output(root,new FileWriter( xmlFile+".new.xml"));
		} 
		catch (Exception err)
		{
			if(debug)
			{
				System.out.println("Fehler beim schreiben von "+xmlFile+".new.xml");
			}
		}
	}

}
