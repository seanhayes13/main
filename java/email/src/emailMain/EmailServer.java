package emailMain;

import java.util.HashMap;

public class EmailServer {
	private HashMap<User, Boolean> users;
	
	public EmailServer(){
		users = new HashMap<>();
	}
	
	public boolean addUser(User c){
		if(users.size() == 0){
			System.out.println("No existing users, adding user.");
			users.put(c, false);
			return true;
		} else {
			for(User cIter : users.keySet()){
				if(cIter.getUserID().equals(c.getUserID())){
					System.out.println("UserID is taken, try again.");
					return false;
				}
			}
			System.out.println("UserID is not taken, adding user.");
			users.put(c, false);
			return true;
		}
	}
	
	public void loadContacts(){
		
	}
	
	private void newContact(User c){
		//create the xml file: userID.xml
	}
	
	public void userOnline(User u){
		users.put(u, true);
	}
	
	public void userOffline(User u){
		users.put(u, false);
	}
	
	public HashMap<User,Boolean> getUsers(){
		return users;
	}
}
