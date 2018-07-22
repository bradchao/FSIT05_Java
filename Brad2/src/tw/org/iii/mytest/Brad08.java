package tw.org.iii.mytest;

import javax.swing.JOptionPane;

public class Brad08 {

	public static void main(String[] args) {
		String strYear = JOptionPane.showInputDialog("input a year");
		int year = Integer.parseInt(strYear);
		
		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0) {
					// 29
				}else {
					// 28
				}
			}else {
				// 29
			}
		}else {
			// 28
		}
		
	}

}
