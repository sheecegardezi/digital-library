package wordnet;

import core.Constants;
import edu.smu.tspell.wordnet.Synset;
import edu.smu.tspell.wordnet.WordNetDatabase;

public class Utlities {

	public static boolean isWordCorrect(String term){
		//JWNLApi
		System.setProperty("wordnet.database.dir", Constants.FILE_PATH_WordNet_2_1);

		WordNetDatabase database = WordNetDatabase.getFileInstance();

		Synset[] synsets = database.getSynsets(term);
		if(synsets.length>0){
				return true;
		}
		return false;

	}

}
