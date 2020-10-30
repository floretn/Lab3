package ch2.employee;
import ch2.interface2.Measurable;

public class Employee implements Measurable {
    private double salary;
    private String name;

    public Employee(double salary, String name){
        this.salary = salary;
        this.name = name;
    }

    public Employee(){
        this.salary = 0;
        this.name = null;
    }

    @Override
    public double getMeasure() {
        return salary;
    }

    //@Override
    public String getName() {
        return name;
    }

    @Override
    public Measurable largest(Measurable[] objects) {
        Measurable emp = new Employee();
        for (Measurable object : objects) {
            if (emp.getMeasure() < object.getMeasure()) {
                emp = object;
            }
        }
        return emp;
    }


    public static double average(Measurable[] objects){
        double rez = 0;
        for(int i = 0; i < objects.length; i++){
            rez += objects[i].getMeasure();
        }
        return rez/objects.length;
    }
}
