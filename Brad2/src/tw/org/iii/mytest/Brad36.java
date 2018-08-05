package tw.org.iii.mytest;

public class Brad36 {
	public static void main(String[] args) {
		Brad363 obj1 = new Brad363();
		Brad362 obj2 = new Brad363();
	}
}
interface Brad362 {
	void m1();
	void m2();
}
class Brad363 implements Brad362 {
	public void m1() {}
	public void m2() {}
	void m3() {}
}
class Brad364 implements Brad362{
	public void m1() {}
	public void m2() {}	
}
