package com.wsbook.casestudy.ejb;

/**
* This is a Primary Key Class for the Entity Bean
**/
public class CustomerEJBKey implements java.io.Serializable { 
	public int primaryKey;
	final static long serialVersionUID = 3206093459760846163L;

/**
* CustomerEJBKey() constructor 
*/
public CustomerEJBKey()  {
}
/**
* CustomerEJBKey(int key) constructor 
*/
public CustomerEJBKey(int key)  {
	primaryKey = key;
}
/**
* equals method
* - user must provide a proper implementation for the equal method. The generated 
*   method assumes the key is a String object.
*/
public boolean equals (Object o)  {
	if (o instanceof CustomerEJBKey) 
		return primaryKey == ((CustomerEJBKey)o).primaryKey;
	else
		return false;
}
/**
* hashode method
* - user must provide a proper implementation for the hashCode method. The generated
*    method assumes the key is a String object.
*/
public int hashCode ()  {
	return primaryKey;
}
}
