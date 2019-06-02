package com.action.utils;

import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;
import java.rmi.RemoteException;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.axis2.AxisFault;

import com.action.service.PriceActionServiceImplStub;

public class MainUtils {

	private static final String HOME_DIR = "/root/eclipse-workspace/Currency-client/WebContent";
	
	/*
	 * First test case 
	 */
	public static String getRenderedBourse(Long id) throws TransformerException, RemoteException {
				
		PriceActionServiceImplStub stub = new PriceActionServiceImplStub();
		PriceActionServiceImplStub.GetBourse params = new PriceActionServiceImplStub.GetBourse();
		params.setId(id);
		PriceActionServiceImplStub.GetBourseResponse response = stub.getBourse(params);
		params.setId(id);
		String bourseXml = response.get_return();
		System.out.println(bourseXml);
		
	 
	    TransformerFactory factory = TransformerFactory.newInstance();
        Source xslt = new StreamSource(new File(HOME_DIR  + "/single-bourse.xsl"));
        Transformer transformer = factory.newTransformer(xslt);

        Source text = new StreamSource(new StringReader(bourseXml));
        StringWriter writer = new StringWriter();
        transformer.transform(text, new StreamResult(writer));
        
        return writer.toString();
	}
	
	/*
	 * Bourses list xml parsing 
	 */
	public static String getRenderedBourses() throws TransformerException, RemoteException {
				
		PriceActionServiceImplStub stub = new PriceActionServiceImplStub();
		PriceActionServiceImplStub.GetBourses params = new PriceActionServiceImplStub.GetBourses();
		PriceActionServiceImplStub.GetBoursesResponse response = stub.getBourses(params);
		String boursesXml = response.get_return();
		System.out.println(boursesXml);
		
	 
	    TransformerFactory factory = TransformerFactory.newInstance();
        Source xslt = new StreamSource(new File(HOME_DIR  + "/bourses-list.xsl"));
        Transformer transformer = factory.newTransformer(xslt);

        Source text = new StreamSource(new StringReader(boursesXml));
        StringWriter writer = new StringWriter();
        transformer.transform(text, new StreamResult(writer));
        
        return writer.toString();
	}
	
	/*
	 * Bourse list xml parsing 
	 */
	public static String getRenderedBourses(Long id) throws TransformerException, RemoteException {
				
		PriceActionServiceImplStub stub = new PriceActionServiceImplStub();
		PriceActionServiceImplStub.GetBoursesById params = new PriceActionServiceImplStub.GetBoursesById();
		params.setId(id);
		PriceActionServiceImplStub.GetBoursesByIdResponse response = stub.getBoursesById(params);
		String boursesXml = response.get_return();
		System.out.println(boursesXml);
		
	 
	    TransformerFactory factory = TransformerFactory.newInstance();
        Source xslt = new StreamSource(new File(HOME_DIR  + "/bourses-list.xsl"));
        Transformer transformer = factory.newTransformer(xslt);

        Source text = new StreamSource(new StringReader(boursesXml));
        StringWriter writer = new StringWriter();
        transformer.transform(text, new StreamResult(writer));
        
        return writer.toString();
	}
	
	/*
	 * Actions list xml parsing 
	 */
	public static String getRenderedActions() throws TransformerException, RemoteException {
				
		PriceActionServiceImplStub stub = new PriceActionServiceImplStub();
		PriceActionServiceImplStub.GetActions params = new PriceActionServiceImplStub.GetActions();
		PriceActionServiceImplStub.GetActionsResponse response = stub.getActions(params);
		String actionsXml = response.get_return();
		System.out.println(actionsXml);
		
	 
	    TransformerFactory factory = TransformerFactory.newInstance();
        Source xslt = new StreamSource(new File(HOME_DIR  + "/actions-list.xsl"));
        Transformer transformer = factory.newTransformer(xslt);

        Source text = new StreamSource(new StringReader(actionsXml));
        StringWriter writer = new StringWriter();
        transformer.transform(text, new StreamResult(writer));
        
        return writer.toString();
	}
	
	/*
	 * Actions list xml parsing 
	 */
	public static String getRenderedActionHistory(String name) throws TransformerException, RemoteException {
				
		PriceActionServiceImplStub stub = new PriceActionServiceImplStub();
		PriceActionServiceImplStub.GetActionHistory params = new PriceActionServiceImplStub.GetActionHistory();
		params.setName(name);
		PriceActionServiceImplStub.GetActionHistoryResponse response = stub.getActionHistory(params);
		String actionsXml = response.get_return();
		System.out.println(actionsXml);
		
	 
	    TransformerFactory factory = TransformerFactory.newInstance();
        Source xslt = new StreamSource(new File(HOME_DIR  + "/action-history.xsl"));
        Transformer transformer = factory.newTransformer(xslt);

        Source text = new StreamSource(new StringReader(actionsXml));
        StringWriter writer = new StringWriter();
        transformer.transform(text, new StreamResult(writer));
        
        return writer.toString();
	}
	
	/*
	 * Bourse Actions list xml parsing 
	 */
	public static String getRenderedBourseActions(Long id) throws TransformerException, RemoteException {
				
		PriceActionServiceImplStub stub = new PriceActionServiceImplStub();
		PriceActionServiceImplStub.GetActionsByBourse params = new PriceActionServiceImplStub.GetActionsByBourse();
		params.setId(id);
		
		PriceActionServiceImplStub.GetActionsByBourseResponse response = stub.getActionsByBourse(params);
		String actionsXml = response.get_return();
		System.out.println(actionsXml);
		
	 
	    TransformerFactory factory = TransformerFactory.newInstance();
        Source xslt = new StreamSource(new File(HOME_DIR  + "/actions-list.xsl"));
        Transformer transformer = factory.newTransformer(xslt);

        Source text = new StreamSource(new StringReader(actionsXml));
        StringWriter writer = new StringWriter();
        transformer.transform(text, new StreamResult(writer));
        
        return writer.toString();
	}
	
	/*
	 * Check user validity 
	 */
	public static boolean isValidUser(String email, String password) throws RemoteException {
		PriceActionServiceImplStub stub = new PriceActionServiceImplStub();
		PriceActionServiceImplStub.IsValidAdmin params = new PriceActionServiceImplStub.IsValidAdmin();
		params.setEmail(email);
		params.setPassword(password);
		
		PriceActionServiceImplStub.IsValidAdminResponse response = stub.isValidAdmin(params);
		return response.get_return();
	}
	
	/*
	 * Login 
	 */
	public static String getLoginPage(String error) throws TransformerException, RemoteException {
	 
	    TransformerFactory factory = TransformerFactory.newInstance();
        Source xslt = new StreamSource(new File(HOME_DIR  + "/login.xsl"));
        Transformer transformer = factory.newTransformer(xslt);

        Source text = null;
        if( error == null ) {
        	text = new StreamSource(new StringReader("<user />"));
        } else {
        	text = new StreamSource(new StringReader("<user error='1'/>"));
        }
        
        StringWriter writer = new StringWriter();
        transformer.transform(text, new StreamResult(writer));
        
        return writer.toString();
	}
	
	
}
