package Serilaze;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import datastructures.ResearchPaper;

public class io {

	public static ArrayList<ResearchPaper> read(String fileName) throws IOException, ClassNotFoundException {

		ArrayList<ResearchPaper> researchPapers = null;
		FileInputStream fileIn = new FileInputStream(fileName);
		ObjectInputStream in = new ObjectInputStream(fileIn);
		researchPapers = (ArrayList<ResearchPaper>) in.readObject();
		in.close();
		fileIn.close();
		return researchPapers;
	}

	// write
	public static void write(ArrayList<ResearchPaper> ResearchPapers, String fileName) throws IOException {

		FileOutputStream fileOut = new FileOutputStream(fileName);
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(ResearchPapers);
		out.close();
		fileOut.close();
	}
}
