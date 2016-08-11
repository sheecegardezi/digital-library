package datamanipulating;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

import core.Constants;
import datastructures.ResearchPaper;
import utilities.Functions;

public class DatabaseReader {

	Reader reader;
	CsvParserSettings settings;
	CsvParser parser;

	ArrayList<ResearchPaper> ResearchPapers;

	private HandlingDatabase data61;
	private HandlingDatabase microsoft;
	private HandlingDatabase google;
	private HandlingDatabase jmlr;

	public DatabaseReader() throws IOException {

		data61 = new DATA61();
		microsoft = new MICROSOFT();
		google = new GOOGLE();
		jmlr = new JMLR();

		ResearchPapers = new ArrayList<ResearchPaper>();
		
		Logger logger = LogManager.getRootLogger();
		logger.debug("Opening CSV File.........");		
		
		ReadCSV csv_reader1 = new ReadCSV(data61);
		ResearchPapers.addAll(csv_reader1.getResearchPapers());

//		FileOutputStream fileOut = new FileOutputStream("./res/test/rp.ser");
//		ObjectOutputStream out = new ObjectOutputStream(fileOut);
//		out.writeObject(ResearchPapers);
//		out.close();
//		fileOut.close();
//		logger.debug("Serialized data is saved in ./res/test/rp.ser");		

//		ReadCSV csv_reader2 = new ReadCSV(microsoft);
//		ResearchPapers.addAll(csv_reader2.getResearchPapers());
//
//		ReadCSV csv_reader3 = new ReadCSV(google);
//		ResearchPapers.addAll(csv_reader3.getResearchPapers());
//
//		ReadCSV csv_reader4 = new ReadCSV(jmlr);
//		ResearchPapers.addAll(csv_reader4.getResearchPapers());
	}

	public ArrayList<ResearchPaper> getResearchPapers() {
		return ResearchPapers;
	}

	public static void main(String[] args) throws IOException {

		Functions.setCurrentID("0");
		DatabaseReader DR = new DatabaseReader();

		for (ResearchPaper research_paper : DR.getResearchPapers()) {
			System.out.println(research_paper);
			break;

		}
	}

}
