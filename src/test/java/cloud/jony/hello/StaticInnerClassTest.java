package cloud.jony.hello;

import java.lang.reflect.Array;
import java.util.Arrays;

public class StaticInnerClassTest {
    public static void main(String[] args) throws Exception {
        double[] d = new double[20];
        for (int i = 0; i < d.length; i++) {
            d[i] = 100 * Math.random();
        }
        Arrays.sort(d);
        System.out.println(Arrays.toString(d));
        ArrayAlg.Pair p = ArrayAlg.Pair.minmax(d);

        System.out.println("min= " + p.getFirst());
        System.out.println("max= "+ p.getSecond());


    }
}

class ArrayAlg {
    public static class Pair {
        private double first;
        private double second;

        public Pair(double f, double s) {
            first = f;
            second = s;
        }

        public double getFirst() {
            return first;
        }

        public double getSecond() {
            return second;
        }

        public static Pair minmax(double[] values) {
            double min = Double.POSITIVE_INFINITY;
            double max = Double.NEGATIVE_INFINITY;

            for (double v :
                    values) {
                if (min > v) min = v;
                if (max < v) max = v;
            }

            return new Pair(min, max);
        }
    }
}
