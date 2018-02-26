package com.socketTest;

import java.io.*;
import java.net.*;

public class Server {

	public static void main(String[] args) {
		try {
			System.out.println("Start Server");
			ServerSocket serverSocket = new ServerSocket(11111);
			Socket socket = serverSocket.accept();
			System.out.println("Server Connected");
			ObjectInputStream inStream = new ObjectInputStream(socket.getInputStream());
			ObjectOutputStream outStream = new ObjectOutputStream(socket.getOutputStream());
			Student student = (Student) inStream.readObject();
			System.out.println("Object received = " + student);
			outStream.writeObject(student);
			System.out.println("Object written");
			inStream.close();
			outStream.close();
		} catch (SocketException se) {
			System.out.println(se.getLocalizedMessage());
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException cn) {
			cn.printStackTrace();
		}
	}
}
