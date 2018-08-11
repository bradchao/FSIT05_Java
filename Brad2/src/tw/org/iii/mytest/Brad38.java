package tw.org.iii.mytest;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class Brad38 extends JFrame{
	private MyPanelV3 myPanel;
	
	public Brad38() {
		setLayout(new BorderLayout());
		
		myPanel = new MyPanelV3();
		add(myPanel, BorderLayout.CENTER);
		
		addWindowListener(new MyLinstener());
		setSize(640, 480);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Brad38();
	}
}

class MyLinstener extends WindowAdapter {
	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);	// command line return value; 0 => normal; non-zero => error
	}
}
//class MyWindowListener implements WindowListener {
//
//	@Override
//	public void windowOpened(WindowEvent e) {
//		System.out.println("opened");
//	}
//
//	@Override
//	public void windowClosing(WindowEvent e) {
//		System.out.println("closing");
//		System.exit(0);	// command line return value; 0 => normal; non-zero => error
//	}
//
//	@Override
//	public void windowClosed(WindowEvent e) {
//		System.out.println("closed");
//	}
//
//	@Override
//	public void windowIconified(WindowEvent e) {
//		System.out.println("icon");
//	}
//
//	@Override
//	public void windowDeiconified(WindowEvent e) {
//		System.out.println("deicon");
//	}
//
//	@Override
//	public void windowActivated(WindowEvent e) {
//		System.out.println("actiated");
//	}
//
//	@Override
//	public void windowDeactivated(WindowEvent e) {
//		System.out.println("deactiated");
//	}
//	
//}
