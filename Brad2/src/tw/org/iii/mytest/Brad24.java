package tw.org.iii.mytest;

public class Brad24 {
	public static void main(String[] args) {
		Bike b1 = new Bike();
		Scooter s1 = new Scooter();
		System.out.println(b1.getSpeed());
		System.out.println(s1.getSpeed());
		b1.upSpeed();
		s1.upSpeed();
		System.out.println(b1.getSpeed());
		System.out.println(s1.getSpeed());
		s1.chageGear(3);
		s1.upSpeed();
		System.out.println(s1.getSpeed());
		//b1.chageGear(3);
		
		
	}
}
