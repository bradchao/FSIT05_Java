package tw.org.iii.mytest;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.Serializable;
import java.util.LinkedList;

import javax.imageio.ImageIO;
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
	
	public void saveJPEG() {
		BufferedImage paintImage = 
			new BufferedImage(
				getWidth(), getHeight(), 
				BufferedImage.TYPE_3BYTE_BGR);
		Graphics2D graphics2D = paintImage.createGraphics();
	    paint(graphics2D);
		try {
			ImageIO.write(paintImage, "jpeg", new File("dir1/brad1.jpg"));
		}catch(Exception e) {
			System.out.println(e);
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
	
	public LinkedList<LinkedList<MyPoint>> getLines() {return lines;}
	public void setLines(LinkedList<LinkedList<MyPoint>> lines) {
		this.lines = lines;
		repaint();
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
}
class MyPoint implements Serializable {
	int x, y;
	public MyPoint(int x, int y) {this.x =x ; this.y = y;}
}

