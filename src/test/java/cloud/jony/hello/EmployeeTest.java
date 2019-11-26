package cloud.jony.hello;

public class EmployeeTest {

    public static void swap(Employee x, Employee y) {
        Employee temp = x;
        x = y;
        y = temp;


        System.out.println(x.getName());
        System.out.println(x);
        System.out.println(y.getName());
        System.out.println(y);

    }

//    public static void main(String[] args) {
//        Employee[] staff = new Employee[3];
//
//        staff[0] = new Employee("Tom", 75000);
//        staff[1] = new Employee("Dick", 50000);
//        staff[2] = new Employee("Harry", 40000);
//
//        System.out.println(staff[0].getName());
//        System.out.println(staff[1].getName());
//        swap(staff[0],staff[1]);
//        System.out.println(staff[0].getName());
//        System.out.println(staff[1].getName());
//
//
//
//        for (Employee e :
//                staff) {
//            e.setId();
//        }
//
//        for (Employee e :
//                staff) {
//            e.raiseSalary(5);
//        }
//
//        for (Employee e :
//                staff) {
//            System.out.println("name=" + e.getName() + ", salary=" + e.getSalary() + ", id=" + e.getId());
//        }
//
//        System.out.println("Next available id=" + Employee.getNextId());
//
//    }
}
