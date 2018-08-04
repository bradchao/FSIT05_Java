package tw.org.iii.mytest;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GuessNumber extends JFrame {
	private JButton guess;
	private JTextField input;
	private JTextArea hist;
	private String answer = createAnswer();
	private int counter; 
	
	public GuessNumber() {
		super("猜數字遊戲");
		
		guess = new JButton("猜");
		input = new JTextField();
		hist = new JTextArea();
		input.setFont(new Font("Default", Font.PLAIN, 24));
		hist.setFont(new Font("Default", Font.BOLD + Font.ITALIC, 24));
		
		JPanel top = new JPanel(new BorderLayout());
		top.add(guess, BorderLayout.EAST);
		top.add(input, BorderLayout.CENTER);
		
		setLayout(new BorderLayout());
		add(hist, BorderLayout.CENTER);
		add(top, BorderLayout.NORTH);
		
		guess.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				doGuess();
			}
		});
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//System.out.println(answer);
	}
	
	
	void doGuess() {
		counter++;
		String result = checkAB();
		hist.append(counter + ". " + input.getText() + " => " + result + "\n");
		input.setText("");
		
		if (result.equals("3A0B")) {
			JOptionPane.showMessageDialog(null, "恭喜老爺,賀喜夫人");
		}else if (counter == 10) {
			JOptionPane.showMessageDialog(null, "Loser: " + answer);
		}
	}
	
	String checkAB() {
		int a, b; a = b = 0;
		String guess = input.getText();
		for (int i=0; i<guess.length(); i++) {
			if (guess.charAt(i) == answer.charAt(i)) {
				a++;
			}else if(answer.indexOf(guess.charAt(i)) != -1) {
				b++;
			}
		}
		return a + "A" + b + "B";
	}
	
	String createAnswer() {
		int[] poker = new int[10];
		boolean isRepeat;
		int temp;
		for (int i=0; i<poker.length; i++) {
			do {
				temp = (int)(Math.random()*10);
				
				// 檢查機制
				isRepeat = false;
				for (int j=0; j<i; j++) {
					if (poker[j] == temp) {
						isRepeat = true;
						break;
					}
				}
			}while (isRepeat);
			poker[i] = temp;
		}
		
		return "" + poker[0] + poker[1] + poker[2];
	}
	
	public static void main(String[] args) {
		new GuessNumber();
	}

}
