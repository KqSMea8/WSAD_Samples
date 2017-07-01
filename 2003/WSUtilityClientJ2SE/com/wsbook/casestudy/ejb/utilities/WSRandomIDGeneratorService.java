/**
 * WSRandomIDGeneratorService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package com.wsbook.casestudy.ejb.utilities;

public interface WSRandomIDGeneratorService extends javax.xml.rpc.Service {
    public java.lang.String getWSRandomIDGeneratorAddress();

    public com.wsbook.casestudy.ejb.utilities.WSRandomIDGenerator getWSRandomIDGenerator() throws javax.xml.rpc.ServiceException;

    public com.wsbook.casestudy.ejb.utilities.WSRandomIDGenerator getWSRandomIDGenerator(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
