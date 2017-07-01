package com.wsbook.acme.mappers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.wsbook.acme.Purchasing;
import com.wsbook.mapping.DomainObject;
import com.wsbook.mapping.MappingException;

/**
 * @author jamsden
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class PurchasingMapper extends DepartmentMapper {

	protected static final String _findAllString =
		"SELECT ID, NAME, DESCRIPTION, CODE, EXTERNALBUDGET, TYPE  FROM "+authId+".DEPARTMENT "+
		"WHERE CODE="+PURCHASING;

	protected void doActivate(DomainObject domainObject, ResultSet rs) 
		throws SQLException, MappingException {
		Purchasing dept = (Purchasing)domainObject;
		dept.setExternalBudget(rs.getFloat(5));
	}

	protected String getFindAllString() {
		return _findAllString;
	}
	
	/**
	 * @see com.wsbook.acme.mappers.DepartmentMapper#passivate(DomainObject, PreparedStatement)
	 */
	protected void passivate(DomainObject domainObject, PreparedStatement ps)
		throws SQLException, MappingException {
		super.passivate(domainObject, ps);
		Purchasing dept = (Purchasing)domainObject;
		ps.setFloat(5, dept.getExternalBudget());
		ps.setInt(6, DepartmentMapper.PURCHASING);
	}

}
