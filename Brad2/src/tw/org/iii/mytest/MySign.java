package tw.org.iii.mytest;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MySign extends JFrame {
	private JButton clear, undo;
	private MyView myView;
	
	public MySign() {
		super("簽名");
	
		setLayout(new BorderLayout());
		JPanel top = new JPanel(new FlowLayout());
		clear = new JButton("Clear");
		undo = new JButton("Undo");
		top.add(clear); top.add(undo);
		add(top, BorderLayout.NORTH);
		
		myView = new MyView();
		add(myView, BorderLayout.CENTER);
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new MySign();
	}	

}
