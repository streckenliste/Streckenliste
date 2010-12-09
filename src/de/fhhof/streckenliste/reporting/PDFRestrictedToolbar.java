package de.fhhof.streckenliste.reporting;

import java.lang.reflect.Constructor;
import java.util.Locale;
import java.util.ResourceBundle;

import net.sf.jasperreports.engine.util.JRClassLoader;
import net.sf.jasperreports.swing.JRViewerController;
import net.sf.jasperreports.swing.JRViewerToolbar;
import net.sf.jasperreports.view.JRSaveContributor;

public class PDFRestrictedToolbar extends JRViewerToolbar {

	private static final long serialVersionUID = 1L;

	public PDFRestrictedToolbar(JRViewerController viewerContext) {
		super(viewerContext);

		JRSaveContributor[] save = getSaveContributors();
		for (int i=0; i<save.length; i++) 
		{
			removeSaveContributor(save[i]);
		}

		// Allow these SaveContributor
		final String[] DEFAULT_CONTRIBUTORS = {
				"net.sf.jasperreports.view.save.JRPdfSaveContributor"
				/*"net.sf.jasperreports.view.save.JROdtSaveContributor",
				"net.sf.jasperreports.view.save.JRRtfSaveContributor",
				"net.sf.jasperreports.view.save.JRHtmlSaveContributor",
				"net.sf.jasperreports.view.save.JRSingleSheetXlsSaveContributor",
				"net.sf.jasperreports.view.save.JRMultipleSheetsXlsSaveContributor",
				"net.sf.jasperreports.view.save.JRCsvSaveContributor",
				"net.sf.jasperreports.view.save.JRXmlSaveContributor",
				"net.sf.jasperreports.view.save.JREmbeddedImagesXmlSaveContributor" */
		};

		for(int i = 0; i < DEFAULT_CONTRIBUTORS.length; i++) 
		{
			try 
			{
				@SuppressWarnings("rawtypes")
				Class saveContribClass = JRClassLoader.loadClassForName(DEFAULT_CONTRIBUTORS[i]);
				ResourceBundle jrViewerResBundel = ResourceBundle.getBundle("net/sf/jasperreports/view/viewer", getLocale() );
				@SuppressWarnings({ "rawtypes", "unchecked" })
				Constructor constructor = saveContribClass.getConstructor(new Class[]{Locale.class, ResourceBundle.class});
				JRSaveContributor saveContrib = (JRSaveContributor)constructor.newInstance(new Object[]{getLocale(), jrViewerResBundel });
				addSaveContributor(saveContrib);
			}
			catch (Exception e) {}
		}
	}


}
