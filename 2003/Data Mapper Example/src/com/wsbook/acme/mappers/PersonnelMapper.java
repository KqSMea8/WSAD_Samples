package com.wsbook.acme.mappers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.wsbook.acme.Personnel;
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
public class PersonnelMapper extends DepartmentMapper {

	protected static final String _findAllString =
		"SELECT ID, NAME, DESCRIPTION, CODE, EXTERNALBUDGET, TYPE  FROM "+authId+".DEPARTMENT "+
		"WHERE CODE="+PERSONNEL;

	protected void doActivate(DomainObject domainObject, ResultSet rs) 
		throws SQLException, MappingException {
		super.doActivate(domainObject, rs);
		Personnel dept = (Personnel)domainObject;
		dept.setCode(rs.getString(4));
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
		Personnel dept = (Personnel)domainObject;
		ps.setString(4, dept.getCode());
		ps.setInt(6, DepartmentMapper.PERSONNEL);
	}

}
