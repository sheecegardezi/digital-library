package core;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

import datamanipulating.ConstructingXMLFile;
import datamanipulating.DATA61;
import datamanipulating.DatabaseReader;
import datastructures.ResearchPaper;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, ParserConfigurationException, TransformerException {
		
		//read the orgnal data
		
		DatabaseReader DR=new DatabaseReader();
		int counter =1;
		
		for(ResearchPaper research_paper:DR.getResearchPapers()){
			if(counter ==362){
				System.out.println(research_paper);
				break;
			}
			counter++;
			
		}
		
		//create XML database of papers
		ConstructingXMLFile CXML=new ConstructingXMLFile();
		CXML.buildXMLDatabase(Constants.FILE_PATH_DATABASE_XML,DR.getResearchPapers());
	}
}
