package ch6.main;

import ch6.iterator.DigitSequence;
import java.util.Iterator;

public class Main6 {
    public static void main(String[] args) {
        Iterator ds = new DigitSequence();
        while(ds.hasNext()){
            System.out.println(ds.next());
        }
        //ds.forEachRemaining(super.);
    }
}