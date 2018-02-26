package com.socketTest;

import java.io.*;
import java.net.*;

public class Client {
	private Socket socket = null;
	private ObjectInputStream inputStream = null;
	private ObjectOutputStream outputStream = null;
	private boolean isConnected = false;

	public Client() {
	}

	public void communicate(Student s) {
		while (!isConnected) {
			try {
				if(socket==null){
					socket = new Socket("127.0.0.1", 11111);
				}
				System.out.println("Client Connected");
				isConnected = true;
				outputStream = new ObjectOutputStream(socket.getOutputStream());
				inputStream = new ObjectInputStream(socket.getInputStream());
				System.out.println("Object to be written = " + s);
				outputStream.writeObject(s);
				Student newStudent = (Student)inputStream.readObject();
				System.out.println("New: " +newStudent);
				
				outputStream.close();
				inputStream.close();
				socket.close();
				System.out.println("Client socket closed");
			} catch (SocketException se) {
				se.printStackTrace();
				 System.exit(0);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		isConnected = false;
	}

	public static void main(String[] args) {
		Client client = new Client();
		
		Student s = new Student(1, "James");
		client.communicate(s);
		
//		Student s2 = new Student(2, "John");
//		client.communicate(s2);
//		
//		Student s3 = new Student(3, "Mary");
//		client.communicate(s3);
//		
//		Student s4 = new Student(4, "Susan");
//		client.communicate(s4);
	}

}
