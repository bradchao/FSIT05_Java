package tw.org.iii.clock;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.Rectangle2D;


@SuppressWarnings("serial")
public class AnalogClock extends AbstractClock implements MouseListener, MouseMotionListener {
	final static int NUMBERS  = 0x1;
	final static int MAJOR_TICKS =  0x2;
	final static int MINOR_TICKS =  0x4;
	final static int ROMAN =  0x8;
	private final static double ring_factor = .1;
	private final static String[] romanTime = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII"};
	private final static BasicStroke stroke_1 = new BasicStroke(1, BasicStroke.CAP_ROUND, 0);
	private final static BasicStroke stroke_4 = new BasicStroke(4, BasicStroke.CAP_ROUND, 0);
	private final static BasicStroke stroke_8 = new BasicStroke(8, BasicStroke.CAP_ROUND, 0);
	private final static int BASE_OFFSET = 5;
	private final static int font_h = 40;
	private double moving_angle = -1;
	
	private int flags = NUMBERS | MAJOR_TICKS | MINOR_TICKS; // | ROMAN;	
	private Font f, f_am_pm;
	private int center, radius;
	private boolean editable;
	private int moving_arm = -1;
	private double d_angle;
	private int numberHeight = -1;
	private int maxNumberWidth = -1;
	
	public AnalogClock() {
		f = new Font("TimesRoman", Font.PLAIN, font_h);
		f_am_pm = new Font("TimesRoman", Font.PLAIN, font_h/2);
		setEditable(true);
	}

	public void setTime(int hours, int minutes, int seconds) {
		super.setTime(hours, minutes, seconds);
		repaint();
	}

	private void drawTicks(Graphics2D g, int offset, int side, double rf, boolean minor) {
		g.setColor(Color.black);
		g.setStroke(rf < 0 ? stroke_4 : stroke_1);
		g.drawOval(offset, offset, side, side);
		g.setStroke(stroke_4);
		int r = side/2;
		center = offset+side/2;
		for (int i=0; i<12; i++) {
			double angle = i*Math.PI/6;
			int p0_x = (int) (center+r*Math.cos(angle));
			int p0_y = (int) (center+r*Math.sin(angle));
			int p1_x = (int) (center+(1+rf)*r*Math.cos(angle));
			int p1_y = (int) (center+(1+rf)*r*Math.sin(angle));
			g.drawLine(p0_x,  p0_y,  p1_x,  p1_y);
		}
		if (minor) {
			g.setStroke(stroke_1);
			for (int i=0; i<60; i++) {
				if (i%5 != 0) {					
					double angle = i*Math.PI/30;
					int p0_x = (int) (center+r*Math.cos(angle));
					int p0_y = (int) (center+r*Math.sin(angle));
					int p1_x = (int) (center+(1+rf)*r*Math.cos(angle));
					int p1_y = (int) (center+(1+rf)*r*Math.sin(angle));
					g.drawLine(p0_x,  p0_y,  p1_x,  p1_y);
				}					
			}
		}
	}

