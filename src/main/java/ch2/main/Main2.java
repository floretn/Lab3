package ch2.main;

import ch2.employee.Employee;
import ch2.interface2.Measurable;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        System.out.print("Введите количество работников: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Measurable[] objects = new Measurable[n];
        for (int i = 0; i < n; i++){
            System.out.print("Введите имя работника: ");
            String name;
            name = sc.next();
            System.out.print("Введите зарплату: ");
            double measure = sc.nextDouble();
            Employee emp = new Employee(measure, name);
            objects[i] = emp;
        }
        //double average = Employee.average(objects);
        System.out.println(Employee.average(objects));

        System.out.print("Имя работника с самой большой зарплатой: ");
        Measurable emp = new Employee();
        emp = emp.largest(objects);
        Employee emp1;
        if (emp instanceof Employee) {
            emp1 = (Employee) emp;
            System.out.print(emp1.getName());
        }
    }
}
