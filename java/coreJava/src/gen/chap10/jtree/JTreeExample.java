package gen.chap10.jtree;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class JTreeExample extends JFrame{
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	
	public JTreeExample(){
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("World");
		DefaultMutableTreeNode country = new DefaultMutableTreeNode("USA");
		
		root.add(country);
		
		DefaultMutableTreeNode state = new DefaultMutableTreeNode("California");
		country.add(state);
		
		DefaultMutableTreeNode city = new DefaultMutableTreeNode("San Jose");
		state.add(city);
		
		city = new DefaultMutableTreeNode("Cupertino");
		state.add(city);
		
		state = new DefaultMutableTreeNode("Michigan");
		country.add(state);
		
		city = new DefaultMutableTreeNode("Ann Arbor");
		state.add(city);
		
		JTree tree = new JTree(root);
		add(new JScrollPane(tree));
	}
}
