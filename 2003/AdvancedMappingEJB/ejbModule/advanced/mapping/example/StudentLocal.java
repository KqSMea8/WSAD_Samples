package advanced.mapping.example;
/**
 * Local interface for Enterprise Bean: Student
 */
public interface StudentLocal extends javax.ejb.EJBLocalObject {
	/**
	 * Get accessor for persistent attribute: name
	 */
	public java.lang.String getName();
	/**
	 * Set accessor for persistent attribute: name
	 */
	public void setName(java.lang.String newName);
	/**
	 * Get accessor for persistent attribute: age
	 */
	public int getAge();
	/**
	 * Set accessor for persistent attribute: age
	 */
	public void setAge(int newAge);
	/**
	 * Get accessor for persistent attribute: gpa
	 */
	public java.lang.Double getGpa();
	/**
	 * Set accessor for persistent attribute: gpa
	 */
	public void setGpa(java.lang.Double newGpa);
	/**
	 * This method was generated for supporting the relationship role named courses.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public java.util.Collection getCourses();
	/**
	 * This method was generated for supporting the relationship role named courses.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setCourses(java.util.Collection aCourses);
}
