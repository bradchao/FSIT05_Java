package tw.org.iii.mytest;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Brad58 {

	public static void main(String[] args) {
		try(ObjectInputStream oin = 
				new ObjectInputStream(new FileInputStream("dir1/brad2.object"))){
			Object obj = oin.readObject();
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
