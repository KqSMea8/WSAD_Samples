package test.simple;
/**
 * Bean implementation class for Enterprise Bean: Employee
 */
public abstract class EmployeeBean implements javax.ejb.EntityBean {
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
	public java.lang.Integer ejbCreate(java.lang.Integer ssn)
		throws javax.ejb.CreateException {
		setSsn(ssn);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.Integer ssn)
		throws javax.ejb.CreateException {
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
	 * Get accessor for persistent attribute: firstName
	 */
	public abstract java.lang.String getFirstName();
	/**
	 * Set accessor for persistent attribute: firstName
	 */
	public abstract void setFirstName(java.lang.String newFirstName);
	/**
	 * Get accessor for persistent attribute: middleInit
	 */
	public abstract char getMiddleInit();
	/**
	 * Set accessor for persistent attribute: middleInit
	 */
	public abstract void setMiddleInit(char newMiddleInit);
	/**
	 * Get accessor for persistent attribute: lastName
	 */
	public abstract java.lang.String getLastName();
	/**
	 * Set accessor for persistent attribute: lastName
	 */
	public abstract void setLastName(java.lang.String newLastName);
	/**
	 * Get accessor for persistent attribute: phone
	 */
	public abstract java.lang.String getPhone();
	/**
	 * Set accessor for persistent attribute: phone
	 */
	public abstract void setPhone(java.lang.String newPhone);
	/**
	 * Get accessor for persistent attribute: hireDate
	 */
	public abstract java.sql.Date getHireDate();
	/**
	 * Set accessor for persistent attribute: hireDate
	 */
	public abstract void setHireDate(java.sql.Date newHireDate);
	/**
	 * Get accessor for persistent attribute: ssn
	 */
	public abstract java.lang.Integer getSsn();
	/**
	 * Set accessor for persistent attribute: ssn
	 */
	public abstract void setSsn(java.lang.Integer newSsn);
}
