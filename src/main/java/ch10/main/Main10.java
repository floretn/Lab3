package ch10.main;

import ch10.isDirectory.*;
import java.io.File;
import java.io.FileFilter;

public class Main10 {

    public static File[] file1(File f){
        FileFilter ff = new IsDirectory1();
        return f.listFiles(ff);
    }

    public static File[] file2(File f){
        return f.listFiles((pathname) -> {
            return pathname.isDirectory();
        });
    }

    public static File[] file3(File f){
        return f.listFiles(File::isDirectory);
    }

    public static File[] file4(File f){
        FileFilter ff = IsDirectory1.filter();
        return f.listFiles(ff);
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
        files = file3(f);
        System.out.println("Files are: ");
        for (File file : files) {
            System.out.println(file.getName());
        }
        System.out.println("*************************************************************");
        files = file4(f);
        System.out.println("Files are: ");
        for (File file : files) {
            System.out.println(file.getName());
        }
        System.out.println("*************************************************************");

    }
}
