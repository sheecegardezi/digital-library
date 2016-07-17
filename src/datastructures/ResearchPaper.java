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
		this.Title=Title;
		this.Authors=Authors;
		this.Keywords=Keywords;
		this.Abstract=Abstract;
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
		return Authors.get(0);
	}

	public void setAuthors(ArrayList<String> authors) {
		Authors = authors;
	}

	public ArrayList<String> getKeywords() {
		return Keywords;
	}
	public String getKeyword() {
		return Keywords.get(0);
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
		return "ResearchPaper [Id=" + Id + ", Title=" + Title + ", Authors=" + Authors + ", Keywords=" + Keywords
				+ ", Abstract=" + Abstract + ", Date=" + Date + "Publisher"+Publisher +"]";
	}

	public String getPublisher() {
		return Publisher;
	}

	public void setPublisher(String publisher) {
		Publisher = publisher;
	}
	
	
}
