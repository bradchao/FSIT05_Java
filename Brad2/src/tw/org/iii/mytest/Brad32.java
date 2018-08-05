package tw.org.iii.mytest;

public class Brad32 {
	public static void main(String[] args) {

	}
}
class Brad321{
	void m1() {
		System.out.println("Brad321:m1()");
	}
}
class Brad322 extends Brad321 {
	void m1() {
		System.out.println("Brad322:m1()");
		super.m1();
	}
}
