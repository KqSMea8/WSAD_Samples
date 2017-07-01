package coreservlets;

import java.awt.Color;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/** Servlet that generates an array of strings and
 *  sends them via an ObjectOutputStream to applet
 *  or other Java client.
 *  <P>
 *  Taken from Core Servlets and JavaServer Pages
 *  from Prentice Hall and Sun Microsystems Press,
 *  http://www.coreservlets.com/.
 *  &copy; 2000 Marty Hall; may be freely used or adapted.
 */

public class AppletShowQueryGenerator extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		boolean useNumbering = true;
		String useNumberingFlag = request.getParameter("useNumbering");
		if ((useNumberingFlag == null) || useNumberingFlag.equals("false")) {
			useNumbering = false;
		}
		String contentType = "application/x-java-serialized-object";
		response.setContentType(contentType);
		ObjectOutputStream out =
			new ObjectOutputStream(response.getOutputStream());
		Object[][] queries = getQueries(useNumbering);
		// If you send a nonstandard data structure, be
		// sure it is defined with "implements Serializable".
		out.writeObject(queries);
		out.flush();
	}

	public void doPost(
		HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {
		doGet(request, response);
	}
	/**
		private String[] getQueries(boolean useNumbering) {
			String[] queries = new String[50];
			for (int i = 0; i < queries.length; i++) {
				queries[i] = randomQuery();
				if (useNumbering) {
					queries[i] = "" + (i + 1) + ": " + queries[i];
				}
			}
			return (queries);
		}
	
		// The real, honest-to-goodness queries people have sent :-)
	
		private String randomQuery() {
			String[] locations = { "Where ", "How " };
			String[] actions = { "can I look for ", "can I find ", "can I get " };
			String[] sources =
				{ "information ", "resources ", "data ", "references " };
			String[] prepositions = { "on ", "about ", "concerning " };
			String[] subjects =
				{
					"the book Core Servlets and JavaServer Pages",
					"the text Core Servlets and JavaServer Pages",
					"Core Servlets and JavaServer Pages",
					"Core Servlets and JSP",
					"the book Core Web Programming (Java 2 Edition)",
					"Core Web Programming (Java 2 Edition)",
					"servlet programming",
					"JavaServer Pages",
					"JSP",
					"Java alternatives to CGI",
					"server-side Java" };
			String[] endings = { "?", "?", "?", "?!", "?!!!?" };
			String[][] sentenceTemplates =
				{ locations, actions, sources, prepositions, subjects, endings };
			String query = "";
			for (int i = 0; i < sentenceTemplates.length; i++) {
				query = query + randomEntry(sentenceTemplates[i]);
			}
			return (query);
		}
	
		private String randomEntry(String[] strings) {
			int index = (int) (Math.random() * strings.length);
			return (strings[index]);
		}
	*/
	private Object[][] cells =
		{
			{
				"Mercury",
				new Double(2440),
				new Integer(0),
				Boolean.FALSE,
				Color.yellow },
			{
			"Venus",
				new Double(6052),
				new Integer(0),
				Boolean.FALSE,
				Color.yellow },
				{
			"Earth",
				new Double(6378),
				new Integer(1),
				Boolean.FALSE,
				Color.blue },
				{
			"Mars",
				new Double(3397),
				new Integer(2),
				Boolean.FALSE,
				Color.red },
				{
			"Jupiter",
				new Double(71492),
				new Integer(16),
				Boolean.TRUE,
				Color.orange },
				{
			"Saturn",
				new Double(60268),
				new Integer(18),
				Boolean.TRUE,
				Color.orange },
				{
			"Uranus",
				new Double(25559),
				new Integer(17),
				Boolean.TRUE,
				Color.blue },
				{
			"Neptune",
				new Double(24766),
				new Integer(8),
				Boolean.TRUE,
				Color.blue },
				{
			"Pluto",
				new Double(1137),
				new Integer(1),
				Boolean.FALSE,
				Color.black },
				{
			"Mercury",
				new Double(2440),
				new Integer(0),
				Boolean.FALSE,
				Color.yellow },
				{
			"Venus",
				new Double(6052),
				new Integer(0),
				Boolean.FALSE,
				Color.yellow },
				{
			"Earth",
				new Double(6378),
				new Integer(1),
				Boolean.FALSE,
				Color.blue },
				{
			"Mars",
				new Double(3397),
				new Integer(2),
				Boolean.FALSE,
				Color.red },
				{
			"Jupiter",
				new Double(71492),
				new Integer(16),
				Boolean.TRUE,
				Color.orange },
				{
			"Saturn",
				new Double(60268),
				new Integer(18),
				Boolean.TRUE,
				Color.orange },
				{
			"Uranus",
				new Double(25559),
				new Integer(17),
				Boolean.TRUE,
				Color.blue },
				{
			"Neptune",
				new Double(24766),
				new Integer(8),
				Boolean.TRUE,
				Color.blue },
				{
			"Pluto",
				new Double(1137),
				new Integer(1),
				Boolean.FALSE,
				Color.black },
				{
			"Mercury",
				new Double(2440),
				new Integer(0),
				Boolean.FALSE,
				Color.yellow },
				{
			"Venus",
				new Double(6052),
				new Integer(0),
				Boolean.FALSE,
				Color.yellow },
				{
			"Earth",
				new Double(6378),
				new Integer(1),
				Boolean.FALSE,
				Color.blue },
				{
			"Mars",
				new Double(3397),
				new Integer(2),
				Boolean.FALSE,
				Color.red },
				{
			"Jupiter",
				new Double(71492),
				new Integer(16),
				Boolean.TRUE,
				Color.orange },
				{
			"Saturn",
				new Double(60268),
				new Integer(18),
				Boolean.TRUE,
				Color.orange },
				{
			"Uranus",
				new Double(25559),
				new Integer(17),
				Boolean.TRUE,
				Color.blue },
				{
			"Neptune",
				new Double(24766),
				new Integer(8),
				Boolean.TRUE,
				Color.blue },
				{
			"Pluto",
				new Double(1137),
				new Integer(1),
				Boolean.FALSE,
				Color.black },
				{
			"Mercury",
				new Double(2440),
				new Integer(0),
				Boolean.FALSE,
				Color.yellow },
				{
			"Venus",
				new Double(6052),
				new Integer(0),
				Boolean.FALSE,
				Color.yellow },
				{
			"Earth",
				new Double(6378),
				new Integer(1),
				Boolean.FALSE,
				Color.blue },
				{
			"Mars",
				new Double(3397),
				new Integer(2),
				Boolean.FALSE,
				Color.red },
				{
			"Jupiter",
				new Double(71492),
				new Integer(16),
				Boolean.TRUE,
				Color.orange },
				{
			"Saturn",
				new Double(60268),
				new Integer(18),
				Boolean.TRUE,
				Color.orange },
				{
			"Uranus",
				new Double(25559),
				new Integer(17),
				Boolean.TRUE,
				Color.blue },
				{
			"Neptune",
				new Double(24766),
				new Integer(8),
				Boolean.TRUE,
				Color.blue },
				{
			"Pluto",
				new Double(1137),
				new Integer(1),
				Boolean.FALSE,
				Color.black }

	};
	private Object[][] getQueries(boolean useNumbering) {
		Object[][] retObjects = new Object[10000][10];
		for (int i = 0; i < retObjects.length; i++) {
			retObjects[i] =
				new Object[] {
					"String" + i,
					new Double(i + 1100),
					new Integer(i),
					(i % 2 == 1) ? Boolean.FALSE : Boolean.TRUE,
					Color.green,
					"String" + i,
					new Double(i + 1100),
					new Integer(i),
					(i % 2 == 1) ? Boolean.FALSE : Boolean.TRUE,
					Color.black };
		}

		//return cells;
		return retObjects;
	}
}
