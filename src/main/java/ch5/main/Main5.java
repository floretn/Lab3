package ch5.main;

import ch5.interface5.IntSequence;

import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        System.out.print("Введите целое число: ");
        Scanner sc = new Scanner(System.in);
        int j = sc.nextInt();
        IntSequence is = IntSequence.constant(j);
        int i = 0;
        while(i < 100){
            System.out.println(is.next() + ", ");
            i++;
        }


        System.out.print("Введите целое число для лямбда-выражения: ");
        int j1 = sc.nextInt();
        IntSequence is1 = () -> {return j1;};
        i = 0;
        while(i < 100){
            System.out.println(is1.next() + ", ");
            i++;
        }

    }
}
