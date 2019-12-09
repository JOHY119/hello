package cloud.jony.hello;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class ThreadPoolTest {
    public static void main(String[] args) {
        String directory="/Users/johy";
        String keyword = "list";
        ExecutorService pool=Executors.newCachedThreadPool();
        MatchCounterWithPool counter = new MatchCounterWithPool(new File(directory), keyword, pool);
        Future<Integer> result = pool.submit(counter);

        try {
            System.out.println(result.get() + " matched files");
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException ignored) {
        }

        pool.shutdown();
        int largestPoolSize=((ThreadPoolExecutor)pool).getLargestPoolSize();
        System.out.println("largest pool size="+ largestPoolSize);
    }

}

class MatchCounterWithPool implements Callable<Integer> {

    private File directory;
    private String keyword;
    private ExecutorService pool;
    private int count;

    public MatchCounterWithPool(File directory, String keyword, ExecutorService pool) {
        this.directory = directory;
        this.keyword = keyword;
        this.pool = pool;
    }

    public boolean search(File file) {
        try {
            try (Scanner in = new Scanner(file, StandardCharsets.UTF_8)) {
                boolean found = false;
                while (!found && in.hasNextLine()) {
                    String line = in.nextLine();
                    if (line.contains(keyword))
                        found = true;
                }
                return found;
            }
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public Integer call() throws Exception {
        count = 0;
        try {
            File[] files = directory.listFiles();
            List<Future<Integer>> results = new ArrayList<>();

            for (File file :
                    files) {
                if (file.isDirectory()) {
                    MatchCounterWithPool counter = new MatchCounterWithPool(file, keyword, pool);
                    Future<Integer> result = pool.submit(counter);
                    results.add(result);
                } else {
                    if (search(file))
                        count++;
                }
            }
            for (Future<Integer> result :
                    results) {
                try {
                    count += result.get();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        } catch (InterruptedException ignored) {
        }
        return count;
    }
}
