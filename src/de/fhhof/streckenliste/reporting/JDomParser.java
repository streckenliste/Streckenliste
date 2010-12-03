/**
 * 
 */
package de.fhhof.streckenliste.reporting;

import org.jdom.Element;

import de.fhhof.streckenliste.reporting.daten.Streckenliste;

/**
 * @author ronny
 *
 */
public class JDomParser implements DataFileIO {

	private Element root;
	private int jJahr;
	public JDomParser(Element root,int jJahr)
	{
		this.jJahr=jJahr;
		this.root=root;
	}
	/* (non-Javadoc)
	 * @see de.fhhof.streckenliste.reporting.DataFileIO#readStreckenliste()
	 */
	@Override
	public Streckenliste readStreckenliste() {
		// TODO Auto-generated method stub
		return null;
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
