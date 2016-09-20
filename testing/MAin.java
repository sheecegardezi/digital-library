import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import core.Constants;

public class MAin {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println(Constants.FILE_PATH_NOISY_DATA);
		
		


		BufferedReader in = new BufferedReader(new FileReader(Constants.FILE_PATH_NOISY_DATA));
		
		
		String line;
		while((line = in.readLine()) != null)
		{
		    System.out.println(line);
		}
		in.close();
		


	}

}
