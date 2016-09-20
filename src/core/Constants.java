package core;

public final class Constants {

	// PUBLIC //
	  
	/** Path to the keyword file  */
	
	public static final String FILE_PATH_RUNNING_ID="./res/req/id.data";
	
	public static final String FILE_PATH_DATA61_CSV="./res/input/nicta_publications_table.csv";
	public static final String FILE_PATH_MICROSOFT_CSV="./res/input/microsoft_publications_table.csv";
	public static final String FILE_PATH_JMLR_CSV="./res/input/jmlr_publications_table.csv";
	public static final String FILE_PATH_GOOGLE_CSV="./res/input/google_publications_table.csv";	
	
	public static final String FILE_PATH_KEYWORDS="./res/input/keywords";
	public static final String FILE_PATH_DATABASE_XML="./res/xml/database.xml";
	public static final String FILE_PATH_LOG_CONFIG="./src/log/log4j2.xml";

	public static final String FILE_PATH_WordNet_2_1="./res/WordNet/2.1/dict/";
	public static final String FILE_PATH_WordNet_3_0="./res/WordNet/3.0/dict";
	public static final String FILE_PATH_WordNet_3_1="./res/WordNet/3.1/dict";
	
	public static final String FILE_PATH_NOISY_DATA="./res/test/noisey_data.txt";
	public static final String FILE_PATH_CAPITAL_WORDS_DATA ="./res/test/capital_word_data.txt";
	public static final String FILE_PATH_ABBREVIATED_WORDS_DATA = "./res/test/abbreviated_words_data.txt";
	public static final String FILE_PATH_KEY_WORDS_DATA ="./res/test/key_words_data.txt";
	public static final String FILE_PATH_KEY_TEMP_DATA ="./res/test/temp_data.txt";
	
	public static final String BATCH_FILE_DIRECTORY ="res/process/";
	public static final String FILE_PATH_RUNNING_BATCH_NUMBER ="./res/req/batch.data";
	
	public static final int BATCH_SIZE =500;
	
		
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
