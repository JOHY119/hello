package cloud.jony.hello;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Yueshu {

    public static long foo2(long n) {
        n = n * n;
        long s, i, r;
        s = 1;
        for (i = 2; i * i <= n; i++) {
            r = 0;
            while (n % i == 0) {
                r++;
                n /= i;
            }
            if (r > 0) {
                r++;
                s *= r;
            }
        }
        if (n > 1)
            s *= 2;
//        System.out.println((s+1)/2);
        return (s + 1) / 2;
    }

    public static long foo(long n) {
        ArrayList<Integer> factorCnt = new ArrayList<>();
        for (int i = 2; i * i < n; i++) {
            int cnt = 0;
            while (n % i == 0) {
                n /= i;
                cnt++;
            }
            if (cnt > 0)
                factorCnt.add(cnt);
        }
        if (n > 1) {
            factorCnt.add(1);
        }
        long ans = 1;
        for (Integer cnt : factorCnt) {
            ans *= (cnt * 2 + 1);
        }
        return (ans / 2 + 1);
    }

    public static void main(String[] args) {

//        for (int n = 100; n < 1000; n++) {
//            int finalN = n;
//            Runnable r = () -> {
//                int i = 100_0000 + finalN * (1000000);
//                int e_i = i + 1000000;
//                System.out.println("此线程 " + i + " " + e_i);
//                for (; i < e_i; i++) {
//                    long c = foo(i);
////                System.out.println("n: " + i + " 解数: " + c);
//                    if (c >= 100_0000) {
//                        System.out.println("n: " + i + " 解数: " + c);
//                        break;
//                    }
//                }
//                System.out.println(" thread end");
//            };
//            Thread t = new Thread(r);
//            t.start();
//
//        }


//        int[] counts = {100_0000};
//        for (int count :
//                counts) {
//            for (int i = 1; i < 100_000000; i++) {
//
//                long c = foo(i);
////                System.out.println("n: " + i + " 解数: " + c);
//                if (c >= count) {
//                    System.out.println("n: " + i + " 解数: " + c);
//                    break;
//                }
//            }
//        }
        System.out.println("main end");
//        System.out.println(foo(72201776446800));


    }
}
