package ch4.interface4;

import ch4.sequence.Sequence;

import java.util.ArrayList;

public interface IntSequence {

    public static final ArrayList<Integer> current = new ArrayList<>();

    default boolean hasNext() {
        return true;
    }

    int next();

    static Sequence of1(int... values){
        return new Sequence(values);
    }

    static IntSequence of2(int... values){
        return () -> {
            int i = values[current.size()];
            current.add(0);
            return i;
        };

        /*new IntSequence() {

            int current = -1;
            public boolean hasNext(){
                return current + 1 < values.length;
            }

            public int next(){
                current++;
                return values[current];
            }
        };
        */
    }


}
