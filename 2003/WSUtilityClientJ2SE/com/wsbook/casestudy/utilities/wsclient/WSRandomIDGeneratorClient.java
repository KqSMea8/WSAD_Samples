package com.wsbook.casestudy.utilities.wsclient;

import com.wsbook.casestudy.ejb.utilities.*;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.ServiceFactory;

/**
 * @author wsbook
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class WSRandomIDGeneratorClient {

	
	
	public static void main (String[] args) throws Exception {
		try{
	
		
			Service aService = ServiceFactory.newInstance().createService(
				new URL("http://localhost:9080/TSS/services/WSRandomIDGenerator?wsdl"),
				new QName("http://utilities.ejb.casestudy.wsbook.com","WSRandomIDGeneratorService") );
		
			WSRandomIDGenerator idGenService = (WSRandomIDGenerator)
			 	aService.getPort(
				new QName("http://utilities.ejb.casestudy.wsbook.com", "WSRandomIDGenerator"),
				WSRandomIDGenerator.class);

			
			int result = (int)idGenService.calculateID();	
			System.out.println(result);	
				
			
		} catch (Exception e) 
			{e.printStackTrace();}
		
	}

}
