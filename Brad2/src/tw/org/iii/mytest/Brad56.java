package tw.org.iii.mytest;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Brad56 {

	public static void main(String[] args) {
		try(ObjectInputStream oin = 
				new ObjectInputStream(new FileInputStream("dir1/brad.object"))){
			Object obj = oin.readObject();
			Student s1 = (Student)obj;
			System.out.println(s1.calSum() + ":" + s1.calAvg());
			System.out.println(s1.bike.getSpeed());
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
