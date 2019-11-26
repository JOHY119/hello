package cloud.jony.hello;

import org.jetbrains.annotations.Contract;

import java.time.LocalDate;
import java.util.Objects;

public class Employee extends Person {

    private double salary;
    private LocalDate hireDay;


    //    public Employee(double s) {
//        // 下面这行语句会被‘看’一眼 然而此时nextId就被固定了，此时还没有执行对象初始化块，所以nextId不加1
//        this("Employee #" + Employee.nextId, s);
////        System.out.println("执行完构造器 单参数 nextId=" + nextId);
//    }
//
//    public Employee(String n, double s) {
////        System.out.println("开始执行双参数初始化块 name=" + n);
//
//        name = n;
//        salary = s;
////        System.out.println("执行构造器 双参数, nextId= " + nextId);
//    }
//
//    /**
//     * 无参构造器.
//     */
//    public Employee() {
//        System.out.println("执行构造器 无参数");
//
//    }
    public Employee(String name) {
        this(name, 0, 1980, 1, 1);
    }

    public Employee(String name, double salary, int year, int month, int day) {
        super(name);
        this.salary = salary;
        this.hireDay = LocalDate.of(year, month, day);
    }

    public final int foo(int a){
        return a;
    }

    public final int foo(int a, int b) {
        return a+b;
    }

    public String getName() {
        return super.getName();
    }

    @Override
    public String getDescription() {
        return String.format("an employee with a salary of $%.2f", salary);
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    @Override
    public boolean equals(Object obj) {
//        是否是当前对象(即是否指向同一块内存区域)
        if (this == obj) return true;
//        是否是null
        if (obj == null) return false;
//        是否是同一个类的对象
        if (getClass() != obj.getClass()) return false;
//        调用超类的equals
//        if(!super.equals(obj)) return false;
//        经过上一步后确认是当前类对象 进行强制转换
        Employee other = (Employee) obj;
//        比较当前类中实例域都是否相同
        return salary == other.salary
                && Objects.equals(hireDay, other.hireDay)
                && Objects.equals(getName(), other.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), salary, hireDay);
    }

    @Override
    public String toString() {
        return getClass().getName() + "[name=" + getName() + ", salary=" + salary + ", hireDay=" + hireDay + "]";
    }
}

