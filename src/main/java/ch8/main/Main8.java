package ch8.main;

import ch8.greeter.Greeter;
import java.util.Scanner;

public class Main8 {
    public static void main(String[] args) {
        System.out.print("Введите первое n: ");
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        System.out.print("Введите первый target: ");
        String target1 = sc.next();
        System.out.print("Введите второе n: ");
        int n2 = sc.nextInt();
        System.out.print("Введите второй target: ");
        String target2 = sc.next();

        Runnable task1 = new Greeter(n1, target1);
        Thread thread1 = new Thread(task1);
        Runnable task2 = new Greeter(n2, target2);
        Thread thread2 = new Thread(task2);
        thread1.start();
        thread2.start();
    }
}
