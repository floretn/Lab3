package ch13.main;

import java.util.Scanner;

public class Main13 {

    public static Runnable method(Runnable... a){
        return () -> {
            for(Runnable b : a){
                b.run();
            }
        };
    }

    public static void main(String[] args) {
        System.out.print("Введите число: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Runnable[] a = new Runnable[n];
        for (int i = 0; i < n; i++){
            a[i] = () -> System.out.println("Bla-bla-bla");
        }

        method(() -> System.out.println("1 lambda"), () -> System.out.println("2 lambda")).run();

    }
}
