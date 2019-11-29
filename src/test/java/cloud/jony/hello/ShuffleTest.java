package cloud.jony.hello;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ShuffleTest {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <=49; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);

        List<Integer> sub = numbers.subList(0, 6);
        System.out.println(sub);
//        Collections.sort(sub);
        sub.sort(Comparator.reverseOrder());
        System.out.println(sub);
    }
}
