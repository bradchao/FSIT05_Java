package tw.org.iii.mytest;

import java.awt.FontFormatException;
import java.io.IOException;
import java.text.ParseException;

public class Brad43 {
	public static void main(String[] args) throws Exception{
		Bird b1 = new Bird();
//		try {
			b1.setLeg(2);
//		}catch(ParseException e) {
//			
//		}catch(IOException e) {
//			
//		}
	}
}
class Bird {
	private int leg;
	void setLeg(int leg) throws ParseException, IOException{
		if (leg<0) {
			throw new ParseException("XXX",3);
		}else if(leg>2) {
			throw new IOException();
		}else {
			this.leg = leg;	
		}		
	}
}
class BirdV2 extends Bird {
	void setLegV2(int leg) throws ParseException, IOException, FontFormatException{
		super.setLeg(leg);
		if (leg>1000) {
			throw new FontFormatException("");
		}
	}
}
