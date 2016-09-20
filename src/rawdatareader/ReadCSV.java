package rawdatareader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

import core.Constants;
import datastructures.ResearchPaper;
import utilities.Functions;

public class ReadCSV {

	int id;
	String title;
	ArrayList<String> authors;
	ArrayList<String> keywords;
	String abstracts;
	String date;
	String publisher;

	Reader reader;
	CsvParserSettings settings;
	CsvParser parser;

	ArrayList<ResearchPaper> ResearchPapers;
	Logger logger;
	
	
	int batchNo;

	public ReadCSV(HandlingDatabase database,int batchSize) throws IOException {

		id=Integer.parseInt(Functions.getCurrentID());

		authors = new ArrayList<String>();
		keywords = new ArrayList<String>();
		ResearchPapers = new ArrayList<ResearchPaper>();
		
		batchNo=0;
		
		logger = LogManager.getRootLogger();

		CsvParserSettings settings = new CsvParserSettings();
		settings.setMaxCharsPerColumn(20000);
		settings.getFormat().setLineSeparator("\r");
		settings.setHeaderExtractionEnabled(true);
		CsvParser parser = new CsvParser(settings);

		List<Record> allRecords = parser.parseAllRecords(new FileReader(database.getCSVFilePath()));
		// parser.getRecordMetadata().setDefaultValueOfColumns("0", "Year");

		int counter = 0;
		for (Record record : allRecords) {

			counter++;
			if (counter % 500 == 0) {
				logger.info("Number of Records Read:" + counter + "/" + allRecords.size());
			}
			
			if(counter%batchSize==0){
				int batchNo=Integer.parseInt(Functions.getCurrentBatchNumber());
				batchNo=batchNo+1;
				
				String fileName=Constants.BATCH_FILE_DIRECTORY+batchNo+".ser";
				Serilaze.io.write(ResearchPapers, fileName);

				Functions.setCurrentBatchNumber(batchNo+"");
				ResearchPapers=new ArrayList<ResearchPaper>();
			}

			id = id+1;


			title = record.getString(database.getTitleFieldName());
			if(title==null){
				title="";
			}
			authors.add(record.getString(database.getAuthorsFieldName()));
			keywords.add(record.getString(database.getKeywordsFieldName()));
			abstracts = record.getString(database.getAbstractsFieldName());
			if(abstracts==null){
				abstracts="";
			}
			date = record.getString(database.getDateFieldName());
			publisher = database.getPublisher();

			ResearchPaper research_paper = new ResearchPaper(id+"", title, authors, keywords, abstracts, date, publisher);
			
			//conditions to ignore the paper
			if(title.length()>5||abstracts.length()>20||date.length()>2){
				ResearchPapers.add(research_paper);	
			}
			

		}
		
		//save the data from the last batch
		int batchNo=Integer.parseInt(Functions.getCurrentBatchNumber());
		batchNo=batchNo+1;
		
		String fileName=Constants.BATCH_FILE_DIRECTORY+batchNo+".ser";
		Serilaze.io.write(ResearchPapers, fileName);

		Functions.setCurrentBatchNumber(batchNo+"");
		ResearchPapers=new ArrayList<ResearchPaper>();

		parser.stopParsing();
		Functions.setCurrentID(id+"");

	}// end reading and writing data to dataStructure

	public static void main(String[] args) throws ClassNotFoundException, ParserConfigurationException, TransformerException, IOException{
//		HandlingDatabase data61 = new DATA61();
//		HandlingDatabase microsoft = new MICROSOFT();
//		HandlingDatabase google = new GOOGLE();
//		HandlingDatabase jmlr = new JMLR();
//		
//		ReadCSV DR = new ReadCSV(data61, Constants.BATCH_SIZE);

	}
}
