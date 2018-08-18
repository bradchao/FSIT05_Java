package tw.org.iii.mytest;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Brad63 {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("192.168.201.105", 9999);
			
			OutputStream out = socket.getOutputStream();
			out.write("Hello, Brad\nLine1\nLine2".getBytes());
			out.flush();
			out.close();
			
			socket.close();
			System.out.println("OK1");
		} catch (IOException e) {
			System.out.println(e);
		} 
	}

}
