package utilities;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Functions {

	public static boolean isAlpha(String name) {
	    char[] chars = name.toCharArray();
	    for (char c : chars) {
	        if(!Character.isLetter(c)) {
	            return false;
	        }
	    }
	    return true;
	}

	public static String cleanString(String line){

		line = line.replaceAll("&.*?;"," ");//remove words occouring with &
		line=line.replaceAll("[^\\x00-\\x7F]", " ");//remove now unicode charaters
//		line = line.replace("&", " ");//remove & it breaks xml
		line = line.trim().replaceAll(" +", " ");//remove repeating spaces
		return line;
	}

	public static ArrayList<String> extractKeywords(String line){

		
		HashMap<String, String> regs = new HashMap<String, String>();
		
		    regs.put("capitalwords", "([A-Z]+)");
		    //regs.put("abbreviations", "([A-Za-z]{1,}[-]?[A-Z]{1,}[-]?[A-Za-z]{1,})");

	        ArrayList<String> matches=new ArrayList<String>();

		    for (HashMap.Entry<String, String> entry : regs.entrySet()) {
		       
		    	String key = entry.getKey();
		        String value = entry.getValue();
		        
		        Matcher matcher = Pattern.compile(value).matcher(line);
		        while(matcher.find()){
		        	 String group = matcher.group();
		             matches.add(group);
		        }
		    }   
		return matches;
	}


	
	public static void createFile(String file, ArrayList<String> arrData)
            throws IOException {
        FileWriter writer = new FileWriter(file);
        int size = arrData.size();
        for (int i=0;i<size;i++) {
            String str = arrData.get(i).toString();
            writer.write(str);
            if(i < size-1){
                writer.write("\n");
                }
        }
        writer.close();
    }
	
	public static String[] potentialKeywordsFromList(String stringOfWords,String KeywordsFilePath){
		return new String[]{""};
	}
	
	public static void main(String[] args) throws FileNotFoundException {
	String testString="&lt;I&gt &lt;/I&gt; &lt;I&gt; &lt; &#12; &#15; &#19; &#12; &lt;p&gt; & &. &&&n a polygonal path P with vertices p1, ..., pn in R^d and a real number t&gt;1, a path Q = (pi1, pi2, ... , pik) is a t-distance preserving approximation of P if 1 = i1 &lt; i2 &lt; ... &lt; ik = n and each straight-line edge (pij ; pij+1) of Q ap";	
	String testString2="D-PLL, known NEURAL PROSTHESES:BY-PASSING DAMAGED NEURO-WIRELESS TECHNOLOGY A Digital Based A.A.E asdasdASDASDBJHasdASDasd";
	String testString3="1-D2-D 3-D A asdasd B>asdasd";
	//	System.out.println(cleanString(testString));
	
    ArrayList<String> matches=extractKeywords(testString3);

    for(String word:matches){

    	System.out.println(word);
    		
    }
    
	}

	public static void removeDuplicates(ArrayList<String> capitalWords) {
		
		Set<String> capitalWordsSet = new HashSet<>();
		capitalWordsSet.addAll(capitalWords);
		capitalWords.clear();
		capitalWords.addAll(capitalWordsSet);
		Collections.sort(capitalWords.subList(1, capitalWords.size()));
		
	}
}
