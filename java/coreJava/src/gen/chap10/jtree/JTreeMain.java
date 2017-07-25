package gen.chap10.jtree;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class JTreeMain {
	public static void main(String[] args){
		EventQueue.invokeLater(()->
		{
			JFrame frame = new JTreeExample();
			frame.setTitle("Test");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		}
		);
	}
}
