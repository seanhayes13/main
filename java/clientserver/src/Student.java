import java.io.Serializable;

public class Student  implements Serializable{
	private String firstName;
	private String lastName;
	private int iD = 0;
	
	public Student(String f, String l) {
		firstName = f;
		lastName = l;
	}
	
	public Student(String f, String l, int i) {
		firstName = f;
		lastName = l;
		iD = i;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getiD() {
		return iD;
	}

	public void setiD(int iD) {
		this.iD = iD;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if(iD > 0) {
			sb.append("ID: "+iD);
		}
		sb.append("\n-->First Name: " + firstName);
		sb.append("\n-->Last Name: " + lastName);
		return sb.toString();
	}

}