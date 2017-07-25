package gen.chap2;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Chapter2Samples {
	public static void main(String[] args){
		
	}
	
	public static void section1_3(){
		try {
			FileInputStream fin = new FileInputStream("employee.dat");
			DataInputStream din = new DataInputStream(fin);
			double x = din.readDouble();
			//byte b = (byte)fin.read();
		} catch (FileNotFoundException e) {
			e.getMessage();
		} catch (IOException e) {
			e.getMessage();
		}
	}
}
