package cloud.jony.hello.testFile;

import cloud.jony.hello.Employee;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Scanner;

public class TextFileTest {

    public static void writeEmployee(PrintWriter out, Employee e) {
        out.println(e.getName() + "|" + e.getSalary() + "|" + e.getHireDay());
    }

    public static Employee readEmployee(Scanner in) {
        String line = in.nextLine();
        String[] tokens = line.split("\\|");
        String name = tokens[0];
        double salary = Double.parseDouble(tokens[1]);
        LocalDate localDate = LocalDate.parse(tokens[2]);
        int year = localDate.getYear();
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();

        return new Employee(name, salary, year, month, day);
    }

    private static void writeData(Employee[] employees, PrintWriter out) {
        out.println(employees.length);
        for (Employee e :
                employees) {
            writeEmployee(out, e);
        }
    }

    private static Employee[] readData(Scanner in) {
        int n = in.nextInt();
        in.nextLine();

        Employee[] employees = new Employee[n];
        for (int i = 0; i < n; i++) {
            employees[i] = readEmployee(in);
        }
        return employees;
    }

    public static void main(String[] args) throws IOException {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);

        //save all employee records to the file employee.txt
        try (PrintWriter out = new PrintWriter("src/test/resources/employee.txt", StandardCharsets.UTF_8)) {
            writeData(staff, out);
        }

        //retrieve all records into a new array
        try (Scanner in = new Scanner(new FileInputStream("src/test/resources/employee.txt"), StandardCharsets.UTF_8)) {
            Employee[] newStaff = readData(in);

            for (Employee e :
                    newStaff) {
                System.out.println(e);
            }
        }

    }
}
