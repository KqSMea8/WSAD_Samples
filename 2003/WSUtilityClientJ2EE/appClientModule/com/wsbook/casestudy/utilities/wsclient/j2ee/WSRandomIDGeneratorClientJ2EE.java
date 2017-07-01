package com.wsbook.casestudy.utilities.wsclient.j2ee;

import com.wsbook.casestudy.ejb.utilities.*;
import javax.xml.namespace.QName;
import java.util.Hashtable;
import javax.naming.InitialContext;
import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.ServiceFactory;

/**
 * @author wsbook
 */
public class WSRandomIDGeneratorClientJ2EE {

	public static void main (String[] args) throws Exception {
		try{		

			InitialContext aContext = new InitialContext();
			
			Service aService = (Service)
				aContext.lookup("java:comp/env/service/WSRandomIDGeneratorService");
			
			WSRandomIDGenerator idGenService = (WSRandomIDGenerator)
			 	aService.getPort(WSRandomIDGenerator.class);



			int result = (int)idGenService.calculateID();	
			System.out.println(result);	
				
		} catch (Exception e) 
			{e.printStackTrace();}
	}
}