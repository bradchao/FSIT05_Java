package tw.org.iii.clock;
import java.util.Vector;
import javax.swing.JComponent;



public abstract class AbstractClock extends JComponent implements ClockListener {
	public final static int HOURS = 0;
	public final static int MINS = 1;
	public final static int SECS = 2;
	
	private int[] time = new int[]{12, 30, 0};
	private boolean isAM = true;
	
	private Vector<ClockListener> listeners = new Vector<ClockListener>();  
	public AbstractClock() {
	}
	
	public void setTime(int hours, int minutes, int seconds, boolean isAM) {
		if (hours == time[HOURS] && minutes == time[MINS] && seconds == time[SECS])
			return;
		if (hours<1 || hours>12)
			throw new Error("'hour' argument is "+hours+", should be between 1 and 12");
		if (minutes<0 || minutes>59)
			throw new Error("'minutes' argument is "+minutes+", should be between 0 and 59");
		if (seconds<0 || seconds>59)
			throw new Error("'seconds' argument is "+seconds+", should be between 0 and 59");
		
		time = new int[]{hours, minutes, seconds};
		this.isAM = isAM;
		repaint();
		for (ClockListener l : listeners) {
			l.timeChanged(time[HOURS], time[MINS], time[SECS], isAM);
		}
	}
	
	public void setTime(int hours, int minutes, int seconds) {
		setTime(hours, minutes, seconds, isAM);
	}

		public void setTime24(int hours, int minutes, int seconds) {		
		if (hours < 12)
			setTime(hours, minutes, seconds, true);
		else
			setTime(hours-12, minutes, seconds, false);
	}
	
	
	public void setTime(int arm, int value, boolean isAM) {
		if (arm == MINS)
			if (value == 0 && time[MINS] == 59) {
				time[HOURS]++;
				if (time[HOURS] == 13)
					time[HOURS] = 1;
			} else if (value == 59 && time[MINS] == 0) {
				time[HOURS]--;
				if (time[HOURS] == 0)
					time[HOURS] = 12;
			}
		switch(arm) {
			case HOURS:
				setTime(value, time[MINS], time[SECS], isAM);
				break;
			case MINS:
				setTime(time[HOURS], value, time[SECS], isAM);
				break;
			case SECS:
				setTime(time[HOURS], time[MINS], value, isAM);
				break;
		}
	}

	public void setTime(int arm, int value) {
		setTime(arm, value, isAM);
	}
	
	public int[] getTime() {
		return time;
	}
	
	public int getTime(int which) {
		return time[which];
	}
	
	public boolean isAM() {
		return isAM;
	}
	
	public void addListener(ClockListener l) {
		listeners.add(l);
		l.timeChanged(time[HOURS], time[MINS], time[SECS], isAM);
	}
	
	public void removeListener(ClockListener l) {
		listeners.remove(l);
	}

	@Override
	public void timeChanged(int h, int m, int s, boolean isAM) {
		setTime(h, m, s, isAM);		
	}

	@Override
	public void runningChanged(boolean running) {
	}

}