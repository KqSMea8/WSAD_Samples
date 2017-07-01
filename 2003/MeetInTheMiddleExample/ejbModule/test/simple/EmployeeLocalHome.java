package test.simple;
/**
 * Local Home interface for Enterprise Bean: Employee
 */
public interface EmployeeLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: Employee
	 */
	public test.simple.EmployeeLocal create(java.lang.Integer ssn)
		throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: Employee
	 */
	public test.simple.EmployeeLocal findByPrimaryKey(
		java.lang.Integer primaryKey)
		throws javax.ejb.FinderException;
}
