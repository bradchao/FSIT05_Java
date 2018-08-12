package tw.org.iii.mytest;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Brad55 {

	public static void main(String[] args) {
		Student s1 = new Student(90, 60, 24);
		System.out.println(s1.calSum() + ":" + s1.calAvg());
		try(ObjectOutputStream oout = 
				new ObjectOutputStream(
					new FileOutputStream("dir1/brad.object"))){
			oout.writeObject(s1);
			System.out.println("Save OK");
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}

class Student implements Serializable {
	int ch, eng, math;
	Student(int ch,int eng,int math){
		this.ch =ch; this.eng=eng; this.math=math;
	}
	int calSum() {
		return ch + eng + math;
	}
	double calAvg() {
		return calSum()/3.0;
	}
}

