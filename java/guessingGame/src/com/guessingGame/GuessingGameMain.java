package com.guessingGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import com.guessingGame.mathQuiz.MathQuiz;
import com.guessingGame.multipleChoice.MultipleChoiceQuiz;

public class GuessingGameMain {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	private static HashMap<Integer, ArrayList<Integer>> alreadyCalled;
	
	public static void main(String[] args){
		alreadyCalled = new HashMap<>();
//		generateNums(5);
		String choice = "";
		boolean repeat = true;
		while(repeat){
			displayMenu();
			try {
				choice = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			switch(choice){
			case "1":
				MathQuiz mqb = new MathQuiz();
				mqb.display();
				break;
			case "2":
				MultipleChoiceQuiz mcq = new MultipleChoiceQuiz();
				mcq.display();
				break;
			case "3":
				System.out.println("Good bye");
				repeat = false;
				break;
			default:
				System.out.println("Please select an option from the list above");
				break;
			}
		}
	}
	
	private static void displayMenu(){
		StringBuilder sb = new StringBuilder();
		sb.append("Select an option from the list below:\n");
		sb.append("--> 1. Math - Multiplication. Basic Math Multiplication\n");
		sb.append("--> 2. Multiple Choice in other subjects.\n");
		sb.append("--> 3. Exit the program.\n\n>>>");
		System.out.println(sb.toString());
	}
	
	/*
	 * Test purposes only
	 */
	private static void generateNums(int x){
		int limit = x*(x+1)/2;
		for(int i = 0; i < limit; i++){
			Random rand = new Random();
			int a = rand.nextInt(x);
			int b = rand.nextInt(x);
			boolean validNums = checkPairs(a,b);
			while(!validNums){
				System.out.println("Generating new numbers");
				a = rand.nextInt(x);
				b = rand.nextInt(x);
				validNums = checkPairs(a,b);
			}
			addPairs(a,b);
			System.out.println("a - " + a + "   ===   b - " + b);
		}
	}
	
	/*
	 * Test purposes only
	 */
	private static void addPairs(int a, int b){
		if(alreadyCalled.containsKey(a)){
			alreadyCalled.get(a).add(b);
		} else {
			alreadyCalled.put(a, new ArrayList<>());
			alreadyCalled.get(a).add(b);
		}
	}
	
	/*
	 * Test purposes only
	 */
	private static boolean checkPairs(int a, int b){
		if((alreadyCalled.get(a) !=null  && alreadyCalled.get(a).contains(b)) 
				|| (alreadyCalled.get(b) != null && alreadyCalled.get(b).contains(a))){
			return false;
		} else {
			return true;
		}
	}
}
