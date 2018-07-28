package tw.org.iii.mytest;

public class Brad11 {

	public static void main(String[] args) {
		byte a = 11, b = 100;
		final byte c = 100;
		
		switch (a) {
			case 1: 
				System.out.println("A"); 
				break;
			default:
				System.out.println("X"); 
				//break;
			case c-90: 
				System.out.println("B"); 
				break;
			case c-91: 
				System.out.println("C"); 
				break;
//			case 1000: 
//				System.out.println("D"); 
//				break;
		}
		
		
	}

}
