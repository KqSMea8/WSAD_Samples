package com.wsbook.acme.management;

import java.rmi.RemoteException;
import java.util.Collection;

import com.wsbook.acme.Employee;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
/**
 * Local interface for Enterprise Bean: EmployeeManagement
 */
public interface EmployeeManagementLocal extends javax.ejb.EJBLocalObject {
	public Collection findAll();
	public Employee getEmployee(String id);
	public void update(Map args);
	public void createNewEmployee(Map args);
	public void deleteAnEmployee(String id);
}
