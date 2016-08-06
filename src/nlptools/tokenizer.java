package nlptools;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import core.Constants;
import datamanipulating.DatabaseReader;
import datastructures.ResearchPaper;

public class tokenizer {

	

	public static void addWordsToWordVector(String text, ArrayList<String> word_vector) {

		for(String word:text.split("\\s+")){
			word_vector.add(word);
		};		
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		
		DatabaseReader DR=new DatabaseReader();
		String currentWord="";
    	System.setProperty("log4j.configurationFile",Constants.FILE_PATH_LOG_CONFIG);
    	Logger logger = LogManager.getRootLogger();
		ArrayList<String> vocabulary=new ArrayList<String>();

		for(ResearchPaper research_paper:DR.getResearchPapers()){

			for(int i=0;i<research_paper.getWord_vector().size();i++){
				currentWord=research_paper.getWord_vector().get(i);

				for(String voc:currentWord.split("([A-Z]+)")){

					vocabulary.add(voc);
			    	logger.debug(voc);
			    		
				}}
			}
		
	}


}
