package com.guessingGame.resultTypes;

public class PracticeType extends MathType{
	private int attempts;
	
	public PracticeType(){};
	
	public PracticeType(String e, int cA){
		super(e, cA);
	}
	
	public void increaseAttemptCount(){
		attempts++;
	}
	
	public int getAttemptCount(){
		return attempts;
	}
	
	public void printResults(){
		System.out.println("For the equation " + equation + " you answered " + userAnswer);
		if(isCorrect()){
			//Update this to display try vs tries
			System.out.println("You answered it in " + attempts + " tries.");
		} else {
			System.out.println("That was not the correct answer. The correct answer was " + correctAnswer);
		}
	}
}
