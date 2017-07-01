package advanced.mapping.example;
/**
 * Local interface for Enterprise Bean: Employee
 */
public interface EmployeeLocal extends javax.ejb.EJBLocalObject {
	/**
	 * Get accessor for persistent attribute: name
	 */
	public java.lang.String getName();
	/**
	 * Set accessor for persistent attribute: name
	 */
	public void setName(java.lang.String newName);
	/**
	 * This method was generated for supporting the relationship role named address.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public advanced.mapping.example.AddressLocal getAddress();
	/**
	 * This method was generated for supporting the relationship role named address.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setAddress(advanced.mapping.example.AddressLocal anAddress);
}
