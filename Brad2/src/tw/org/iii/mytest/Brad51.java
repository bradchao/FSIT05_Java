package tw.org.iii.mytest;

import java.io.FileReader;

public class Brad51 {

	public static void main(String[] args) {
		String a = null;
		System.out.println(a);
		
		
		
		try {
			FileReader reader = new FileReader("dir1/brad.txt");
			int v = reader.read();
			System.out.println((char)v);
			v = reader.read();
			System.out.println((char)v);
			v = reader.read();
			System.out.println((char)v);
			reader.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		
	}

}
