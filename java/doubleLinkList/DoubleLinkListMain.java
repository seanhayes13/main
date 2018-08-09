package dblLinkList;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class DoubleLinkListMain {
	public static void main(String[] args) throws IOException{
		DoubleLinkList<Object> dll = new DoubleLinkList<>();
		System.out.println("\n#######   Getting words from file   #######\n");
		ArrayList<String> words = buildList();
		System.out.println("\n#######   Adding words to list   #######\n");
		for(String s : words){
			dll.add(s);
		}
		System.out.println("\n#######   Sorting list - Ascending   #######\n");
		dll.sortAsc();
		dll.iterateForward();
		System.out.println("\n#######   Sorting list - Descending   #######\n");
		dll.sortDesc();
		dll.iterateForward();
//		System.out.println("\n#######   Printing list   #######\n");
//		dll.iterateForward();
		
//		DoubleLinkList<Object> dll = new DoubleLinkList<>();
//		dll.add("delta");
//		dll.add("zulu");
//		dll.add("hotel");
//		dll.add("bravo");
//		dll.add("alpha");
//		dll.add("x-ray");
//		dll.add("yankee");
//		dll.add("charlie");
//		dll.sortDesc();
//		dll.add(42);
//		System.out.println("\n#######   Before sort   #######\n");
//		dll.iterateForward();
//		System.out.println("\n#######   After sort   #######\n");
//		dll.sortAsc();
//		dll.iterateForward();
	}
	
	private static ArrayList<String> buildList() throws IOException{
		ArrayList<String> result = new ArrayList<>();
		String fileName = "files/english3.txt";
		ArrayList<String> words = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line = br.readLine();
		while (line != null){
			words.add(line);
			line = br.readLine();
		}
		Random rand = new Random();
		int[] nums = rand.ints(30, 0, words.size()).toArray();
		for(int i : nums){
			result.add(words.get(i));
		}
		return result;
	}
}
