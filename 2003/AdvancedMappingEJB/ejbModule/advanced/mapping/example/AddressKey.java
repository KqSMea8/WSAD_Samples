package advanced.mapping.example;
/**
 * Key class for Entity Bean: Address
 */
public class AddressKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: employee_ssn
	 */
	public java.lang.String employee_ssn;
	/**
	 * Creates a key for Entity Bean: Address
	 */
	public AddressKey() {
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof advanced.mapping.example.AddressKey) {
			advanced.mapping.example.AddressKey o =
				(advanced.mapping.example.AddressKey) otherKey;
			return ((this.employee_ssn.equals(o.employee_ssn)));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (employee_ssn.hashCode());
	}
	/**
	 * Creates a key for Entity Bean: Address
	 */
	public AddressKey(advanced.mapping.example.EmployeeKey argEmployee) {
		privateSetEmployeeKey(argEmployee);
	}
	/**
	 * This method was generated for supporting the relationship role named employee.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public advanced.mapping.example.EmployeeKey getEmployeeKey() {
		advanced.mapping.example.EmployeeKey temp =
			new advanced.mapping.example.EmployeeKey();
		boolean employee_NULLTEST = true;
		employee_NULLTEST &= (employee_ssn == null);
		temp.ssn = employee_ssn;
		if (employee_NULLTEST)
			temp = null;
		return temp;
	}
	/**
	 * This method was generated for supporting the relationship role named employee.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void privateSetEmployeeKey(
		advanced.mapping.example.EmployeeKey inKey) {
		boolean employee_NULLTEST = (inKey == null);
		employee_ssn = (employee_NULLTEST) ? null : inKey.ssn;
	}
}
