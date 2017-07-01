package advanced.mapping.example;
/**
 * Local Home interface for Enterprise Bean: Course
 */
public interface CourseLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: Course
	 */
	public advanced.mapping.example.CourseLocal create(
		java.lang.Integer number)
		throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: Course
	 */
	public advanced.mapping.example.CourseLocal findByPrimaryKey(
		java.lang.Integer primaryKey)
		throws javax.ejb.FinderException;
}
