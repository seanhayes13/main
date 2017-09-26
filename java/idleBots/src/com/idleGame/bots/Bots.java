package com.idleGame.bots;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Bots {
	// Make this a multiple of 2 starting at 1 (1 2, 4, 8, 16, 32, 64
	// pass this value in the BotThread as the sleep value. Breaks in
	// purchases divide this number by 2 cutting the rate time in half
	// each time.
	protected int rate;
	protected int amount;
	protected String type;
	private ArrayList<Integer> discountBreaks = (ArrayList<Integer>) Arrays.asList(10,25,50,100);
	
	public int count;
	
	public void increaseCount(){
		count++;
	}
	
	public int getAmount(){
		
		return amount * count;
	}
	
	public String getType(){
		return type;
	}
	
	public int getRate(){
		return rate;
	}
}
