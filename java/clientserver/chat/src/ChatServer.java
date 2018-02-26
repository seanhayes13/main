import java.io.*;
import java.io.IOException;
import java.net.*;
import java.util.StringTokenizer;
import java.util.Vector;

public class ChatServer {
	private static Vector clientSockets;
	private Vector loginNames;
	
	public ChatServer() throws IOException{
		ServerSocket server = new ServerSocket(5217);
		clientSockets = new Vector();
		loginNames = new Vector();
		
		while(true){
			Socket client = server.accept();
			AcceptClient acceptClient = new AcceptClient(client);
			
		}
	}
	
	class AcceptClient extends Thread{
		Socket clientSocket;
		DataInputStream din;
		DataOutputStream dout;
		AcceptClient(Socket client) throws IOException{
			clientSocket = client;
			din = new DataInputStream(clientSocket.getInputStream());
			dout = new DataOutputStream(clientSocket.getOutputStream());
			
			String loginName = din.readUTF();
			
			loginNames.add(loginName);
			clientSockets.add(clientSocket);
			
			start();
		}
		
		public void run(){
			while(true){
				try {
					String msgClient = din.readUTF();
					StringTokenizer st = new StringTokenizer(msgClient);
					String loginName = st.nextToken();
					String msgType = st.nextToken();
					int io = -1;
					
					String msg = "";
					
					while(st.hasMoreTokens()){
						msg = msg+" "+st.nextToken();
					}
					
					if(msgType.equals("LOGIN")){
						for(int i = 0; i < loginNames.size(); i++){
							Socket pSocket = (Socket)clientSockets.elementAt(i);
							DataOutputStream pOut = new DataOutputStream(pSocket.getOutputStream());
							pOut.writeUTF(loginName + " has logged in");
						}
					} else if(msgType.equals("LOGOUT")){
						for(int i = 0; i < loginNames.size(); i++){
							if(loginName == loginNames.elementAt(i)){
								io = i;
							}
							Socket pSocket = (Socket)clientSockets.elementAt(i);
							DataOutputStream pOut = new DataOutputStream(pSocket.getOutputStream());
							pOut.writeUTF(loginName + " has logged out");
							if(io>=0){
								loginNames.removeElementAt(io);
								clientSockets.removeElementAt(io);
							}
						}
					} else {
						for(int i = 0; i < loginNames.size(); i++){
							Socket pSocket = (Socket)clientSockets.elementAt(i);
							DataOutputStream pOut = new DataOutputStream(pSocket.getOutputStream());
							pOut.writeUTF(loginName + ": " + msg);
						}
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		ChatServer server = new ChatServer();
	}

}
