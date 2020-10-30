package theory.mycomparator.compar;

import theory.mycomparator.mycomparator.MyComparator;

public class Compar1 implements MyComparator<String> {

    @Override
    public int compare(String o1, String o2) {
        if(o1.contains("Anonim") && !o2.contains("Anonim")){
            return -1;
        }
        if(o2.contains("Anonim") && !o1.contains("Anonim")){
            return 1;
        }
        return o1.compareTo(o2);
    }
}
