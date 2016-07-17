package utilities;

import java.io.FileNotFoundException;

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
	
	public static String[] potentialKeywordsFromList(String stringOfWords,String KeywordsFilePath){
		return new String[]{""};
	}
	public static void main(String[] args) throws FileNotFoundException {
	String testString="&lt;I&gt &lt;/I&gt; &lt;I&gt; &lt; &#12; &#15; &#19; &#12; &lt;p&gt; & &. &&&n a polygonal path P with vertices p1, ..., pn in R^d and a real number t&gt;1, a path Q = (pi1, pi2, ... , pik) is a t-distance preserving approximation of P if 1 = i1 &lt; i2 &lt; ... &lt; ik = n and each straight-line edge (pij ; pij+1) of Q ap";
	
	System.out.println(cleanString(testString));
	}
}
