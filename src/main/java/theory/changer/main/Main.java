package theory.changer.main;

import theory.changer.changerInterface.Changer;
import java.util.Random;

public class Main {

    public static String[] stringChanger(String[] s, Changer ch){
        String[] sChanged = new String[s.length];
        for (int i = 0; i < s.length; i++){
            sChanged[i] = ch.change(s[i]);
        }
        return sChanged;
    }

    public static void main(String[] args) {

        String[] s = new String[] {"World", "Dangerous", "Animal", "Winter", "Requiem", "Dream", "Heeeeelp", "Me"};

        String[] sChanged = stringChanger(s, (String i) -> {
            StringBuilder builder = new StringBuilder(i);
            return builder.reverse().toString();
        });

        System.out.print(sChanged[0]);
                for(int i = 1; i < sChanged.length; i++){
            System.out.print(", " + sChanged[i]);
        }

        Changer ch =  (String i) -> {
            StringBuilder builder = new StringBuilder(i);
            return builder.reverse().toString();
        };

        sChanged = stringChanger(s, ch);
        System.out.println("************************************************************");

        Random rnd = new Random();
        sChanged = stringChanger(s, (String i) -> {
            int len = rnd.nextInt(i.length());
            for(int j = 0; j < len; j++){
                int ind = rnd.nextInt(i.length());
                while(i.charAt(ind) == '_'){
                    if(ind == i.length() - 1){
                        ind = -1;
                    }
                    ind++;
                }
                StringBuilder builder = new StringBuilder(i);
                builder.setCharAt(ind, '_');
                i = builder.toString();
            }
            return i;
        });
        System.out.print(sChanged[0]);
        for(int i = 1; i < sChanged.length; i++){
            System.out.print(", " + sChanged[i]);
        }

        System.out.println("************************************************************");

        String inside = "Cross out";
        sChanged = stringChanger(s, (String i) -> {
            if(i.charAt(0) == 'W'){
                return inside;
            }
            return i;
        });
        System.out.print(sChanged[0]);
        for(int i = 1; i < sChanged.length; i++){
            System.out.print(", " + sChanged[i]);
        }
    }
}
