package com.guessingGame.multipleChoice;

import java.util.HashMap;
import java.util.Map;

public class MultipleChoiceOption {
	private String question;
	
	private String correctAnswer;
	
	private HashMap<Character,String> options;
	
	public MultipleChoiceOption(){
		
	}
	
	public MultipleChoiceOption(String q, String c){
		question = q;
		correctAnswer = c;
		options = new HashMap<>();
	}
	
	public void addOption(Character key, String value){
		if(options == null){
			options = new HashMap<>();
		}
		options.put(key, value);
	}
	
	public void printDetails(){
		StringBuilder sb = new StringBuilder();
		sb.append("Question: " + question + "\n");
		for(Map.Entry<Character, String> entry : options.entrySet()){
			sb.append(entry.getKey() + ") " + entry.getValue() +"\n");
		}
		sb.append("Correct Answer: " + question + "\n");
		System.out.println(sb.toString());
	}
}
