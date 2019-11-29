package cloud.jony.hello;

import java.util.BitSet;

public class Sieve {
    public static void main(String[] args) {
        int n=1_000_000_00;
        long start=System.currentTimeMillis();
        BitSet b = new BitSet(n + 1);

        for (int i = 2; i <=n; i++) {
            b.set(i);
        }
        for (int i = 2; i*i <=n ; i++) {
            if (b.get(i)) {
                int k=2*i;
                while (k<=n){
                    b.clear(k);
                    k+=i;
                }
            }
        }
        long end=System.currentTimeMillis();

        int count=0;
        for (int i = 0; i < n; i++) {
            if (b.get(i))
                count++;
        }
        System.out.println(count+" primes");
        System.out.println("time: "+(double)(end-start)/1000+"s");
    }
}
