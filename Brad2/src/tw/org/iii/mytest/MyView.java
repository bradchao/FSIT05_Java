package tw.org.iii.mytest;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;

import javax.swing.JPanel;

public class MyView extends JPanel {
	private MyMouseListener mouseListener = new MyMouseListener();
	private LinkedList<LinkedList<MyPoint>> lines = new LinkedList<>();
	private LinkedList<LinkedList<MyPoint>> recycle = new LinkedList<>();
	
	public MyView() {
		setBackground(Color.YELLOW);
		addMouseListener(mouseListener);
		addMouseMotionListener(mouseListener);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setStroke(new BasicStroke(4));
		g2d.setColor(Color.BLUE);
		
		for (LinkedList<MyPoint> line : lines) {
			for (int i=1; i<line.size(); i++) {
				MyPoint p0 = line.get(i-1);
				MyPoint p1 = line.get(i);
				g2d.drawLine(p0.x, p0.y, p1.x, p1.y);
			}
		}
	}
	
	public void clear() {
		lines.clear();
		repaint();
	}
	
	public void undo() {
		if (lines.size()>0) {
			recycle.add(lines.removeLast());
			repaint();
		}
	}
	public void redo() {
		if (recycle.size()>0) {
			lines.add(recycle.removeLast());
			repaint();
		}
	}
	
	private class MyMouseListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			LinkedList<MyPoint> line = new LinkedList<>();
			MyPoint point = new MyPoint(e.getX(),e.getY());
			line.add(point);
			lines.add(line);
			recycle.clear();
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			MyPoint point = new MyPoint(e.getX(),e.getY());
			lines.getLast().add(point);
			repaint();
		}
		
	}
	
	private class MyPoint {
		int x, y;
		public MyPoint(int x, int y) {this.x =x ; this.y = y;}
	}
	
}
