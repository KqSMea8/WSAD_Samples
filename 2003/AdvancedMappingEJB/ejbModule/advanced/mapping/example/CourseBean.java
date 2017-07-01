package advanced.mapping.example;
/**
 * Bean implementation class for Enterprise Bean: Course
 */
public abstract class CourseBean implements javax.ejb.EntityBean {
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
	public java.lang.Integer ejbCreate(java.lang.Integer number)
		throws javax.ejb.CreateException {
		setNumber(number);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.Integer number)
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
	 * Get accessor for persistent attribute: number
	 */
	public abstract java.lang.Integer getNumber();
	/**
	 * Set accessor for persistent attribute: number
	 */
	public abstract void setNumber(java.lang.Integer newNumber);
	/**
	 * Get accessor for persistent attribute: name
	 */
	public abstract java.lang.String getName();
	/**
	 * Set accessor for persistent attribute: name
	 */
	public abstract void setName(java.lang.String newName);
	/**
	 * Get accessor for persistent attribute: description
	 */
	public abstract java.lang.String getDescription();
	/**
	 * Set accessor for persistent attribute: description
	 */
	public abstract void setDescription(java.lang.String newDescription);
	/**
	 * This method was generated for supporting the relationship role named students.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract java.util.Collection getStudents();
	/**
	 * This method was generated for supporting the relationship role named students.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setStudents(java.util.Collection aStudents);
}
