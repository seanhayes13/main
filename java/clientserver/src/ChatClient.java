import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings({ "unused", "serial" })
public class ChatClient extends JFrame implements Runnable{
	
	private Socket socket;
	private JTextArea ta;
	private Thread thread;
	private DataInputStream din;
	private DataOutputStream dout;
	private String loginName;
	private JButton send, logout, newStudent;
	private JTextField tf;
	private JLabel firstNameLabel;
	private JTextField firstNameInput;
	private JLabel lastNameLabel;
	private JTextField lastNameInput;
	
	public ChatClient(String login) throws UnknownHostException, IOException{
		super(login);
		loginName = login;
		
		addWindowListener(new WindowAdapter() {
			public void windowClose(WindowEvent e) {
				try {
					Message m = new Message("LOGOUT",loginName);
					System.out.println(m.toString());
					dout.writeUTF(m.toString());
//					dout.writeUTF(loginName + " " + "LOGOUT");
					System.exit(1);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		ta = new JTextArea(18,50);
		ta.setEditable(false);
		tf = new JTextField(50);
		tf.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					if(tf.getText().length()>0) {
						try {
							Message m = new Message("DATA",loginName,tf.getText().toString());
							System.out.println(m);
							dout.writeUTF(m.toString());
//							dout.writeUTF(loginName+ " " + "DATA " + tf.getText().toString());
							tf.setText("");
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		send = new JButton("Send");
		send.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					Message m = new Message("DATA",loginName,tf.getText().toString());
					System.out.println(m);
					dout.writeUTF(m.toString());
//					dout.writeUTF(loginName+ " " + "DATA " + tf.getText().toString());
					tf.setText("");
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
					Message m = new Message("LOGOUT",loginName);
					dout.writeUTF(m.toString());
//					dout.writeUTF(loginName+ " " + "LOGOUT ");
					System.exit(1);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
		newStudent = new JButton("New Student");
		newStudent.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(firstNameInput.getText().length() > 0 && lastNameInput.getText().length() > 0) {
					Student s = new Student(firstNameInput.getText(), lastNameInput.getText());
					System.out.println(s);
					Message m = new Message("NEW_STUDENT",loginName, s.toString());
					try {
						dout.writeUTF(m.toString());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					tf.setText("");
				}
			}
			
		});
		
		socket = new Socket("localhost",5217);

		din = new DataInputStream(socket.getInputStream());
		dout = new DataOutputStream(socket.getOutputStream());
		dout.writeUTF(loginName);
		dout.writeUTF(loginName + " " +"LOGIN");
		Message m = new Message("LOGIN",loginName);
		dout.writeUTF(m.toString());
		
		
		thread = new Thread(this);
		thread.start();
		setup();
	}
	
	private void setup(){
		setLayout(new BorderLayout());
		setSize(800,400);
		JPanel leftPanel = new JPanel();
		leftPanel.add(new JScrollPane(ta));
		add(leftPanel,BorderLayout.WEST);
		
		JPanel southPanel = new JPanel();
		southPanel.add(tf);
		southPanel.add(send);
		southPanel.add(logout);
		add(southPanel,BorderLayout.SOUTH);
		
		JPanel rightPanel = buildRightPanel();
		add(rightPanel,BorderLayout.EAST);
		setVisible(true);
	}
	
	private JPanel buildRightPanel() {
		JPanel result = new JPanel();
		result.setLayout(new GridBagLayout());
		GridBagConstraints g = new GridBagConstraints();
		g.gridx = 0;
		g.gridy = 0;
		firstNameLabel = new JLabel("First Name:");
		firstNameInput = new JTextField(15);
		lastNameLabel = new JLabel("Last Name:");
		lastNameInput = new JTextField(15);
		result.add(firstNameLabel, g);
		g.gridy++;
		result.add(firstNameInput, g);
		g.gridy++;
		result.add(lastNameLabel, g);
		g.gridy++;
		result.add(lastNameInput, g);
		g.gridy++;
		result.add(newStudent, g);
		return result;
	}

	@Override
	public void run() {
		while(true){
			try {
//				ta.append("\n"+din.readObject().toString());
//				Message m = (Message)din.readObject();
//				ta.append("\n"+m.toString());
				ta.append("\n"+din.readUTF());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}