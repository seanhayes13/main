import java.awt.event.*;

import javax.swing.JButton;

public class CaesarCipherEvent implements ActionListener{
	CaesarCipher gui;
	
	public CaesarCipherEvent(CaesarCipher cc){
		gui = cc;
	}
	
	public void actionPerformed(ActionEvent event){
		String command = event.getActionCommand();
		if(command.equals("Encrypt Using One Key")){
			String getInput = gui.inputMsg.getText();
			int getKey1 = Integer.parseInt(gui.key1.getText());
			String encryptedMsg = gui.encrypt(getKey1,getInput);
			gui.displayRes.setText(encryptedMsg);
		}
		if(command.equals("Encrypt Using Two Keys")){
			String getInput = gui.inputMsg.getText();
			int getKey1 = Integer.parseInt(gui.key1.getText());
			int getKey2 = Integer.parseInt(gui.key2.getText());
			String encryptedMsg = gui.encrypt2key(getKey1, getKey2, getInput);
			gui.displayRes.setText(encryptedMsg);
		}
		if(command.equals("Decrypt Using One Known Key")){
			String getInput = gui.inputMsg.getText();
			int getKey1 = Integer.parseInt(gui.key1.getText());
			String decryptedMsg = gui.encrypt(26-getKey1, getInput);
			gui.displayRes.setText(decryptedMsg);
		}
		if(command.equals("Decrypt Using Two Known Keys")){
			String getInput = gui.inputMsg.getText();
			int getKey1 = Integer.parseInt(gui.key1.getText());
			int getKey2 = Integer.parseInt(gui.key2.getText());
			String decryptedMsg = gui.encrypt2key(26-getKey1, 26-getKey2, getInput);
			gui.displayRes.setText(decryptedMsg);
		}
		if(command.equals("Decrypt With One Unknown Key")){
			String getInput = gui.inputMsg.getText();
			String decryptedMsg = gui.decryptUnkKey(getInput);
			gui.displayRes.setText(decryptedMsg);
		}
		if(command.equals("Decrypt With Two Unknown Keys")){
			String getInput = gui.inputMsg.getText();
			String decryptedMsg = gui.decryptUnk2Key(getInput);
			gui.displayRes.setText(decryptedMsg);
		}
	}
}
