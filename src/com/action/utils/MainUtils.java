package com.action.utils;

import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;
import java.rmi.RemoteException;
import java.security.MessageDigest;

import javax.xml.bind.DatatypeConverter;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import com.action.service.PriceActionServiceImplStub;
import com.action.service.PriceActionServiceImplStub.Action;
import com.action.service.PriceActionServiceImplStub.Bourse;

public class MainUtils {

	private static final String HOME_DIR = "/root/eclipse-workspace/Currency-client/WebContent";

	/*
	 * User injector
	 */
	public static String injectUser(String email, String xmlData) {
		String add = "<connected-user email='" + email + "' />";
		if (email != null) {
			StringBuilder finalResults = new StringBuilder(xmlData).insert(xmlData.lastIndexOf("</") - 1, add);
			return finalResults.toString();
		} else {
			return xmlData;
		}
	}

	/*
	 * Error injector
	 */
	public static String injectError(String error, String xmlData) {
		String add = "<validation-error error='" + error + "' />";
		if (error != null) {
			StringBuilder finalResults = new StringBuilder(xmlData).insert(xmlData.lastIndexOf("</") - 1, add);
			return finalResults.toString();
		} else {
			return xmlData;
		}
	}

	/*
	 * Success injector
	 */
	public static String injectSuccess(String success, String xmlData) {
		String add = "<validation-success success='" + success + "' />";
		if (success != null) {
			StringBuilder finalResults = new StringBuilder(xmlData).insert(xmlData.lastIndexOf("</") - 1, add);
			return finalResults.toString();
		} else {
			return xmlData;
		}
	}

	/*
	 * Xml Data injector
	 */
	public static String injectData(String existedData, String newData) {

		StringBuilder finalResults = new StringBuilder(existedData).insert(existedData.lastIndexOf("</") - 1, newData);
		return finalResults.toString();
	}

	/*
	 * Actions list injector
	 */
	public static String injectBourses(String xmlData, String delimiter) throws RemoteException {

		// Retrieve actions list
		PriceActionServiceImplStub stub = new PriceActionServiceImplStub();
		PriceActionServiceImplStub.GetBourses params = new PriceActionServiceImplStub.GetBourses();
		PriceActionServiceImplStub.GetBoursesResponse response = stub.getBourses(params);
		String boursesXml = response.get_return();

		boursesXml = boursesXml.substring(boursesXml.indexOf(delimiter) + 1);

		// Inject the list
		StringBuilder finalResults = new StringBuilder(xmlData).insert(xmlData.lastIndexOf("</") - 1, boursesXml);

		// Return final results
		return finalResults.toString();
	}

	/*
	 * First test case
	 */
	public static String getRenderedBourse(Long id, String email) throws TransformerException, RemoteException {

		PriceActionServiceImplStub stub = new PriceActionServiceImplStub();
		PriceActionServiceImplStub.GetBourse params = new PriceActionServiceImplStub.GetBourse();
		params.setId(id);
		PriceActionServiceImplStub.GetBourseResponse response = stub.getBourse(params);
		params.setId(id);
		String bourseXml = injectUser(email, response.get_return());
		System.out.println(bourseXml);

		TransformerFactory factory = TransformerFactory.newInstance();
		Source xslt = new StreamSource(new File(HOME_DIR + "/single-bourse.xsl"));
		Transformer transformer = factory.newTransformer(xslt);

		Source text = new StreamSource(new StringReader(bourseXml));
		StringWriter writer = new StringWriter();
		transformer.transform(text, new StreamResult(writer));

		return writer.toString();
	}

