package theory.mycomparator.compar;

import theory.mycomparator.mycomparator.MyComparator;

public class Compar implements MyComparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }


}
