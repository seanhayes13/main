import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class CaesarCipher extends JFrame {
	CaesarCipherEvent cipher = new CaesarCipherEvent(this);
	
	JLabel key1label = new JLabel("Key 1",JLabel.RIGHT);
	JLabel key2label = new JLabel("Key 2",JLabel.RIGHT);
	JTextField key1 = new JTextField(10);
	JTextField key2 = new JTextField(10);
	JButton encr1K = new JButton("Encrypt Using One Key");
	JButton encr2K = new JButton("Encrypt Using Two Keys");
	JButton decr1KK = new JButton("Decrypt Using One Known Key");
	JButton decr2KK = new JButton("Decrypt Using Two Known Keys");
	JButton decr1UK = new JButton("Decrypt With One Unknown Key");
	JButton decr2UK = new JButton("Decrypt With Two Unknown Keys");
	JTextArea inputMsg = new JTextArea(2,10);
	JTextArea displayRes = new JTextArea(2,10);
	JLabel inputLabel = new JLabel("Input: ",JLabel.RIGHT);
	JLabel resLabel = new JLabel("Result: ",JLabel.RIGHT);
	
	public static void main(String[] arguments){
		new CaesarCipher();
	}
	
	public CaesarCipher(){
		super("Caesar Cipher");
		setSize(1400,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLookAndFeel();
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		//double height = screenSize.getHeight();
		//System.out.println("W: "+width + " | H: "+height);
		
		double baseW = 3200.0;
		//double baseH = 1800.0;
		
		double newFont = width*25/baseW;
		GridBagLayout gridbag = new GridBagLayout();
		
		encr1K.addActionListener(cipher);
		encr2K.addActionListener(cipher);
		
		decr1KK.addActionListener(cipher);
		decr2KK.addActionListener(cipher);
		
		decr1UK.addActionListener(cipher);
		decr2UK.addActionListener(cipher);
		
		setLayout(gridbag);
		GridBagConstraints constraint = new GridBagConstraints();
		constraint.fill = GridBagConstraints.HORIZONTAL;

		displayRes.setEditable(false);
		inputMsg.setLineWrap(true);
		inputMsg.setWrapStyleWord(true);
		
		encr1K.setFont(encr1K.getFont().deriveFont((float)newFont));
	    constraint.weightx = 1;
	    constraint.weighty = 1;
	    constraint.gridwidth = 2;
		constraint.gridx = 0;
		constraint.gridy=3;
		gridbag.setConstraints(encr1K, constraint);
		add(encr1K);
		
		constraint = new GridBagConstraints();
		constraint.fill = GridBagConstraints.HORIZONTAL;
	    encr2K.setFont(encr2K.getFont().deriveFont((float)newFont));
	    constraint.weightx = 1;
	    constraint.weighty = 1;
	    constraint.gridwidth = 2;
	    constraint.gridx = 0;
	    constraint.gridy=4;
		gridbag.setConstraints(encr2K, constraint);
		add(encr2K);
		
		constraint = new GridBagConstraints();	    
		constraint.fill = GridBagConstraints.HORIZONTAL;
	    decr1KK.setFont(decr1KK.getFont().deriveFont((float)newFont));
	    constraint.weightx = 1;
	    constraint.weighty = 1;
	    constraint.gridwidth = 2;
	    constraint.gridx = 2;
	    constraint.gridy=3;
		gridbag.setConstraints(decr1KK, constraint);
		add(decr1KK);
		
		constraint = new GridBagConstraints();		
		constraint.fill = GridBagConstraints.HORIZONTAL;
	    decr2KK.setFont(decr2KK.getFont().deriveFont((float)newFont));
	    constraint.weightx = 1;
	    constraint.weighty = 1;
	    constraint.gridwidth = 2;
		constraint.gridx = 2;
		constraint.gridy=4;
		gridbag.setConstraints(decr2KK, constraint);
		add(decr2KK);
		
		constraint = new GridBagConstraints();	  
		constraint.fill = GridBagConstraints.HORIZONTAL;  
	    decr1UK.setFont(decr1UK.getFont().deriveFont((float)newFont));
	    constraint.weightx = 1;
	    constraint.weighty = 1;
	    constraint.gridwidth = 2;
	    constraint.gridx = 4;
	    constraint.gridy=3;
		gridbag.setConstraints(decr1UK, constraint);
		add(decr1UK);
		
		constraint = new GridBagConstraints();	
		constraint.fill = GridBagConstraints.HORIZONTAL;	
	    decr2UK.setFont(decr2UK.getFont().deriveFont((float)newFont));
	    constraint.weightx = 1;
	    constraint.weighty = 1;
	    constraint.gridwidth = 2;
		constraint.gridx = 4;
		constraint.gridy=4;
		gridbag.setConstraints(decr2UK, constraint);
		add(decr2UK);
		
		constraint = new GridBagConstraints();	
		constraint.fill = GridBagConstraints.HORIZONTAL;    
	    key1.setFont(key1.getFont().deriveFont((float)newFont));
	    constraint.weightx = 1;
	    constraint.weighty = 1;
	    constraint.gridx = 1;
	    constraint.gridy=2;
		gridbag.setConstraints(key1, constraint);
		add(key1);
		
		constraint = new GridBagConstraints();	
		constraint.fill = GridBagConstraints.HORIZONTAL;	
	    key2.setFont(key2.getFont().deriveFont((float)newFont));
	    constraint.weightx = 1;
	    constraint.weighty = 1;
	    constraint.gridx = 3;
	    constraint.gridy=2;
		gridbag.setConstraints(key2, constraint);
		add(key2);
	    
		constraint = new GridBagConstraints();
		constraint.fill = GridBagConstraints.HORIZONTAL;
	    key1label.setFont(key1label.getFont().deriveFont((float)newFont));
	    constraint.weightx = 1;
	    constraint.weighty = 1;
	    constraint.gridx = 0;
	    constraint.gridy=2;
		gridbag.setConstraints(key1label, constraint);
		add(key1label);
		
		constraint = new GridBagConstraints();
		constraint.fill = GridBagConstraints.HORIZONTAL;
	    key2label.setFont(key2label.getFont().deriveFont((float)newFont));
	    constraint.weightx = 1;
	    constraint.weighty = 1;
	    constraint.gridx = 2;
	    constraint.gridy=2;
		gridbag.setConstraints(key2label, constraint);
		add(key2label);
	    
		constraint = new GridBagConstraints();
		constraint.fill = GridBagConstraints.HORIZONTAL;
	    inputLabel.setFont(inputLabel.getFont().deriveFont((float)newFont));
	    constraint.weightx = 1;
	    constraint.weighty = 1;
	    constraint.gridwidth = 1;
	    constraint.gridx = 0;
	    constraint.gridy=0;
		gridbag.setConstraints(inputLabel, constraint);
		add(inputLabel);
		
		constraint = new GridBagConstraints();
		constraint.fill = GridBagConstraints.HORIZONTAL;
	    resLabel.setFont(resLabel.getFont().deriveFont((float)newFont));
	    constraint.weightx = 1;
	    constraint.weighty = 1;
	    constraint.gridx = 0;
	    constraint.gridy=6;
		gridbag.setConstraints(resLabel, constraint);
		add(resLabel);
	    
		constraint = new GridBagConstraints();
		constraint.fill = GridBagConstraints.HORIZONTAL;
	    inputMsg.setFont(inputMsg.getFont().deriveFont((float)newFont));
	    constraint.weightx = 1;
	    constraint.weighty = 1;
	    constraint.gridx = 1;
	    constraint.gridwidth = 5;
	    constraint.gridheight = 2;
	    constraint.gridy=0;
		gridbag.setConstraints(inputMsg, constraint);
		add(inputMsg);
		
		constraint = new GridBagConstraints();
		constraint.fill = GridBagConstraints.HORIZONTAL;
	    displayRes.setFont(displayRes.getFont().deriveFont((float)newFont));
	    constraint.weightx = 1;
	    constraint.weighty = 1;
	    constraint.gridwidth = 5;
	    constraint.gridheight = 2;
	    constraint.gridx = 1;
	    constraint.gridy=6;
		gridbag.setConstraints(displayRes, constraint);
		add(displayRes);
	    
		//pack();
		setVisible(true);
	}
	
	public String encrypt(int key, String input){
		String encr = "";
		String lowerMsg = input.toLowerCase();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String shiftedAlphabet = shiftedAlpha(key);
        for(int ctr = 0; ctr < lowerMsg.length();ctr++){
            char currChar = lowerMsg.charAt(ctr);
            int idx = alphabet.indexOf(currChar);
            if(idx==-1){
            	encr+=currChar;
            }
            if(idx!=-1){
                char newChar = shiftedAlphabet.charAt(idx);
                encr += newChar;
            }
        }
        return encr;
    }
	
	public String encrypt2key(int key1, int key2, String input){
		String encr = "";
		String lowerMsg = input.toLowerCase();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String shiftedAlphabet1 = shiftedAlpha(key1);
        String shiftedAlphabet2 = shiftedAlpha(key2);
        for(int ctr = 0; ctr < lowerMsg.length();ctr++){
        	char currChar = lowerMsg.charAt(ctr);
            int idx = alphabet.indexOf(currChar);
            if(idx==-1){
            	encr+=currChar;
            }
            if(idx!=-1){
                if (ctr%2==0){
                    char newChar = shiftedAlphabet1.charAt(idx);
                    encr += newChar;
                }
                if (ctr%2==1){
                    char newChar = shiftedAlphabet2.charAt(idx);
                    encr += newChar;
                }
            }
        }
        return encr;
    }
	
	public String decryptUnk2Key(String input){
		String result = "";
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String[] bigrams = {"bk","fq","jc","jt","mj","qh","qx","vj","wz","zh","bq","fv","jd","jv","mq","qj","qy","vk","xb","zj","bx","fx","jf","jw","mx","qk","qz","vm","xg","zn","cb","fz","jg","jx","mz","ql","sx","vn","xj","zq","cf","gq","jh","jy","pq","qm","sz","vp","xk","zr","cg","gv","jk","jz","pv","qn","tq","vq","xv","zs","cj","gx","jl","kq","px","qo","tx","vt","xz","zx","cp","hk","jm","kv","qb","qp","vb","vw","yq","cv","hv","jn","kx","qc","qr","vc","vx","yv","cw","hx","jp","kz","qd","qs","vd","vz","yz","cx","hz","jq","lq","qe","qt","vf","wq","zb","dx","iy","jr","lx","qf","qv","vg","wv","zc","fk","jb","js","mg","qg","qw","vh","wx","zg"};
        for (int key1 = 0; key1<26;key1++){
            for (int key2 = 0;key2<26;key2++){
            	String decr="";
                String shiftedAlphabet1 = alphabet.substring(key1)+alphabet.substring(0,key1);
                String shiftedAlphabet2 = alphabet.substring(key2)+alphabet.substring(0,key2);
                for (int ctr = 0; ctr<input.length();ctr++){
                    char currChar = input.charAt(ctr);
                    int idx = alphabet.indexOf(currChar);
                    if(idx==-1){
                    	decr+=currChar;
                    }
                    if(idx!=-1){
                        if (ctr%2==0){
                            char newChar = shiftedAlphabet1.charAt(idx);
                            decr += newChar;
                        }
                        if (ctr%2==1){
                            char newChar = shiftedAlphabet2.charAt(idx);
                            decr += newChar;
                        }
                    }
                }
                int bgCheck = 0;
                for (int bg = 0; bg<bigrams.length; bg++){
                    int check = decr.indexOf(bigrams[bg]);
                    if(check != -1){
                        bgCheck++;
                        //continue;
                    }
                }
                if (bgCheck==0){
                    result = result + decr + "\n";
                	System.out.println(decr);
                }
            }
        }
        return result;
    }
    
    public String decryptUnkKey(String input){
		String result = "None Found";
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String[] bigrams = {"bk","fq","jc","jt","mj","qh","qx","vj","wz","zh","bq","fv","jd","jv","mq","qj","qy","vk","xb","zj","bx","fx","jf","jw","mx","qk","qz","vm","xg","zn","cb","fz","jg","jx","mz","ql","sx","vn","xj","zq","cf","gq","jh","jy","pq","qm","sz","vp","xk","zr","cg","gv","jk","jz","pv","qn","tq","vq","xv","zs","cj","gx","jl","kq","px","qo","tx","vt","xz","zx","cp","hk","jm","kv","qb","qp","vb","vw","yq","cv","hv","jn","kx","qc","qr","vc","vx","yv","cw","hx","jp","kz","qd","qs","vd","vz","yz","cx","hz","jq","lq","qe","qt","vf","wq","zb","dx","iy","jr","lx","qf","qv","vg","wv","zc","fk","jb","js","mg","qg","qw","vh","wx","zg"};
        for (int key1 = 0; key1<26;key1++){
        	String decr = "";
            String shiftedAlphabet = alphabet.substring(key1)+alphabet.substring(0,key1);
            for (int ctr = 0; ctr<input.length();ctr++){
                char currChar = input.charAt(ctr);
                int idx = alphabet.indexOf(currChar);
                if(idx==-1){
                	decr+=currChar;
                }
                if (idx !=-1){
                    char newChar = shiftedAlphabet.charAt(idx);
                    decr += newChar;
                }
            }
            int bgCheck = 0;
            for (int bg = 0; bg<bigrams.length; bg++){
                int check = decr.indexOf(bigrams[bg]);
                if(check != -1){ //if the bigram is present
                    bgCheck++;
                    continue;
                }
            }
            if (bgCheck==0){
                result = decr;
            }
        }
        return result;
    }
	
	public String shiftedAlpha(int key){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String shifted = alphabet.substring(key)+alphabet.substring(0,key);
        return shifted;
	}
	
	private void setLookAndFeel(){
		try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NumbusLookAndFeel");
		} catch (Exception exc){
			
		}
	}
}
