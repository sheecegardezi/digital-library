package datastructures;

import java.util.ArrayList;

public class ResearchPaper {

	
	String Id;
	String Title;
	ArrayList<String> Authors;
	ArrayList<String> Keywords;
	String Abstract;
	String Date;
	String Publisher;
	
	public ResearchPaper(String Id,String Title,ArrayList<String> Authors,ArrayList<String> Keywords,String Abstract,String Date,String Publisher){
		this.Id=Id;
		this.Title=Title.replace('\'', ' ').replace('\"', ' ');
		this.Authors=Authors;
		this.Keywords=Keywords;
		this.Abstract=Abstract.replace('\'', ' ').replace('\"', ' ');
		this.Date=Date;
		this.Publisher=Publisher;
	}

	public ResearchPaper() {
		
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public ArrayList<String> getAuthors() {
		return Authors;
	}
	public String getAuthor() {
		if(Authors.size()>0){
			return Authors.get(0).replace('\'', ' ').replace('\"', ' ');
		}
		return "";
	}

	public void setAuthors(ArrayList<String> authors) {
		Authors = authors;
	}

	public ArrayList<String> getKeywords() {
		return Keywords;
	}
	public String getKeyword() {
		if(Keywords.size()>0){
			return Keywords.get(0).replace('\'', ' ').replace('\"', ' ');
		}
		return "";
	}
	public void setKeywords(ArrayList<String> keywords) {
		Keywords = keywords;
	}

	public String getAbstract() {
		return Abstract;
	}

	public void setAbstract(String abstract1) {
		Abstract = abstract1;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	@Override
	public String toString() {
		return "ResearchPaper [Id=" + Id +'\n'+ ", Title=" + Title +'\n'+ ", Authors=" + Authors +'\n'+ ", Keywords=" + Keywords
				+'\n'+ ", Abstract=" + Abstract +'\n'+ ", Date=" + Date +'\n'+ "Publisher"+Publisher +'\n'+"]";
	}

	public String getPublisher() {
		return Publisher;
	}

	public void setPublisher(String publisher) {
		Publisher = publisher;
	}
	
	
}
