package com.guessingGame.mathQuiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import com.guessingGame.interfaces.BuildMathTypes;
import com.guessingGame.resultTypes.MathType;
import com.guessingGame.resultTypes.PracticeType;
import com.guessingGame.resultTypes.QuizResults;

public class MathQuizBase implements BuildMathTypes{
	protected HashMap<Integer, ArrayList<Integer>> alreadyCalled;
	
	public MathQuizBase(){
		alreadyCalled = new HashMap<>();
	}
	
	public void display(){
		String choice = "";
		boolean repeat = true;
		while(repeat){
			displaySubMenu();
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				choice = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			int range = 0;
			int numberOfQuestions = 0;
			switch(choice){
			case "1":
				range = getRange();
				numberOfQuestions = getNumberOfQuestions(range);
				practiceQuiz(range, numberOfQuestions);
				break;
			case "2":
				range = getRange();
				numberOfQuestions = getNumberOfQuestions(range);
				recordQuiz(range, numberOfQuestions);
				break;
			case "3":
				repeat = false;
				break;
			default:
				System.out.println("Please select an option from the list above");
				break;
			}
		}
	}
	
	protected int getRange(){
		System.out.println("Enter a number between 3 and 46340");
		int result = 0;
		while (result < 3){
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				result = Integer.parseInt(br.readLine());
			} catch (NumberFormatException e) {
				System.out.println("Please enter a valid number");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	protected int getNumberOfQuestions(int range){
		System.out.println("How many questions?");
		int result = 0;
		int limit = range*(range+1)/2;
		while (result < 3 || result > limit){
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				result = Integer.parseInt(br.readLine());
			} catch (NumberFormatException e) {
				System.out.println("Please enter a valid number");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	protected void addPairs(int a, int b){
		if(alreadyCalled.containsKey(a)){
			alreadyCalled.get(a).add(b);
		} else {
			alreadyCalled.put(a, new ArrayList<>());
			alreadyCalled.get(a).add(b);
		}
	}
	
	protected boolean checkPairs(int a, int b){
		if((alreadyCalled.get(a) !=null  && alreadyCalled.get(a).contains(b)) 
				|| (alreadyCalled.get(b) != null && alreadyCalled.get(b).contains(a))){
			return false;
		} else {
			return true;
		}
	}
	
	protected void displaySubMenu(){
		StringBuilder sb = new StringBuilder();
		sb.append("Select an option from the list below:\n");
		sb.append("--> 1. Practice. Get up to 5 attempts to answer the question correctly\n");
		sb.append("--> 2. Record. Only one chance to answer each question.\n");
		sb.append("--> 3. Return to main menu.\n\n>>>");
		System.out.println(sb.toString());
	}
	
	protected void practiceQuiz(int range, int numberOfQuestions){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		QuizResults qr = new QuizResults();
		Random rand = new Random();
		for(int i = 0; i < numberOfQuestions; i++){
			boolean repeat = true;

			int a = rand.nextInt(range);
			int b = rand.nextInt(range);
			boolean validNums = checkPairs(a,b);
			while(!validNums){
				a = rand.nextInt(range);
				b = rand.nextInt(range);
				validNums = checkPairs(a,b);
			}
			PracticeType pt = buildPracticeType(a,b);
			int result = 0;
			while (repeat){
				displayPrompt(a, b);
				try {
					result = Integer.parseInt(br.readLine());
				} catch (IOException e) {
					System.out.println("IOException Error");
				}
				boolean correct = (result == getExpectedResult(a,b)) ? true : false;
				if(correct){
					repeat = false;
					pt.setCorrect(true);
				} else {
					System.out.println("That is not the correct answer, please try again");
					pt.increaseAttemptCount();
				}
			}
			addPairs(a,b);
			qr.addRecord(pt);
		}
		System.out.println("Congrats, you finished");
		qr.printResults();
	}
	
	protected void recordQuiz(int range, int numberOfQuestions){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		QuizResults qr = new QuizResults();
		Random rand = new Random();
		for(int i = 0; i < numberOfQuestions; i++){
			int a = rand.nextInt(range);
			int b = rand.nextInt(range);
			boolean validNums = checkPairs(a,b);
			while(!validNums){
				System.out.println("Generating new numbers");
				a = rand.nextInt(range);
				b = rand.nextInt(range);
				validNums = checkPairs(a,b);
			}
			int result = 0;
			displayPrompt(a,b);
			try {
				result = Integer.parseInt(br.readLine());
			} catch (IOException e) {
				System.out.println("IOException Error");
			}
			boolean correct = (result == getExpectedResult(a,b)) ? true : false;
			MathType mt = buildMathType(a, b, correct);
			mt.setUserAnswer(result);
			addPairs(a,b);
			qr.addRecord(mt);
		}
		System.out.println("Congrats, you finished");
		qr.printResults();
	}
	
	public void displayPrompt(int a, int b){
		//Do nothing here. Derived class will override
	}
	
	public int getExpectedResult(int a, int b){
		//Derived class will override
		return 0;
	}
	
	public PracticeType buildPracticeType(int a, int b){
		//Do nothing here. Derived class will override
		return null;
	}
	
	public MathType buildMathType(int a, int b, boolean c){
		//Do nothing here. Derived class will override
		return null;
	}
}
