package tw.org.iii.mytest;
import java.io.FileOutputStream;
import java.io.IOException;

public class Brad47 {

	public static void main(String[] args) {
		try {
			FileOutputStream fout = new FileOutputStream("dir1/brad4.txt",true);
			fout.write("abcdefg\n".getBytes());
			fout.write("abcdefg\n".getBytes());
			fout.write("abcdefg\n".getBytes());
			fout.flush();
			fout.close();
			System.out.println("OK");
		}catch(IOException ie) {
			System.out.println(ie);
		}
	}

}
