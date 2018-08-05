package tw.org.iii.mytest;

public class Brad33 {
	public static void main(String[] args) {
		//Brad332.m2();
		//Brad331 obj1 = new Brad331();
		Brad332 obj2 = new Brad332();
		Brad332 obj3 = new Brad332();
	}
}
class Brad331{
	static {System.out.println("Brad331{static}");}
	{System.out.println("Brad331{}");}
	Brad331(){System.out.println("Brad331()");}
	void m1(){System.out.println("Brad331:m1()");}
	static void m2(){System.out.println("Brad331:m2()");}
}
class Brad332 extends Brad331{
	static {System.out.println("Brad332{static}");}
	{System.out.println("Brad332{}");}
	Brad332(){System.out.println("Brad332()");}
	void m1(){System.out.println("Brad332:m1()");}
	static void m2(){System.out.println("Brad332:m2()");}
}
