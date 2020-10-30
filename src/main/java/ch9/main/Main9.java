package ch9.main;

import java.util.Scanner;

public class Main9 {

    public static void runTogether(Runnable... tasks){
        Thread[] threads = new Thread[tasks.length];
        for(int i = 0; i < tasks.length; i++){
            threads[i] = new Thread(tasks[i]);
            threads[i].start();
        }
    }

    public static void runInOrder(Runnable... tasks) {
        for (Runnable task : tasks) {
            task.run();
        }
    }

    public static void main(String[] args){
        System.out.println("Введите количество потоков: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Runnable[] tasks = new Runnable[n];
        for(int i = 0; i < n; i++){
            tasks[i] = () -> {for (int j = 0; j <= 10; j++){
                System.out.println(j + "a" + j);
            }};
        }
        runInOrder(tasks);
        System.out.println("********************************************************************************");
        runTogether(tasks);
    }
}
