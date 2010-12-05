package de.fhhof.streckenliste.reporting;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import de.fhhof.streckenliste.reporting.daten.Streckenliste;

public class DataJDomParser implements DataFileIO {

	boolean debug=true;
	@Override
	public Streckenliste readStreckenliste() {
		int jJahr=2010;
		String xmlFile="StreckenlistePC_V5.1.xml";
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
		// TODO Auto-generated method stub
		return st;
	}

	@Override
	public Streckenliste readStreckenliste(int jahr, String revier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void streckenlisteAbschliessen(int jahr, String revier) {
		// TODO Auto-generated method stub

	}

	@Override
	public void streckenlisteZwischenmeldung(int jahr, String revier) {
		// TODO Auto-generated method stub

	}

}
