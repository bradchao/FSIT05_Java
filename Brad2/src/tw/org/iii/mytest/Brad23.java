package tw.org.iii.mytest;

public class Brad23 {

	public static void main(String[] args) {
		String s1 = new String();
		byte[] b2 = {97,98,99,100}; 
		String s2 = new String(b2);
		String s3 = new String(b2,1,2);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
		s1 = new String(b2);
		String s4 = "Brad";
		String s5 = "Brad";
		String s6 = new String(s4);
		String s7 = new String(s5);
		
		int a = 10, b = 10;
		System.out.println(a == b);
		System.out.println(s4 == s5);
		System.out.println(s4 == s6);
		System.out.println(s6 == s7);
		System.out.println("-----");
		System.out.println(s4.equals(s5));
		System.out.println(s4.equals(s6));
		System.out.println(s6.equals(s7));
		System.out.println("-----");
		s4 = s6;
		System.out.println(s4 == s6);
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
