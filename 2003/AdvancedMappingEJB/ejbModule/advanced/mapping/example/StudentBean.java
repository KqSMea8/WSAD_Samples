package advanced.mapping.example;
/**
 * Bean implementation class for Enterprise Bean: Student
 */
public abstract class StudentBean implements javax.ejb.EntityBean {
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
	public java.lang.String ejbCreate(java.lang.String ssn)
		throws javax.ejb.CreateException {
		setSsn(ssn);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String ssn)
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
	 * Get accessor for persistent attribute: ssn
	 */
	public abstract java.lang.String getSsn();
	/**
	 * Set accessor for persistent attribute: ssn
	 */
	public abstract void setSsn(java.lang.String newSsn);
	/**
	 * Get accessor for persistent attribute: name
	 */
	public abstract java.lang.String getName();
	/**
	 * Set accessor for persistent attribute: name
	 */
	public abstract void setName(java.lang.String newName);
	/**
	 * Get accessor for persistent attribute: age
	 */
	public abstract int getAge();
	/**
	 * Set accessor for persistent attribute: age
	 */
	public abstract void setAge(int newAge);
	/**
	 * Get accessor for persistent attribute: gpa
	 */
	public abstract java.lang.Double getGpa();
	/**
	 * Set accessor for persistent attribute: gpa
	 */
	public abstract void setGpa(java.lang.Double newGpa);
	/**
	 * This method was generated for supporting the relationship role named courses.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract java.util.Collection getCourses();
	/**
	 * This method was generated for supporting the relationship role named courses.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setCourses(java.util.Collection aCourses);
}
