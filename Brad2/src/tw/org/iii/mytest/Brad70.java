package tw.org.iii.mytest;

public class Brad70 {
	public static void main(String[] args) {
		int a = 10;
		Integer b = new Integer(10);
		Integer c = new Integer("10");
		Integer d = 10;		// auto-boxing
		System.out.println(d + 6); 	// unWrapper => auto-unboxing
		
		System.out.println(b.equals(d));
		
	}
}
