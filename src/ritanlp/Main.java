package ritanlp;

import rita.RiString;

//new library to use worknet with
public class Main {

	  public static void main(String[] args) {

		    RiString rs = new RiString("The elephant took a bite!");
		    System.out.println(rs.features());
		  }

}
