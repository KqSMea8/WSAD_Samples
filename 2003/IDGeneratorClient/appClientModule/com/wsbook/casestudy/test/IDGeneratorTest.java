package com.wsbook.casestudy.test;

import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

import com.wsbook.casestudy.ejb.utilities.RandomIDGenerator;
import com.wsbook.casestudy.ejb.utilities.RandomIDGeneratorHome;


public class IDGeneratorTest {

	/**
	 * Constructor for IDGeneratorTest.
	 */
	public IDGeneratorTest() {
		super();
	}

	public static void main(String[] args) {
		try {
			InitialContext ctx = new InitialContext();
			//Lookup the home using ejb reference name.
			RandomIDGeneratorHome home;
			home = (RandomIDGeneratorHome) PortableRemoteObject.narrow(
					ctx.lookup("java:comp/env/ejb/IDGenerator"),
					RandomIDGeneratorHome.class);
			//Create a RandomIDGenerator.
			RandomIDGenerator generator = home.create();
			//Print out 10 random IDs.
			for (int i = 0; i < 10; i++)
				System.out.println(generator.calculateID());
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (CreateException e) {
			e.printStackTrace();
		}
	}
}
