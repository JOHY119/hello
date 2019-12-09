package cloud.jony.hello.streams;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountLongWords {
    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("user.dir"));
        String contents = new String(Files.readAllBytes(Paths.get("src/main/resources/pg19551.txt")), StandardCharsets.UTF_8);

        String path = "src/main/resources/pg19551.txt";
        PushbackInputStream pin;
        DataInputStream din = new DataInputStream(pin = new PushbackInputStream(new FileInputStream(path)));

        List<String> words = Arrays.asList(contents.split("\\PL+"));
        long count=0;
        for (String w :
                words) {
            if (w.length() > 12)
                count++;
        }
        System.out.println(count);

        count=words.stream().filter(w->w.length()>12).count();
        System.out.println(count);

        count=words.parallelStream().filter(w->w.length()>12).count();
        System.out.println(count);


    }
}