	public void paintComponent(Graphics gg) {
		Graphics2D g = (Graphics2D)gg;
		boolean has_ticks = (flags & (MINOR_TICKS|MAJOR_TICKS)) != 0;
		g.setRenderingHints(
				new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
		Dimension d = getSize();
		Color c = Color.lightGray;
		g.setColor(c);
		g.fillRect(0, 0, d.width, d.height);
		int max_side = Math.min(d.width, d.height)-2*BASE_OFFSET;
		int offset = (has_ticks ? (int)((max_side)*ring_factor)/2 : 0) + BASE_OFFSET;
		int side = max_side-2*offset;
		radius = side/2;
		center = offset+side/2;
		if (has_ticks) {
			int outer_side = max_side-2*BASE_OFFSET;
			g.setColor(Color.white);
			g.fillOval(BASE_OFFSET, BASE_OFFSET, outer_side, outer_side);
			drawTicks(g, BASE_OFFSET, outer_side, -ring_factor, (flags & MINOR_TICKS) != 0);
		} else {
			g.setColor(Color.white);
			g.fillOval(offset, offset, side, side);
		}
		// draw main circle
		g.setColor(Color.black);
		g.setStroke(has_ticks ? stroke_1 : stroke_4);
		g.drawOval(offset, offset, side, side);
		if ((flags & NUMBERS) != 0) {
			g.setFont(f);
			FontMetrics fm = g.getFontMetrics(f);	
			if (numberHeight < 0) {
				FontRenderContext frc = g.getFontRenderContext();
				GlyphVector gv = f.layoutGlyphVector(frc, new char[]{'1'},
			            0, 1, Font.LAYOUT_LEFT_TO_RIGHT);				
				Rectangle pixBounds = gv.getPixelBounds(frc, 0, 0);
				numberHeight = pixBounds.height;
				maxNumberWidth = 0;
				for (int i=0; i<12; i++) {
					int hour = (((i+2) % 12) + 1);
					int w = fm.stringWidth(""+hour);			
					if (w > maxNumberWidth)
						maxNumberWidth = w;
				}
			}
			int hm = maxNumberWidth/2;
			for (int i=0; i<12; i++) {				
				double angle = i*Math.PI/6;
				int hour = (((i+2) % 12) + 1);
				Rectangle2D r = fm.getStringBounds(""+hour, g);
				int w = (int)r.getWidth();
				int h = (int)numberHeight;
				int p1_x = (int) (center+(radius-hm)*Math.cos(angle));
				int p1_y = (int) (center+(radius-hm)*Math.sin(angle));
				if ((flags &  ROMAN) != 0)
					g.drawString(""+romanTime[hour], p1_x-w/2, p1_y+h/2);
				else				
					g.drawString(""+hour, p1_x-w/2, p1_y+h/2);
			}
		}
		
		// draw AM/FM
		g.setFont(f_am_pm);
		FontMetrics fm = g.getFontMetrics(f_am_pm);	
		FontRenderContext frc = g.getFontRenderContext();
		GlyphVector gv = f_am_pm.layoutGlyphVector(frc, new char[]{'1'},
	            0, 1, Font.LAYOUT_LEFT_TO_RIGHT);				
		Rectangle pixBounds = gv.getPixelBounds(frc, 0, 0);
		String am_pm = isAM()? "AM":"FM";
		Rectangle2D r = fm.getStringBounds(am_pm, g);
		
		// draw arms:
		double h_angle = getCurrentAngle(HOURS);
		double m_angle = getCurrentAngle(MINS);
		// draw shadows first
		int soff=4;
		int rrh = radius - font_h;
		int rrm = radius - 4;
		double sin_h_angle = Math.sin(h_angle);
		double cos_h_angle = Math.cos(h_angle);
		double sin_m_angle = Math.sin(m_angle);
		double cos_m_angle = Math.cos(m_angle);
		double rrh_cos_h = rrh*cos_h_angle;
		double rrh_sin_h = rrh*sin_h_angle;
		double rrm_cos_m = rrm*cos_m_angle;
		double rrm_sin_m = rrm*sin_m_angle;

		g.setColor(new Color(0xf0, 0xf0, 0xf0));
		g.fillRect(center+2*radius/3-(int)r.getWidth()-2, center-pixBounds.height/2-2, (int)r.getWidth()+4, pixBounds.height+4);
		g.draw3DRect(center+2*radius/3-(int)r.getWidth()-2, center-pixBounds.height/2-2, (int)r.getWidth()+4, pixBounds.height+4, false);
		g.setColor(Color.black);
		g.drawString(am_pm, center+2*radius/3-(int)r.getWidth(), center+(int)pixBounds.height/2);
		// draw shadows for arms
		g.setColor(Color.gray);
		g.setStroke(stroke_8);
		g.drawLine(center+soff, center+soff, center+(int)(rrh_sin_h)+soff, center-(int)rrh_cos_h+soff);
		g.setStroke(stroke_4);
		g.drawLine(center+soff, center+soff, center+(int)(rrm_sin_m)+soff, center-(int)rrm_cos_m+soff);
		// draw actual arms
		g.setColor(Color.black);
		g.setStroke(stroke_8);
		g.drawLine(center, center, center+(int)(rrh_sin_h), center-(int)(rrh_cos_h));
		g.setStroke(stroke_4);
		g.drawLine(center, center, center+(int)(rrm_sin_m), center-(int)(rrm_cos_m));
	}


	private double getAngleFromTime(int which, int time) {
		double r;
		switch(which) {
		case HOURS:
			r = time*Math.PI/6 + getTime(MINS)*Math.PI/360;
			break;
		case MINS:
			r = time*Math.PI/30;
			break;
		default:
			throw new Error("Invalid value "+which+" for argument");
		}
		return r<2*Math.PI ? r : r-2*Math.PI;		
	}
	
	private double getCurrentAngle(int which) {
		if (which == moving_arm)
			return moving_angle;
		return getAngleFromTime(which, getTime(which));
	}
	
	private int getTimeFromAngle(int arm, double angle) {
		double f = (arm == HOURS) ? 12 : 60;
		int t = (int)(f*angle/(2*Math.PI));
		if (arm == HOURS && t == 13)
			t = 1;
		else if (arm == MINS & t == 60)
			t = 0;
		if (arm == HOURS && t == 0)
			t = 12;
		return t;
	}
	
	public void setEditable(boolean v) {
		if (v == editable)
			return;
		editable = v;
		if (editable) {
			addMouseListener(this);
			addMouseMotionListener(this);
		} else {
			removeMouseListener(this);
			removeMouseMotionListener(this);
		}
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {	}
	@Override
	public void mouseClicked(MouseEvent e) { }
	@Override
	public void mouseEntered(MouseEvent e) { }
	@Override
	public void mouseExited(MouseEvent e) {	}

	private double angleFromMouseEvent(MouseEvent e) {
		double ang = Math.atan2(e.getY()-center, e.getX()-center)+Math.PI/2;
		if (ang < 0)
			ang += 2*Math.PI;
		return ang;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		double h_a = getCurrentAngle(HOURS);
		double m_a = getCurrentAngle(MINS);
		double mouse_a = angleFromMouseEvent(e);
		double dh = dist(h_a, radius, mouse_a);			
		double dm = dist(m_a, radius, mouse_a);
		if (dh <= dm && dh < .1) {
			moving_arm = HOURS;
			moving_angle = h_a;
			d_angle = dh;
			
		} else if (dm < dh && dm < .1) {
			moving_arm = MINS;
			moving_angle = m_a;
			d_angle = dm;			
		} else
			moving_arm = -1;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		moving_angle = angleFromMouseEvent(e) - d_angle;
		int t = getTimeFromAngle(moving_arm, moving_angle);
		System.out.println("T="+t);
		setTime(moving_arm, t);
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		moving_angle = angleFromMouseEvent(e) - d_angle;
		int t = getTimeFromAngle(moving_arm, moving_angle);
		System.out.println("time from ange: "+t);
		if (moving_arm == HOURS) {
			double prev_angle = getAngleFromTime(HOURS, t);
			double next_angle = getAngleFromTime(HOURS, t+1);
			if (next_angle<prev_angle)
				next_angle += Math.PI*2;
			System.out.println("prev="+prev_angle+", post="+next_angle+" curr="+moving_angle);
			System.out.println("d1="+(moving_angle-prev_angle)+", post="+(next_angle-moving_angle));
			if (Math.abs(moving_angle-prev_angle) > Math.abs(next_angle-moving_angle)) {
				t++;
				if (t==13)
					t=1;
			}
		}
		setTime(moving_arm, t);
		moving_arm = -1;		
	}


	/**
	 * Finds distance between line passing on (cx, cy) and with angle angle
	 * and point (x,y). 
	 * @param center2
	 * @param center3
	 * @param angle
	 * @param x
	 * @param y
	 * @return
	 */
	private double dist(double armAngle, int radius, double mouseAngle) {
		double res = Math.abs(mouseAngle-armAngle);
		if (res > Math.PI)
			res -= Math.PI;
		return res;
//		double d = Math.sqrt((x-x1)*(x-x1)+(y-y1)*(y-y1));
//		if (d>radius)
//			return Double.MAX_VALUE;
//		int dx = (int)(Math.cos(angle)*radius);
//		int x2 = x1 + dx;
//		int dy = (int)(Math.sin(angle)*radius);
//		int y2 = y1 + dy;
//		double dst = Math.abs(dy*x - x1*y2 + x2*y1)/Math.sqrt(dx*dx+dy*dy); 
//		return dst;
	}

}