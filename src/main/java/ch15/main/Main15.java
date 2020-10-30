package ch15.main;

import ch15.inter.IntSequence;
import javafx.scene.transform.Scale;

import java.util.Random;
import java.util.Scanner;

public class Main15 {

    private static final Random generator = new Random();

    static class RandomSequence implements IntSequence {
        private int low;
        private int high;

        public RandomSequence(int low, int high){
            this.low = low;
            this.high = high;
        }

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public int next() {
            return low + generator.nextInt(high - low +1);
        }
    }

    public static IntSequence returnIntSeq(int low, int high){
        class RandomSequence implements IntSequence {
            @Override
            public boolean hasNext() {
                return true;
            }
            @Override
            public int next() {
                return low + generator.nextInt(high - low +1);
            }
        }
        return new RandomSequence();
    }

    public static IntSequence randomInts(int low, int high) {
        return new RandomSequence(low, high);
    }

    public static IntSequence randomInts1(int low, int high) {
        return Main15.returnIntSeq(low, high);
    }

    public static void main(String[] args) {
        System.out.print("Введите два числа: ");
        Scanner sc = new Scanner(System.in);
        int low = sc.nextInt();
        int high = sc.nextInt();
        IntSequence m = randomInts(low, high);
        int i = 0;
        while(m.hasNext() && i < 10){
            System.out.println(m.next());
            i++;
        }

        m = randomInts1(low, high);
        i = 0;
        while(m.hasNext() && i < 10){
            System.out.println(m.next());
            i++;
        }
    }
}
