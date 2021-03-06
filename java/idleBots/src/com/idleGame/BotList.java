package com.idleGame;

import java.time.Instant;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.idleGame.bots.AlphaBot;
import com.idleGame.bots.BasicBot;
import com.idleGame.bots.Bots;
import com.idleGame.gui.UserInterface;

public class BotList {
	protected ArrayList<String> bots = new ArrayList<>();
	protected static BasicBot basicBot;
	protected static AlphaBot alphaBot;
	private UserInterface ui;
	
	private ExecutorService pool = Executors.newFixedThreadPool(2);
	
	public ExecutorService getPool() {
		return pool;
	}

	public void setPool(ExecutorService pool) {
		this.pool = pool;
	}

	public BotList(UserInterface u){
		ui = u;
	}
	
	public boolean newBot(String s){
		if(bots.contains(s)){
			return false;
		} else {
			return true;
		}
	}
	
	public void addBot(Bots b){
		if(b instanceof BasicBot){
			if(!bots.contains(b.getType())){
				basicBot = new BasicBot();
				bots.add(basicBot.getType());
				BotThread bt = new BotThread(basicBot,Instant.now(),ui);
				pool.submit(bt);
			} else {
				basicBot.increaseCount();
			}
		}
		if(b instanceof AlphaBot){
			if(!bots.contains(b.getType())){
				alphaBot = new AlphaBot();
				bots.add(alphaBot.getType());
				BotThread bt = new BotThread(alphaBot,Instant.now(),ui);
				pool.submit(bt);
			} else {
				alphaBot.increaseCount();
			}
		}
	}

	public ArrayList<String> getBots() {
		return bots;
	}

	public void setBots(ArrayList<String> bots) {
		this.bots = bots;
	}

	public BasicBot getBasicBot() {
		return basicBot;
	}

	public void setBasicBot(BasicBot basicBot) {
		BotList.basicBot = basicBot;
	}

	public AlphaBot getAlphaBot() {
		return alphaBot;
	}

	public void setAlphaBot(AlphaBot alphaBot) {
		BotList.alphaBot = alphaBot;
	}

}
