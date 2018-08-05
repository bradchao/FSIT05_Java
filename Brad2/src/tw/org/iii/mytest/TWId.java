package tw.org.iii.mytest;

public class TWId extends Object{
	private String id;
	static final String letters = "ABCDEFGHJKLMNPQRSTUVXYWZIO";
	
	TWId(){
		this((int)(Math.random()*2)==0);
	}
	TWId(boolean isMale){
		this(isMale,(int)(Math.random()*26));
	}
	TWId(int area){
		this((int)(Math.random()*2)==0,area);
	}
	TWId(boolean isMale, int area){
		// super();
		String i1 = letters.substring(area,area+1);
		String i2 = isMale?"1":"2";
		String newid = i1.concat(i2)
				.concat(String.valueOf((int)(Math.random()*10)))
				.concat(String.valueOf((int)(Math.random()*10)))
				.concat(String.valueOf((int)(Math.random()*10)))
				.concat(String.valueOf((int)(Math.random()*10)))
				.concat(String.valueOf((int)(Math.random()*10)))
				.concat(String.valueOf((int)(Math.random()*10)))
				.concat(String.valueOf((int)(Math.random()*10)));
		for (int i=0; i<=9; i++) {
			if (checkId(newid+i)) {
				this.id = newid + i;
				break;
			}
		}
	}
	private TWId(String id){
		this.id = id;
	}
	static TWId createTWId(String id) {
		if (checkId(id)) {
			return new TWId(id);
		}else {
			return null;
		}
	}
	
	static boolean checkId(String id) {
		boolean isRight = false;
		if (id.matches("^[A-Z][12][0-9]{8}$")) {
			
			int n12 = letters.indexOf(id.charAt(0)) + 10;
			int n1 = n12 / 10;
			int n2 = n12 % 10;
			int n3 = Integer.parseInt(id.substring(1, 2));
			int n4 = Integer.parseInt(id.substring(2, 3));
			int n5 = Integer.parseInt(id.substring(3, 4));
			int n6 = Integer.parseInt(id.substring(4, 5));
			int n7 = Integer.parseInt(id.substring(5, 6));
			int n8 = Integer.parseInt(id.substring(6, 7));
			int n9 = Integer.parseInt(id.substring(7, 8));
			int n10 = Integer.parseInt(id.substring(8, 9));
			int n11 = Integer.parseInt(id.substring(9, 10));
			int sum = n1*1 + n2*9 + n3*8 + n4*7 + n5*6 + n6*5 +
					n7*4 + n8*3 + n9*2 + n10*1 + n11*1;
			isRight = sum % 10 == 0;
		}
		return isRight;
	}
	
	String getId() {return id;}
	
	boolean isMale() {
		
		return true;
	}
	
	String getArea() {
		
		return "台中市";
	}
	
	@Override
	public String toString() {
		return id;
	}
	
}
