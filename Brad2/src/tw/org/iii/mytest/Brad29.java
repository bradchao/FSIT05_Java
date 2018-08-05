package tw.org.iii.mytest;

public class Brad29 {
	public static void main(String[] args) {
		Brad291 obj1 = new Brad291();
		obj1.m1();
		Brad291 obj2 = new Brad292();
		obj2.m1();
		Brad292 obj3 = (Brad292)obj2;	// OK
		obj3.m1();
		obj3.m2();
		System.out.println(obj2 == obj3);
		
		if (obj1 instanceof Brad292) {
			Brad292 obj4 = (Brad292)obj1; //=> RuntimeException	
		}else {
			System.out.println("xx");
		}
		
				
		Brad294 obj5 = new Brad294();
		//Brad292 obj6 = (Brad292)obj5; //=> compile error
		
		
	}
}
class Brad291{
	void m1(){
		System.out.println("Brad291:m1()");
	}
}
class Brad292 extends Brad291{
	void m1(){
		System.out.println("Brad292:m1()");
	}
	void m2(){}
}
class Brad293 extends Brad292{void m3(){}}
class Brad294{}
