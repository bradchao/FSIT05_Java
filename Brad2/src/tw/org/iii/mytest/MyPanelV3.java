package tw.org.iii.mytest;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyPanelV3 extends MyPanel {
	public MyPanelV3() {
		// super();
		addMouseListener(new MyMouseListener());
	}

	// MyPanelV3 Object has-a Inner class
	private class MyMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			//super.mouseClicked(e);
			System.out.println("OK");
		}
	}
	
}
