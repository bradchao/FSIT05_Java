import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Racing extends JFrame {
	private JButton go;
	private JLabel[] lanes = new JLabel[8];
	private Horse[] horses = new Horse[8];
	private int rank = 0;
	
	public Racing() {
		super();
		setLayout(new GridLayout(9, 0));
		
		go = new JButton("Go!"); add(go);
		for (int i=0; i<lanes.length; i++) {
			lanes[i] = new JLabel((i+1) + ".");
			add(lanes[i]);
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
