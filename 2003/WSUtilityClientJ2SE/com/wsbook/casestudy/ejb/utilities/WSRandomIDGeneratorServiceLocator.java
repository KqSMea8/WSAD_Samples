/**
 * WSRandomIDGeneratorServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package com.wsbook.casestudy.ejb.utilities;

public class WSRandomIDGeneratorServiceLocator extends org.apache.axis.client.Service implements com.wsbook.casestudy.ejb.utilities.WSRandomIDGeneratorService {

    // Use to get a proxy class for WSRandomIDGenerator
    private final java.lang.String WSRandomIDGenerator_address = "http://localhost:9080/TSS/services/WSRandomIDGenerator";

    public java.lang.String getWSRandomIDGeneratorAddress() {
        return WSRandomIDGenerator_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WSRandomIDGeneratorWSDDServiceName = "WSRandomIDGenerator";

    public java.lang.String getWSRandomIDGeneratorWSDDServiceName() {
        return WSRandomIDGeneratorWSDDServiceName;
    }

    public void setWSRandomIDGeneratorWSDDServiceName(java.lang.String name) {
        WSRandomIDGeneratorWSDDServiceName = name;
    }

    public com.wsbook.casestudy.ejb.utilities.WSRandomIDGenerator getWSRandomIDGenerator() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WSRandomIDGenerator_address);
        }
        catch (java.net.MalformedURLException e) {
            return null; // unlikely as URL was validated in WSDL2Java
        }
        return getWSRandomIDGenerator(endpoint);
    }

    public com.wsbook.casestudy.ejb.utilities.WSRandomIDGenerator getWSRandomIDGenerator(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.wsbook.casestudy.ejb.utilities.WSRandomIDGeneratorSoapBindingStub _stub = new com.wsbook.casestudy.ejb.utilities.WSRandomIDGeneratorSoapBindingStub(portAddress, this);
            _stub.setPortName(getWSRandomIDGeneratorWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.wsbook.casestudy.ejb.utilities.WSRandomIDGenerator.class.isAssignableFrom(serviceEndpointInterface)) {
                com.wsbook.casestudy.ejb.utilities.WSRandomIDGeneratorSoapBindingStub _stub = new com.wsbook.casestudy.ejb.utilities.WSRandomIDGeneratorSoapBindingStub(new java.net.URL(WSRandomIDGenerator_address), this);
                _stub.setPortName(getWSRandomIDGeneratorWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        String inputPortName = portName.getLocalPart();
        if ("WSRandomIDGenerator".equals(inputPortName)) {
            return getWSRandomIDGenerator();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://utilities.ejb.casestudy.wsbook.com", "WSRandomIDGeneratorService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("WSRandomIDGenerator"));
        }
        return ports.iterator();
    }

}
