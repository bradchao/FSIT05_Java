package tw.org.iii.mytest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Brad46 {

	public static void main(String[] args) {
		try {
			File source = new File("dir1/brad.txt");
			FileInputStream fin = new FileInputStream(source);

			byte[] b = new byte[(int)(source.length())];
			fin.read(b);
			fin.close();
			System.out.println(new String(b));
			
		}catch(FileNotFoundException fe) {
			
		}catch(IOException fe) {
			
			
		}
	}

}
