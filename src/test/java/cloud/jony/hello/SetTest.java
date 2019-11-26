package cloud.jony.hello;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SetTest {
    public static void main(String[] args) throws FileNotFoundException {
        String path=SetTest.class.getResource("/pg19551.txt").getPath();

        Set<String> words = new TreeSet<>();
        long totalTime=0;

        try (Scanner in = new Scanner(new File(path))) {
            while (in.hasNext()) {
                String word=in.next();
                Long callTime=System.currentTimeMillis();
                words.add(word);
                callTime=System.currentTimeMillis()-callTime;
                totalTime+=callTime;
            }
        }

        Iterator<String> iter=words.iterator();
        for (int i = 0; i < 20 && iter.hasNext(); i++) {
            System.out.println(iter.next());
        }
        System.out.println("...");
        System.out.println(words.size()+" distinct words. "+totalTime+" ms");
    }
}
