package ch10.isDirectory;

import java.io.File;
import java.io.FileFilter;

public class IsDirectory1 implements FileFilter {
    @Override
    public boolean accept(File pathname) {
        return pathname.isDirectory();
    }

    public static FileFilter filter(){
        return new FileFilter(){
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        };
    }
}
