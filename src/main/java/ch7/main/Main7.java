package ch7.main;

import java.util.*;

public class Main7 {

    public static void luckySort(ArrayList<String> strings, Comparator<String> comp) {
        Random rnd = new Random();
        strings.sort(comp);
        ArrayList<String> strings2 = new ArrayList<>();
        for (String string : strings) {
            strings2.add(string);
        }

        Collections.shuffle(strings, rnd);
        while(!strings2.equals(strings)){
            Collections.shuffle(strings, rnd);
            System.out.println(strings);
        }
    }

    public static void main(String[] args) {
        System.out.print("Введите колличество строк: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String> strings = new ArrayList<>();
        while (n != 0) {
            System.out.print("Введите новую строку: ");
            strings.add(sc.next());
            n--;
        }

        luckySort(strings, (first, second) -> {
            if (first.length() == second.length()){
                return first.compareTo(second);
            }
            return first.length() - second.length();
        });
        System.out.println(strings);
    }

}
