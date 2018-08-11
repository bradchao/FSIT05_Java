package tw.org.iii.mytest;

public class Brad41 {
	public static void main(String[] args) {
		int a = 10, b = 3;
		int c;
		int[] d = new int[3];
		
		try {
			c = a / b;
			System.out.println(c);
			System.out.println(d[13]);
//		}catch (ArithmeticException e) {
//			System.out.println("Ooop2");
		}catch (RuntimeException e) {
			System.out.println("Ooop1");
		}
		
		System.out.println("Game Over");
	}
}
