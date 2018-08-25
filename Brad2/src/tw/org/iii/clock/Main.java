package tw.org.iii.clock;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;


public class Main extends JFrame {
    private final JLabel label;
    private final JButton done;
    private final AnalogClock aclock;
    private final DigitalClock dclock;
    private final TextClock tclock;
    
    public static void main(String args[]) throws InterruptedException {
        new Main();
    }
    
    public Main() throws InterruptedException {
        super("Clock");
        setSize(640,  400);
        Color dgreen = Color.lightGray;
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        c.setBackground(dgreen);
        JPanel clocksPanel = new JPanel();
        clocksPanel.setLayout(new BorderLayout());
        clocksPanel.setBackground(dgreen);
        c.add(clocksPanel, BorderLayout.WEST);
        aclock = new AnalogClock();
        dclock = new DigitalClock();
        tclock = new TextClock();
        dclock.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        aclock.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        tclock.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        aclock.addListener(dclock);
        dclock.addListener(aclock);
        dclock.addListener(tclock);
        clocksPanel.add(aclock, BorderLayout.CENTER);
        clocksPanel.add(dclock, BorderLayout.NORTH);
        clocksPanel.add(tclock, BorderLayout.SOUTH);
        label = new JLabel("<html>Super Clock</html>");
        c.add(label, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        done = new JButton("<html><h1>Done</h1></html>");
        c.add(done, BorderLayout.SOUTH);
        setVisible(true);
        level1();
        
    }

    public String getLevelTxt(int level, int quiz) {
        return "<font color=\"yellow\">Level "+level+", quiz "+quiz+"</font><br><br>";
    }
    
    public void level1() throws InterruptedException {
        final Thread t = Thread.currentThread();
        for(int i=0; i<10; i++) {
            int h = (int)(Math.random()*12);
            int m = ((int)(Math.random()*12))*5;
            boolean success = false;
            while(!success) {
            label.setText("<html><h1>"+getLevelTxt(1, i+1)+"Hi. Set the clock to "+h+":"+m+". press the \"Done!\" button when you're done!</h1></html>");
                done.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        synchronized(t) {
                            t.notify();
                        }
                    }
                });
                synchronized(t) {
                    t.wait();
                }
                int time[] = aclock.getTime();
                success = time[0] == h && time[1] == m;
                if (success) {
                    label.setText("<html><h1><font color=\"green\">Good Job!</h1></html>");
                } else {
                    label.setText("<html><h1><font color=\"red\">Acc... not quite. try again</h1></html>");
                }
                Thread.sleep(3000);
            }
        }
    }
    
}
