package core;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import com.univocity.parsers.csv.CsvWriter;
import com.univocity.parsers.csv.CsvWriterSettings;

import datastructures.ResearchPaper;
import utilities.Functions;

public class Main {
	public static void main(String[] args)
			throws ClassNotFoundException, ParserConfigurationException, TransformerException, IOException {
		// its going to read all the csv and store them in batches files in
		// processing
		// only yhe abstract is used to partition into words
		 rawdatareader.Core Reader = new rawdatareader.Core();

		// read one of the research paper and display

		File csvFile = new File("res/dataCSV/test.csv","");
		Writer out = new FileWriter(csvFile);
		
		
		CsvWriterSettings settings = new CsvWriterSettings();		

	    settings.setMaxCharsPerColumn(20000);
		settings.getFormat().setLineSeparator("\r");

		
		CsvWriter writer = new CsvWriter(out, settings);
	    writer.writeHeaders("Id", "Title", "Authors", "Keywords", "Abstracts","Date","Publisher","WordVector");
	    
		
		int counter=0;
		System.out.println("Its on!");
		for (String fileName : Functions.getFilesInDirectory(Constants.BATCH_FILE_DIRECTORY)) {


			ArrayList<ResearchPaper> researchPapers = Serilaze.io.read(fileName);
			counter=counter+1;
			System.out.println("Its on!");


			if(counter<11)
				continue;
			for (ResearchPaper researchPaper : researchPapers) {
				System.out.println(researchPaper);

				
				
				writer.addValue("Id", researchPaper.getId());
				System.out.println(researchPaper.getId());

				writer.addValue("Title", researchPaper.getTitle());
				System.out.println(researchPaper.getTitle());

				
				String newString="";
				for(String word: researchPaper.getAuthors()){
					newString+=", "+word;
				}
				System.out.println(newString);

				writer.addValue("Authors", newString);

				newString="";
				for(String word: researchPaper.getKeywords()){
					newString+=", "+word;
				}
				writer.addValue("Keywords", newString);
				System.out.println(newString);

				writer.addValue("Abstracts", researchPaper.getAbstract());
				System.out.println(researchPaper.getAbstract());

				writer.addValue("Date", researchPaper.getDate());
				System.out.println(researchPaper.getDate());

				writer.addValue("Publisher", researchPaper.getPublisher());
				System.out.println(researchPaper.getPublisher());

				
				newString="";
				for(String word: researchPaper.getWord_vector()){
					newString+=", "+word;
				}
				writer.addValue("WordVector", newString);
				System.out.println(newString);

				writer.writeValuesToRow();
			
	
			    writer.close();
			   
			    System.exit(0);
			    
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