package tw.org.iii.mytest;

public class Brad79 {

	public static void main(String[] args) {
		Brad791 obj1 = new Brad791("A");
		obj1.start();
		
		try {
			Thread.sleep(1000);
		}catch(Exception e) {}
		
		Brad791 obj2 = new Brad791("B");
		obj2.start();
		
		System.out.println("OK1");
		try {
			obj2.join(2000);
		} catch (InterruptedException e) {
		}
		
		System.out.println("OK2");
		
	}

}
class Brad791 extends Thread {
	String name;
	Brad791(String name){this.name = name;}
	@Override
	public void run() {
		try {
			for (int i=0; i<10; i++) {
				System.out.println(name + ":" + i);
//				if (i % 3 == 0) {
//					Brad791 obj2 = new Brad791(name+i);
//					obj2.start(); obj2.join();
//				}else {
					Thread.sleep(500);
//				}
			}
		}catch(Exception e) {
			
		}
	}
}
