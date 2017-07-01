package advanced.mapping.example;
/**
 * Bean implementation class for Enterprise Bean: Address
 */
public abstract class AddressBean implements javax.ejb.EntityBean {
	private javax.ejb.EntityContext myEntityCtx;
	/**
	 * setEntityContext
	 */
	public void setEntityContext(javax.ejb.EntityContext ctx) {
		myEntityCtx = ctx;
	}
	/**
	 * getEntityContext
	 */
	public javax.ejb.EntityContext getEntityContext() {
		return myEntityCtx;
	}
	/**
	 * unsetEntityContext
	 */
	public void unsetEntityContext() {
		myEntityCtx = null;
	}
	/**
	 * ejbCreate
	 */
	public advanced.mapping.example.AddressKey ejbCreate(
		advanced.mapping.example.EmployeeLocal argEmployee)
		throws javax.ejb.CreateException {
		advanced.mapping.example.EmployeeKey argEmployeePK =
			(advanced.mapping.example.EmployeeKey) argEmployee.getPrimaryKey();
		setEmployee_ssn(argEmployeePK.ssn);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(
		advanced.mapping.example.EmployeeLocal argEmployee)
		throws javax.ejb.CreateException {
		setEmployee(argEmployee);
	}
	/**
	 * ejbActivate
	 */
	public void ejbActivate() {
	}
	/**
	 * ejbLoad
	 */
	public void ejbLoad() {
	}
	/**
	 * ejbPassivate
	 */
	public void ejbPassivate() {
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove() throws javax.ejb.RemoveException {
	}
	/**
	 * ejbStore
	 */
	public void ejbStore() {
	}
	/**
	 * Get accessor for persistent attribute: street
	 */
	public abstract java.lang.String getStreet();
	/**
	 * Set accessor for persistent attribute: street
	 */
	public abstract void setStreet(java.lang.String newStreet);
	/**
	 * Get accessor for persistent attribute: city
	 */
	public abstract java.lang.String getCity();
	/**
	 * Set accessor for persistent attribute: city
	 */
	public abstract void setCity(java.lang.String newCity);
	/**
	 * Get accessor for persistent attribute: state
	 */
	public abstract java.lang.String getState();
	/**
	 * Set accessor for persistent attribute: state
	 */
	public abstract void setState(java.lang.String newState);
	/**
	 * Get accessor for persistent attribute: zip
	 */
	public abstract int getZip();
	/**
	 * Set accessor for persistent attribute: zip
	 */
	public abstract void setZip(int newZip);
	/**
	 * This method was generated for supporting the relationship role named employee.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract advanced.mapping.example.EmployeeLocal getEmployee();
	/**
	 * This method was generated for supporting the relationship role named employee.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setEmployee(
		advanced.mapping.example.EmployeeLocal anEmployee);
	/**
	 * ejbCreate
	 */
	public advanced.mapping.example.AddressKey ejbCreate(
		java.lang.String employee_ssn)
		throws javax.ejb.CreateException {
		setEmployee_ssn(employee_ssn);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String employee_ssn)
		throws javax.ejb.CreateException {
	}
	/**
	 * Get accessor for persistent attribute: employee_ssn
	 */
	public abstract java.lang.String getEmployee_ssn();
	/**
	 * Set accessor for persistent attribute: employee_ssn
	 */
	public abstract void setEmployee_ssn(java.lang.String newEmployee_ssn);
}
