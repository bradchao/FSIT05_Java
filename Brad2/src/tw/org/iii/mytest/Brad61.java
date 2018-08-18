package tw.org.iii.mytest;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Brad61 {
	public static void main(String[] args) {
		byte[] buf = "Hello, World".getBytes();
		try {
			DatagramSocket socket = new DatagramSocket();
			DatagramPacket packet = new DatagramPacket(
					buf, buf.length, 
					InetAddress.getByName("192.168.201.105"), 
					8888);
			socket.send(packet);
			socket.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	
	}
}
