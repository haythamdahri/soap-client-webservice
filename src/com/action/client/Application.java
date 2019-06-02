package com.action.client;

import java.rmi.RemoteException;

import com.action.service.AdministrateurServiceStub;
import com.action.service.AdministrateurServiceStub.Administrateur;

public class Application {
	
	public static void main(String[] args) throws RemoteException {
		
		// Initialize the stub
		AdministrateurServiceStub stub = new AdministrateurServiceStub();
		
		// Get params objects to put parameters on it before sending
		AdministrateurServiceStub.GetAdministrateur params = new AdministrateurServiceStub.GetAdministrateur();
		params.setId(1L);
		
		// Get method response object
		AdministrateurServiceStub.GetAdministrateurResponse response =  stub.getAdministrateur(params);
		
		// Get administrateur object from the response
		Administrateur administrateur = response.get_return();
		
		// Display the retrieved admin
		System.out.println("Id: " + administrateur.getId());
		System.out.println("First name: " + administrateur.getFirstName());
		System.out.println("Last name: " + administrateur.getLastName());
		System.out.println("Email: " + administrateur.getEmail());
		System.out.println("Password: " + administrateur.getPassword());
	}

}
