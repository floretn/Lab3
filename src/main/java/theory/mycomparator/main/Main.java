package theory.mycomparator.main;

import theory.mycomparator.chuvaki.Chuvaki;
import theory.mycomparator.compar.Compar;
import theory.mycomparator.compar.Compar1;
import theory.mycomparator.mycomparator.MyComparator;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

    public static String[] sort(String[] s, MyComparator<String> mc) {
        String test;
        for (int i = 0; i < s.length - 1; i++) {
            for (int j = 1; j < s.length; j++) {
                if (mc.compare(s[j - 1], s[j]) > 0) {
                    test = s[j - 1];
                    s[j - 1] = s[j];
                    s[j] = test;
                }
            }
        }
        return s;
    }

    public static Chuvaki[] sort1(Chuvaki[] s, MyComparator<Chuvaki> mc) {
        Chuvaki test;
        for (int i = 0; i < s.length - 1; i++) {
            for (int j = 1; j < s.length; j++) {
                if (mc.compare(s[j - 1], s[j]) > 0) {
                    test = s[j - 1];
                    s[j - 1] = s[j];
                    s[j] = test;
                }
            }
        }
        return s;
    }


    public static void main(String[] args) {

        MyComparator<String> mc = new Compar();
        String[] s = new String[]{"vsd", "j", "c", "y", "nbrt"};

        sort(s, mc);
        for (int i = 0; i < 5; i++) {
            System.out.println(s[i]);
        }
        System.out.println("******************************************************************");

        MyComparator<String> mc1 = mc.reversed();
        sort(s, mc1);
        for (int i = 0; i < 5; i++) {
            System.out.println(s[i]);
        }
        System.out.println("******************************************************************");

        mc = (c1, c2) -> {
            if (c1.compareTo(c2) > 0) {
                return 1;
            }
            return 0;
        };
        sort(s, mc1.thenComparing(mc));
        for (int i = 0; i < 5; i++) {
            System.out.println(s[i]);
        }
        System.out.println("******************************************************************");

        mc1 = new Compar();
        String[] s1 = new String[]{"vsd", "j", "c", null, "y", "nbrt", null};

        mc1 = MyComparator.nullsFirst(mc1);
        sort(s1, mc1);
        for (int i = 0; i < 7; i++) {
                System.out.println(s1[i]);
        }

        System.out.println("******************************************************************");

        sort(s, MyComparator.naturalOrder());
        for (int i = 0; i < 5; i++) {
            System.out.println(s[i]);
        }

        System.out.println("******************************************************************");
        List<String> names = new ArrayList<>();
        System.out.print("Введите число чуваков: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Введите имя для нового чувака: ");
            names.add(sc.next());
        }
        Stream<Chuvaki> stream = names.stream().map(Chuvaki::new);
        Chuvaki[] chuvakis = stream.toArray(Chuvaki[]::new);
        mc = new Compar1();
        MyComparator<Chuvaki> mcChuvakiForever = MyComparator.comparing(Chuvaki::getName, mc);
        sort1(chuvakis, mcChuvakiForever);
        for (Chuvaki chuvaki : chuvakis) {
            System.out.println(chuvaki.getName());
        }

    }
}

