package tw.org.iii.mytest;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyGame extends JFrame{
	private GamePanel gPanel;
	
	public MyGame() {
		setLayout(new BorderLayout());
	
		gPanel = new GamePanel();
		add(gPanel,BorderLayout.CENTER);
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private class GamePanel extends JPanel {
		private BufferedImage ball;
		private int viewW, viewH, ballW, ballH;

		public GamePanel() {
			try {
				ball = ImageIO.read(new File("dir1/ball.png"));
				ballW = ball.getWidth(); ballH = ball.getHeight();
			} catch (IOException e) {
				System.out.println(e);
			}
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D)g;
			viewW = getWidth(); viewH = getHeight();
			
			g2d.drawImage(ball, 0, 0, null);
		}
	}
	
	public static void main(String[] args) {
		new MyGame();
	}

}
