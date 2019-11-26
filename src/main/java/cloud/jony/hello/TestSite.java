package cloud.jony.hello;

import java.text.NumberFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;


public class TestSite {
    enum Size {Small, M, L, XL}

    private static void enumerate() {
        Size[] sizes = Size.values();
        System.out.println(Arrays.toString(sizes));
    }


    private static void yangHuiTriangle() {
        int MAX = 10;
        int[][] odds = new int[MAX][];
        for (int i = 0; i < MAX; i++) {
            odds[i] = new int[i + 1];
        }
//        System.out.println(Arrays.deepToString(odds));
        for (int i = 0; i < odds.length; i++) {
            for (int j = 0; j < odds[i].length; j++) {
                int v = 1;
                for (int k = 1; k <= j; k++) {
                    v = v * (i - k + 1) / k;
                }
                odds[i][j] = v;
            }
        }

        System.out.println(Arrays.deepToString(odds));
        for (int[] line :
                odds) {
            System.out.println(Arrays.toString(line));
        }
    }

    private static void triangleArray() {
        int[] a = {1, 2, 3, 4, 5};
        int[][][] b = {
                {
                        {1, 2, 3, 4},
                        {1, 2, 3, 4},
                        {1, 2, 3, 4},

                },
                {
                        {1, 2, 3, 4},
                        {1, 2, 3, 4},
                        {1, 2, 3, 4},
                },
        };
//        格式化输出数组
        System.out.println(Arrays.toString(a));
//        格式化输出多维数组
        System.out.println(Arrays.deepToString(b));
    }

    private static void lottery() {
        int n = 100;
        int rs = 10;
        int[] numbers = new int[n];
        int[] results = new int[rs];

        for (int i = 0; i < n; i++) {
            numbers[i] = i + 1;
        }

        for (int i = 0; i < rs; i++) {
            int r = (int) (Math.random() * n);
            results[i] = numbers[r];
            numbers[r] = numbers[n - 1];
            n--;
        }
        Arrays.sort(results);
        System.out.println(Arrays.toString(results));
    }

    private static void printCurrentMouthCalendar(){
        LocalDate date = LocalDate.now();
        int mouth = date.getMonthValue();
        int day = date.getDayOfMonth();

        date = date.minusDays(day - 1);

        DayOfWeek dayOfWeek = date.getDayOfWeek();
        int value = dayOfWeek.getValue();
//        一周从周日开始 需要每个值都+1
        value = value % 7 + 1;

        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        for (int i = 1; i < value; i++) {
            System.out.print("    ");
        }

        while (date.getMonthValue() == mouth) {
            System.out.printf("%3d", date.getDayOfMonth());
            if (date.getDayOfMonth() == day) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
            date = date.plusDays(1);
            if (date.getDayOfWeek().getValue() == 7) {
                System.out.println();
            }

        }
    }

    public static void main(String[] args) {
//        enumerate();
//        lottery();
//        triangleArray();
//        yangHuiTriangle();
//        printCurrentMouthCalendar();

        NumberFormat currency=NumberFormat.getCurrencyInstance();
        NumberFormat percent=NumberFormat.getPercentInstance();
        double n=0.1;

        System.out.println(currency.format(n));
        System.out.println(percent.format(n));




    }


}
