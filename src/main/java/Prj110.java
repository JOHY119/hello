
import junit.framework.TestCase;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class Prj110 extends TestCase {

    public static int LIMIT = 100;
    BigInteger min = null;
    DivisorsEnum div = null;

    /**
     * n < x <= y; x = ny / ( y -n) <= y ===> y >= 2n; so assume x in (n, 2n];
     * n(n +i)/i, i in [1, n] ===> numOfDivisors( n * n ) + 1 > 2 * LIMIT;
     */
    public void testDiophantineReciprocalsII() {

        int count = 0;
        int mul = 1;
        while (mul < LIMIT * 2 - 1) {
            mul *= 3;
            count++;

        }
        System.out.println("count=" + (count));

        List<Integer> ls = new ArrayList<Integer>();
        for (int i = 2; i <= 100; i++) {
            if (isPrime(i)) {
                ls.add(i);
            }
        }

        BigInteger b = BigInteger.ONE;

        int[] primesArr = new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31,
                37, 41, 43, 47 };

        for (int i = 0; i < primesArr.length; i++) {
            b = b.multiply(new BigInteger(Integer.toString(primesArr[i])));
        }
        System.out.println(b.toString());
        min = b;

        // int[] primesArr = new int[] { 2, 3, 5, 7, 11, 13, 17, 19};
        // int[] primesArr = new int[] { 2, 3, 5, 7, 11, 13, 17};
        int[] expArrs = new int[15];

        dfs(primesArr, expArrs, 0);

        System.out.println(min);
        System.out.println(div.innerCaln());
        System.out.println(div);
    }

    public static class DivisorsEnum implements Comparable<DivisorsEnum> {

        public int[] primesArr;
        public int[] expArrs;

        public DivisorsEnum(int[] primesArr, int[] expArrs) {
            super();
            this.primesArr = primesArr;
            this.expArrs = expArrs;
        }

        @Override
        public String toString() {
            return "DivisorsEnum [primesArr=" + Arrays.toString(primesArr)
                    + ", expArrs=" + Arrays.toString(expArrs) + "]";
        }

        public static BigInteger caln(int[] primesArr, int[] expArrs) {
            BigInteger n = BigInteger.ONE;
            for (int i = 0; i < expArrs.length; i++) {
                n = n.multiply(new BigInteger(Integer.toString(primesArr[i]))
                        .pow(expArrs[i]));
            }
            return n;
        }

        public BigInteger innerCaln() {
            BigInteger n = BigInteger.ONE;
            for (int i = 0; i < expArrs.length; i++) {
                n = n.multiply(new BigInteger(Integer.toString(primesArr[i]))
                        .pow(expArrs[i]));
            }
            return n;
        }

        @Override
        public int compareTo(DivisorsEnum o) {
            BigInteger n1 = caln(primesArr, expArrs);
            BigInteger n2 = caln(o.primesArr, o.expArrs);

            return n1.compareTo(n2);
        }
    }

    public void dfs(int[] primesArr, int[] expArrs, int startIndex) {
        if (startIndex >= expArrs.length) {
            long numOfDivisors = 1;
            for (int i = 0; i < expArrs.length; i++) {
                numOfDivisors *= (2 * expArrs[i] + 1);
            }
            if (numOfDivisors > 2 * LIMIT - 1) {
                DivisorsEnum d = new DivisorsEnum(Arrays.copyOf(primesArr,
                        expArrs.length), Arrays.copyOf(expArrs, expArrs.length));
                if (d.innerCaln().compareTo(min) < 0) {
                    min = d.innerCaln();
                    div = d;
                }
                System.out.println(d);
            }
            return;
        }

        for (int i = 0; i <= 10; i++) {

            // guess
            if (startIndex > 5 && i >= 2) {
                return;
            }
            // exp[i] >= exp[i + 1]
            if (startIndex != 0 && i > expArrs[startIndex - 1]) {
                continue;
            }
            expArrs[startIndex] = i;

            long numOfDivisors = 1;
            for (int j = 0; j <= startIndex; j++) {
                numOfDivisors *= (2 * expArrs[j] + 1);
            }
            if (numOfDivisors > 2 * LIMIT - 1) {
                int[] copy = new int[expArrs.length];
                for (int j = 0; j <= startIndex; j++) {
                    copy[j] = expArrs[j];
                }
                DivisorsEnum d = new DivisorsEnum(Arrays.copyOf(primesArr,
                        expArrs.length), Arrays.copyOf(copy, copy.length));
                if (d.innerCaln().compareTo(min) < 0) {
                    min = d.innerCaln();
                    div = d;
                }
                System.out.println(d);
                return;
            }
            dfs(primesArr, expArrs, startIndex + 1);

        }

    }

    boolean isPrime(int num) {
        if (num <= 10) {
            if (num == 2 || num == 3 || num == 5 || num == 7) {
                return true;
            }
            return false;
        }

        if (num % 2 == 0) {
            return false;
        }

        for (int i = 3; i * i <= num; i = i + 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}