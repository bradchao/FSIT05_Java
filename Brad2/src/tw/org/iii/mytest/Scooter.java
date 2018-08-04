package tw.org.iii.mytest;

public class Scooter extends Bike{
	private int gear;
	
	void chageGear(int gear) {
		this.gear = gear;
	}
	
	int getGear() {
		return gear;
	}
	
	void upSpeed(){
		super.upSpeed();
		speed *= gear;
	}
	
	double getSpeed() {
		return speed+2;
	}
}
