package com.idleGame.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.idleGame.BotList;
import com.idleGame.actions.IdleGameActions;
import com.idleGame.bots.AlphaBot;
import com.idleGame.bots.BasicBot;

public class UserInterface {
	//public long balance = 1;
	
	//private IdleGameActions iga;
	private BotList bl;
	
	private static AtomicInteger cash;

	private ArrayList<BotPanel> botPanels = new ArrayList<>();
	
	public ArrayList<BotPanel> getBotPanels() {
		return botPanels;
	}

	public void setBotPanels(ArrayList<BotPanel> botPanels) {
		this.botPanels = botPanels;
	}

	private JFrame frame;
	private JPanel pane;
	
	public JTextField basicCounter;
	public JTextField basicCost;
	public JTextField alphaCounter;
	public JTextField alphaCost;
	public JTextField balanceDisplay;
	
	public JButton basicAddBtn;
	public JButton alphaAddBtn;
	
	public void display(){
		if(cash==null){
			cash = new AtomicInteger(1);
		}
		frame = new JFrame("Idle Bots");
		frame.add(pane);
//		frame.setSize(800, 800);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	System.out.println("Current total cash: " + cash.get());
		        System.out.println("Shutting down");
		        System.exit(0);
		    }
		});
		frame.setLocation(300, 100);
		frame.pack();
		frame.setVisible(true);
	}
	
	public void setUpPane(){
		pane = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(20,20,20,20);
		gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.CENTER;
		
		BotPanel bp = new BotPanel(new BasicBot(), this);
		bp.buildPanel();
		botPanels.add(bp);
		pane.add(bp, gbc);
		
		gbc.gridx++;
		bp = new BotPanel(new AlphaBot(), this);
		bp.buildPanel();
//		bp.disablePanel();
		botPanels.add(bp);
		pane.add(bp, gbc);
		
		//Repeat later for additional bots
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		JLabel balanceLabel = new JLabel("Balance");
		pane.add(balanceLabel, gbc);
		balanceDisplay = new JTextField();
		balanceDisplay.setText(String.valueOf(1));
		balanceDisplay.setEditable(false);
		gbc.gridx = 1;
		pane.add(balanceDisplay,gbc);
	}
	
//	public void setIGA(IdleGameActions i){
//		iga = i;
//	}
//	
//	public IdleGameActions getIGA(){
//		return iga;
//	}
	
	public void setBotList(BotList b){
		bl = b;
	}
	
	public BotList getBotList(){
		return bl;
	}
	
	public int getCash(){
		return cash.get();
	}
	
	public void updateCash(int i){
		cash.addAndGet(i);
	}
	
	public void deductCash(int i){
		cash.set(cash.get() - i);
	}
	
	public void updateButtons(){
		for(BotPanel bp : botPanels){
			if(bp.isEnabled()){
				bp.checkCost(cash.get());
			}
		}
	}
}
