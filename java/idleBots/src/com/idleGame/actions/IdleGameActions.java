package com.idleGame.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

import com.idleGame.BotList;
import com.idleGame.BotThread;
import com.idleGame.bots.AlphaBot;
import com.idleGame.gui.UserInterface;

public class IdleGameActions implements ActionListener{
	private UserInterface ui;
	
	private BotList bots;
	
	public IdleGameActions(BotList b, UserInterface u){
		bots = b;
		ui = u;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String action = event.getActionCommand();
		if(action.equals("addbasic")){
			System.out.println("Adding basic bot");
			ui.balanceDisplay.setText(String.valueOf(Integer.parseInt(ui.balanceDisplay.getText())-1));
			bots.getBasicBot().increaseCount();
			ui.basicCounter.setText(String.valueOf(bots.getBasicBot().count));
		} if(action.equals("addalpha")){
			System.out.println("Adding alpha bot");
			if(bots.getBots().contains("alpha")){
				bots.getAlphaBot().increaseCount();
			} else {
				AlphaBot alpha = new AlphaBot();
				bots.addBot(alpha);
				BotThread alphaBT = new BotThread(alpha,Instant.now(),ui);
				alphaBT.run();
			}
			ui.alphaCounter.setText(String.valueOf(bots.getAlphaBot().count));
		}
	}
}