	/*
	 * Bourses list xml parsing
	 */
	public static String getRenderedBourses(String email) throws TransformerException, RemoteException {

		PriceActionServiceImplStub stub = new PriceActionServiceImplStub();
		PriceActionServiceImplStub.GetBourses params = new PriceActionServiceImplStub.GetBourses();
		PriceActionServiceImplStub.GetBoursesResponse response = stub.getBourses(params);
		String boursesXml = injectUser(email, response.get_return());
		System.out.println(boursesXml);

		TransformerFactory factory = TransformerFactory.newInstance();
		Source xslt = new StreamSource(new File(HOME_DIR + "/bourses-list.xsl"));
		Transformer transformer = factory.newTransformer(xslt);

		Source text = new StreamSource(new StringReader(boursesXml));
		StringWriter writer = new StringWriter();
		transformer.transform(text, new StreamResult(writer));

		injectUser("haytham.dahri@gmail.com", boursesXml);

		return writer.toString();
	}

	/*
	 * Bourse list xml parsing
	 */
	public static String getRenderedBourses(Long id, String email) throws TransformerException, RemoteException {

		PriceActionServiceImplStub stub = new PriceActionServiceImplStub();
		PriceActionServiceImplStub.GetBoursesById params = new PriceActionServiceImplStub.GetBoursesById();
		params.setId(id);
		PriceActionServiceImplStub.GetBoursesByIdResponse response = stub.getBoursesById(params);
		String boursesXml = injectUser(email, response.get_return());
		System.out.println(boursesXml);

		TransformerFactory factory = TransformerFactory.newInstance();
		Source xslt = new StreamSource(new File(HOME_DIR + "/bourses-list.xsl"));
		Transformer transformer = factory.newTransformer(xslt);

		Source text = new StreamSource(new StringReader(boursesXml));
		StringWriter writer = new StringWriter();
		transformer.transform(text, new StreamResult(writer));

		return writer.toString();
	}

	/*
	 * Actions list xml parsing
	 */
	public static String getRenderedActions(String email) throws TransformerException, RemoteException {

		PriceActionServiceImplStub stub = new PriceActionServiceImplStub();
		PriceActionServiceImplStub.GetActions params = new PriceActionServiceImplStub.GetActions();
		PriceActionServiceImplStub.GetActionsResponse response = stub.getActions(params);
		String actionsXml = injectUser(email, response.get_return());
		System.out.println(actionsXml);

		TransformerFactory factory = TransformerFactory.newInstance();
		Source xslt = new StreamSource(new File(HOME_DIR + "/actions-list.xsl"));
		Transformer transformer = factory.newTransformer(xslt);

		Source text = new StreamSource(new StringReader(actionsXml));
		StringWriter writer = new StringWriter();
		transformer.transform(text, new StreamResult(writer));

		return writer.toString();
	}

	/*
	 * Actions list xml parsing
	 */
	public static String getRenderedActionHistory(String name, String email)
			throws TransformerException, RemoteException {

		PriceActionServiceImplStub stub = new PriceActionServiceImplStub();
		PriceActionServiceImplStub.GetActionHistory params = new PriceActionServiceImplStub.GetActionHistory();
		params.setName(name);
		PriceActionServiceImplStub.GetActionHistoryResponse response = stub.getActionHistory(params);
		String actionsXml = injectUser(email, response.get_return());
		System.out.println(actionsXml);

		TransformerFactory factory = TransformerFactory.newInstance();
		Source xslt = new StreamSource(new File(HOME_DIR + "/action-history.xsl"));
		Transformer transformer = factory.newTransformer(xslt);

		Source text = new StreamSource(new StringReader(actionsXml));
		StringWriter writer = new StringWriter();
		transformer.transform(text, new StreamResult(writer));

		return writer.toString();
	}

