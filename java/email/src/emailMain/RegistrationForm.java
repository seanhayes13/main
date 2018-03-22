package emailMain;

import javax.swing.JFrame;
import javax.swing.JTextField;

/*
 * This frame will be a simple frame to get the user information
 * needed to create an instance of the User class. The submit button
 * will need to check that a user with that userID does not already 
 * exist (see code in NonJUnitTests)
 */

public class RegistrationForm extends JFrame{
	//JLabel
	private JTextField firstNameInput;
	//JLabel
	private JTextField lastNameInput;
	//JLabel
	private JTextField userIDInput;
}
