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
			if(Integer.parseInt(ui.basicCost.getText())>Integer.parseInt(ui.balanceDisplay.getText())){
				System.out.println("Adding basic bot");
				int cost = bots.getBasicBot().getCost();
				ui.balanceDisplay.setText(String.valueOf(Integer.parseInt(ui.balanceDisplay.getText())-cost));
				bots.getBasicBot().increaseCost();
				bots.getBasicBot().increaseCount();
				ui.basicCounter.setText(String.valueOf(bots.getBasicBot().count));
				ui.basicCost.setText(String.valueOf(bots.getBasicBot().getCost()));				
			} else {
				
			}
		} if(action.equals("addalpha")){
			if(Integer.parseInt(ui.alphaCost.getText())>Integer.parseInt(ui.balanceDisplay.getText())){
				System.out.println("Adding alpha bot");
				if(bots.getBots().contains("alpha")){
					bots.getAlphaBot().increaseCount();
					ui.balanceDisplay.setText(String.valueOf(Integer.parseInt(ui.balanceDisplay.getText())-1));
				} else {
					AlphaBot alpha = new AlphaBot();
					bots.addBot(alpha);
				}
				ui.alphaCounter.setText(String.valueOf(bots.getAlphaBot().count));				
			} else {
				
			}
		}
	}
	
	private void updateBtns(){
		//basic
		if(Integer.parseInt(ui.balanceDisplay.getText())>bots.getBasicBot().getCost()){
			ui.basicAddBtn.setEnabled(true);
		} else {
			ui.basicAddBtn.setEnabled(false);
		}
		//alpha
	}
}
