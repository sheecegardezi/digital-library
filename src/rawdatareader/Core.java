package rawdatareader;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import core.Constants;
import datastructures.ResearchPaper;
import datastructures.Word;
import utilities.Functions;

public class Core {
	static ReadCSV DR;

	public Core() throws ParserConfigurationException, TransformerException, IOException, ClassNotFoundException {

		System.setProperty("log4j.configurationFile", Constants.FILE_PATH_LOG_CONFIG);
		Logger logger = LogManager.getRootLogger();

		Functions.setCurrentID("0");
		Functions.setCurrentBatchNumber("0");

		HandlingDatabase data61 = new DATA61();
		HandlingDatabase microsoft = new MICROSOFT();
		HandlingDatabase google = new GOOGLE();
		HandlingDatabase jmlr = new JMLR();

		logger.debug("Reading Database.........");
		DR = new ReadCSV(data61, Constants.BATCH_SIZE);
		DR = new ReadCSV(microsoft, Constants.BATCH_SIZE);
		DR = new ReadCSV(google, Constants.BATCH_SIZE);
		DR = new ReadCSV(jmlr, Constants.BATCH_SIZE);
		// logger.error("testing ERROR level");
		// logger.debug("testing ERROR level");
		// logger.info("testing ERROR level");
		// logger.trace("testing ERROR level");

		logger.debug("Tokenize Abstract.........");

		for (String fileName : Functions.getFilesInDirectory(Constants.BATCH_FILE_DIRECTORY)) {

			ArrayList<ResearchPaper> researchPapers = Serilaze.io.read(fileName);

			
			
			for (ResearchPaper researchPaper : researchPapers) {

				
				String text = researchPaper.getAbstract();

				for(String potentialWord:standfordnlp.utlities.getTokens(text)){
					if(	wordnet.Utlities.isWordCorrect(potentialWord)){
						researchPaper.addWord_vector(potentialWord);
					}
				}
				text = researchPaper.getKeyword();

				for(String potentialWord:standfordnlp.utlities.getTokens(text)){
					if(	wordnet.Utlities.isWordCorrect(potentialWord)){
						researchPaper.addWord_vector(potentialWord);
					}
				}
				text = researchPaper.getTitle();

				for(String potentialWord:standfordnlp.utlities.getTokens(text)){
					if(	wordnet.Utlities.isWordCorrect(potentialWord)){
						researchPaper.addWord_vector(potentialWord);
					}
				}

			}
			Serilaze.io.write(researchPapers, fileName);
		}
	}
	
	public static void main(String[] args) throws ClassNotFoundException, ParserConfigurationException, TransformerException, IOException
	{
		 rawdatareader.Core DataReader = new rawdatareader.Core();

	}
}