	/*
	 * Bourse Actions list xml parsing
	 */
	public static String getRenderedBourseActions(Long id, String email) throws TransformerException, RemoteException {

		PriceActionServiceImplStub stub = new PriceActionServiceImplStub();
		PriceActionServiceImplStub.GetActionsByBourse params = new PriceActionServiceImplStub.GetActionsByBourse();
		params.setId(id);

		PriceActionServiceImplStub.GetActionsByBourseResponse response = stub.getActionsByBourse(params);
		String actionsXml = injectUser(email, response.get_return());
		System.out.println(actionsXml);

		TransformerFactory factory = TransformerFactory.newInstance();
		Source xslt = new StreamSource(new File(HOME_DIR + "/actions-list.xsl"));
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
	 * Login Page
	 */
	public static String getLoginPage(String error) throws TransformerException, RemoteException {

		TransformerFactory factory = TransformerFactory.newInstance();
		Source xslt = new StreamSource(new File(HOME_DIR + "/login.xsl"));
		Transformer transformer = factory.newTransformer(xslt);

		Source text = null;
		if (error == null) {
			text = new StreamSource(new StringReader("<user />"));
		} else {
			text = new StreamSource(new StringReader("<user error='1'/>"));
		}

		StringWriter writer = new StringWriter();
		transformer.transform(text, new StreamResult(writer));

		return writer.toString();
	}

	/*
	 * Login Page
	 */
	public static String getPasswordHash(String password) {

		try {

			MessageDigest md = MessageDigest.getInstance("MD5");
			System.out.println("Password: " + password);
			md.update(password.getBytes());
			byte[] digest = md.digest();
			String passwordHash = DatatypeConverter.printHexBinary(digest);
			return passwordHash;
		} catch (Exception exception) {
			return "";
		}

	}

	/*
	 * Bourse list xml parsing for admins
	 */
	public static String getAdminRenderedBourses(String email, String success, String error)
			throws TransformerException, RemoteException {

		PriceActionServiceImplStub stub = new PriceActionServiceImplStub();
		PriceActionServiceImplStub.GetBourses params = new PriceActionServiceImplStub.GetBourses();
		PriceActionServiceImplStub.GetBoursesResponse response = stub.getBourses(params);
		String boursesXml = injectUser(email, response.get_return());
		System.out.println(boursesXml);

		TransformerFactory factory = TransformerFactory.newInstance();
		Source xslt = new StreamSource(new File(HOME_DIR + "/bourses-list-admin.xsl"));
		Transformer transformer = factory.newTransformer(xslt);

		Source text = null;

		if (success != null) {
			text = new StreamSource(new StringReader(injectSuccess(success, boursesXml)));
		} else if (error != null) {
			text = new StreamSource(new StringReader(injectError(error, boursesXml)));
		} else {
			text = new StreamSource(new StringReader(boursesXml));
		}

		StringWriter writer = new StringWriter();
		transformer.transform(text, new StreamResult(writer));

		return writer.toString();
	}

	/*
	 * Bourse form xml parsing for admins
	 */
	public static String getRenderedBourseForm(Long id, String email, String error)
			throws TransformerException, RemoteException {

		String bourseXml = "";

		if (id != null) {
			PriceActionServiceImplStub stub = new PriceActionServiceImplStub();
			PriceActionServiceImplStub.GetBourse params = new PriceActionServiceImplStub.GetBourse();
			params.setId(id);
			PriceActionServiceImplStub.GetBourseResponse response = stub.getBourse(params);
			params.setId(id);
			bourseXml = injectUser(email, response.get_return());
		} else {
			bourseXml = "<connected-user email='\" + email + \"' />";
		}
		System.out.println(bourseXml);

		TransformerFactory factory = TransformerFactory.newInstance();
		Source xslt = new StreamSource(new File(HOME_DIR + "/bourse-form.xsl"));
		Transformer transformer = factory.newTransformer(xslt);

		// Inject the error in case of error
		Source text = null;
		if (error != null) {
			text = new StreamSource(new StringReader(injectError(error, bourseXml)));
		} else {
			text = new StreamSource(new StringReader(bourseXml));
		}

		// Inject success message

		StringWriter writer = new StringWriter();
		transformer.transform(text, new StreamResult(writer));

		return writer.toString();
	}

	/*
	 * Action form xml parsing for admins
	 */
	public static String getRenderedActionForm(Long id, String email, String error)
			throws TransformerException, RemoteException {

		String actionXml = "";

		if (id != null) {
			PriceActionServiceImplStub stub = new PriceActionServiceImplStub();
			PriceActionServiceImplStub.GetAction params = new PriceActionServiceImplStub.GetAction();
			params.setId(id);
			PriceActionServiceImplStub.GetActionResponse response = stub.getAction(params);
			params.setId(id);
			actionXml = injectUser(email, response.get_return());

			// Inject bourses list message
			actionXml = injectBourses(actionXml, "?>");

		} else {
			actionXml = "<connected-user email='\" + email + \"'></connected-user>";
			// Inject bourses list message
			actionXml = injectBourses(actionXml, "?>");
		}
		System.out.println(actionXml);

		TransformerFactory factory = TransformerFactory.newInstance();
		Source xslt = new StreamSource(new File(HOME_DIR + "/action-form.xsl"));
		Transformer transformer = factory.newTransformer(xslt);

		// Inject the error in case of error
		Source text = null;
		if (error != null) {
			text = new StreamSource(new StringReader(injectError(error, actionXml)));
		} else {
			text = new StreamSource(new StringReader(actionXml));
		}

		StringWriter writer = new StringWriter();
		transformer.transform(text, new StreamResult(writer));

		return writer.toString();
	}

	/*
	 * Update bourse
	 */
	public static boolean updateBourse(Bourse updatedBourse) throws TransformerException, RemoteException {

		PriceActionServiceImplStub stub = new PriceActionServiceImplStub();
		PriceActionServiceImplStub.UpdateBourse params = new PriceActionServiceImplStub.UpdateBourse();
		params.setBourse(updatedBourse);
		PriceActionServiceImplStub.UpdateBourseResponse response = stub.updateBourse(params);
		return response.get_return();
	}

	/*
	 * Update bourse
	 */
	public static boolean updateAction(Action action) throws TransformerException, RemoteException {

		PriceActionServiceImplStub stub = new PriceActionServiceImplStub();
		PriceActionServiceImplStub.UpdateAction params = new PriceActionServiceImplStub.UpdateAction();
		params.setAction(action);
		PriceActionServiceImplStub.UpdateActionResponse response = stub.updateAction(params);
		return response.get_return();
	}

	/*
	 * Persist bourse
	 */
	public static boolean persistBourse(Bourse persistedBourse) throws TransformerException, RemoteException {

		PriceActionServiceImplStub stub = new PriceActionServiceImplStub();
		PriceActionServiceImplStub.AddBourse params = new PriceActionServiceImplStub.AddBourse();
		params.setBourse(persistedBourse);
		PriceActionServiceImplStub.AddBourseResponse response = stub.addBourse(params);
		return response.get_return();
	}

	/*
	 * Persist action
	 */
	public static boolean persistAction(Action persistedAction) throws TransformerException, RemoteException {

		PriceActionServiceImplStub stub = new PriceActionServiceImplStub();
		PriceActionServiceImplStub.AddAction params = new PriceActionServiceImplStub.AddAction();
		params.setAction(persistedAction);
		PriceActionServiceImplStub.AddActionResponse response = stub.addAction(params);
		return response.get_return();
	}

	/*
	 * Delete bourse
	 */
	public static boolean deleteBourse(Long id) throws TransformerException, RemoteException {

		PriceActionServiceImplStub stub = new PriceActionServiceImplStub();
		PriceActionServiceImplStub.DeleteBourse params = new PriceActionServiceImplStub.DeleteBourse();
		params.setId(id);
		PriceActionServiceImplStub.DeleteBourseResponse response = stub.deleteBourse(params);
		return response.get_return();
	}

	/*
	 * Delete action
	 */
	public static boolean deleteAction(Long id) throws TransformerException, RemoteException {

		PriceActionServiceImplStub stub = new PriceActionServiceImplStub();
		PriceActionServiceImplStub.DeleteAction params = new PriceActionServiceImplStub.DeleteAction();
		params.setId(id);
		PriceActionServiceImplStub.DeleteActionResponse response = stub.deleteAction(params);
		return response.get_return();
	}

	/*
	 * Actions list xml parsing for admins
	 */
	public static String getAdminRenderedActions(String email, String success, String error)
			throws TransformerException, RemoteException {

		PriceActionServiceImplStub stub = new PriceActionServiceImplStub();
		PriceActionServiceImplStub.GetActions params = new PriceActionServiceImplStub.GetActions();
		PriceActionServiceImplStub.GetActionsResponse response = stub.getActions(params);
		String actionsXml = injectUser(email, response.get_return());
		System.out.println(actionsXml);

		TransformerFactory factory = TransformerFactory.newInstance();
		Source xslt = new StreamSource(new File(HOME_DIR + "/actions-list-admin.xsl"));
		Transformer transformer = factory.newTransformer(xslt);

		Source text = null;

		if (success != null) {
			text = new StreamSource(new StringReader(injectSuccess(success, actionsXml)));
		} else if (error != null) {
			text = new StreamSource(new StringReader(injectError(error, actionsXml)));
		} else {
			text = new StreamSource(new StringReader(actionsXml));
		}

		StringWriter writer = new StringWriter();
		transformer.transform(text, new StreamResult(writer));

		return writer.toString();
	}

	/*
	 * Actions list xml parsing for admins
	 */
	public static String getRenderedHomePage(String email, String success, String error, String actionName)
			throws TransformerException, RemoteException {

		// Retrieve actions xml from web service
		PriceActionServiceImplStub stub = new PriceActionServiceImplStub();
		PriceActionServiceImplStub.GetActiveActions params = new PriceActionServiceImplStub.GetActiveActions();
		PriceActionServiceImplStub.GetActiveActionsResponse response = stub.getActiveActions(params);
		String actionsXml = injectUser(email, response.get_return());

		// Retrieve bourses from web service
		PriceActionServiceImplStub.GetActiveBourses newParams = new PriceActionServiceImplStub.GetActiveBourses();
		PriceActionServiceImplStub.GetActiveBoursesResponse newResponse = stub.getActiveBourses(newParams);
		String boursesXml = newResponse.get_return();
		boursesXml = boursesXml.substring(boursesXml.indexOf("?>") + 1);
		
		// Retrieve bourses from web service
		PriceActionServiceImplStub.GetBourses parameters = new PriceActionServiceImplStub.GetBourses();
		PriceActionServiceImplStub.GetBoursesResponse res = stub.getBourses(parameters);
		String allBoursesXml = res.get_return();
		allBoursesXml = allBoursesXml.substring(allBoursesXml.indexOf("?>") + 1);

		// Retrieve all action from web service
		PriceActionServiceImplStub.GetActions latestParams = new PriceActionServiceImplStub.GetActions();
		PriceActionServiceImplStub.GetActionsResponse latestResponse = stub.getActions(latestParams);
		String allActionsXml = latestResponse.get_return();
		allActionsXml = allActionsXml.substring(allActionsXml.indexOf("?>") + 1);

		// Inject bourses inside actions + Remove XML head tag
		String homeXml = injectData(actionsXml, boursesXml);
		String xmlNewData = injectData(homeXml, allActionsXml);
		String finalXml = injectData(xmlNewData, allBoursesXml);

		
		if( actionName != null ) {
			PriceActionServiceImplStub.GetActionHistory nsParams = new PriceActionServiceImplStub.GetActionHistory();
			nsParams.setName(actionName);
			PriceActionServiceImplStub.GetActionHistoryResponse nsResponse = stub.getActionHistory(nsParams);
			String xml = nsResponse.get_return();
			xml = xml.substring(xml.indexOf("?>") + 1);
			finalXml = injectData(finalXml, xml);
					
		}
		
		System.out.println(finalXml);
		
		TransformerFactory factory = TransformerFactory.newInstance();
		Source xslt = new StreamSource(new File(HOME_DIR + "/home.xsl"));
		Transformer transformer = factory.newTransformer(xslt);

		Source text = null;

		if (success != null) {
			text = new StreamSource(new StringReader(injectSuccess(success, finalXml)));
		} else if (error != null) {
			text = new StreamSource(new StringReader(injectError(error, finalXml)));
		} else {
			text = new StreamSource(new StringReader(finalXml));
		}

		StringWriter writer = new StringWriter();
		transformer.transform(text, new StreamResult(writer));

		return writer.toString();
	}

}
