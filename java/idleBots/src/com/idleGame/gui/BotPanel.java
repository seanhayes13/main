package com.idleGame.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.idleGame.BotList;
import com.idleGame.BotThread;
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
		botCount.setText(String.valueOf(bot.count));
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
		buyBot.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if( (Integer.parseInt(ui.balanceDisplay.getText()) - bot.getCost()) >=0){
					if(!ui.getBotPanels().get(pos+1).active){
						ui.getBotPanels().get(pos+1).enablePanel();
						start();
					}
					System.out.println("Adding " + bot.getType() +" bot");
					int cost = bot.getCost();
					ui.balanceDisplay.setText(String.valueOf(Integer.parseInt(ui.balanceDisplay.getText())-cost));
					bot.increaseCost();
					bot.increaseCount();
					botCount.setText(String.valueOf(bot.count));
					botCost.setText(String.valueOf(bot.getCost()));
				} else {
					System.out.println("Oops" + (Integer.parseInt(ui.balanceDisplay.getText()) - bot.getCost()));
				}
			}
		});
		add(buyBot,gbc);
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
		BotThread bt = new BotThread(bot,Instant.now(),ui);
		ui.getBotList().getPool().submit(bt);
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
