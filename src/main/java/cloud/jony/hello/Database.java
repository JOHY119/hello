package cloud.jony.hello;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

class EmbeddingItem {
    private String word;

    private ArrayList<Double> emb;

    public String getWord() {
        return word;
    }

    public ArrayList<Double> getEmb() {
        return emb;
    }

    public int length() {
        return this.emb.size();
    }

    public EmbeddingItem(String[] strings) {
        this.word = strings[0];
        ArrayList<Double> embDouble = new ArrayList<>();
        for (int i = 1; i < strings.length; i++) {
            embDouble.add(Double.parseDouble(strings[i]));
        }

        this.emb = embDouble;
    }

    public String toString() {
        return this.word + "  " + this.emb;
    }
}


public class Database {
    private static final String URL = "jdbc:mysql://jony.cloud:16666/sentence";
    private static final String NAME = "johy";
    private static final String PASSWORD = "58023Sun*";

    public static void printRunTime(long startTime){
        long endTime = System.currentTimeMillis();    //获取结束时间

        System.out.println((endTime - startTime) + "ms");    //输出程序运行时间
    }

    public static void main(String[] args) throws Exception {
        long  startTime = System.currentTimeMillis();
        String path = TestSite.class.getResource("/sgns.wiki.bigram-char").toURI().getPath();
        System.out.println(path);
        File file = new File(path);
        Scanner in = new Scanner(file, StandardCharsets.UTF_8);
        String[] p = in.nextLine().split(" ");
        int[] shape = new int[p.length];
        for (int i = 0; i < p.length; i++) {
            shape[i] = Integer.parseInt(p[i]);
        }
        for (int i :
                shape) {
            System.out.println(i);
        }

        ArrayList<EmbeddingItem> embedding = new ArrayList<>();

        while (in.hasNext()){
            String[] lineItem = in.nextLine().strip().split(" ");
            EmbeddingItem item = new EmbeddingItem(lineItem);
            embedding.add(item);
        }
        printRunTime(startTime);

//        for (int i = 0; i < 100; i++) {
//            String[] lineItem = in.nextLine().split(" ");
//            EmbeddingItem item = new EmbeddingItem(lineItem);
//            embedding.add(item);
//        }

        String max="";
        for (EmbeddingItem item:
                embedding) {
            if (item.getWord().length()>max.length()){
                max=item.getWord();
            }
        }
        printRunTime(startTime);
        System.out.println(max);
        System.out.println(max.length());
        System.out.println(embedding.size());



//        //1.加载驱动程序
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        //2.获得数据库的连接
//        Connection conn = DriverManager.getConnection(URL, NAME, PASSWORD);
//        //3.通过数据库的连接操作数据库，实现增删改查
//        Statement stmt = conn.createStatement();
//        ResultSet rs = stmt.executeQuery("select * from test");//选择import java.sql.ResultSet;
//        while (rs.next()) {//如果对象中有数据，就会循环打印出来
//            System.out.println(rs.toString());
//        }
    }
}
