package com.guessingGame.multipleChoice;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class MultipleChoiceQuiz {
	
	public MultipleChoiceQuiz(){
		
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
				historyQuiz();
				break;
//			case "2":
//				callSubtractionQuiz();
//				break;
//			case "3":
//				callMultiplicationQuiz();
//				break;
//			case "4":
//				System.out.println("Not implemented yet, please try again");
//				break;
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
		sb.append("--> 1. History\n");
//		sb.append("--> 2. Subtraction\n");
//		sb.append("--> 3. Multiplication\n");
//		sb.append("--> 4. Division\n");
		sb.append("--> 5. Return to main menu.\n\n>>>");
		System.out.println(sb.toString());
	}
	
	private void historyQuiz(){
		ArrayList<MultipleChoiceOption> questionList = new ArrayList<>();
		Object obj;
		try {
			obj = new JSONParser().parse(new FileReader("files/history.json"));
		
			JSONObject jo = (JSONObject)obj;
	
			JSONArray questions = ((JSONArray)jo.get("questions"));
			Iterator itr = questions.iterator();
			while(itr.hasNext()){
				Map questionBlock = ((Map)itr.next());
				String question = (String) questionBlock.get("question");
//				System.out.println(question);
				String correctAnswer = (String) questionBlock.get("correctAnswer");
//				System.out.println("Correct answer: " + correctAnswer);
				MultipleChoiceOption mco = new MultipleChoiceOption(question, correctAnswer);
				
				JSONArray ja = (JSONArray)questionBlock.get("choices");
				Iterator itr2 = ja.iterator();
	//			ArrayList<String> choices = new ArrayList<>();
				char option = 'A';
				while(itr2.hasNext()){
//					System.out.println(option + ") " + ((Map)itr2.next()).get("choice").toString());
	//				choices.add(((Map)itr2.next()).get("choice").toString());
					mco.addOption(option, ((Map)itr2.next()).get("choice").toString());
					option++;
				}
				mco.printDetails();
				questionList.add(mco);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
