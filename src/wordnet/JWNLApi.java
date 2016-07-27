package wordnet;
//

import java.io.IOException;

import core.Constants;
import edu.smu.tspell.wordnet.Synset;
import edu.smu.tspell.wordnet.WordNetDatabase;
import net.didion.jwnl.JWNLException;

public class JWNLApi {
	
	public static boolean isWordCorrect(String term){
	
		WordNetDatabase database = WordNetDatabase.getFileInstance();

		Synset[] synsets = database.getSynsets(term);
		if(synsets.length>0){
				return true;
		}
		return false;

	}

	
	public static void main(String[] args) throws IOException, JWNLException{
		
		System.setProperty("wordnet.database.dir", Constants.FILE_PATH_WordNet_2_1);
		
		System.out.println(isWordCorrect("Sheece"));
		System.out.println(isWordCorrect("love"));
			
//		Synset[] synsets = database.getSynsets("fly", SynsetType.ADJECTIVE); 
//		for (int i = 0; i < synsets.length; i++) { 
//		    nounSynset = (NounSynset)(synsets[i]); 
//		    hyponyms = nounSynset.getHyponyms(); 
//		    System.err.println(nounSynset.getWordForms()[0] + 
//		            ": " + nounSynset.getDefinition() + ") has " + hyponyms.length + " hyponyms"); 
//		}
	}

}
