package cloud.jony.hello;

import javax.print.DocFlavor;
import java.util.*;

public class MapTest {
    public static void main(String[] args) {
        Map<String, Employee> staff = new LinkedHashMap<>(128,0.75F, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Employee> eldest) {
                System.out.println("in remove eldest, size= "+size());
                System.out.println(eldest);
                return size()>2;
            }
        };

        staff.put("144-25-5464", new Employee("Amy Lee"));
        staff.put("567-24-2546", new Employee("Harry Hacker"));
        staff.put("157-62-7935", new Employee("Gary Cooper"));
        staff.put("456-62-5527", new Employee("Francesca Cruz"));

        System.out.println(staff);

        staff.remove("567-24-2546");
        staff.put("456-62-5527", new Employee("Francesca Miller"));
        System.out.println(staff.get("157-62-7935"));

        staff.forEach((k,v)-> System.out.println("key="+k+", value="+v));
        SortedMap<Integer, String> stringSortedMap = new TreeMap<>();



    }
}