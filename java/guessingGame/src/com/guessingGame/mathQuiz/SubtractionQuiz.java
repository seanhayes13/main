package com.guessingGame.mathQuiz;

import com.guessingGame.resultTypes.MathType;
import com.guessingGame.resultTypes.PracticeType;

public class SubtractionQuiz extends MathQuizBase{
	
	public SubtractionQuiz(){
		
	}
	
	@Override
	public void displayPrompt(int a, int b){
		System.out.println("What is " + a + " minus " + b + "?");
	}
	
	@Override
	public int getExpectedResult(int a, int b){
		return a-b;
	}

	@Override
	public PracticeType buildPracticeType(int a, int b){
		return new PracticeType(String.valueOf(a)+" - "+ String.valueOf(b), a-b);
	}

	@Override
	public MathType buildMathType(int a, int b, boolean correct){
		return new MathType(String.valueOf(a)+" - "+String.valueOf(b), a-b, correct);
	}

}