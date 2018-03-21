package test;

import java.util.ArrayList;
import java.util.Date;

import emailMain.User;
import emailMain.EmailMessage;
import emailMain.EmailServer;

public class NonJUnitTests {
	public static void main(String[] args){
//		testContact();
//		testMultipleContacts();
		testEmailMessages();
	}
	
	private static void testEmailMessages(){
		EmailServer server = new EmailServer();
		User sender = new User("Sean","Hayes","shayes13");
		server.addUser(sender);
		server.userOnline(sender);
		User receiver1 = new User("Anne","Hayes","annehayes");
		server.addUser(receiver1);
		server.userOnline(receiver1);
		User receiver2 = new User("Alex","Hayes","alexhayes");
		server.addUser(receiver2);
		ArrayList<User> receivers = new ArrayList<>();
		receivers.add(receiver1);
		receivers.add(receiver2);
		Date date = new Date();
		String subject = "Hello";
		String[] message = {
				"Hello,\n","\tHow are you?\n\n","Sean"
		};
		EmailMessage em = new EmailMessage(sender, receivers, date,
				subject, message);
		System.out.println(em);
		for(User u : receivers){
			if(server.getUsers().get(u)){
				System.out.println("User: "+u.getUserID() + " is online.");
			} else {
				System.out.println("User: "+u.getUserID() + " is not online.");
			}
			u.addNewEmail(em);
		}
		receiver1.markEmailAsRead(em);
		for(User u : receivers){
			System.out.println("User: " + u.getUserID() + " has");
		}
	}
	
	private static void testContact(){
		User c = new User("Sean","Hayes","shayes13");
		System.out.println(c);
	}
	
	private static void testMultipleContacts(){
		EmailServer server = new EmailServer();
		User c = new User("Sean","Hayes","shayes13");
		addUserToServer(server, c);
		User c2 = new User("Steven","Hayes","shayes13");
		addUserToServer(server, c2);
		User c3 = new User("Anne","Hayes","annehayes");
		addUserToServer(server, c3);
	}
	
	private static void addUserToServer(EmailServer s, User c){
		if(s.addUser(c)){
			System.out.println("User added");
		} else {
			System.out.println("User not added, userID is taken, choose another");
		}
	}
}
