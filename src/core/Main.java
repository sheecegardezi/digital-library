package core;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import algorithums.Algorithum;
import algorithums.CValue;
import datamanipulating.ConstructingXMLFile;
import datamanipulating.DATA61;
import datamanipulating.DatabaseReader;
import datastructures.ResearchPaper;
import utilities.Functions;

public class Main {

	public static void main(String[] args) throws ParserConfigurationException, TransformerException, IOException {
		
		
    	System.setProperty("log4j.configurationFile",Constants.FILE_PATH_LOG_CONFIG);
    	Logger logger = LogManager.getRootLogger();

    	logger.error("testing ERROR level");
    	logger.debug("testing ERROR level");
    	logger.info("testing ERROR level");
    	logger.trace("testing ERROR level");
    	
		//read the orgnal data
		
		DatabaseReader DR=new DatabaseReader();
		
		ArrayList<String> noisyWords=new ArrayList<String>();

		String previousWord="";
		String nextWord="";
		String currentWord="";
		
		int counter=0;
		for(ResearchPaper research_paper:DR.getResearchPapers()){
			counter++;

	    	logger.info("Number of itrations: "+counter+"/"+DR.getResearchPapers().size());

			for(int i=0;i<research_paper.getWord_vector().size();i++){
				
				currentWord=research_paper.getWord_vector().get(i);
				
				//get all the words  that are capital
				
				if(!Functions.isAlpha(currentWord)){
					previousWord="";
					nextWord="";
					
					if((i-1)>0){
						previousWord=research_paper.getWord_vector().get(i-1);
					}
					if((i+1)<research_paper.getWord_vector().size()){
						nextWord=research_paper.getWord_vector().get(i+1);
					}
					
					noisyWords.add(previousWord+" "+currentWord+" "+nextWord);
			    	logger.trace(noisyWords.size());
				}
			}
		}
		
		Functions.createFile(Constants.FILE_PATH_NOISY_DATA, noisyWords);
		
		//create XML database of papers
		//ConstructingXMLFile CXML=new ConstructingXMLFile();
		//CXML.buildXMLDatabase(Constants.FILE_PATH_DATABASE_XML,DR.getResearchPapers());
		
		//Automatic term extraction (ATR) 
//		Algorithum cvalue = new CValue(DR.getResearchPapers());
//		String keywords= cvalue.getkeywords();
	}
}
