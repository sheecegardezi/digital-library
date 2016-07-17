package database;

import java.sql.Connection;
//Import required packages
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import datamanipulating.DatabaseReader;
import datastructures.ResearchPaper;

class Main {

	public static void main(String[] args) throws ClassNotFoundException {

		Connection connection = null;
		Statement statement = null;
		String sql = null;

		// Register JDBC driver
		Class.forName("com.mysql.jdbc.Driver");

		// JDBC driver name and database URL
		System.setProperty("javax.net.ssl.trustStore", "/usr/lib/jvm/java/jre/truststore.jks");
		System.setProperty("javax.net.ssl.trustStorePassword", "truststore_password");
		final String url = "jdbc:mysql://researchpaperdb.c4biixuxo4ue.us-west-2.rds.amazonaws.com:3333/ReseachPaperDB";

		// Database credentials
		final String username = "root";
		final String password = "sprite3G";

		try {
			// Open a connection
			System.out.println("Connecting to a selected database...");
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connected database successfully...");

			// STEP 4: Execute a query
			System.out.println("Creating table in given database...");
			statement = connection.createStatement();

//			String sql = "CREATE TABLE researchPapers" + 
//			"(id INTEGER not NULL, " + 
//			" authors VARCHAR(255), " + 
//			" title VARCHAR(500), " + 
//			" keywords VARCHAR(500), " +
//			" abstract VARCHAR(5000), " +
//			" date INTEGER, " +
//			" publisher VARCHAR(50), " +
//			" PRIMARY KEY ( id ))";
			
			//String sql = "DROP TABLE researchPapers ";
			//String sql = "INSERT INTO researchPapers " + "VALUES (1, 'authors', 'title', 'keywords' , 'abstract', 'date','publisher' )";
			
			DatabaseReader DR=new DatabaseReader();
			
			for(ResearchPaper research_paper:DR.getResearchPapers()){
				sql = "INSERT INTO researchPapers " + "VALUES ("+ research_paper.getId()+"," +research_paper.getAuthor()+", "+research_paper.getTitle().replace(',', ' ')+", "+research_paper.getKeyword().replace(',', ' ')+" , "+research_paper.getAbstract().replace(',', ' ')+", "+research_paper.getDate()+","+research_paper.getPublisher()+" )";
				break;				
			}
			
			statement.executeUpdate(sql);
			sql = "SELECT id, authors, title, keywords, abstract, date, publisher FROM researchPapers";
			//STEP 5: Extract data from result set
		    ResultSet rs = statement.executeQuery(sql);  
			while(rs.next()){
		        //Retrieve by column name
		        int id  = rs.getInt("id");
		        String authors = rs.getString("authors");
		        String title = rs.getString("title");
		        String keywords = rs.getString("keywords");
		        String abstracts = rs.getString("abstract");
	          	int date = rs.getInt("date");
	          	String publisher = rs.getString("publisher");	
	          	
	            //Display values
	            System.out.print("id: " + id);
	            System.out.print(", authors: " + authors);
	            System.out.print(", title: " + title);
	            System.out.println(", keywords: " + keywords);
	            System.out.println(", abstracts: " + abstracts);
	            System.out.println(", date: " + date);
	            System.out.println(", publisher: " + publisher);
	            
	            break;
			}
//			statement.executeUpdate(sql);
			System.out.println("Created table in given database...");

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (statement != null)
					connection.close();
			} catch (SQLException se) {
			} // do nothing
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		}
	}
}
