package emailMain;
import java.util.ArrayList;
import java.util.Date;

public class EmailMessage {
	private User sender;
	private ArrayList<User> receiver;
	private Date sendDate;
	private String subject;
	private String[] message;
	
	public EmailMessage(){}
	
	public EmailMessage(User send, ArrayList<User> rec,
			Date d, String sub, String[] m){
		sender = send;
		receiver = rec;
		sendDate = d;
		subject = sub;
		message = m;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("From: "+sender.getUserID());
		sb.append("\nTo: ");
		for(int i = 0; i < receiver.size(); i++){
			sb.append(receiver.get(i).getUserID());
			if(i < receiver.size()-1)
				sb.append(", ");
		}
		sb.append("\nDate: " + sendDate.toString());
		sb.append("\nSubject: "+subject);
		sb.append("\nMessage:\n");
		for(String s : message){
			sb.append(s);
		}
		return sb.toString();
	}
}
