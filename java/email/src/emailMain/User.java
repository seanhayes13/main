package emailMain;

import java.util.LinkedHashMap;
import java.util.LinkedList;

/*
 * This class will be what is saved to xml
 */

public class User {
	private String firstName;
	private String lastName;
	private String userID;
	private LinkedHashMap<EmailMessage, MessageStatus> messages;
	
	public User(){}
	
	public User(String f, String l, String u){
		firstName = f;
		lastName = l;
		userID = u;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("User ID: "+userID);
		sb.append("\nFirst Name: "+firstName);
		sb.append("\nLast Name: "+lastName);
		return sb.toString();
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getUserID() {
		return userID;
	}
	
	public void addNewEmail(EmailMessage em){
		messages.put(em, MessageStatus.UNREAD);
	}
	
	public void markEmailAsRead(EmailMessage em){
		messages.put(em, MessageStatus.READ);
	}
}
