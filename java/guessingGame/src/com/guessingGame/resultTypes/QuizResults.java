package com.guessingGame.resultTypes;

import java.util.LinkedList;

public class QuizResults {
	private LinkedList<TypeBase> questions;
	private int numCorrect;
	private int numIncorrect;
	
	public QuizResults(){
		questions = new LinkedList<>();
		numCorrect = 0;
		numIncorrect = 0; 
	}
	
	public void addRecord(TypeBase t){
		questions.add(t);
		if (t.isCorrect()){
			numCorrect++;
		} else {
			numIncorrect++;
		}
	}
	
	public void printResults(){
		System.out.printf("You answered %d out of %d questions correct",
				numCorrect, questions.size());
		if(numIncorrect>0){
			System.out.printf(", and missed %d out of %d questions",
					numIncorrect, questions.size());
		}
		
		System.out.print("\n");
	}
}
