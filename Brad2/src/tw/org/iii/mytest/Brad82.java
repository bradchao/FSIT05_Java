package tw.org.iii.mytest;

import java.util.HashSet;

public class Brad82 {

	public static void main(String[] args) {
		Brad821 obj1 = new Brad821(300);
		System.out.println(obj1.x);
		Brad821 obj2 = test1(obj1);
		System.out.println(obj2.x);
		System.out.println(obj1 == obj2);
		
	}
	
	static Brad821 test1(Brad821 obj) {
		obj = new Brad821(100);
		return obj;
	}
	
}
class Brad821 {
	int x;
	Brad821(int x){this.x = x;}
}
