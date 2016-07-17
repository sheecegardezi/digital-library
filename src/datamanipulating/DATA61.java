package datamanipulating;


import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.csv.*;

import core.Constants;
import datastructures.ResearchPaper;

 

import java.io.*;
import java.math.*;
import java.util.*;
import java.util.Map.*;


public class DATA61 implements HandlingDatabase{

	
	String title_field_name;
	String authors_field_name;
	String keywords_field_name;
	String abstracts_field_name;
	String date_field_name;
	String publisher="Data61";
	
	
	public String getPublisher() {
		return publisher;
	}


	public DATA61(String title,String authors,String keywords,String abstracts,String date){
		setTitleFieldName( title);
		setAuthorsFieldName( authors);
		setKeywordsFieldName( keywords);
		setAbstractsFieldName( abstracts);
		setDateFieldName( date);
	}

	
	public String getTitleFieldName() {
		return title_field_name;
	}


	public void setTitleFieldName(String title) {
		this.title_field_name = title;
	}


	public String getAuthorsFieldName() {
		return authors_field_name;
	}


	public void setAuthorsFieldName(String authors) {
		this.authors_field_name = authors;
	}


	public String getKeywordsFieldName() {
		return keywords_field_name;
	}


	public void setKeywordsFieldName(String keywords) {
		this.keywords_field_name = keywords;
	}


	public String getAbstractsFieldName() {
		return abstracts_field_name;
	}


	public void setAbstractsFieldName(String abstracts) {
		this.abstracts_field_name = abstracts;
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
	
	ArrayList<String> addStringArray(String[] stringArray){
		ArrayList<String> stringArrayList=new ArrayList<String>();  
		
		for(String element:stringArray){
			stringArrayList.add(element);
		}
		return stringArrayList;
	}
	//TODO store all the keywords in a file read the file for keywords and then check if any of the words are in the string in question and add it to the keyword list return the keyword string after all comparisions
	@Override
	public ArrayList<String> getFormatedKeywords(String potentialKeywords){
		
		ArrayList<String> Keywords=new ArrayList<String>();  
		potentialKeywords=utilities.Functions.cleanString(potentialKeywords);

		if(potentialKeywords==null||potentialKeywords.contains("NULL")){
				return addStringArray(new String[0]);
		}
		else if(!potentialKeywords.toLowerCase().contains(" ")){
						
				return addStringArray(new String[]{potentialKeywords});
		}
		else if(potentialKeywords.toLowerCase().split("(,)").length>1){
			return addStringArray(potentialKeywords.split("(,)"));
		}
		else if(potentialKeywords.toLowerCase().split("(-)").length>1){
			return addStringArray(potentialKeywords.split("(-)"));
		}
		else if(potentialKeywords.toLowerCase().split("(;)").length>1){
			return addStringArray(potentialKeywords.split("(;)"));
		}
		else if(potentialKeywords.toLowerCase().split("(/)").length>1){
			return addStringArray(potentialKeywords.split("(/)"));
		}
		//check if the word combination is in the list of key words
		return addStringArray(utilities.Functions.potentialKeywordsFromList(potentialKeywords,Constants.FILE_PATH_KEYWORDS));
		
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


		
	
}

