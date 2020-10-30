package ch14.main;

import ch14.employee.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main14 {
    public static void main(String[] args) {
        System.out.print("Введите количество работников: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Employee[] emp = new Employee[n];
        for (int i = 0; i < n; i++){
            System.out.print("Введите имя работника: ");
            String name = sc.next();
            System.out.print("Введите зарплату работника: ");
            int salary = sc.nextInt();
            emp[i] = new Employee(salary, name);
        }
        Comparator<Employee> c = Comparator.comparingInt(Employee::getSalary).thenComparing(Comparator.comparing(Employee::getName));
        Arrays.sort(emp, c);
        for(int i = 0; i < n; i++){
            System.out.println(emp[i].getName() + "   " + emp[i].getSalary());
        }

        System.out.println("**************************************************************");
        
        Arrays.sort(emp, c.reversed());
        for(int i = 0; i < n; i++){
            System.out.println(emp[i].getName() + "   " + emp[i].getSalary());
        }

        System.out.println("**************************************************************");
    }
}
