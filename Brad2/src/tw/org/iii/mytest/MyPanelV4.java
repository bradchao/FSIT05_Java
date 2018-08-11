package tw.org.iii.mytest;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyPanelV4 extends MyPanel {
	private MouseListener mListener = new MouseListener() {
		@Override
		public void mouseReleased(MouseEvent e) {
		}
		@Override
		public void mousePressed(MouseEvent e) {
		}
		@Override
		public void mouseExited(MouseEvent e) {
		}
		@Override
		public void mouseEntered(MouseEvent e) {
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println(b);
		}
	};
	
	private MouseListener mListener2 = new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println(a);
		}
	};
	private int a = 10;
	private int b = 20;
	private int c = 30;
	
	public MyPanelV4() {
		// super();
		addMouseListener(mListener);
		addMouseListener(mListener2);
		MouseListenerV100 mListener3 = new MouseListenerV100(this);
		addMouseListener(mListener3);
	}

	public int getC() {return c;}
	
}

class MouseListenerV100 extends MouseAdapter{
	private MyPanelV4 obj;
	public MouseListenerV100(MyPanelV4 obj) {
		this.obj = obj;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(obj.getC());
		obj.repaint();
	}
}


