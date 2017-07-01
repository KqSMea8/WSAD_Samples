package test.simple;
/**
 * Local interface for Enterprise Bean: Employee
 */
public interface EmployeeLocal extends javax.ejb.EJBLocalObject {
	/**
	 * Get accessor for persistent attribute: firstName
	 */
	public java.lang.String getFirstName();
	/**
	 * Set accessor for persistent attribute: firstName
	 */
	public void setFirstName(java.lang.String newFirstName);
	/**
	 * Get accessor for persistent attribute: middleInit
	 */
	public char getMiddleInit();
	/**
	 * Set accessor for persistent attribute: middleInit
	 */
	public void setMiddleInit(char newMiddleInit);
	/**
	 * Get accessor for persistent attribute: lastName
	 */
	public java.lang.String getLastName();
	/**
	 * Set accessor for persistent attribute: lastName
	 */
	public void setLastName(java.lang.String newLastName);
	/**
	 * Get accessor for persistent attribute: phone
	 */
	public java.lang.String getPhone();
	/**
	 * Set accessor for persistent attribute: phone
	 */
	public void setPhone(java.lang.String newPhone);
	/**
	 * Get accessor for persistent attribute: hireDate
	 */
	public java.sql.Date getHireDate();
	/**
	 * Set accessor for persistent attribute: hireDate
	 */
	public void setHireDate(java.sql.Date newHireDate);
}
