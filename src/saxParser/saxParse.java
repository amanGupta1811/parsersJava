package saxParser;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.graalvm.compiler.debug.JavaMethodContext;
import org.w3c.dom.Document;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.bind.JAXBContext;


public class saxParse {

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		// TODO Auto-generated method stub
		String newFile = "./src/saxParser/emplooye.xml";
		
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser = factory.newSAXParser();
		DefaultHandler handler = new DefaultHandler() {
		    
		boolean name = false;
		boolean age = false;
		boolean gpa = false;
		
   public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
			if(qName.equalsIgnoreCase("name")) {
				name = true;
			}
			if(qName.equalsIgnoreCase("age")) {
				age = true;
			}
			if(qName.equalsIgnoreCase("gpa")) {
				gpa=false;
			}
		}
		
		public void endElement(String uri, String localName, String qName) throws SAXException{
			
		}
		public void characters(char ch[], int start, int length) throws SAXException{
			if(name) {
				System.out.println("Name "+ new String(ch, start, length));
				name=false;
			}
			if(age) {
				System.out.println("Age "+ new String(ch, start, length));
				age=false;
			}
			if(gpa) {
				System.out.println("Gpa "+ new String(ch, start, length));
				gpa=false;
			}
		}
		
		};
		
	saxParser.parse("./src/saxParser/student.xml",handler);
		
		
      
	}
}

		
		
		
	


