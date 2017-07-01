package advanced.mapping.example;
/**
 * Local interface for Enterprise Bean: Course
 */
public interface CourseLocal extends javax.ejb.EJBLocalObject {
	/**
	 * Get accessor for persistent attribute: name
	 */
	public java.lang.String getName();
	/**
	 * Set accessor for persistent attribute: name
	 */
	public void setName(java.lang.String newName);
	/**
	 * Get accessor for persistent attribute: description
	 */
	public java.lang.String getDescription();
	/**
	 * Set accessor for persistent attribute: description
	 */
	public void setDescription(java.lang.String newDescription);
	/**
	 * This method was generated for supporting the relationship role named students.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public java.util.Collection getStudents();
	/**
	 * This method was generated for supporting the relationship role named students.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setStudents(java.util.Collection aStudents);
}
