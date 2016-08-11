package datamanipulating;


import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.csv.*;

import core.Constants;
import datastructures.ResearchPaper;
import utilities.Functions;

import java.io.*;
import java.math.*;
import java.util.*;
import java.util.Map.*;


public class DATA61 implements HandlingDatabase{

	
	String title_field_name="title";
	String authors_field_name="authors";
	String keywords_field_name="keywords";
	String abstracts_field_name="abstract";
	String date_field_name="updated_at";
	String publisher="Data61";
	
	
	
	public String getPublisher() {
		return publisher;
	}


	public DATA61(){

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


	public void setDateFieldName(String date) {
		this.date_field_name = date;
	}


	@Override
	public String getFormatedTitle(String potentialTitle){
		potentialTitle=utilities.Functions.cleanString(potentialTitle);
		return potentialTitle;
	}

	@Override
	public ArrayList<String> getFormatedAuthors(String potentialAuthors){
		
		ArrayList<String> Authors=new ArrayList<String>();  

		if(potentialAuthors==null){

			return Authors;
		}
		else if(potentialAuthors.split("(,)").length>1){

			for(String authorName: potentialAuthors.split("(,)")) {

				authorName=utilities.Functions.cleanString(authorName);
				Authors.add(authorName);
				}
		}
		else{
			potentialAuthors=utilities.Functions.cleanString(potentialAuthors);

			Authors.add(potentialAuthors);

			}
					
		return Authors;
	}
	
	
	//TODO store all the keywords in a file read the file for keywords and then check if any of the words are in the string in question and add it to the keyword list return the keyword string after all comparisions
	@Override
	public ArrayList<String> getFormatedKeywords(String potentialKeywords){
		
		ArrayList<String> Keywords=new ArrayList<String>();  
		potentialKeywords=utilities.Functions.cleanString(potentialKeywords);

		if(potentialKeywords==null||potentialKeywords.contains("NULL")){
				return Functions.convertStringArrayToArrayList(new String[0]);
		}
		else if(!potentialKeywords.toLowerCase().contains(" ")){
						
				return Functions.convertStringArrayToArrayList(new String[]{potentialKeywords});
		}
		else if(potentialKeywords.toLowerCase().split("(,)").length>1){
			return Functions.convertStringArrayToArrayList(potentialKeywords.split("(,)"));
		}
		else if(potentialKeywords.toLowerCase().split("(-)").length>1){
			return Functions.convertStringArrayToArrayList(potentialKeywords.split("(-)"));
		}
		else if(potentialKeywords.toLowerCase().split("(;)").length>1){
			return Functions.convertStringArrayToArrayList(potentialKeywords.split("(;)"));
		}
		else if(potentialKeywords.toLowerCase().split("(/)").length>1){
			return Functions.convertStringArrayToArrayList(potentialKeywords.split("(/)"));
		}
		//check if the word combination is in the list of key words
		return Functions.convertStringArrayToArrayList(utilities.Functions.potentialKeywordsFromList(potentialKeywords,Constants.FILE_PATH_KEYWORDS));
		
	}

	@Override
	public String getFormatedAbstract(String potentialAbstract){
			
			potentialAbstract=utilities.Functions.cleanString(potentialAbstract);

			if(potentialAbstract==null){
				potentialAbstract="";
			}
			else if(potentialAbstract.length()<10){
				potentialAbstract="";
			}
			
			return potentialAbstract;
		}
	@SuppressWarnings("null")
	@Override
	public String getFormatedDate(String potentialDate){
		
		potentialDate=utilities.Functions.cleanString(potentialDate);


		if(potentialDate==null&&potentialDate.split("(/)").length!=3){
			potentialDate="1990";
		}
		else{
			potentialDate=potentialDate.split("(/)")[2];
		}
		
		return potentialDate;
	}


	public String getCSVFilePath() {
		return Constants.FILE_PATH_DATA61_CSV;
	}


		
	
}

