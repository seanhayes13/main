package com.idleGame;

import java.time.Instant;

import com.idleGame.bots.Bots;
import com.idleGame.gui.UserInterface;

public class BotThread extends Thread {
	private Instant startTime;
	private Instant timeNow;
	private UserInterface ui;
	private Bots bot;
	//private long balance;
	private long diff;

	public BotThread(Bots b, Instant s, UserInterface u) {
		startTime = s;
		ui = u;
		bot = b;
	}
	
	/*
	 * Look into having this method update a variable in the UserInterface
	 * which will have it's own method that will periodically update the
	 * text field, this way only one method is actively updating the field
	 * and the variable can be synchronized
	 */

	@Override
	public void run() {
		System.out.println("Running...");
		boolean check = true;
		while(check){
			resetDiff();
			if (diff >= bot.getRate() /*&& (diff % bot.getRate() == 0)*/) {
				System.out.println("Adding " + bot.getAmount() + " from " + bot.getType());
				//balance += bot.getAmount();
				int balance = Integer.parseInt(ui.balanceDisplay.getText());
				balance +=bot.getAmount();
				System.out.println("Updating balance to " + balance);
				ui.balanceDisplay.setText(String.valueOf(balance));
				//check balance and update buttons
				//This section may provide an opening for using the template panel concept
				//from FileCabinets: load basic and alpha, after user purchases the first alpha
				//the bravo panel will get loaded
				resetDiff();
			} else {
				System.out.println("hmmm" + diff);
				resetDiff();
			}
		}
	}
	
	private void resetDiff(){
		try {
			Thread.sleep(bot.getRate());
			timeNow = Instant.now();
			diff = (timeNow.getEpochSecond() - startTime.getEpochSecond())*bot.getRate();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
