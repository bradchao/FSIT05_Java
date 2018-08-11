package tw.org.iii.mytest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Brad46 {

	public static void main(String[] args) {
		try {
			FileInputStream fin = new FileInputStream("dir1/brad.txt");

			int temp; byte[] b = new byte[3];
			while ( (temp = fin.read(b)) != -1) {
				System.out.print(new String(b,0,temp));
			}
			
			
			fin.close();
		}catch(FileNotFoundException fe) {
			
		}catch(IOException fe) {
			
			
		}
	}

}
