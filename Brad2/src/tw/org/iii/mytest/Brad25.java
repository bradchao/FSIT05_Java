package tw.org.iii.mytest;

public class Brad25 {
	public static void main(String[] args) {
		Brad251 b1 = new Brad251(2);
		//Brad251 b2 = new Brad251();
		Brad252 b2 = new Brad252();
		
		Brad251 b3 = new Brad251(2);
		System.out.println(b1.equals(b3));
		System.out.println(b1 == b3);
		System.out.println(b1.isSame(b3));
		
		
		
	}
}

class Brad251 {
	private int a;
	Brad251(int a){
		//super();
		this.a = a;
		System.out.println("Brad251()");
	}
	
	public int getA() {return a;}
	
//	public boolean equals(Object obj) {
//		return ((Brad251)obj).getA() == a;
//	}

	public boolean isSame(Brad251 obj) {
		return obj.getA() == a; 
	}
	
}
class Brad252 extends Brad251 {
	Brad252(){
		// super();
		super(3);
	}
}
class Brad253 extends Brad252 {
	
}
