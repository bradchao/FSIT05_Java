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

public class Brad68 {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://pdfmyurl.com/?url=www.gamer.com.tw");
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.connect();

			FileOutputStream fout = new FileOutputStream("dir3/gamer.pdf");
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
