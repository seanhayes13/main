package com.chatClient;
import java.io.*;
import java.net.*;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressWarnings("unused")
public class ChatServer {
	private static Vector clientSockets;
	private Vector loginNames;
	private static AtomicInteger idTracker;
	private static LinkedList<Student> students;
	
	public ChatServer() throws IOException{
		System.out.println("ChatServer started");
		ServerSocket server = null;
		server = new ServerSocket(5217);
		clientSockets = new Vector();
		loginNames = new Vector();
		students = new LinkedList<>();

		idTracker = new AtomicInteger(1);
		while(true){
			Socket client;
			client = server.accept();
			AcceptClient acceptClient = new AcceptClient(client);
			
		}
	}
	
	class AcceptClient extends Thread{
		Socket clientSocket;
//		DataInputStream din;
//		DataOutputStream dout;
		ObjectInputStream objin;
		ObjectOutputStream objout;
		ObjectOutputStream pOut;
		AcceptClient(Socket client) throws IOException {
			clientSocket = client;
//			din = new DataInputStream(clientSocket.getInputStream());
//			dout = new DataOutputStream(clientSocket.getOutputStream());
			if(objin == null){
				objin = new ObjectInputStream(clientSocket.getInputStream());
			}
			if (objout == null){
				objout = new ObjectOutputStream(clientSocket.getOutputStream());
			}

			String loginName = "";
//			loginName = din.readUTF();
			try {
				Message m = (Message)objin.readObject();
				loginName = m.getUser();
				loginNames.add(loginName);
				clientSockets.add(clientSocket);
				System.out.println("Chat Server Ready");
				start();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
//			loginNames.add(loginName);
//			clientSockets.add(clientSocket);
//			System.out.println("Chat Server Ready");
//			start();
			
		}
		
		public void run(){
			while(true){
				try {
//					String msgClient = din.readUTF();
//					StringTokenizer st = new StringTokenizer(msgClient);
//					String loginName = st.nextToken();
//					String msgType = st.nextToken();
					Message m = (Message)objin.readObject();
					String loginName = m.getUser();
					String msgType = m.getType();
					int io = -1;
					if(msgType.equals("LOGIN")){
						for(int i = 0; i < loginNames.size(); i++){
							Socket pSocket = (Socket)clientSockets.elementAt(i);
//							DataOutputStream pOut = new DataOutputStream(pSocket.getOutputStream());
							ObjectOutputStream pOut = new ObjectOutputStream(pSocket.getOutputStream());
//							pOut.writeUTF(loginName + " has logged in");
							pOut.writeObject(m);
						}
					} else if(msgType.equals("LOGOUT")){
						for(int i = 0; i < loginNames.size(); i++){
							if(loginName.equals(loginNames.elementAt(i))){
								io = i;
							}
							Socket pSocket = (Socket)clientSockets.elementAt(i);
//							DataOutputStream pOut = new DataOutputStream(pSocket.getOutputStream());
							ObjectOutputStream pOut = new ObjectOutputStream(pSocket.getOutputStream());
//							pOut.writeUTF(loginName + " has logged out");
							pOut.writeObject(m);
							if(io>=0){
								loginNames.removeElementAt(io);
								clientSockets.removeElementAt(io);
							}
						}
					} else if(msgType.equals("DATA")) {
//						String msg = "";
//						
//						while(st.hasMoreTokens()){
//							msg = msg+" "+st.nextToken();
//						}
						for(int i = 0; i < loginNames.size(); i++){
							Socket pSocket = (Socket)clientSockets.elementAt(i);
//							DataOutputStream pOut = new DataOutputStream(pSocket.getOutputStream());
							ObjectOutputStream pOut = new ObjectOutputStream(pSocket.getOutputStream());
//							pOut.writeUTF(m.toString());
							pOut.writeObject(m);
						}
					} else if(msgType.equals("NEW_STUDENT")){
						objout.writeObject(m);
//						String msg = "";
//						String firstNameLabel1 = st.nextToken();
//						String firstNameLabel2 = st.nextToken();
//						String firstName = st.nextToken();
//						String lastNameLabel1 = st.nextToken();
//						String lastNameLabel2 = st.nextToken();
//						String lastName = st.nextToken();
//						Student s = new Student(firstName, lastName, idTracker.incrementAndGet());
//						students.add(s);
//						dout.writeUTF(s.toString());
//						dout.writeUTF("There are now "+ students.size() + " students in the list");
					}
					if(msgType.equals("LOGOUT")){
						break;
					}
					
//					if(din.readObject() instanceof Student){
//						
//					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(loginNames.size()==0) {
				System.out.println("No more users, closing server");
				System.exit(1);
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		ChatServer server = new ChatServer();
	}

}