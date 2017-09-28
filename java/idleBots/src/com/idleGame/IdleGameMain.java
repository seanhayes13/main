package com.idleGame;

import com.idleGame.actions.IdleGameActions;
import com.idleGame.gui.UserInterface;

public class IdleGameMain {
	public static void main(String[] args) throws InterruptedException{
		UserInterface ui = new UserInterface();
		BotList bl = new BotList(ui);
		System.out.println("Bot list created");
//		IdleGameActions iga = new IdleGameActions(bl, ui);
//		System.out.println("Actions listener started");
//		ui.setIGA(iga);
		System.out.println("Display running");
		ui.setBotList(bl);
		System.out.println("Actions set on interface");
		ui.setUpPane();
		System.out.println("Pane set up");
		ui.display();
		System.out.println("Bot list set on interface");
		System.out.println("Ready to roll");
//		Instant timeNow;
//		long sum = 0;
//		long diff;
//		int time = 0;
//		int count = 0;
//		while(time < 100000){
//			timeNow = Instant.now();
//			diff = timeNow.getEpochSecond() - startTime.getEpochSecond();
//			/*
//			 * Need to iterate through each array list in in the bots
//			 * object and run the code below for each of those lists
//			 */
////			for(Bots b : bots){
////				if(diff >= b.getRate() && diff%b.getRate()==0){
////					System.out.println(count + "- Adding " + b.getRate());
////					sum += b.getRate();
////					System.out.println(count + "- sum: "+sum);
////				}				
////			}
//			count++;
//			time++;
//			Thread.sleep(1000);
//		}
	}
}
