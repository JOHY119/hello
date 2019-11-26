package cloud.jony.hello;

import java.util.Objects;

public class Manager extends Employee {

    private double bonus;

    /**
     *
     * @param name the employee's name
     * @param salary the salary
     * @param year the hire year
     * @param month the hire month
     * @param day the hire day
     */
    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
        this.bonus=0;
    }

    public double getSalary(){
        double baseSalary=super.getSalary();
        return baseSalary+this.bonus;
    }

    public void setBonus(double bonus){
        this.bonus=bonus;
    }

    @Override
    public boolean equals(Object obj) {
        if(!super.equals(obj)) return false;

        Manager other=(Manager) obj;

        return this.bonus == bonus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), Double.hashCode(bonus));
    }

    @Override
    public String toString() {
        return super.toString() + "[bonus=" + bonus + "]";
    }
}
