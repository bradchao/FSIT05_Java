package tw.org.iii.mytest;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Brad59 {

	public static void main(String[] args) {
		try {
			InetAddress[] ips = InetAddress.getAllByName("www.bradchao.com");
			for (InetAddress ip : ips) {
				System.out.println(ip.getHostAddress());	
			}			
		} catch (UnknownHostException e) {
			System.out.println(e.toString());
		}
		
	}

}
