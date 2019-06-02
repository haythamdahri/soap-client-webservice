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

import com.action.service.PriceActionServiceImplStub;

public class HomeUtils {

	private static final String HOME_DIR = "/root/eclipse-workspace/Currency-client/WebContent";
	
	/*
	 * First test case 
	 */
	public static String getRenderedBourse() throws TransformerException, RemoteException {
				
		PriceActionServiceImplStub stub = new PriceActionServiceImplStub();
		PriceActionServiceImplStub.GetBourse params = new PriceActionServiceImplStub.GetBourse();
		params.setId(1);
		PriceActionServiceImplStub.GetBourseResponse response = stub.getBourse(params);
		String bourseXml = response.get_return();
		System.out.println(bourseXml);
		
	 
	    TransformerFactory factory = TransformerFactory.newInstance();
        Source xslt = new StreamSource(new File(HOME_DIR  + "/home.xsl"));
        Transformer transformer = factory.newTransformer(xslt);

        Source text = new StreamSource(new StringReader(bourseXml));
        StringWriter writer = new StringWriter();
        transformer.transform(text, new StreamResult(writer));
        
        return writer.toString();
	}
	
}
