package theory.teor2.main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void launch(ArrayList<String> strings, Runnable... launch){
        Thread[] threads = new Thread[launch.length];
        for(int i = 0; i < launch.length; i++){
            threads[i] = new Thread(launch[i]);
            threads[i].start();
        }
        while (true) {
            System.out.print("1.Добавить строку\n2.Сделать строку null\n0.Выйти\nВыберите действие: ");
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            if(n == 1){
                System.out.print("Введите строку: ");
                String s = sc.next();
                strings.add(s);
            }

            if(n == 2){
                System.out.print("Введите индекс: ");
                int i = sc.nextInt();
                strings.set(i, null);
            }

            if(n == 0){
                break;
            }
            System.out.println(strings);
        }

        //for(Thread t : threads){
            //t.stop();
        //}
    }

    public static void main(String[] args) {

        ArrayList<String> strings = new ArrayList<>();
        Thread t = Thread.currentThread();
        Scanner sc = new Scanner(System.in);


        int time1 = 60000;
        Runnable r1 = () -> {
            while(t.getState() == Thread.State.RUNNABLE) {
                for (int i = 0; i < strings.size(); i++) {
                    if (strings.get(i) == null) {
                        strings.remove(i);
                    }
                }
                try {
                    Thread.sleep(time1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Все пустые строки удалены!\n Продолжайте ввод здесь: ");
            }
        };

        launch(strings, r1, () -> {
            boolean check = true;
            while (t.getState() == Thread.State.RUNNABLE){
                if (!check){
                    System.out.println("Сделайте зарядку для глаз!\nКогда сделаете, продолжайте ввод здесь: ");
                }else{
                    check = false;
                }
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }});
    }
}
