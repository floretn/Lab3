package ch14.employee;

public class Employee {

    private int salary;
    private String name;

    public Employee(int salary, String name){
        this.name = name;
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }
}
