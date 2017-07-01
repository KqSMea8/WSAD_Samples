package com.wsbook.casestudy.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * The CreateEmployeeServlet is a simple example Servlet.
 * It is NOT hooked into the rest of our case study.
 *
 * If the URL for this
 * servlet is called with a GET request (ie. from
 * the browser URL line), then a sample form will
 * be displayed.  When the Submit button on that
 * form is pressed, the doPost() method will be
 * called to process the form.
 * 
 */

public class CreateEmployeeServlet extends javax.servlet.http.HttpServlet {
/**
 * The doGet method is called when:
 *		1- an HTML form accesses this servlet using the GET method 
 *		2- The URL for this servlet is typed on the URL line of a browser
 * 		3- The URL for this servlet is placed in an <A HREF> tag and
 *			is then clicked on
 * This method will paint back an HTML form which has an action
 * set to call this same servlet using the POST method.
 */
public void doGet(HttpServletRequest req, 
							HttpServletResponse res) 
		throws IOException{
	res.setContentType("text/html");
	PrintWriter out = res.getWriter();

	// Write Header info
	out.println(
		"<HTML><HEAD>\n" +
		"<TITLE>Create an Employee</TITLE>\n" +
		"</HEAD>\n" +
		"<BODY>\n" +
		"<TABLE width=\"100%\" border=\"0\" bgcolor=\"#FFFFFF\" " +
		" cellspacing=\"0\" cellpadding=\"3\">\n" +
 		"<TR>\n" +
		"<TD colspan=\"3\" bgcolor=\"#009900\"><B>Create an Employee</B></TD>\n" +
		"<TD bgcolor=\"#009900\">Todays date is " + new java.util.Date() + "</TD> \n" +
		"</TR>\n" +
		"</TABLE>\n" 
	);

	// Write Form with embedded table for layout
	out.println(		
		"<FORM NAME=\"" + req.getRequestURI() + "\"" +
		" ACTION= \"" + req.getRequestURI() + "\" " + 
		" METHOD=\"POST\">\n" +
		"<BR>\n" + 

		// Start Table for layout
		"<TABLE BORDER=1>\n" +

		// First Name Text Field
		"<TR><TD>\n" +
		"<B>First Name</B>\n" +
		"</TD><TD>\n" +
		"<INPUT TYPE=\"text\" SIZE=20 MAXLENGTH=30" + 
 		" NAME=\"firstName\" VALUE=\"enterFirstName\">" + 
		"</TD></TR>\n" + 
 
		// Middle Name Text Field
		"<TR><TD>\n" +
		"<B>Middle Name</B>\n" +
		"</TD><TD>\n" +
		"<INPUT TYPE=\"text\" SIZE=20 MAXLENGTH=30" + 
 		" NAME=\"MiddleName\" VALUE=\"enterMiddleName\">" + 
		"</TD></TR>\n" + 

		// Last Name Text Field
		"<TR><TD>\n" +
		"<B>Last Name</B>\n" +
		"</TD><TD>\n" +
		"<INPUT TYPE=\"text\" SIZE=20 MAXLENGTH=30" + 
 		" NAME=\"LastName\" VALUE=\"enterLastName\">" + 
		"</TD></TR>\n" + 

		// Social Security Number Text Field
		"<TR><TD>\n" +
		"<B>SSN</B>\n" +
		"</TD><TD>\n" +
		"<INPUT TYPE=\"text\" SIZE=20 MAXLENGTH=30" + 
 		" NAME=\"ssn\" VALUE=\"enterSSN\">" + 
		"</TD></TR>\n" + 
		
		// Tax Information Check boxes
		"<TR><TD>\n" +
		"<B>Tax Information</B> \n" +
		"</TD><TD>\n" +
		"<INPUT type=\"checkbox\" name=\"taxinfo1\"" +
		" value=\"US Citizen\" CHECKED> US Citizen\n" +
		"<BR>\n" +
		"<INPUT type=\"checkbox\" name=\"taxinfo2\"" +
		" value=\"Salaried\"> Salaried\n" +
		"<BR>\n" +
		"<INPUT type=\"checkbox\" name=\"taxinfo3\"" +
		" value=\"Married\"> Married\n" +
		"<BR>\n" +
		"<INPUT type=\"checkbox\" name=\"taxinfo4\"" +
		" value=\"Children\"> Children\n" +
		"</TD></TR>\n" +  
		
		// Sex radio buttons
		"<TR><TD>\n" +
 		"<B>Sex</B> \n" +
		"</TD><TD>\n" +
		"<INPUT type=\"radio\" name=\"sex\" " +
		" VALUE=\"Female\"> Female\n" +
		"<BR>\n" +
		"<INPUT type=\"radio\" name=\"sex\" " +
		" VALUE=\"Male\"> Male\n" +
		"<BR>\n" +
		"<INPUT type=\"radio\" name=\"sex\" " +
		" VALUE=\"Unspecified\" CHECKED> Unspecified\n" +
		"</TD></TR>\n" +  
		
		// Age Selection				
		"<TR><TD>\n" +
 		"<B>Age</B> \n" +
		"</TD><TD>\n" +
		"<SELECT id=\"AgeSelectBox\" name=\"age\">\n" +
			"\t<OPTION value=\"Under 18\" SELECTED>Under 18</OPTION> \n" +
			"\t<OPTION value=\"18-21\">18-21</OPTION> \n" + 
			"\t<OPTION value=\"22-35\">22-35</OPTION> \n" +
			"\t<OPTION value=\"36-45\">36-45</OPTION> \n" +
			"\t<OPTION value=\"Over 55\">Over 55</OPTION> \n" +
		"</SELECT> \n" +
		"</TD></TR>\n" +  
		
		// Comments Text Area Box		
 		"<TR><TD>\n" +
 		"<B>Comments</B> \n" +
		"</TD><TD>\n" +
		"<TEXTAREA NAME =\"comments\" cols=\"20\"" + 
		" rows=\"2\">Enter any comments </TEXTAREA>" +		
		"</TD></TR>\n" + 

		// Blank Line
		"<TR><TD>\n" +
		"<!-- Blank line --->\n" +
		"</TD></TR>\n" + 

		// Submit and Reset Buttons
		"<TR><TD>\n" +
		"<INPUT TYPE=\"submit\"" + 
 		"NAME=\"action\" VALUE=\"Submit1\">" + 
		"<INPUT TYPE=\"submit\"" + 
 		"NAME=\"action\" VALUE=\"Submit2\">" + 
 		"</TD><TD>\n" +
		"<INPUT TYPE=\"reset\"" + 
 		"NAME=\"reset\" VALUE=\"Reset\">" + 
		"</TD></TR>\n"
	);


	// Write the ending tags.
	out.println(	
		"</TABLE>\n" +	
 		"</FORM>\n" +
 		"</BODY>\n" +
 		"</HTML>\n" 
	);
	
	
	return;
}
/*
 * The doPost method is called when an HTML Form which has been
 * coded to use a method=POST is used. This method will process
 * the form data and then echo the data in the response.
 */
public void doPost(HttpServletRequest req, 
						HttpServletResponse res) 
		throws IOException{
	res.setContentType("text/html");			
	PrintWriter out = res.getWriter();

	// Write the Header information and create a table of parms
	out.println(
		"<HEAD>\n" +
		"<TITLE>Sample Input Form</TITLE>\n" +
		"<BODY>\n" +
		"<TABLE width=\"100%\" border=\"0\" bgcolor=\"#FFFFFF\" cellspacing=\"0\" cellpadding=\"3\">\n" +
 		"<TR>\n" +
		"<TD colspan=\"3\" bgcolor=\"#009900\"><B>Create an Employee</B></TD>\n" +
		"<TD bgcolor=\"#009900\">Todays date is " + new java.util.Date() + "</TD> \n" +
		"</TR>\n" +
 		"<TR>\n" +
 		"<TD>\n" +	
		"<FONT COLOR=\"blue\" SIZE=\"+2\">\n" +
		"<H1>You entered the following values on the form:</H1>\n" +
		"</FONT>\n" +
		"</TD>\n " +
		"</TR>\n" +
		"</TABLE>\n" +		

		"<FORM NAME=\"" + req.getRequestURI() + "\"" +
		" ACTION= \"" + req.getRequestURI() + "\" " + 
		" METHOD=\"POST\">\n" +
		
		"<TABLE Border=1>\n" +
		"<TR><TH>\n" +
		"Parameter Name \n" + 
		"</TH><TH>\n" + 
		"Paramter Value \n" +
		"</TH></TR>\n"
	);
	
	// Process each form parameter found in the Request
	java.util.Enumeration enumeration = req.getParameterNames();
	for (int i = 0; enumeration.hasMoreElements(); i++) {
		// Use te form Parm name to obtain the parm values
		String formVarName = (String) enumeration.nextElement();
		String[] formVarValues = req.getParameterValues(formVarName);

		// For each form parm name, there could potentially be
		// multiple parm values.
		for (int j=0; j < formVarValues.length; j++) {
			String formVarValue = formVarValues[j];
			out.println(
				"<TR><TD>\n" +
				formVarName + 
				"</TD><TD>\n" + 
				formVarValue +
				"</TD></TR>\n"
				);
		}
	}
	
	// Finish the table and write an ending message
	String color = null;
	if (req.getParameter("action").equals("Submit1")) {
		color = "blue";
	} else {
		color = "red";
	}
	out.println(
		// Submit and Reset Buttons
		"<TR><TD>\n" +
		"<INPUT TYPE=\"submit\"" + 
 		"NAME=\"action\" VALUE=\"Confirm\">" + 
		"</TD><TD>\n" +
		"<INPUT TYPE=\"submit\"" + 
 		"NAME=\"action\" VALUE=\"Return\">" + 
		"</TD></TR>\n" +
		
		"</TABLE>\n" +
		"</FORM>\n" + 
		"<BR>\n" +
		"<FONT COLOR=\"" + color + "\" SIZE=\"+2\">" +
		" Parameter List Complete </FONT>\n" +
		"<BR>\n" +
		"</BODY> \n" +
		"</HTML>"
		);
	
	return;
}
}
