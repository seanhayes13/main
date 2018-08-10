package com.guessingGame.resultTypes;

public class MathType extends TypeBase{
	protected String equation;
	
	protected int userAnswer;
	
	protected int correctAnswer;
	
	public MathType(){}
	
	public MathType(String e, int cA){
		equation = e;
		correctAnswer = cA;
	}
	
	public MathType(String e, int cA, boolean c){
		this(e, cA);
		setCorrect(c);
	}
	
	public void setEquation(String e){
		equation = e;
	}
	
	public void setUserAnswer(int a){
		userAnswer = a;
	}
	
	public void printResults(){
		System.out.println("For the equation " + equation + " you answered " + userAnswer);
		if(isCorrect()){
			System.out.println("That was the correct answer");
		} else {
			System.out.println("That was not the correct answer. The correct answer was " + correctAnswer);
		}
	}
}
