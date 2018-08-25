package tw.org.iii.mytest;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tw.org.iii.clock.AbstractClock;
import tw.org.iii.clock.AnalogClock;
import tw.org.iii.clock.DigitalClock;

public class Racing extends JFrame {
	private JButton go;
	private JLabel[] lanes = new JLabel[8];
	private Horse[] horses = new Horse[8];
	private int rank = 0;
	private AbstractClock clock;
	private Timer timer;
	
	public Racing() {
		super();
		setLayout(new GridLayout(1, 0));
		
		JPanel top = new JPanel(new BorderLayout());
		go = new JButton("Go!"); 
		top.add(go, BorderLayout.EAST);
		clock = new DigitalClock();
		clock.setTime(10, 12, 34);
		clock.setBounds(0, 0, 200, 200);
		top.add(clock, BorderLayout.CENTER);
		add(top);
		
		timer = new Timer();
		timer.schedule(new ClockTask(), 0, 500);
		
		for (int i=0; i<lanes.length; i++) {
			lanes[i] = new JLabel((i+1) + ".");
//			add(lanes[i]);
		}
		
		go.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				go.setEnabled(false);
				newRound();
			}
		});
		
		setSize(800, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private class ClockTask extends TimerTask {
		@Override
		public void run() {
			Calendar calendar = Calendar.getInstance();
			clock.setTime24(calendar.get(Calendar.HOUR_OF_DAY), 
					calendar.get(Calendar.MINUTE), 
					calendar.get(Calendar.SECOND));
		}
	}
	
	
	private void newRound() {
		rank = 1;
		for (int i=0; i<horses.length; i++) {
			lanes[i].setText((i+1) + ".");
			horses[i] = new Horse(i);
			horses[i].start();
		}
	}
	
	private void stopGame() {
		for (int i=0; i<horses.length; i++) {
			horses[i].interrupt();
		}
		go.setEnabled(true);
	}
	
	private class Horse extends Thread {
		int lane;
		Horse(int lane){this.lane = lane;}
		@Override
		public void run() {
			for (int i=0; i<100; i++) {
				lanes[lane].setText(lanes[lane].getText() + ">");
				if (i==99) {
					lanes[lane].setText(lanes[lane].getText() + rank++);
					stopGame();
				}
				try {
					Thread.sleep(50 + (int)(Math.random()*150));
				}catch (Exception e) {
					break;
				}
			}
			
		}
	}
	

	public static void main(String[] args) {
		new Racing();
	}

}
