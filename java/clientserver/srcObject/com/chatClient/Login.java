package com.chatClient;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class Login {
	public static void main(String[] args) throws ParseException {
		JFrame frame = new JFrame("Login");
		JPanel pane = new JPanel();
//		MaskFormatter formatter = new MaskFormatter("AAAAAAAAAAAAAAAA");
//		JFormattedTextField loginName = new JFormattedTextField(formatter);
//		loginName.setColumns(20);
		JTextField loginName = new JTextField(20);
		JButton submit = new JButton("Submit");
		
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
//				System.out.println("Name: '"+ loginName.getText()+"'");
				if(loginName.getText().length()>0) {
//					System.out.println("A");
					try {
//						System.out.println("Name2: '"+ loginName.getText()+"'");
						String login = loginName.getText();
						ChatClient chat = new ChatClient(login);
						frame.setVisible(false);
						frame.dispose();
					} catch (UnknownHostException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (IOException e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					}
				}
			}
			
		});
		
		loginName.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
//				System.out.println("Name: '"+ loginName.getText()+"'");
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					if(loginName.getText().length()>0) {
//						System.out.println("B");
						try {
//							System.out.println("Name2: '"+ loginName.getText()+"'");
							String login = loginName.getText();
							ChatClient chat = new ChatClient(login);
							frame.setVisible(false);
							frame.dispose();
						} catch (UnknownHostException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						} catch (IOException e3) {
							// TODO Auto-generated catch block
							e3.printStackTrace();
						}
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		pane.add(loginName);
		pane.add(submit);
		
		frame.setSize(300, 100);
		frame.add(pane);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}