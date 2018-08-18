package tw.org.iii.mytest;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class Brad67 {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://www.newbalance.com.tw/uploads/e9e5e8d477eb4cf4250c6d97eadb8290.jpg");
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.connect();

			FileOutputStream fout = new FileOutputStream("dir3/ok.jpg");
			BufferedInputStream bin = new BufferedInputStream(conn.getInputStream());
			byte[] buf = new byte[4096]; int len;
			while ( (len = bin.read(buf)) != -1) {
				fout.write(buf, 0, len);
			}
			bin.close();
			fout.flush();
			fout.close();
			
			System.out.println("fetch ok");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
