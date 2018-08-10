package com.guessingGame.mathQuiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import com.guessingGame.resultTypes.MathType;
import com.guessingGame.resultTypes.PracticeType;
import com.guessingGame.resultTypes.QuizResults;

public class MultiplicationQuiz extends MathQuizBase{
	
	public MultiplicationQuiz(){
		
	}
	
	@Override
	public void displayPrompt(int a, int b){
		System.out.println("What is " + a + " times " + b + "?");
	}
	
	@Override
	public int getExpectedResult(int a, int b){
		return a*b;
	}

	@Override
	public PracticeType buildPracticeType(int a, int b){
		return new PracticeType(String.valueOf(a)+" x "+ String.valueOf(b), a*b);
	}

	@Override
	public MathType buildMathType(int a, int b, boolean correct){
		return new MathType(String.valueOf(a)+" x "+String.valueOf(b), a*b, correct);
	}
	
//	@Override
//	protected void recordQuiz(int range, int numberOfQuestions){
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		QuizResults qr = new QuizResults();
//		Random rand = new Random();
//		for(int i = 0; i < numberOfQuestions; i++){
//			int a = rand.nextInt(range);
//			int b = rand.nextInt(range);
//			boolean validNums = checkPairs(a,b);
//			while(!validNums){
//				System.out.println("Generating new numbers");
//				a = rand.nextInt(range);
//				b = rand.nextInt(range);
//				validNums = checkPairs(a,b);
//			}
//			int result = 0;
//			displayPrompt(a,b);
//			try {
//				result = Integer.parseInt(br.readLine());
//			} catch (IOException e) {
//				System.out.println("IOException Error");
//			}
//			boolean correct = (result == getExpectedResult(a,b)) ? true : false;
//			MathType mt = buildMathType(a, b, correct);
//			mt.setUserAnswer(result);
//			addPairs(a,b);
//			qr.addRecord(mt);
//		}
//		System.out.println("Congrats, you finished");
//		qr.printResults();
//	}
	
//	@Override
//	protected void practiceQuiz(int range, int numberOfQuestions){
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		QuizResults qr = new QuizResults();
//		Random rand = new Random();
//		for(int i = 0; i < numberOfQuestions; i++){
//			boolean repeat = true;
//
//			int a = rand.nextInt(range);
//			int b = rand.nextInt(range);
//			boolean validNums = checkPairs(a,b);
//			while(!validNums){
//				a = rand.nextInt(range);
//				b = rand.nextInt(range);
//				validNums = checkPairs(a,b);
//			}
//			PracticeType pt = buildPracticeType(a,b);
//			int result = 0;
//			while (repeat){
//				displayPrompt(a, b);
//				try {
//					result = Integer.parseInt(br.readLine());
//				} catch (IOException e) {
//					System.out.println("IOException Error");
//				}
//				boolean correct = (result == getExpectedResult(a,b)) ? true : false;
//				if(correct){
//					repeat = false;
//					pt.setCorrect(true);
//				} else {
//					System.out.println("That is not the correct answer, please try again");
//					pt.increaseAttemptCount();
//				}
//			}
//			addPairs(a,b);
//			qr.addRecord(pt);
//		}
//		System.out.println("Congrats, you finished");
//		qr.printResults();
//	}
}
