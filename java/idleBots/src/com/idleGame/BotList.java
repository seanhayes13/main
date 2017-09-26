package com.idleGame;

import java.time.Instant;
import java.util.ArrayList;

import com.idleGame.bots.AlphaBot;
import com.idleGame.bots.BasicBot;
import com.idleGame.bots.Bots;
import com.idleGame.gui.UserInterface;

public class BotList {
	protected ArrayList<String> bots = new ArrayList<>();
	protected long balance;
	protected BasicBot basicBot;
	protected AlphaBot alphaBot;
	private UserInterface ui;
	
	public BotList(UserInterface u){
		basicBot = new BasicBot();
		bots.add("basic");
		balance = 0;
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
			basicBot.increaseCount();
		}
		if(b instanceof AlphaBot){
			if(alphaBot == null){
				alphaBot = new AlphaBot();
				bots.add("alpha");
			} else {
				alphaBot.increaseCount();
			}
		}
	}
	
	public void start(){
		BotThread bt = new BotThread(basicBot,Instant.now(),ui);
		bt.run();
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
		this.basicBot = basicBot;
	}

	public AlphaBot getAlphaBot() {
		return alphaBot;
	}

	public void setAlphaBot(AlphaBot alphaBot) {
		this.alphaBot = alphaBot;
	}

}
