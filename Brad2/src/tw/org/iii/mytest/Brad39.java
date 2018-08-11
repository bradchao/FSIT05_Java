package tw.org.iii.mytest;

public class Brad39 {
	public static void main(String[] args) {
		Brad391 obj1 = new Brad391();
		Brad391.Brad392 obj2 = obj1.new Brad392();
		obj2.m1();
		Brad391.Brad393 obj3 = new Brad391.Brad393();
		obj3.m1();
	}
}
class Brad391 {
	private int a = 10;
	class Brad392 {
		Brad391 m1() {
			System.out.println("Brad391:Brad392:m1()");
			System.out.println(a);
			return Brad391.this;
		}
	}
	
	static class Brad393 {
		void m1() {
			System.out.println("Brad391:Brad393:m1()");
		}
	}
}
