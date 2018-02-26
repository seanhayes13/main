package com.socketTest;

public class SocketTestMain {
	public static void main(String[] args){
		System.out.println("Calling Server");
		Server.main(args);
		System.out.println("Calling Client");
		Client.main(args);
		System.out.println("Finished");
	}

}
