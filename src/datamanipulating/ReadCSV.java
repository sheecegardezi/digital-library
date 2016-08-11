package datamanipulating;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

import datastructures.ResearchPaper;
import utilities.Functions;

public class ReadCSV {

	String id = Functions.getCurrentID();
	String title;
	ArrayList<String> authors = new ArrayList<String>();
	ArrayList<String> keywords = new ArrayList<String>();
	String abstracts;
	String date;
	String publisher;

	Reader reader;
	CsvParserSettings settings;
	CsvParser parser;

	ArrayList<ResearchPaper> ResearchPapers;

	public ReadCSV(HandlingDatabase database) throws IOException {

		ResearchPapers = new ArrayList<ResearchPaper>();
		Logger logger = LogManager.getRootLogger();

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
			title = record.getString(database.getTitleFieldName());
			authors.add(record.getString(database.getAuthorsFieldName()));
			keywords.add(record.getString(database.getKeywordsFieldName()));
			abstracts = record.getString(database.getAbstractsFieldName());
			date = record.getString(database.getDateFieldName());
			publisher = database.getPublisher();

			ResearchPaper research_paper = new ResearchPaper(id, title, authors, keywords, abstracts, date, publisher);
			ResearchPapers.add(research_paper);

		}
		parser.stopParsing();
		Functions.setCurrentID(id);

	}// end reading and writing data to datastructure

	public ArrayList<ResearchPaper> getResearchPapers() {
		return ResearchPapers;
	}

	String getNewID() {

		// increment the value of the id and then return the incremented value
		this.id = Integer.toString(Integer.parseInt(this.id) + 1);
		return this.id;
	}

}
