package core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import datamanipulating.DatabaseReader;
import datastructures.ResearchPaper;
import utilities.Functions;

public class Main {

	public static void main(String[] args) throws ParserConfigurationException, TransformerException, IOException {

		System.setProperty("log4j.configurationFile", Constants.FILE_PATH_LOG_CONFIG);
		Logger logger = LogManager.getRootLogger();

		// logger.error("testing ERROR level");
		// logger.debug("testing ERROR level");
		// logger.info("testing ERROR level");
		// logger.trace("testing ERROR level");

		// read the orgnal data

		logger.debug("Reading Database.........");
		DatabaseReader DR = new DatabaseReader();

		// Map<String, Set<String> > dic = Functions.loadVocabulary();

		ArrayList<String> temp = new ArrayList<String>();
		ArrayList<String> noisyWords = new ArrayList<String>();
		ArrayList<String> keyWords = new ArrayList<String>();

		String previousWord = "";
		String nextWord = "";
		String currentWord = "";

		int counter = 0;

		// logger.debug("Writing data on the file.........");
		// Serilaze.io.read("");

		logger.debug("Seperating Noise and Keywords.........");
		for (ResearchPaper research_paper : DR.getResearchPapers()) {
			counter++;
			if (counter % 500 == 0) {
				logger.info("Number of itrations:" + counter + "/" + DR.getResearchPapers().size());
				Functions.removeDuplicates(noisyWords);
				Functions.removeDuplicates(keyWords);
				Functions.removeDuplicates(temp);
			}

			for (int i = 0; i < research_paper.getWord_vector().size(); i++) {

				currentWord = research_paper.getWord_vector().get(i);

				currentWord=Functions.standard_cleaning(currentWord);
				
				if (Functions.isNonAlpha(currentWord)) {
					
					noisyWords.add(currentWord);
					
				} else if (Functions.isHypenAtRightEnd(currentWord)) {
					if (i + 1 < research_paper.getWord_vector().size()) {
						nextWord = research_paper.getWord_vector().get(i + 1);
						currentWord = currentWord + nextWord;
						temp.add(currentWord);
					} else {
						temp.add(currentWord.substring(0, currentWord.length() - 1));
					}

				} else if (Functions.isHypenAtLeftEnd(currentWord)) {
					if (i - 1 < 0) {
						previousWord = research_paper.getWord_vector().get(i - 1);
						currentWord = previousWord+currentWord;
						temp.add(currentWord);
					} else {
						temp.add(currentWord.substring(1, currentWord.length()));
					}

				} else if (Functions.isAlphaAndHypen(currentWord)) {
					temp.add(currentWord);
				} else if (Functions.isAlphaAndHypenExpLastChar(currentWord)) {
					temp.add(currentWord.substring(0, currentWord.length() - 1));

				} else if (Functions.isAlpha(currentWord)) {
					keyWords.add(currentWord);

				} else if (Functions.isAlphaExpectLastChar(currentWord)) {
					keyWords.add(currentWord.substring(0, currentWord.length() - 1));

				} else {
					noisyWords.add(currentWord);
				}

			}
		}

		Functions.createFile(Constants.FILE_PATH_NOISY_DATA, noisyWords);
		Functions.createFile(Constants.FILE_PATH_KEY_WORDS_DATA, keyWords);
		Functions.createFile(Constants.FILE_PATH_KEY_TEMP_DATA, temp);

		// create XML database of papers
		// ConstructingXMLFile CXML=new ConstructingXMLFile();
		// CXML.buildXMLDatabase(Constants.FILE_PATH_DATABASE_XML,DR.getResearchPapers());

		// Automatic term extraction (ATR)
		// Algorithum cvalue = new CValue(DR.getResearchPapers());
		// String keywords= cvalue.getkeywords();
	}
}
