package com.guessingGame.mathQuiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class MathQuiz {
	
	public MathQuiz(){
	}
	
	public void display(){
		String choice = "";
		boolean repeat = true;
		while(repeat){
			displayMenu();
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				choice = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			switch(choice){
			case "1":
				callAdditionQuiz();
				break;
			case "2":
				callSubtractionQuiz();
				break;
			case "3":
				callMultiplicationQuiz();
				break;
			case "4":
				System.out.println("Not implemented yet, please try again");
				break;
			case "5":
				repeat = false;
				break;
			default:
				System.out.println("Please select an option from the list above");
				break;
			}
		}
	}
	
	private void displayMenu(){
		StringBuilder sb = new StringBuilder();
		sb.append("Select an option from the list below:\n");
		sb.append("--> 1. Addition\n");
		sb.append("--> 2. Subtraction\n");
		sb.append("--> 3. Multiplication\n");
		sb.append("--> 4. Division\n");
		sb.append("--> 5. Return to main menu.\n\n>>>");
		System.out.println(sb.toString());
	}
	
	private void callMultiplicationQuiz(){
		MultiplicationQuiz mq = new MultiplicationQuiz();
		mq.display();
	}
	
	private void callAdditionQuiz(){
		AdditionQuiz aq = new AdditionQuiz();
		aq.display();
	}
	
	private void callSubtractionQuiz(){
		SubtractionQuiz sq = new SubtractionQuiz();
		sq.display();
	}
}
