package ch1.main;

import ch1.employee.Employee;
import ch1.interface1.Measurable;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        System.out.print("Введите количество работников: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Measurable[] objects = new Measurable[n];
        for (int i = 0; i < n; i++){
            System.out.print("Введите имя работника: ");
            String name;
            name= sc.next();
            System.out.print("Введите зарплату: ");
            double salary = sc.nextDouble();
            Employee emp = new Employee(salary, name);
            objects[i] = emp;
        }
        //double average = Employee.average(objects);
        System.out.println(Employee.average(objects));

    }
}
