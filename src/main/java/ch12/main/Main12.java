package ch12.main;

import java.io.File;
import java.util.Arrays;
import java.util.Random;

public class Main12 {

    public static void main(String[] args) {
        File[] files = new File[10];
        files[0] = new File("/etc/rc2.d/S01irqbalance"); //файл
        files[1] = new File("/tmp/kotlin-daemon.2020-05-02.21-04-43-173.00.log"); //файл
        files[2] = new File("/home/floret/1.txt"); //файл
        files[3] = new File("/");
        files[8] = new File("/home/floret");
        files[5] = new File("/etc/chatscripts/provider"); //файл
        files[6] = new File("/run/gdm3.pid"); //файл
        files[7] = new File("/home/floret/IdeaProjects/Laboratornaya_Rabota_3/src/main/java/ch12/main/Main12.java"); //файл
        //files[8] = new File("/run/udev/data");
        files[4] = new File("/home/floret/snap");
        files[9] = new File("/sys/bus/iio/drivers");
        Arrays.sort(files, (File f1, File f2) -> {
            if (f1.isDirectory() && !f2.isDirectory()) {
                return -1;
            }
            if (!f1.isDirectory() && f2.isDirectory()) {
                return 1;
            }

            int c = 0;
            for (int i = 0; i < Math.min(f1.getAbsolutePath().length(), f2.getAbsolutePath().length()); i++){
                String s1 = f1.getAbsolutePath().substring(0, i);
                String s2 = f2.getAbsolutePath().substring(0, i);
                c = s1.compareTo(s2);
                if(c != 0){
                    return c;
                }
            }
            return f1.getAbsolutePath().length() - f2.getAbsolutePath().length();
        }
        );

        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }

    }
}
