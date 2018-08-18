package tw.org.iii.mytest;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Brad65 {
	public static void main(String[] args) {
		
		try {
			ServerSocket server = new ServerSocket(7777);
			Socket socket = server.accept();

			FileOutputStream fout = new FileOutputStream("dir3/iii.jpg");
			
			InputStream in = socket.getInputStream();
			int len; byte[] buf = new byte[4096*1024];
			while ( (len = in.read(buf)) != -1) {
				fout.write(buf,0,len);
			}
			in.close();
			
			fout.flush();
			fout.close();
			
			server.close();
			
			System.out.println("Receive OK");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
	}
}
