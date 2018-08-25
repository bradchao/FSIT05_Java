package tw.org.iii.mytest;

public class Brad76 {
	public static void main(String[] args) {
		Brad761 t1 = new Brad761("A");
		Brad761 t2 = new Brad761("B");
		t1.start();
		t2.start();
		System.out.println("OK");
		try {
			Thread.sleep(3*1000);
		}catch(Exception e) {
			
		}
		System.out.println("wakeup");
		t1.run();
		t2.run();
	}
}
class Brad761 extends Thread {
	String name;
	Brad761(String name){this.name = name;}
	@Override
	public void run() {
		for (int i=0; i<10; i++) {
			System.out.println(name + ":" + i);
			try {
				Thread.sleep(100);
			}catch(Exception e) {
				break;
			}
		}
	}
}
