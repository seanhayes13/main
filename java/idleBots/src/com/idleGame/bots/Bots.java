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
	//change this to a float and change the increment amount to a fraction of the cost
	protected double cost;
	//private ArrayList<Integer> discountBreaks = (ArrayList<Integer>) Arrays.asList(10,25,50,100);
	
	protected int count;
	
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
	
	public void increaseCost(){
		cost *= 1.2;
	}
	
	public int getCost(){
		return (int)cost;
	}
	
	public int getCount(){
		return count;
	}
	
	/*
	 * Need to write a method to set the time reduction and rate increase
	 * based on how the count of each bot. This will need to account for
	 * situations where further reductions become impossible (reducing rate
	 * when rate is already at 1
	 */
}
