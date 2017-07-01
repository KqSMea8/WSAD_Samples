package advanced.mapping.example;
/**
 * Local interface for Enterprise Bean: Address
 */
public interface AddressLocal extends javax.ejb.EJBLocalObject {
	/**
	 * Get accessor for persistent attribute: street
	 */
	public java.lang.String getStreet();
	/**
	 * Set accessor for persistent attribute: street
	 */
	public void setStreet(java.lang.String newStreet);
	/**
	 * Get accessor for persistent attribute: city
	 */
	public java.lang.String getCity();
	/**
	 * Set accessor for persistent attribute: city
	 */
	public void setCity(java.lang.String newCity);
	/**
	 * Get accessor for persistent attribute: state
	 */
	public java.lang.String getState();
	/**
	 * Set accessor for persistent attribute: state
	 */
	public void setState(java.lang.String newState);
	/**
	 * Get accessor for persistent attribute: zip
	 */
	public int getZip();
	/**
	 * Set accessor for persistent attribute: zip
	 */
	public void setZip(int newZip);
	/**
	 * This method was generated for supporting the relationship role named employee.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public advanced.mapping.example.EmployeeLocal getEmployee();
	/**
	 * This method was generated for supporting the relationship role named employee.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setEmployee(advanced.mapping.example.EmployeeLocal anEmployee);
}
