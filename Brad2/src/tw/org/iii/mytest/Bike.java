package tw.org.iii.mytest;

public class Bike extends Object{
	double speed;
	
	Bike(){
		speed = 0;
	}
	Bike(double speed){
		this.speed = speed;
	}
	
	void upSpeed() {
		speed = speed==0?1:speed*1.4;
	}
	void upSpeed(int gear) {
		speed = speed==0?1:speed*gear*1.2;
	}
	
	
	void downSpeed() {
		speed = speed==1?0:speed*0.7;
	}
	
	double getSpeed() {
		return speed;
	}
	
}
