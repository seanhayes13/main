package com.idleGame;

import com.idleGame.bots.BasicBot;
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
		BasicBot startBot = new BasicBot();
		ui.getBotList().addBot(startBot);
		System.out.println("Bot list set on interface");
		System.out.println("Ready to roll");
	}
}
