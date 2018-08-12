package tw.org.iii.mytest;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class Brad53 {

	public static void main(String[] args) {
		try {
			DataOutputStream dout = 
				new DataOutputStream(
					new FileOutputStream("dir1/brad.dat"));
			dout.writeInt(4);
			dout.writeUTF("Brad");
			dout.writeBoolean(false);
			dout.flush();
			dout.close();
			System.out.println("Save OK");
		}catch(Exception e) {
			
		}
		
	}

}
