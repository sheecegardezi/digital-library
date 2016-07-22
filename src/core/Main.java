package core;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

import algorithums.Algorithum;
import algorithums.CValue;
import datamanipulating.ConstructingXMLFile;
import datamanipulating.DATA61;
import datamanipulating.DatabaseReader;
import datastructures.ResearchPaper;
import utilities.Functions;

public class Main {

	public static void main(String[] args) throws ParserConfigurationException, TransformerException, IOException {
		
		//read the orgnal data
		
		DatabaseReader DR=new DatabaseReader();
		
		ArrayList<String> noisyWords=new ArrayList<String>();
		for(ResearchPaper research_paper:DR.getResearchPapers()){
			

			for(String word:research_paper.getWord_vector()){
				
				if(!Functions.isAlpha(word)){
					noisyWords.add(word);
				}
			}
			
		}
		
		Functions.createFile(Constants.FILE_PATH_NOISY_DATA, noisyWords);
		
		//create XML database of papers
		ConstructingXMLFile CXML=new ConstructingXMLFile();
		CXML.buildXMLDatabase(Constants.FILE_PATH_DATABASE_XML,DR.getResearchPapers());
		
		//Automatic term extraction (ATR) 
//		Algorithum cvalue = new CValue(DR.getResearchPapers());
//		String keywords= cvalue.getkeywords();
	}
}
