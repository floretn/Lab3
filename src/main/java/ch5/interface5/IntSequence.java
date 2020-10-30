package ch5.interface5;

public interface IntSequence {
    int next();
    static IntSequence constant(int j){
        return new IntSequence() {
            @Override
            public int next() {
                return j;
            }
        };
    }
}
