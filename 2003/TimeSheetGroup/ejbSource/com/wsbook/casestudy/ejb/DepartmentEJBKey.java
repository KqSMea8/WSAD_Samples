package com.wsbook.casestudy.ejb;
/**
 * Key class for Entity Bean: DepartmentEJB
 */
public class DepartmentEJBKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: deptNumber
	 */
	public int deptNumber;
	/**
	 * Creates an empty key for Entity Bean: DepartmentEJB
	 */
	public DepartmentEJBKey() {
	}
	/**
	 * Creates a key for Entity Bean: DepartmentEJB
	 */
	public DepartmentEJBKey(int deptNumber) {
		this.deptNumber = deptNumber;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof com.wsbook.casestudy.ejb.DepartmentEJBKey) {
			com.wsbook.casestudy.ejb.DepartmentEJBKey o = (com.wsbook.casestudy.ejb.DepartmentEJBKey)otherKey;
			return ((this.deptNumber == o.deptNumber));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return ((new java.lang.Integer(deptNumber).hashCode()));
	}
	/**
	 * Get accessor for persistent attribute: deptNumber
	 */
	public int getDeptNumber() {
		return deptNumber;
	}
	/**
	 * Set accessor for persistent attribute: deptNumber
	 */
	public void setDeptNumber(int newDeptNumber) {
		deptNumber = newDeptNumber;
	}
}
