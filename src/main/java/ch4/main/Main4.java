package ch4.main;

import ch4.interface4.IntSequence;
import ch4.sequence.Sequence;

public class Main4 {
    public static void main(String[] args) {
        Sequence is1 = IntSequence.of1(1, 43, 54, 543, 34, 645, 6545, 76567);
        if(is1.hasNext()){
            System.out.print(is1.next());
        }
        while(is1.hasNext()){
            System.out.print(", " + is1.next());
        }
        System.out.println();
        IntSequence is2 = IntSequence.of2(1, 45, 56, 793, 3434, 65, 65475, 767);
        if(is2.hasNext()){
            System.out.print(is2.next());
        }
        while(is2.hasNext()){
            System.out.print(", " + is2.next());
        }
    }
}
