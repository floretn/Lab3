package theory.converter.main;

import theory.converter.convertClass.CelciumToFahrenheit;
import theory.converter.convertClass.CelciumToKelvin;
import theory.converter.convertClass.CelciumToReaumur;
import theory.converter.convertInterface.Converter;
import java.util.Scanner;

public class Main {

    public static double[] convertAll(double grad, Converter... all){
        double[] gradAll = new double[all.length];
        for(int i = 0; i < all.length; i++){
            gradAll[i] = all[i].convert(grad);
        }
        return gradAll;
    }

    public static void main(String[] args) {

        Converter cf = new CelciumToFahrenheit();
        Converter ck = new CelciumToKelvin();
        Converter cr = new CelciumToReaumur();

        System.out.print("Введите градусы цельсия: ");
        Scanner sc = new Scanner(System.in);
        double gradC = sc.nextDouble();
        double[] gradAll = convertAll(gradC, cf, ck, cr);
        System.out.println("Градусы в Фаренгейтах, Кельвинах и Реомюрах соответственно:");
        System.out.print(gradAll[0]);
        for (int i = 1; i < gradAll.length; i++){
            System.out.print(", " + gradAll[i]);
        }

    }
}
