package tw.org.iii.mytest;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Brad60 {
	public static void main(String[] args) {
		while (true) {
			byte[] buf = new byte[1024];
			try {
				DatagramSocket socket = new DatagramSocket(8888);
				DatagramPacket packet = new DatagramPacket(buf, buf.length);
				socket.receive(packet);
				socket.close();
				
				byte[] data = packet.getData();
				int len = packet.getLength();
				InetAddress ip = packet.getAddress();
				String mesg = new String(data,0, len); 
				System.out.println(ip.getHostAddress() + ":" +
						len + ":" + 
						mesg);
				
				if (mesg.equals("stop")) {
					System.out.println("will stop");
					break;
				}
			} catch (IOException e) {
				System.out.println(e);
				break;
			}
		}
		
	}
}
