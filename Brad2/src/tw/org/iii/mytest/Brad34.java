package tw.org.iii.mytest;

public class Brad34 {
	public static void main(String[] args) {
		Brad341 obj1 = new Brad342();
		Brad341 obj2 = new Brad343();
		obj1.m2();
		obj2.m2();
		
	}
}
abstract class Brad341 {
	void m1() {System.out.println("Brad341:m1()");}
	abstract void m2();
}
class Brad342 extends Brad341 {
	void m2() {System.out.println("Brad242:m2()");}
}
class Brad343 extends Brad341 {
	void m2() {System.out.println("Brad243:m2()");}
}
