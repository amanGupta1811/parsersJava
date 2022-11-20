package domParser;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class domParse {

	public static void main(String[] args) {
		
		 try {
				String filePath = "./src/domParser/student.xml";
				String newFilePath = "./src/domParser/emplooye.xml";
				String emplooyes="emplooye";
				
		        File inputFile = new File(filePath);
		
				DocumentBuilderFactory dbFactory = 
		                                   DocumentBuilderFactory.newInstance();
		 
				
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		 
				Document document = dBuilder.parse(inputFile);
		 
				Node students = document.getElementsByTagName("student").item(0);

				document.renameNode(students, null, emplooyes);
				
				
				NodeList list = students.getChildNodes();
		 
				for (int temp = 0; temp < list.getLength(); temp++) {
				  Node node = list.item(temp);
				  if (node.getNodeType() == Node.ELEMENT_NODE) {
				    if ("gpa".equals(node.getNodeName())) {
					      students.removeChild(node);
					       }			
				    }
				}
		 
				TransformerFactory transformerFactory = 
					          TransformerFactory.newInstance();
				Transformer transformer=
		                               transformerFactory.newTransformer();
				DOMSource source = new DOMSource(document);
				StreamResult result=new StreamResult(new File(newFilePath));
				transformer.transform(source, result);
		 
				StreamResult consoleResult = new StreamResult(System.out);
				transformer.transform(source, consoleResult);	
			      } catch (Exception e) {
				   e.printStackTrace();
			   }
		
	}

}
