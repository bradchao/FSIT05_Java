package tw.org.iii.mytest;

public class Brad81 {
	public static void main(String[] args) {
		ATMv2 atm = new ATMv2();
		Bankv2 bank = new Bankv2(atm);
		Personv2 pA = new Personv2(atm, "A");
		Personv2 pB = new Personv2(atm, "B");
		Personv2 pC = new Personv2(atm, "C");
		Personv2 pD = new Personv2(atm, "D");
		bank.start();
		pA.start();pB.start();pC.start();pD.start();
	}
}
class ATMv2 {
	private int limit = 1000;
	private int money;
	void add(int add) {
		while (money+add>1000) {
			try {
				System.out.println("bank:" + add + ":wait(" + money+")");
				wait();
			}catch(Exception e) {}
		}
		money += add;
		System.out.println("add:" + add + " => " + money);
		notifyAll();
	}
	void get(int get, String name) {
		while (money<get) {
			try {
				System.out.println(name + ":" + get + ":wait(" + money+")");
				wait();
			}catch(Exception e) {}
		}
		money-=get;
		System.out.println(name + ":get:" + get + " => " + money);
		notifyAll();
	}
}
class Bankv2 extends Thread {
	private ATMv2 atm;
	Bankv2(ATMv2 atm){this.atm = atm;}
	@Override
	public void run() {
		for (int i=0; i<50; i++) {
			synchronized (atm) {
				atm.add(200);
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}
}

class Personv2 extends Thread {
	private ATMv2 atm;
	private String name;
	Personv2(ATMv2 atm, String name){this.atm = atm; this.name = name;}
	@Override
	public void run() {
		for (int i=0; i<50; i++) {
			synchronized (atm) {
				atm.get((int)(Math.random()*100)+1, name);
			}
			try {
				Thread.sleep(100);
			}catch(Exception e) {}
		}
		System.out.println(name + ":stop");
	}
}
