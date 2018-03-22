package emailMain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/*
 * This form will have basic login text fields with buttons for
 * logging in, registering. Other features (password reset,
 * delete account, etc) will come later.
 */
public class MainForm extends JFrame implements ActionListener{
	private JTextField userIDInput;
	private JTextField passwordInput;
	private JButton loginBtn;
	private JButton registerBtn;
	
	public MainForm(){
		super("Temp App Name");
		buildDisplay();
	}
	
	private void buildDisplay(){
		this.setSize(400, 400);
		
		loginBtn = new JButton("Login");
		loginBtn.setActionCommand("login");
		loginBtn.addActionListener(this);
		
		registerBtn = new JButton("Register");
		registerBtn.setActionCommand("register");
		registerBtn.addActionListener(this);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getActionCommand().equals("login")){
			
		}
		if(event.getActionCommand().equals("register")){
			
		}
	}
}
