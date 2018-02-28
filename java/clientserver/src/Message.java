import java.io.Serializable;

public class Message implements Serializable{
	private String type;
	private String user;
	private String message;
	
	public Message(String t, String u){
		type = t;
		user = u;
	}
	
	public Message(String t, String u, String m){
		type = t;
		user = u;
		message = m;
	}

	public String getType() {
		return type;
	}

	public String getUser() {
		return user;
	}

	public String getMessage() {
		return message;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		if(type.equals("LOGIN")){
			sb.append(user + type);
		} else if(type.equals("LOGOUT")){
			sb.append(user + " " + type);
		} else if(type.equals("DATA") || type.equals("NEW_STUDENT")){
			sb.append(user + " " + type + " " + message);
		}
		return sb.toString();
	}

}
