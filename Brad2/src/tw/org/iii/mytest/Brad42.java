package tw.org.iii.mytest;

public class Brad42 {
	public static void main(String[] args) {
		m1();
	}
	
	static void m1() {
		int a = 10, b = 3;
		try {
			System.out.println(a / b);
			
//		}catch (Exception e) {
//			System.out.println("OK");
//			return;
		}finally {
			System.out.println("OK2");
		}
		System.out.println("OK3");
		
	}
}
