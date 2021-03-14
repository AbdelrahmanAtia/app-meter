package com.javaworld.application.util;

import java.io.StringReader;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Node;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.InputSource;

public class XmlUtil {

	public static String prettyFormat(String xmlStr) {
		try {
			final InputSource src = new InputSource(new StringReader(xmlStr));
			final Node document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(src)
					.getDocumentElement();

			final DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
			final DOMImplementationLS impl = (DOMImplementationLS) registry.getDOMImplementation("LS");
			final LSSerializer writer = impl.createLSSerializer();

			writer.getDomConfig().setParameter("format-pretty-print", Boolean.TRUE); // Set this to true if the output

			//return Arrays.asList(writer.writeToString(document).split("\n"));
			return writer.writeToString(document);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
	
	public static boolean containsXmlData(String str) {
		
		//count number of opening and closing brackets
		// and returns true if each of them greater than or equal 4
		
		int openingBracketCounter = 0;
		int closingBracketCounter = 0;
		
		char[] chars = str.toCharArray();
		for(Character ch : chars) {
			if(ch == '>') {
				openingBracketCounter++;
			}
			
			if(ch == '<') {
				closingBracketCounter++;
			}
			
			if(openingBracketCounter >= 4 && closingBracketCounter >= 4) {
				return true;
			}
		}		
		return false;
	}
	
}
