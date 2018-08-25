package tw.org.iii.clock;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;


public class DigitalClock extends AbstractClock {
	private final static int LEDW = 8;
	private final static int LEDL = 48;
	private final static BasicStroke stroke = new BasicStroke(LEDW, BasicStroke.CAP_ROUND, 0);
	private final int GAP = 3*LEDW/2;
	
	int map[][] = {
			{1,1,1,0,1,1,1},
			{0,0,1,0,0,1,0},
			{1,0,1,1,1,0,1},
			{1,0,1,1,0,1,1},
			{0,1,1,1,0,1,0},
			{1,1,0,1,0,1,1},
			{1,1,0,1,1,1,1},
			{1,0,1,0,0,1,0},
			{1,1,1,1,1,1,1},
			{1,1,1,1,0,1,0}
	};
	
	public DigitalClock() {
		setPreferredSize(new Dimension(300,100));
	}
	
	
	
	public void paintComponent(Graphics gg) {
		Graphics2D g = (Graphics2D)gg;
		RenderingHints rh = new RenderingHints(
				RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	    g.setRenderingHints(rh);
		Dimension d = getSize();
		Stroke os = g.getStroke();
		g.setColor(Color.black);
		g.fillRect(0, 0, d.width, d.height);
		int YOFF = 5;
		int dh = d.height-YOFF*2;
		int dw = (dh-LEDW*3)/2;
		int hh = getTime(HOURS);
		int h1 = hh/10;
		if (h1==0) h1=-1;
		int xoff = drawDigit(g, h1, GAP, YOFF, dw, dh);
		int h2 = hh % 10;
		xoff = drawDigit(g, h2, xoff, YOFF, dw, dh);
		xoff = drawColon(g, xoff+LEDL/3, YOFF, dw, dh);
		int m = getTime(MINS);
		int m1 = m/10;
		xoff = drawDigit(g, m1, xoff, YOFF, dw, dh);
		int m2 = m % 10;
		drawDigit(g, m2, xoff, YOFF, dw, dh);
		g.setStroke(os);
	}



	private int drawColon(Graphics2D g, int xoff, int yoff, int dw,
			int dh) {
		g.setStroke(stroke);
		g.setColor(Color.red);
		int o = LEDW;
		g.drawLine(xoff, yoff+dh/4-LEDW/3, xoff, yoff+dh/4+LEDW/3);
		g.drawLine(xoff, yoff+3*dh/4-LEDW/3, xoff, yoff+3*dh/4+LEDW/3);
		return xoff+LEDW+GAP;
	}



	private int drawDigit(Graphics2D g, int v, int xoff, int yoff, int w, int h) {
		if (v != -1) {
			g.setStroke(stroke);
			g.setColor(Color.red);
			int[] m = map[v];
			int o = LEDW;
			if (m[0] == 1)
				g.drawLine(xoff+o, yoff, xoff+w-o, yoff);
			if (m[1] == 1)
				g.drawLine(xoff, yoff+o, xoff, yoff+h/2-o);
			if (m[2] == 1)
				g.drawLine(xoff+w, yoff+o, xoff+w, yoff+h/2-o);
			if (m[3] == 1)
				g.drawLine(xoff+o, yoff+h/2, xoff+w-o, yoff+h/2);
			if (m[4] == 1)
				g.drawLine(xoff, yoff+h/2+o, xoff, yoff+h-o);
			if (m[5] == 1)
				g.drawLine(xoff+w, yoff+h/2+o, xoff+w, yoff+h-o);
			if (m[6] == 1)
				g.drawLine(xoff+o, yoff+h, xoff+w-o, yoff+h);
		}
		return xoff + w + GAP;
	}
}
	
