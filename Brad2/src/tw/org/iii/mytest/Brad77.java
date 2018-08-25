package tw.org.iii.mytest;

import java.util.LinkedList;
import java.util.TimerTask;

public class Brad77 {
	public static void main(String[] args) {
		Brad771 obj1 = new Brad771();
		Brad772 obj2 = new Brad772();
		Brad773 obj3 = new Brad773();
		
		obj1.start();
		//Thread t2 = new Thread(obj2);
		//t2.start();
		Thread t3 = new Thread(obj3);
		t3.start();
		
		Thread t4 = new Thread(obj2) {
			public void run() {
				System.out.println("t4");
			}
		};
		t4.start();
		
		new Thread() {
			int a;
			public void run() {
				for (int i=10000; i<10020; i++) {
					System.out.println(i);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
					}
				}
			}
			public void test1() {
				System.out.println("test1");
			}
		}.start();
		
		System.out.println("OK");
	}
}
class Brad771 extends Thread {
	@Override
	public void run() {
		for (int i=0; i<20; i++) {
			System.out.println(i);
			try {
				Thread.sleep(100);
			}catch(Exception e) {}
		}
	}
}
class Brad772 implements Runnable {
	@Override
	public void run() {
		for (int i=100; i<120; i++) {
			System.out.println(i);
			try {
				Thread.sleep(100);
			}catch(Exception e) {}
		}
	}
}
class Brad773 extends TimerTask {
	@Override
	public void run() {
		for (int i=1000; i<1020; i++) {
			System.out.println(i);
			try {
				Thread.sleep(100);
			}catch(Exception e) {}
		}
	}
}
