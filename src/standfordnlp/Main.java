package standfordnlp;

import edu.stanford.nlp.ling.CoreAnnotations.NamedEntityTagAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.PartOfSpeechAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TextAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.simple.*;
import edu.stanford.nlp.util.CoreMap;

import java.util.List;
import java.util.Properties;


public class Main {

	public static void main(String[] args){
	// creates a StanfordCoreNLP object, with POS tagging, lemmatization, NER, parsing, and coreference resolution 
		Properties props = new Properties();
		props.put("annotators", "tokenize, ssplit, pos");
		StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

	// read some text in the text variable
	String text = "a CoreMap is essentially a Map that uses class objects as keys and has values with custom types";

	// create an empty Annotation just with the given text
	Annotation document = new Annotation(text);

	// run all Annotators on this text
	pipeline.annotate(document);

	// these are all the sentences in this document
	// a CoreMap is essentially a Map that uses class objects as keys and has values with custom types
	List<CoreMap> sentences = document.get(SentencesAnnotation.class);

	for(CoreMap sentence: sentences) {
	  // traversing the words in the current sentence
	  // a CoreLabel is a CoreMap with additional token-specific methods
	  for (CoreLabel token: sentence.get(TokensAnnotation.class)) {
	    // this is the text of the token
	    String word = token.get(TextAnnotation.class);
	    System.out.println(word);
	    // this is the POS tag of the token
	    String pos = token.get(PartOfSpeechAnnotation.class);
	    System.out.println(pos);
	    
	  }

	}
}
}
