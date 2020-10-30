package ch1.employee;
import ch1.interface1.Measurable;

public class Employee implements Measurable {
    private double salary;
    private String name;

    public Employee(double salary, String name){
        this.salary = salary;
        this.name = name;
    }

    public double getMeasure() {
        return salary;
    }

    public static double average(Measurable[] objects){
        double rez = 0;
        for (Measurable object : objects) {
            rez += object.getMeasure();
        }
        return rez/objects.length;
    }
}
