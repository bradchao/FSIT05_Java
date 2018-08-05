package tw.org.iii.mytest;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class MyPanel extends JPanel {
	public MyPanel() {
		System.out.println("MyPanel()");

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		System.out.println("paint");
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		System.out.println("paintComponent");
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.RED);
		g2d.fillOval((int)(Math.random()*400), (int)(Math.random()*400), 80, 80);
	}
	
}
