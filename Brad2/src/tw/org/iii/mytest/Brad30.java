package tw.org.iii.mytest;

public class Brad30 {
	public static void main(String[] args) {
		Brad302 obj1 = new Brad302();
		byte b1 = 2;
		obj1.m1(b1);
		Brad301 obj2 = new Brad301();
		obj2.m1(1,2);
		obj1.m1(new int[] {1,2,3});
	}
}
class Brad301{
//	int m1(int a) {
//		System.out.println("A1");
//		return 1;
//	}
	void m1(int a, int b) {
		System.out.println("A2");
	}
	void m1(int...as) {	// 不定個數的參數
		System.out.println("A3");
	}
//	void m1(int[] names) {
//		System.out.println("A4");
//	}
	
}
class Brad302 extends Brad301 {
	String m1(byte a){
		System.out.println("B");
		return "a";
	}
	void m1(int[] names) {
		System.out.println("A4");
		//return 21;
	}
}
