package cloud.jony.hello;

import java.io.File;
import java.io.IOError;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {
    public static final int FILE_QUEUE_SIZE = 10;
    public static final int SEARCH_THREADS = 100;
    // 虚拟包 表示队尾 最后一个
    private static final File DUMMY = new File("");
    private static BlockingQueue<File> queue = new ArrayBlockingQueue<>(FILE_QUEUE_SIZE);

    public static void main(String[] args) {
        String directory="/Users/johy/IdeaProjects";
        String keyword="queue";

        Runnable enumerator=()->{
            try{
                enumerate(new File(directory));
                queue.put(DUMMY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        new Thread(enumerator).start();
        for (int i = 1; i <=SEARCH_THREADS; i++) {
            Runnable searcher=()->{
                try {
                    boolean done=false;
                    while (!done){
                        File file=queue.take();
                        if (file==DUMMY){
                            queue.put(file);
                            done=true;
                            System.out.println("last one exit "+ Thread.currentThread());
                        }else {
                            search(file,keyword);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException ignored) {
                }
            };
            new Thread(searcher).start();

        }
    }

    public static void enumerate(File directory) throws InterruptedException {
        File[] files = directory.listFiles();
        for (File file :
                files) {
            if (file.isDirectory())
                enumerate(file);
            else
                queue.put(file);
        }
    }

    public static void search(File file, String keyword) throws IOException {
        try (Scanner in = new Scanner(file, "UTF-8")) {
            int lineNumber = 0;
            while (in.hasNextLine()) {
                lineNumber++;
                String line = in.nextLine();
                if (line.contains(keyword)) {
                    System.out.printf("%s:%d:%s%n", file.getPath(), lineNumber, line);
                }
            }
        }
    }

}
