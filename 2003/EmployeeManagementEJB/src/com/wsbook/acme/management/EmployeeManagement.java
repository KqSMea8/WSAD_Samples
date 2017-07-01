package com.wsbook.acme.management;

import java.rmi.RemoteException;
import java.util.Collection;
import java.util.Map;

import com.wsbook.acme.Employee;
import javax.servlet.http.HttpServletRequest;
/**
 * Remote interface for Enterprise Bean: EmployeeManagement
 */
public interface EmployeeManagement extends javax.ejb.EJBObject {
	public Collection findAll() throws java.rmi.RemoteException;
	public Employee getEmployee(String id) throws java.rmi.RemoteException;
	public void update(Map args) throws java.rmi.RemoteException;
	public void createNewEmployee(Map args) throws java.rmi.RemoteException;
	public void deleteAnEmployee(String id) throws java.rmi.RemoteException;
}
