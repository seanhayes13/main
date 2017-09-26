package com.idleGame.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.idleGame.BotList;
import com.idleGame.actions.IdleGameActions;

public class UserInterface {
	private IdleGameActions iga;
	private BotList bl;
	
	private JFrame frame;
	private JPanel pane;
	
	public JTextField basicCounter;
	public JTextField alphaCounter;
	public JTextField balanceDisplay;
	
	public void display(){
		frame = new JFrame("Idle Bots");
		frame.add(pane);
//		frame.setSize(800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

		JLabel basicLabel = new JLabel("Basic Bots");
		pane.add(basicLabel,gbc);
		gbc.gridy = 1;
		basicCounter = new JTextField();
		basicCounter.setEditable(false);
		basicCounter.setText(String.valueOf(1));
		pane.add(basicCounter,gbc);
		gbc.gridy = 2;
		JButton basicAddBtn = new JButton("Build Basic Bot");
		basicAddBtn.setActionCommand("addbasic");
		basicAddBtn.addActionListener(iga);
		pane.add(basicAddBtn,gbc);
		gbc.gridy = 0;
		gbc.gridx = 1;

		JLabel alphaLabel = new JLabel("Alpha Bots");
		pane.add(alphaLabel,gbc);
		gbc.gridy = 1;
		alphaCounter = new JTextField();
		alphaCounter.setText("0");
		alphaCounter.setEditable(false);
		pane.add(alphaCounter,gbc);
		gbc.gridy = 2;
		JButton alphaAddBtn = new JButton("Build Alpha Bot");
		alphaAddBtn.setActionCommand("addalpha");
		alphaAddBtn.addActionListener(iga);
		pane.add(alphaAddBtn,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		JLabel balanceLabel = new JLabel("Balance");
		pane.add(balanceLabel, gbc);
		balanceDisplay = new JTextField();
		balanceDisplay.setText(String.valueOf(0));
		balanceDisplay.setEditable(false);
		gbc.gridx = 1;
		pane.add(balanceDisplay,gbc);
	}
	
	public void setIGA(IdleGameActions i){
		iga = i;
	}
	
	public IdleGameActions getIGA(){
		return iga;
	}
	
	public void setBotList(BotList b){
		bl = b;
	}
	
	public BotList getBotList(){
		return bl;
	}
}
