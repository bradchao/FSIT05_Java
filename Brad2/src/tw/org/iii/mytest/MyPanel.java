package tw.org.iii.mytest;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class MyPanel extends JPanel implements MouseListener {
	private int x, y;
	Color color;
	
	public MyPanel() {
		
	}
	
	public MyPanel(int x, int y) {
		this.x = x; this.y = y;
		color = Color.RED;
		addMouseListener(this);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(color);
		g2d.fillOval(x, y, 80, 80);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("A");
		x = e.getX()-40; y = e.getY()-40;
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
