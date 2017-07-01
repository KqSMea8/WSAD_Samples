package advanced.mapping.example;
/**
 * Key class for Entity Bean: Employee
 */
public class EmployeeKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: ssn
	 */
	public java.lang.String ssn;
	/**
	 * Creates an empty key for Entity Bean: Employee
	 */
	public EmployeeKey() {
	}
	/**
	 * Creates a key for Entity Bean: Employee
	 */
	public EmployeeKey(java.lang.String ssn) {
		this.ssn = ssn;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof advanced.mapping.example.EmployeeKey) {
			advanced.mapping.example.EmployeeKey o =
				(advanced.mapping.example.EmployeeKey) otherKey;
			return ((this.ssn.equals(o.ssn)));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (ssn.hashCode());
	}
}
