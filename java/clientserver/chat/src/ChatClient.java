import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame implements Runnable{
	
	private Socket socket;
	private JTextArea ta;
	private Thread thread;
	private DataInputStream din;
	private DataOutputStream dout;
	private String loginName;
	private JButton send, logout;
	private JTextField tf;
	
	public ChatClient(String login) throws UnknownHostException, IOException{
		super(login);
		loginName = login;
		
		ta = new JTextArea(18,50);
		tf = new JTextField(50);
		send = new JButton("Send");
		send.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					dout.writeUTF(loginName+ " " + "DATA " + tf.getText().toString());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		logout = new JButton("Logout");
		logout.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					dout.writeUTF(loginName+ " " + "LOGOUT ");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		socket = new Socket("localhost",5217);
		
		din = new DataInputStream(socket.getInputStream());
		dout = new DataOutputStream(socket.getOutputStream());
		
		dout.writeUTF(loginName);
		dout.writeUTF(loginName + " " +"LOGIN");
		
		thread = new Thread(this);
		thread.start();
		setup();
	}
	
	private void setup(){
		setSize(600,400);
		JPanel panel = new JPanel();
		panel.add(new JScrollPane(ta));
		panel.add(tf);
		panel.add(send);
		panel.add(logout);
		add(panel);
		setVisible(true);
	}

	@Override
	public void run() {
		while(true){
			try {
				ta.append("\n"+din.readUTF());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException{
		ChatClient client = new ChatClient("User2");
		
	}

}
