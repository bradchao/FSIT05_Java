package tw.org.iii.mytest;

public class Brad37 {
	public static void main(String[] args) {

	}
}
interface Brad371 {
	void m1();
}
interface Brad372 {
	void m2();
}
interface Brad373 extends Brad371, Brad372 {
	void m3();
}
class Brad374 implements Brad373 {
	public void m1() {}
	public void m2() {}
	public void m3() {}
}
