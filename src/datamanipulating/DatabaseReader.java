package datamanipulating;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;

import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

import core.Constants;
import datastructures.ResearchPaper; 

public class DatabaseReader {
	
	Reader reader;
	CsvParserSettings settings;
	CsvParser parser;

	 ArrayList<ResearchPaper> ResearchPapers;

	
	private HandlingDatabase data61;

	int id;
	
	String getNewID(){
		id=id+1;
		return Integer.toString(id);
	}
	public DatabaseReader() throws FileNotFoundException{

		id=0;
		data61=new DATA61("title","authors","keywords","abstract","updated_at");
		ResearchPapers=new ArrayList<ResearchPaper>();
	
		
	    reader = new FileReader(Constants.FILE_PATH_DATA61_CSV);
	    settings = new CsvParserSettings();
	    
		//the file used in the example uses '\n' as the line separator sequence.
		//the line separator sequence is defined here to ensure systems such as MacOS and Windows
		//are able to process this file correctly (MacOS uses '\r'; and Windows uses '\r\n').
		settings.getFormat().setLineSeparator("\r");
		settings.setMaxCharsPerColumn(99999);
		// configure to grab headers from file. We want to use these names to get values from each record.
		settings.setHeaderExtractionEnabled(true);

		// creates a CSV parser
		parser = new CsvParser(settings);
		
		ResearchPapers=new ArrayList<ResearchPaper>();
		readCSVFile(data61);

	}
	
	public void readCSVFile(HandlingDatabase database){
		
		
		// call beginParsing to read records one by one, iterator-style.
		parser.beginParsing(reader);
		
		//among many other things, we can set default values of one ore more columns in the record metadata.
		//Let's again set year to 2000 if it comes as null.
		//parser.getRecordMetadata().setDefaultValueOfColumns(2000, "year");

		parser.getRecordMetadata().setDefaultValueOfColumns("NA", "title");
		parser.getRecordMetadata().setDefaultValueOfColumns("NA", "authors");
		parser.getRecordMetadata().setDefaultValueOfColumns("NA", "keywords");
		parser.getRecordMetadata().setDefaultValueOfColumns("NA", "abstract");
		parser.getRecordMetadata().setDefaultValueOfColumns("1990","updated_at");
		
		Record record; 
		while ((record = parser.parseNextRecord()) != null) {
		
			
			String Id=getNewID();
			String Title=database.getFormatedTitle(record.getValue("title", null));
			ArrayList<String> Authors=database.getFormatedAuthors(record.getString("authors"));
			ArrayList<String> Keywords=database.getFormatedKeywords(record.getString("keywords"));
			String Abstract=database.getFormatedAbstract(record.getString("abstract"));
			String Date=database.getFormatedDate(record.getString("updated_at"));
			String Publisher=database.getPublisher();
			ResearchPaper research_paper=new ResearchPaper(Id,Title,Authors,Keywords,Abstract,Date,Publisher);

			ResearchPapers.add(research_paper);
		}

		//close the reader
		parser.stopParsing();

	}//end reading and writing data to datastructure

	public ArrayList<ResearchPaper>  getResearchPapers() {
		return ResearchPapers;
	}

	public static void main(String[] args) throws FileNotFoundException {
	
		DatabaseReader DR=new DatabaseReader();
		
		int counter=0;
		for(ResearchPaper research_paper:DR.getResearchPapers()){
			if(counter ==361){
				System.out.println(research_paper);
				break;
			}
			counter++;
			
		}
	}

}
