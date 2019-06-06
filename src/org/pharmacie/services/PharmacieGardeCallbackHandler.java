
/**
 * PharmacieGardeCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.9  Built on : Nov 16, 2018 (12:05:37 GMT)
 */

    package org.pharmacie.services;

    /**
     *  PharmacieGardeCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class PharmacieGardeCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public PharmacieGardeCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public PharmacieGardeCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for toString method
            * override this method for handling normal response from toString operation
            */
           public void receiveResulttoString(
                    org.pharmacie.services.PharmacieGardeStub.ToStringResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from toString operation
           */
            public void receiveErrortoString(java.lang.Exception e) {
            }
                
               // No methods generated for meps other than in-out
                
               // No methods generated for meps other than in-out
                
           /**
            * auto generated Axis2 call back method for getNom method
            * override this method for handling normal response from getNom operation
            */
           public void receiveResultgetNom(
                    org.pharmacie.services.PharmacieGardeStub.GetNomResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getNom operation
           */
            public void receiveErrorgetNom(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAdresse method
            * override this method for handling normal response from getAdresse operation
            */
           public void receiveResultgetAdresse(
                    org.pharmacie.services.PharmacieGardeStub.GetAdresseResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAdresse operation
           */
            public void receiveErrorgetAdresse(java.lang.Exception e) {
            }
                


    }
    