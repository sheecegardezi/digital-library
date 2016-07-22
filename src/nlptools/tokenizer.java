package nlptools;

import java.util.ArrayList;

import utilities.Functions;

public class tokenizer {

	

	public static void addWordsToWordVector(String text, ArrayList<String> word_vector) {

		for(String word:text.split("\\s+")){
			word_vector.add(word);
		};		
	}

}
