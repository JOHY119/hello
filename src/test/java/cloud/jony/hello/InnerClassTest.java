package cloud.jony.hello;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class InnerClassTest {
    public static void main(String[] args) {
        TalkingClock talkingClock=new TalkingClock(1000,true);
        talkingClock.start();

        JOptionPane.showMessageDialog(null,"quit?");
        System.exit(0);
    }
}

class TalkingClock {

    public class TimePrinter implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (beep) {
                System.out.println("time is " + new Date());
            }
        }
    }

    private boolean beep;
    private int interval;

    public TalkingClock(int interval, boolean beep) {
        this.beep = beep;
        this.interval = interval;
    }

    public void start() {
        ActionListener listener = new TimePrinter();
        Timer timer = new Timer(interval, listener);
        timer.start();
        Timer timer2 = new Timer(interval, (e) ->{ if(beep) System.out.println("time2 is up");});
        timer2.start();
    }
}
