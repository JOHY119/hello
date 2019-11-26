package cloud.jony.hello;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

class TimerPrinter implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Time is "+new Date());
        Toolkit.getDefaultToolkit().beep();
    }

}

public class TimerTest {
    public static void main(String[] args) {
//        ActionListener listener=new TimerPrinter();
//
//        Timer t = new Timer(1000, listener);
//        t.start();
//
//        JOptionPane.showMessageDialog(null,"Quit?");
//
//        System.exit(0);

        String[] planets = new String[]{"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};

        System.out.println(Arrays.toString(planets));
        System.out.println(" default sort");
        Arrays.sort(planets);
        System.out.println(" sort by length");
        Comparator<String> c=new StringComparator();
        Arrays.sort(planets,new StringComparator());
        Arrays.sort(planets,c);
        Comparator<String> c2=(first,second)->first.length()-second.length();

        Arrays.sort(planets,c2);
        System.out.println(Arrays.toString(planets));

        Timer t = new Timer(1000, e -> System.out.println("time is " + new Date()));
        t.start();
        JOptionPane.showMessageDialog(null, "Quit?");
        System.exit(0);
        String a="1";
        System.out.println(a.compareToIgnoreCase("2"));
    }
}
class StringComparator implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
}
