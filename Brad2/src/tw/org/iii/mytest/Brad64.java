package tw.org.iii.mytest;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Brad64 {

	public static void main(String[] args) {
		// 1. read local file
		// 2. send tcp data
		
		try {
			File file = new File("dir1/brad.jpg");
			byte[] buf = new byte[(int)file.length()];
			new FileInputStream(file).read(buf);
			
			Socket socket = new Socket("192.168.201.105",7777);
			
			OutputStream out = socket.getOutputStream();
			out.write(buf);
			out.flush();
			out.close();
			
			socket.close();
			System.out.println("Send OK");
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
