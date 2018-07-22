package tw.org.iii.mytest;

import javax.swing.JOptionPane;

public class Brad04 {
	public static void main(String[] args) {
		String a1 = JOptionPane.showInputDialog("Input a number1");
		String a2 = JOptionPane.showInputDialog("Input a number2");
		System.out.println(a1 + " : " + a2);
		
		int i1 = Integer.parseInt(a1);
		int i2 = Integer.parseInt(a2);
		int r1 = i1 / i2;
		int r2 = i1 % i2;
		System.out.println(i1 + " / " + i2 + " = " + r1 + "......" + r2);
	}
}
