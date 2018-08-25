package tw.org.iii.mytest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Brad85 {
	public static void main(String[] args) {
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		System.out.println(date);
		System.out.println(calendar);
		
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		System.out.println(df.format(date));
		System.out.println(df.format(calendar.getTime()));
		
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH)+1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println(year + "/" + month + "/" + day);
		
		calendar.add(Calendar.WEEK_OF_YEAR, -2);
		System.out.println(df.format(calendar.getTime()));
		
		
		
		
		
		
		
		
		
	}
}
