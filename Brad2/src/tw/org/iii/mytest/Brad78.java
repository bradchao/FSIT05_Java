package tw.org.iii.mytest;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Brad78 {
	public static void main(String[] args) {
		System.out.println("Start:" + System.currentTimeMillis());
		String[] urls = {
			"https://www.freeiconspng.com/download/35070",
			"https://sharedparentingconfessional.files.wordpress.com/2016/03/info-site-background-purple-elec-faded.jpg",
			"https://wallpaper4rest.com/nature/wallpaper/space-stars-galaxy-hd-background-images_1-1-800x600.jpg",
			"https://images.alphacoders.com/789/thumb-1920-789452.jpg"
		};
		String[] targets = {"brad01.png","brad02.jpg","brad03.jpg","brad04.jpg",};
		
		for (int i=0; i<urls.length; i++) {
			new FetchURLImage(urls[i], targets[i]).start();
//			new FetchURLImage(urls[i], targets[i]).run();
		}
	}
}
class FetchURLImage extends Thread {
	private String url, target;
	public FetchURLImage(String url, String target) {
		this.url = url;
		this.target = target;
	}
	@Override
	public void run() {
		try {
			URL source = new URL(url);
			HttpURLConnection conn = 
				(HttpURLConnection)source.openConnection();
			conn.connect();
			BufferedInputStream bin = new BufferedInputStream(conn.getInputStream());
			FileOutputStream fout = new FileOutputStream("dir1/" + target);
			byte[] buf = new byte[4096*1024]; int len = 0;
			while ( (len = bin.read(buf)) != -1) {
				fout.write(buf, 0, len);
			}
			fout.flush();
			fout.close();
			bin.close();
			System.out.println(target + ":OK");
		}catch(Exception e) {
			System.out.println(target + ":ERROR");
		}
		System.out.println(System.currentTimeMillis());
	}
}
