package ch11.main;

import ch11.expansion.Expansion;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

public class Main11 {

    public static File[] file1(File f){
        System.out.print("Введите расширение: ");
        Scanner sc = new Scanner(System.in);
        String exp = sc.next();
        FilenameFilter ff = new Expansion(exp);
        return f.listFiles(ff);
    }

    public static File[] file2(File f){
        System.out.print("Введите расширение: ");
        Scanner sc = new Scanner(System.in);
        String exp = sc.next();
        return f.listFiles((dir, name) -> {return name.endsWith(exp);});
    }

    public static void main(String[] args) {
        File f = new File("/home/floret");
        File[] files;
        files = file1(f);
        System.out.println("Files are: ");
        for (File file : files) {
            System.out.println(file.getName());
        }
        System.out.println("*************************************************************");
        files = file2(f);
        System.out.println("Files are: ");
        for (File file : files) {
            System.out.println(file.getName());
        }
        System.out.println("*************************************************************");


    }
}
