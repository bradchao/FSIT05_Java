package tw.org.iii.clock;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.StringTokenizer;


public class TextClock extends AbstractClock {
	public static int QUARTERS = 1;
	private static int FONT_HEIGHT = 40;
	private int flags;
	private Font f;
	
	String w [] = {
			"one", "two", "three", "four", "five", 
			"six", "seven", "eight", "nine", "ten",
			"eleven", "twelve", "thirteen", "fourteen", 
			"fifteen", "sixteen", "seventeen", "eighteen",
			"nineteen", "twenty", "thirty", "fourty", "fifty"
	};
	
	public TextClock(int h, int m, int s, int flags) {
		this.flags = flags;
		setTime(h, m, s);
		setPreferredSize(new Dimension(300,100));
		f = new Font("TimesRoman", Font.PLAIN, FONT_HEIGHT);
	}

	public TextClock() {
		this(12, 0, 0, QUARTERS);
	}
	
	public TextClock(String s) {
		StringTokenizer st = new StringTokenizer(s);
		String hstr = st.nextToken();
		String mstr = st.nextToken();
		String mstr1 = mstr;
		int h = 0;
		for(int i=0; i<12; i++)
			if (w[i].equals(hstr)) {
				h += i+1;
				break;
			}
		if (h==0)
			throw new Error("Invalid hour token "+hstr);
		
		int m = -1;
		// mins between "one" and "nineteen"
		for(int i=0; i<20; i++) {
			if (w[i].equals(mstr)) {
				m = i+1;
				setTime(h, m, 0);
				return;
			}
		}
		// mins between "oh-one" and "oh-nine" 
		if (mstr.startsWith("oh-")) {
			mstr = mstr.substring(3);
			for(int i=0; i<9; i++) {
				if (w[i].equals(mstr)) {
					m = i+1;
					setTime(h, m, 0);
					return;
				}
			}
			throw new Error("Invalid minutes "+mstr1);
		}
		for(int i=19; i<23; i++) {
			if (mstr.startsWith(w[i])) {
				m = (i-17)*10;
				mstr = mstr.substring(w[i].length());
				for(int j=0; j<9; j++) {
					if (w[j].equals(mstr)) {
						m += j+1;
						setTime(h, m, 0);
						return;
					}
				}
			}
		}
		throw new Error("Invalid minutes "+mstr1);
	}

	public String toString() {
		int[] t = super.getTime();
		int h = t[0]-1;
		System.out.println("h ="+h); 
		int m = t[1]-1;
		int s = t[2]-1;
		String res = w[h]+" ";
		if (m == -1)
			return res+" o'clock";
		if (m<9)
			res += "oh-";
		if (m<19) {
			if ((flags & QUARTERS)!= 0 && m == 14)
				res = "quarter past "+res;
			else
				res += w[m];
		} else {
			if ((flags & QUARTERS) != 0) {
				switch(m) {
				case 29:
					res = "half past "+res;
					return res;
				case 44:
					h++;
					if (h==12)
						h = 0;
					res = "quarter to "+w[h];
					return res;
				}
			}
			res += w[19+(m-19)/10];
			int mm = m % 10;
			System.out.println("MM="+mm);
			if (mm != 9)
				res += w[mm];
		}
		return res;
	}
	
	public void paintComponent(Graphics g) {
		g.setFont(f);
		g.drawString(this.toString(), 10, FONT_HEIGHT+10);
	}
	
	public static void main(String args[]) {
		System.out.println(new TextClock(8, 30, 0, QUARTERS));
		int[] t = new TextClock("eight fourtyfive").getTime();
		System.out.println(t[0]+":"+t[1]+":"+t[2]);
	}
}
