package advanced.mapping.example;
/**
 * Local Home interface for Enterprise Bean: Student
 */
public interface StudentLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: Student
	 */
	public advanced.mapping.example.StudentLocal create(java.lang.String ssn)
		throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: Student
	 */
	public advanced.mapping.example.StudentLocal findByPrimaryKey(
		java.lang.String primaryKey)
		throws javax.ejb.FinderException;
}
