package com.wsbook.xmlxsl.sample;
import java.io.IOException;
import java.io.Writer;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;

import org.apache.xalan.serialize.SerializerToXML;
import org.w3c.dom.Document;

/**
 * @version 	1.0
 * @author
 */
public class TimeSheetXSLServlet extends HttpServlet {
	public static final String XSL_FILE = "/timesheet2.xsl";

	/**
	* @see javax.servlet.http.HttpServlet#void (javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	*/
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {

		// Look for certain parameters
		String showDetails = req.getParameter("showDetails");
		if (showDetails == null) {
			showDetails = "off";
		}
		String transform = req.getParameter("transform");
		if (transform == null) {
			transform = "off";
		}

		// Generate the XML document
		TimeSheetXMLRenderer renderer = new TimeSheetXMLRenderer();
		Document xmlDoc = renderer.generateXML(showDetails);

		// Do the transformation if transform is true. Otherwise, dump the XML
		if (transform.equalsIgnoreCase("on")) {
			render(req, resp, xmlDoc, new Properties());
		} else {
			dumpXML(xmlDoc, resp.getWriter());

		}
	}

	public void render(
		HttpServletRequest req,
		HttpServletResponse resp,
		Document xmlDoc,
		Properties xslParms) {
		try {

			// Create a Source object for the xml file
			Source src = new javax.xml.transform.dom.DOMSource(xmlDoc);

			// Create a transfomer
			TransformerFactory tFactory = TransformerFactory.newInstance();
			tFactory.setURIResolver(new ClassPathURIResolver());
			Transformer transformer =
				tFactory.newTransformer(tFactory.getURIResolver().resolve(XSL_FILE, null));
			javax.xml.transform.Result result =
				new javax.xml.transform.stream.StreamResult(resp.getWriter());

			// Set the parms into the transformer
			transformer.clearParameters();
			java.util.Enumeration parmNames = xslParms.keys();
			while (parmNames.hasMoreElements()) {
				String parmName = (String) parmNames.nextElement();
				String parmValue = (String) xslParms.get(parmName);
				transformer.setParameter(parmName, parmValue);
			}

			// Do the transformation
			transformer.transform(src, result);
		} catch (Exception e) {
			System.out.println(
				getClass().getName() + " Exception occured - " + e);
			e.printStackTrace();
		}

	}

	public void dumpXML(org.w3c.dom.Node xmlTree, Writer writer) {
		try {
			SerializerToXML s2x = new SerializerToXML();
			s2x.setWriter(writer);
			java.util.Properties props = new java.util.Properties();
			props.setProperty(javax.xml.transform.OutputKeys.INDENT, "yes");
			s2x.setOutputFormat(props);
			s2x.serialize(xmlTree);
		} catch (IOException ioExc) {
		}
	}

}
