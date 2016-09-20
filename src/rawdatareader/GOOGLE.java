package rawdatareader;


import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.csv.*;

import core.Constants;
import datastructures.ResearchPaper;

 

import java.io.*;
import java.math.*;
import java.util.*;
import java.util.Map.*;


public class GOOGLE implements HandlingDatabase{

	
	String title_field_name="paper_title";
	String authors_field_name="author_names";
	String keywords_field_name="venue";
	String abstracts_field_name="abstract";
	String date_field_name="year";
	String publisher="Google";

	public GOOGLE(){
	}
	
	@Override
	public String getFormatedTitle(String potentialTitle){
		return potentialTitle;
	}

	@Override
	public ArrayList<String> getFormatedAuthors(String potentialAuthors){
		
		ArrayList<String> Authors=new ArrayList<String>();  
		return Authors;
	}
	
	@Override
	public ArrayList<String> getFormatedKeywords(String potentialKeywords){
		
		ArrayList<String> Keywords=new ArrayList<String>();  
		return Keywords;
		
	}

	@Override
	public String getFormatedAbstract(String potentialAbstract){
			
			potentialAbstract=utilities.Functions.cleanString(potentialAbstract);
			return potentialAbstract;
		}
	@Override
	public String getFormatedDate(String potentialDate){	
		return potentialDate;
	}


	public String getCSVFilePath() {
		return Constants.FILE_PATH_GOOGLE_CSV;
	}
	
	public String getPublisher() {
		return publisher;
	}

	public String getTitleFieldName() {
		return title_field_name;
	}

	public String getAuthorsFieldName() {
		return authors_field_name;
	}

	public String getKeywordsFieldName() {
		return keywords_field_name;
	}

	public String getAbstractsFieldName() {
		return abstracts_field_name;
	}

	public String getDateFieldName() {
		return date_field_name;
	}

}

