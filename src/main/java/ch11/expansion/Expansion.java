package ch11.expansion;

import java.io.File;
import java.io.FilenameFilter;

public class Expansion implements FilenameFilter {

    private String exp;

    public Expansion(String exp){
        this.exp = exp;
    }

    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(exp);
    }
}
