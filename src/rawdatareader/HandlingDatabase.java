package datamanipulating;

import java.io.Reader;
import java.util.ArrayList;

import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

import datastructures.ResearchPaper;

public interface HandlingDatabase {


	String getCSVFilePath();
	String getFormatedTitle(String potentialTitle);
	ArrayList<String> getFormatedAuthors(String potentialAuthors);
	ArrayList<String> getFormatedKeywords(String potentialKeywords);
	String getFormatedAbstract(String potentialAbstract);
	String getFormatedDate(String potentialDate);
	public String getPublisher();
	public String getTitleFieldName();
	public String getAuthorsFieldName();
	public String getKeywordsFieldName();
	public String getAbstractsFieldName();
	public String getDateFieldName();
	
}
