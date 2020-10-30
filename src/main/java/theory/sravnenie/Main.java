package theory.sravnenie;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void sort(String[] s, Comparator<String> comp){
        for (int i = 0; i < s.length - 1; i++){
            for (int j = i; j < s.length; j++){
                if (comp.compare(s[i], s[j]) > 0){
                    String string = s[i];
                    s[i] = s[j];
                    s[j] = string;
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] s = new String[] {"str", "gt", "y" , "ae", "n", "fhy"};
        System.out.println(Arrays.toString(s));
        sort(s, (s1, s2) -> {
            if (s1.length() != s2.length()){
                return s1.length() - s2.length();
            }
            return s1.compareTo(s2);
        });
        System.out.println(Arrays.toString(s));

        System.out.println("***************************************************************");

        s = new String[] {"str", "gt", "y" , "ae", "n", "fhy"};
        System.out.println(Arrays.toString(s));
        Comparator<String> comparator = (String s1, String s2) -> {
            if (s1.length() != s2.length()){
                return s1.length() - s2.length();
            }
            return 0;
        };
        Comparator<String> comp = comparator.thenComparing(Comparator.naturalOrder());
        sort(s, comp);
        System.out.println(Arrays.toString(s));
    }
}
