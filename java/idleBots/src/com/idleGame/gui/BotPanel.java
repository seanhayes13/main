package com.idleGame.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.idleGame.BotList;
import com.idleGame.BotThread;
import com.idleGame.bots.BasicBot;
import com.idleGame.bots.Bots;

@SuppressWarnings("serial")
public class BotPanel extends JPanel{
	private UserInterface ui;
	
	public boolean active = true;
	
	public JLabel botLabel;
	public JLabel countLabel;
	public JTextField botCount;
	public JLabel costLabel;
	public JTextField botCost;
	public JButton buyBot;
	public JButton buyTenBots;
	
	private int pos;
	
	private Bots bot;
	
	public BotPanel(Bots b, UserInterface u){
		bot = b;
		ui = u;
	}
	
	public void buildPanel(){
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(10,10,10,10);
		gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.CENTER;


		botLabel = new JLabel(bot.getType() + " Bots");
		gbc.gridwidth = 2;
		add(botLabel,gbc);
		gbc.gridy++;
		
		countLabel = new JLabel("Number of Bots");
		gbc.gridwidth = 1;
		add(countLabel,gbc);
		gbc.gridx++;
		botCount = new JTextField(7);
		botCount.setEditable(false);
		botCount.setText(String.valueOf(bot.getCount()));
		add(botCount,gbc);
		gbc.gridx = 0;
		gbc.gridy++;
		
		costLabel = new JLabel("Cost per Bot");
		add(costLabel,gbc);
		gbc.gridx++;		
		botCost = new JTextField(7);
		botCost.setEditable(false);
		botCost.setText(String.valueOf(bot.getCost()));
		add(botCost,gbc);
		gbc.gridx = 0;
		gbc.gridy++;
		
		buyBot = new JButton("Build " + bot.getType() + " Bot");
		gbc.gridwidth = 2;
		buyBot.setEnabled(false);
		buyBot.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if( (ui.getCash() - bot.getCost()) >=0){
					if(!ui.getBotPanels().get(pos+1).active){
						ui.getBotPanels().get(pos+1).enablePanel();
//						start();
					}
					System.out.println("Adding " + bot.getType() +" bot");
					int cost = bot.getCost();
					ui.deductCash(cost);
					ui.getBotList().addBot(bot);
					ui.balanceDisplay.setText(String.valueOf(ui.getCash()));
					bot.increaseCost();
					bot.increaseCount();
					botCount.setText(String.valueOf(bot.getCount()));
					botCost.setText(String.valueOf(bot.getCost()));
				} else {
					System.out.println("Oops" + (ui.getCash() - bot.getCost()));
				}
			}
		});
		add(buyBot,gbc);
		gbc.gridy++;
		
		buyTenBots = new JButton("Build 10 " + bot.getType() + " Bots");
		buyTenBots.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event){
				JOptionPane.showMessageDialog(null, "Not implemented yet");
			}
		});
		buyTenBots.setEnabled(false);
		add(buyTenBots, gbc);
	}
	
	public void enablePanel(){
		botLabel.setEnabled(true);
		botCount.setEnabled(true);
		botCost.setEnabled(true);
		buyBot.setEnabled(true);
	}
	
	public void disablePanel(){
		botLabel.setEnabled(false);
		botCount.setEnabled(false);
		botCost.setEnabled(false);
		buyBot.setEnabled(false);
		active = false;
	}
	
	public void setPos(int i){
		pos = i;
	}
	
	public int getPos(){
		return pos;
	}
	
	public void start(){
		BasicBot startBot = new BasicBot();
		ui.getBotList().addBot(startBot);
	}
	
	public void checkCost(int i){
		//Add check for buyBot button
//		System.out.println(bot.getType() + " - cost:" + bot.getCost());
		if((bot.getCost())<= i){
			buyBot.setEnabled(true);
		} else {
			buyBot.setEnabled(false);
		}
		if((bot.getCost()*10)<= i){
			buyTenBots.setEnabled(true);
		} else {
			buyTenBots.setEnabled(false);
		}
		//Add check for buy100Bots button when we get around to it
	}
	
//	private void checkCost(){
//		try {
//			Thread.sleep(bot.getRate());
//			if(Integer.parseInt(ui.balanceDisplay.getText())<bot.getCost()){
//				buyBot.setEnabled(false);
//			} else {
//				buyBot.setEnabled(true);
//			}
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
}
