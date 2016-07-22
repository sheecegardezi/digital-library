package core;

public final class Constants {

	// PUBLIC //
	  
	/** Path to the keyword file  */
	public static final String FILE_PATH_KEYWORDS="./res/input/keywords";
	public static final String FILE_PATH_DATA61_CSV="./res/input/nicta_publications_table.csv";
	public static final String FILE_PATH_DATABASE_XML="./res/xml/database.xml";
	public static final String FILE_PATH_NOISY_DATA="./res/test/noisey_data.txt";


		
	  // PRIVATE //
	  /**
	   The caller references the constants using <tt>Consts.EMPTY_STRING</tt>, 
	   and so on. Thus, the caller should be prevented from constructing objects of 
	   this class, by declaring this private constructor. 
	  */
	  private Constants(){
	    //this prevents even the native class from 
	    //calling this ctor as well :
	    throw new AssertionError();
	  }
	
}
