package com.wsbook.xmlxsl.sample;

import java.util.Properties;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * @author ghester
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class TimeSheetXMLRenderer {
	
	public Document generateXML(String showDetails) {
		
		Document doc = null;
		try {
			doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
			
		} catch (Exception e) {
		}

		//	<TimeSheet weekEnding="4/25/2003">
		Element timeSheetElem = doc.createElement("TimeSheet");
		doc.appendChild(timeSheetElem);
		timeSheetElem.setAttribute("weekEnding", "04/25/2003");

		//		<Employee id="257899" name="Leonard, Elouise" deptName="Programming"/>
		Element employeeElem = doc.createElement("Employee");
		timeSheetElem.appendChild(employeeElem);
		employeeElem.setAttribute("id", "257899");
		employeeElem.setAttribute("name", "Leonard, Elouise");
		employeeElem.setAttribute("deptName", "Programming");
		
		if (showDetails.equalsIgnoreCase("on")) {
			// <Entries>
			Element entriesElem = doc.createElement("Entries");
			timeSheetElem.appendChild(entriesElem);

			// Entry 1
			// 		<Entry>
			Element entryElem = doc.createElement("Entry");
			entriesElem.appendChild(entryElem);

			//			<Date>4/21/2003</Date>
			Element dateElem = doc.createElement("Date");
			Node textNode = doc.createTextNode("4/21/2003");
			dateElem.appendChild(textNode);
			entryElem.appendChild(dateElem);
			
			//			<Hours>8.5</Hours>
			Element hoursElem = doc.createElement("Hours");
			textNode = doc.createTextNode("8.5");
			hoursElem.appendChild(textNode);			
			entryElem.appendChild(hoursElem);
			hoursElem.setNodeValue("8.5");
			
			//			<Project id="4567" name="ACME AP"/>
			Element projectElem = doc.createElement("Project");
			entryElem.appendChild(projectElem);
			projectElem.setAttribute("id", "4567");
			projectElem.setAttribute("name", "ACME AP");

			// Entry 2
			// 		<Entry>
			entryElem = doc.createElement("Entry");
			entriesElem.appendChild(entryElem);

			//			<Date>4/22/2003</Date>
			dateElem = doc.createElement("Date");
			textNode = doc.createTextNode("4/22/2003");
			dateElem.appendChild(textNode);
			entryElem.appendChild(dateElem);
			dateElem.setNodeValue("4/22/2003");		
			
			//			<Hours>5</Hours>
			hoursElem = doc.createElement("Hours");
			textNode = doc.createTextNode("5");
			hoursElem.appendChild(textNode);
			entryElem.appendChild(hoursElem);
			hoursElem.setNodeValue("5");
			
			//			<Project id="4567" name="ACME AP"/>
			projectElem = doc.createElement("Project");
			entryElem.appendChild(projectElem);
			projectElem.setAttribute("id", "4567");
			projectElem.setAttribute("name", "ACME AP");

			// Entry 3
			// 		<Entry>
			entryElem = doc.createElement("Entry");
			entriesElem.appendChild(entryElem);

			//			<Date>4/22/2003</Date>
			dateElem = doc.createElement("Date");
			textNode = doc.createTextNode("4/22/2003");
			dateElem.appendChild(textNode);
			entryElem.appendChild(dateElem);
			dateElem.setNodeValue("4/22/2003");		
			
			//			<Hours>5</Hours>
			hoursElem = doc.createElement("Hours");
			textNode = doc.createTextNode("5");
			hoursElem.appendChild(textNode);			
			entryElem.appendChild(hoursElem);
			hoursElem.setNodeValue("5");
			
			//			<Project id="2345" name="ACME HR"/>
			projectElem = doc.createElement("Project");
			entryElem.appendChild(projectElem);
			projectElem.setAttribute("id", "2345");
			projectElem.setAttribute("name", "ACME HR");

			// Entry 4
			// 		<Entry>
			entryElem = doc.createElement("Entry");
			entriesElem.appendChild(entryElem);

			//			<Date>4/23/2003</Date>
			dateElem = doc.createElement("Date");
			textNode = doc.createTextNode("4/23/2003");
			dateElem.appendChild(textNode);
			entryElem.appendChild(dateElem);
			dateElem.setNodeValue("4/23/2003");		
			
			//			<Hours>8</Hours>
			hoursElem = doc.createElement("Hours");
			textNode = doc.createTextNode("8");
			hoursElem.appendChild(textNode);			
			entryElem.appendChild(hoursElem);
			hoursElem.setNodeValue("8");
			
			//			<Project id="4567" name="ACME AP"/>
			projectElem = doc.createElement("Project");
			entryElem.appendChild(projectElem);
			projectElem.setAttribute("id", "4567");
			projectElem.setAttribute("name", "ACME AP");

			// Entry 5
			// 		<Entry>
			entryElem = doc.createElement("Entry");
			entriesElem.appendChild(entryElem);

			//			<Date>4/24/2003</Date>
			dateElem = doc.createElement("Date");
			textNode = doc.createTextNode("4/24/2003");
			dateElem.appendChild(textNode);
			entryElem.appendChild(dateElem);
			dateElem.setNodeValue("4/24/2003");		
			
			//			<Hours>8</Hours>
			hoursElem = doc.createElement("Hours");
			textNode = doc.createTextNode("8");
			hoursElem.appendChild(textNode);
			entryElem.appendChild(hoursElem);
			hoursElem.setNodeValue("8");
			
			//			<Project id="4567" name="ACME AP"/>
			projectElem = doc.createElement("Project");
			entryElem.appendChild(projectElem);
			projectElem.setAttribute("id", "4567");
			projectElem.setAttribute("name", "ACME AP");

			// Entry 6
			// 		<Entry>
			entryElem = doc.createElement("Entry");
			entriesElem.appendChild(entryElem);

			//			<Date>4/24/2003</Date>
			dateElem = doc.createElement("Date");
			textNode = doc.createTextNode("4/24/2003");
			dateElem.appendChild(textNode);
			entryElem.appendChild(dateElem);
			dateElem.setNodeValue("4/24/2003");		
			
			//			<Hours>3</Hours>
			hoursElem = doc.createElement("Hours");
			textNode = doc.createTextNode("3");
			hoursElem.appendChild(textNode);			
			entryElem.appendChild(hoursElem);
			hoursElem.setNodeValue("3");
			
			//			<Project id="2345" name="ACME HR"/>
			projectElem = doc.createElement("Project");
			entryElem.appendChild(projectElem);
			projectElem.setAttribute("id", "2345");
			projectElem.setAttribute("name", "ACME HR");

			// Entry 7
			// 		<Entry>
			entryElem = doc.createElement("Entry");
			entriesElem.appendChild(entryElem);

			//			<Date>4/25/2003</Date>
			dateElem = doc.createElement("Date");
			textNode = doc.createTextNode("4/25/2003");
			dateElem.appendChild(textNode);
			entryElem.appendChild(dateElem);
			dateElem.setNodeValue("4/25/2003");		
			
			//			<Hours>8</Hours>
			hoursElem = doc.createElement("Hours");
			textNode = doc.createTextNode("8");
			hoursElem.appendChild(textNode);			
			entryElem.appendChild(hoursElem);
			hoursElem.setNodeValue("8");
			
			//			<Project id="4567" name="ACME AP"/>
			projectElem = doc.createElement("Project");
			entryElem.appendChild(projectElem);
			projectElem.setAttribute("id", "4567");
			projectElem.setAttribute("name", "ACME AP");

		}
		
		//		<Summary totalHours="45.5" overTimeHours="5.5">
		Element summaryElem = doc.createElement("Summary");
		timeSheetElem.appendChild(summaryElem);
		summaryElem.setAttribute("totalHours", "45.5");
		summaryElem.setAttribute("overTimeHours", "5.5");
		
		// 			<ProjectTotals>
		Element projectTotalsElem = doc.createElement("ProjectTotals");
		summaryElem.appendChild(projectTotalsElem);
			
		// 				<Project id="4567" name="ACME AP" totalHours="37.5"/>
		Element project1Elem = doc.createElement("Project");
		projectTotalsElem.appendChild(project1Elem);
		project1Elem.setAttribute("id", "4567");
		project1Elem.setAttribute("name", "ACME AP");
		project1Elem.setAttribute("totalHours", "37.5");

		// 				<Project id="2345" name="ACME HR" totalHours="8"/>
		Element project2Elem = doc.createElement("Project");
		projectTotalsElem.appendChild(project2Elem);
		project2Elem.setAttribute("id", "2345");
		project2Elem.setAttribute("name", "ACME HR");
		project2Elem.setAttribute("totalHours", "8");
		
		return doc;
	}

}
