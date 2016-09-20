package datamanipulating;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import datastructures.ResearchPaper;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;

public class ConstructingXMLFile {
	
    DocumentBuilderFactory dbFactory;
    DocumentBuilder dBuilder;
    Document xmlFile;
    
    // root element
    Element rootElement;
    
		// write the content into xml file
    TransformerFactory transformerFactory;
    Transformer transformer;

    DOMSource source;
    

    public ConstructingXMLFile() throws TransformerConfigurationException, ParserConfigurationException{
        dbFactory = DocumentBuilderFactory.newInstance();
        dBuilder = dbFactory.newDocumentBuilder();
        xmlFile = dBuilder.newDocument();
        
        // root element
        rootElement = xmlFile.createElement("add");
        xmlFile.appendChild(rootElement);
        
 		// write the content into xml file
        transformerFactory =TransformerFactory.newInstance();
        transformer =transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        source = new DOMSource(xmlFile);
        
    }

	static void addField(Document xmlFile,Element document_element,String name, String value){
		
		Element field_element = xmlFile.createElement("field");
        
        Attr attrType = xmlFile.createAttribute("name");
        attrType.setValue(name);
        field_element.setAttributeNode(attrType);
        field_element.appendChild(xmlFile.createTextNode(value));
        
        document_element.appendChild(field_element);
	}
	static void addDocument(Document xmlFile, Element rootElement,Element document_element,ResearchPaper research_paper){
		

		
		addField(xmlFile,document_element,"id",research_paper.getId());
		
		for(String author_name:research_paper.getAuthors()){
			addField(xmlFile,document_element,"author",author_name);			
		}
		addField(xmlFile,document_element,"title",research_paper.getTitle());

		
		for(String keyword:research_paper.getKeywords()){
			addField(xmlFile,document_element,"keyword",keyword);			
		}
		
		addField(xmlFile,document_element,"abstract",research_paper.getAbstract());
		addField(xmlFile,document_element,"date",research_paper.getDate());
		addField(xmlFile,document_element,"publisher",research_paper.getPublisher());
	}

	public void buildXMLDatabase(String outputFileName,ArrayList<ResearchPaper> research_papers) throws TransformerException{

 		for(ResearchPaper research_paper:research_papers){
 	        Element document_element = xmlFile.createElement("doc");
 			addDocument( xmlFile,  rootElement, document_element, research_paper);
 		    rootElement.appendChild(document_element);
 		    StreamResult result =new StreamResult(new File(outputFileName));
 		    transformer.transform(source, result);
      } 
	}
	
	
	public static void main(String[] args) throws FileNotFoundException {
		

			
	}
}
