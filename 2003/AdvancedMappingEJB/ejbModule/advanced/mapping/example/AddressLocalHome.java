package advanced.mapping.example;
/**
 * Local Home interface for Enterprise Bean: Address
 */
public interface AddressLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: Address
	 */
	public advanced.mapping.example.AddressLocal create(
		advanced.mapping.example.EmployeeLocal argEmployee)
		throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: Address
	 */
	public advanced.mapping.example.AddressLocal findByPrimaryKey(
		advanced.mapping.example.AddressKey primaryKey)
		throws javax.ejb.FinderException;
	/**
	 * Creates an instance from a key for Entity Bean: Address
	 */
	public advanced.mapping.example.AddressLocal create(
		java.lang.String employee_ssn)
		throws javax.ejb.CreateException;
}
