package datamanipulating;


import core.Constants;
import java.util.*;



public class JMLR implements HandlingDatabase{

	
	String title_field_name="title";
	String authors_field_name="authors";
	String keywords_field_name="conference_name_long";
	String abstracts_field_name="abstracts";
	String date_field_name="date";
	String publisher="JLMR";

	public JMLR(){
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
		return Constants.FILE_PATH_JMLR_CSV;
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

