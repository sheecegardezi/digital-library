package core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

import com.univocity.parsers.csv.CsvParserSettings;
import com.univocity.parsers.csv.CsvWriter;
import com.univocity.parsers.csv.CsvWriterSettings;

import datastructures.ResearchPaper;

public class Writter {
	
	CsvWriter writer;
	ByteArrayOutputStream csvResult;
	
	public Writter(){
		   // All you need is to create an instance of CsvWriter with the default CsvWriterSettings.
	    // By default, only values that contain a field separator are enclosed within quotes.
	    // If quotes are part of the value, they are escaped automatically as well.
	    // Empty rows are discarded automatically.
		
	    CsvWriterSettings settings = new CsvWriterSettings();		

	    settings.setMaxCharsPerColumn(20000);
		settings.getFormat().setLineSeparator("\r");

		csvResult = new ByteArrayOutputStream();
		Writer outputWriter = new OutputStreamWriter(csvResult);
		
	    writer = new CsvWriter(outputWriter, settings);
	    writer.writeHeaders("Id", "Title", "Authors", "Keywords", "Abstracts","Date","Publisher","WordVector");

		
//	    System.out.println(csvResult.toString());
	}
	

	void addRowToWritter(ResearchPaper researchPaper){
		

		
		writer.addValue("Id", researchPaper.getId());
		writer.addValue("Title", researchPaper.getTitle());
		
		String newString="";
		for(String word: researchPaper.getAuthors()){
			newString+=", "+word;
		}
		writer.addValue("Authors", newString);

		newString="";
		for(String word: researchPaper.getKeywords()){
			newString+=", "+word;
		}
		writer.addValue("Keywords", 100.0);
		
		writer.addValue("Abstracts", 100.0);
		writer.addValue("Date", 100.0);
		writer.addValue("Publisher", 100.0);
		
		newString="";
		for(String word: researchPaper.getWord_vector()){
			newString+=", "+word;
		}
		writer.addValue("WordVector", newString);
		writer.writeValuesToRow();

	}
	
	public void WriteToFile(String fileName) throws IOException {

		BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName));
		fileWriter.write(csvResult.toString());
		fileWriter.close();
		
	    writer.close();
	    csvResult.close();

	}

	public static String getCurrentID() throws IOException {

		BufferedReader br = new BufferedReader(new FileReader(Constants.FILE_PATH_RUNNING_ID));
		String line = br.readLine();
		br.close();

		return line.trim();
	}

}
