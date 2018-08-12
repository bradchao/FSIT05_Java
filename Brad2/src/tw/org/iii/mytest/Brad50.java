package tw.org.iii.mytest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Brad50 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		File source = new File("dir1/brad.jpg");
		final int buflimit = 2000000000;
		byte[] buf = new byte[source.length()<buflimit?(int)source.length():buflimit];
		try {
			FileInputStream fin = new FileInputStream(source);
			FileOutputStream fout = new FileOutputStream("dir2/brad.jpg");
			int len = 0;
			while ((len = fin.read(buf)) != -1) {
				fout.write(buf, 0, len);
			}
			fin.close();
			fout.flush();
			fout.close();
			System.out.println("OK:" + (System.currentTimeMillis()-start));
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
