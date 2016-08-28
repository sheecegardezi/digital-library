package core;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import datastructures.ResearchPaper;
import utilities.Functions;

public class Main {
	public static void main(String[] args)
			throws ClassNotFoundException, ParserConfigurationException, TransformerException, IOException {
		// its going to read all the csv and store them in batches files in
		// processing
		// only yhe abstract is used to partition into words
		 datamanipulating.Main DataReader = new datamanipulating.Main();

		// read one of the reasceh paer and display

		for (String fileName : Functions.getFilesInDirectory(Constants.BATCH_FILE_DIRECTORY)) {

			ArrayList<ResearchPaper> researchPapers = Serilaze.io.read(fileName);

			for (ResearchPaper researchPaper : researchPapers) {
					System.out.println(researchPaper.getWord_vector());


			}
		}

		// read the each data structure and display the words in a file
		// for me to review the quality of the tokens
		// use it to form the input of java machine learning class
		// evaluate the clusters
		// i need to download the newsgroup and first try to cluster them
		// once i get some preformace meause of the news group them i need to
		// adavance
		// get the start of art algorithums understand hoe they work
		// once i can get some sort of clustering start work on the visuliztions


		// create XML database of papers
		// ConstructingXMLFile CXML=new ConstructingXMLFile();
		// CXML.buildXMLDatabase(Constants.FILE_PATH_DATABASE_XML,DR.getResearchPapers());

		// Automatic term extraction (ATR)
		// Algorithum cvalue = new CValue(DR.getResearchPapers());
		// String keywords= cvalue.getkeywords();

	}

}