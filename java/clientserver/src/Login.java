import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Login");
		JPanel pane = new JPanel();
		JTextField loginName = new JTextField(20);
		JButton submit = new JButton("Submit");
		
		pane.add(loginName);
		pane.add(submit);
		
		frame.setSize(300, 100);
		frame.add(pane);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					ChatClient chat = new ChatClient(loginName.getText());
					frame.setVisible(false);
					frame.dispose();
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
		loginName.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					if(loginName.getText().length()>0) {
						try {
							ChatClient chat = new ChatClient(loginName.getText());
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
	}

}
