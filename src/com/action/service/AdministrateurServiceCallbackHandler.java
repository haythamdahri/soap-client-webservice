
/**
 * AdministrateurServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.9  Built on : Nov 16, 2018 (12:05:37 GMT)
 */

    package com.action.service;

    /**
     *  AdministrateurServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class AdministrateurServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public AdministrateurServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public AdministrateurServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for getAdministrateur method
            * override this method for handling normal response from getAdministrateur operation
            */
           public void receiveResultgetAdministrateur(
                    com.action.service.AdministrateurServiceStub.GetAdministrateurResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAdministrateur operation
           */
            public void receiveErrorgetAdministrateur(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for hashPassword method
            * override this method for handling normal response from hashPassword operation
            */
           public void receiveResulthashPassword(
                    com.action.service.AdministrateurServiceStub.HashPasswordResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from hashPassword operation
           */
            public void receiveErrorhashPassword(java.lang.Exception e) {
            }
                


    }
    