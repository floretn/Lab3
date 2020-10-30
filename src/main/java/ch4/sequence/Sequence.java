package ch4.sequence;

import ch4.interface4.IntSequence;

public class Sequence implements IntSequence {

    int[] a;
    int current;

    public Sequence(int[] value){
        a = new int[value.length];
        a = value;
        current = -1;
    }

    public boolean hasNext(){
        return current + 1 < a.length;
    }

    public int next(){
        current++;
        return a[current];
    }

}
