package ch6.iterator;

import java.util.Iterator;
import java.util.Random;

public class DigitSequence implements Iterator {
    int i = 0;

    public boolean hasNext() {
        return i < 10;
    }

    public Object next() {
        Random rnd = new Random();
        i++;
        return rnd.nextInt(100);
    }

    public void remove() {}
}
