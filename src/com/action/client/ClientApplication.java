package com.action.client;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.StringReader;
import java.rmi.RemoteException;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import com.action.service.PriceActionServiceImplStub;

public class ClientApplication {
	 
	public static void main(String[] args) throws RemoteException, FileNotFoundException, TransformerException {

		PriceActionServiceImplStub stub = new PriceActionServiceImplStub();
		PriceActionServiceImplStub.GetBourse params = new PriceActionServiceImplStub.GetBourse();
		params.setId(1);
		PriceActionServiceImplStub.GetBourseResponse response = stub.getBourse(params);
		String bourseXml = response.get_return();
		System.out.println(bourseXml);
		
	 
	    TransformerFactory factory = TransformerFactory.newInstance();
        Source xslt = new StreamSource(new File("WebContent/home.xsl"));
        Transformer transformer = factory.newTransformer(xslt);

        Source text = new StreamSource(new StringReader(bourseXml));
        transformer.transform(text, new StreamResult(System.out));
	}

}
