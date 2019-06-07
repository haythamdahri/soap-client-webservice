
/**
 * PriceActionServiceImplCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.9  Built on : Nov 16, 2018 (12:05:37 GMT)
 */

    package com.action.service;

    /**
     *  PriceActionServiceImplCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class PriceActionServiceImplCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public PriceActionServiceImplCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public PriceActionServiceImplCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for deleteAction method
            * override this method for handling normal response from deleteAction operation
            */
           public void receiveResultdeleteAction(
                    com.action.service.PriceActionServiceImplStub.DeleteActionResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteAction operation
           */
            public void receiveErrordeleteAction(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteBourse method
            * override this method for handling normal response from deleteBourse operation
            */
           public void receiveResultdeleteBourse(
                    com.action.service.PriceActionServiceImplStub.DeleteBourseResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteBourse operation
           */
            public void receiveErrordeleteBourse(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAdmins method
            * override this method for handling normal response from getAdmins operation
            */
           public void receiveResultgetAdmins(
                    com.action.service.PriceActionServiceImplStub.GetAdminsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAdmins operation
           */
            public void receiveErrorgetAdmins(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getActions method
            * override this method for handling normal response from getActions operation
            */
           public void receiveResultgetActions(
                    com.action.service.PriceActionServiceImplStub.GetActionsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getActions operation
           */
            public void receiveErrorgetActions(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAction method
            * override this method for handling normal response from getAction operation
            */
           public void receiveResultgetAction(
                    com.action.service.PriceActionServiceImplStub.GetActionResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAction operation
           */
            public void receiveErrorgetAction(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for updateBourse method
            * override this method for handling normal response from updateBourse operation
            */
           public void receiveResultupdateBourse(
                    com.action.service.PriceActionServiceImplStub.UpdateBourseResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updateBourse operation
           */
            public void receiveErrorupdateBourse(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for updateAdmin method
            * override this method for handling normal response from updateAdmin operation
            */
           public void receiveResultupdateAdmin(
                    com.action.service.PriceActionServiceImplStub.UpdateAdminResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updateAdmin operation
           */
            public void receiveErrorupdateAdmin(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getBourses method
            * override this method for handling normal response from getBourses operation
            */
           public void receiveResultgetBourses(
                    com.action.service.PriceActionServiceImplStub.GetBoursesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getBourses operation
           */
            public void receiveErrorgetBourses(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAdmin method
            * override this method for handling normal response from getAdmin operation
            */
           public void receiveResultgetAdmin(
                    com.action.service.PriceActionServiceImplStub.GetAdminResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAdmin operation
           */
            public void receiveErrorgetAdmin(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addBourse method
            * override this method for handling normal response from addBourse operation
            */
           public void receiveResultaddBourse(
                    com.action.service.PriceActionServiceImplStub.AddBourseResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addBourse operation
           */
            public void receiveErroraddBourse(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getBourse method
            * override this method for handling normal response from getBourse operation
            */
           public void receiveResultgetBourse(
                    com.action.service.PriceActionServiceImplStub.GetBourseResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getBourse operation
           */
            public void receiveErrorgetBourse(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getActionHistory method
            * override this method for handling normal response from getActionHistory operation
            */
           public void receiveResultgetActionHistory(
                    com.action.service.PriceActionServiceImplStub.GetActionHistoryResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getActionHistory operation
           */
            public void receiveErrorgetActionHistory(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for isValidAdmin method
            * override this method for handling normal response from isValidAdmin operation
            */
           public void receiveResultisValidAdmin(
                    com.action.service.PriceActionServiceImplStub.IsValidAdminResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from isValidAdmin operation
           */
            public void receiveErrorisValidAdmin(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getActionsByBourse method
            * override this method for handling normal response from getActionsByBourse operation
            */
           public void receiveResultgetActionsByBourse(
                    com.action.service.PriceActionServiceImplStub.GetActionsByBourseResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getActionsByBourse operation
           */
            public void receiveErrorgetActionsByBourse(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getBoursesById method
            * override this method for handling normal response from getBoursesById operation
            */
           public void receiveResultgetBoursesById(
                    com.action.service.PriceActionServiceImplStub.GetBoursesByIdResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getBoursesById operation
           */
            public void receiveErrorgetBoursesById(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for updateAction method
            * override this method for handling normal response from updateAction operation
            */
           public void receiveResultupdateAction(
                    com.action.service.PriceActionServiceImplStub.UpdateActionResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updateAction operation
           */
            public void receiveErrorupdateAction(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteAdmin method
            * override this method for handling normal response from deleteAdmin operation
            */
           public void receiveResultdeleteAdmin(
                    com.action.service.PriceActionServiceImplStub.DeleteAdminResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteAdmin operation
           */
            public void receiveErrordeleteAdmin(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addAction method
            * override this method for handling normal response from addAction operation
            */
           public void receiveResultaddAction(
                    com.action.service.PriceActionServiceImplStub.AddActionResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addAction operation
           */
            public void receiveErroraddAction(java.lang.Exception e) {
            }
                


    }
    