package advanced.mapping.example;
/**
 * Local Home interface for Enterprise Bean: Employee
 */
public interface EmployeeLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: Employee
	 */
	public advanced.mapping.example.EmployeeLocal create(java.lang.String ssn)
		throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: Employee
	 */
	public advanced.mapping.example.EmployeeLocal findByPrimaryKey(
		advanced.mapping.example.EmployeeKey primaryKey)
		throws javax.ejb.FinderException;
}
