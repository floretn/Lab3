package theory.mycomparator.mycomparator;

import java.util.function.Function;
import java.util.function.ToIntFunction;

public interface MyComparator<T> {

    int compare(T o1, T o2);

    boolean equals(Object obj);

    default MyComparator<T> reversed() {
        MyComparator<T> outer = this;
        return new MyComparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return -outer.compare(o1, o2);
            }
        };
    }

    default MyComparator<T> thenComparing(MyComparator<T> other) {
        return  (c1, c2) -> {
            int res = this.compare(c1, c2);
            if (res != 0){
                return res;
            }
            return other.compare(c1, c2);
        };
    }

    default <U> MyComparator<T> thenComparing(
            Function<T, U> keyExtractor,
            MyComparator<U> keyComparator)
    {
        return this.thenComparing(comparing(keyExtractor, keyComparator));
    }

    default <U extends Comparable<U>> MyComparator<T> thenComparing(
            Function<T, U> keyExtractor)
    {
        return this.thenComparing(comparing(keyExtractor));
    }

    default MyComparator<T> thenComparingInt(ToIntFunction<T> keyExtractor) {
        return this.thenComparing(comparingInt(keyExtractor));
    }


    public static <T, U> MyComparator<T> comparing(
            Function<T,U> keyExtractor,
            MyComparator<U> keyComparator)
    {
        return new MyComparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return keyComparator.compare(keyExtractor.apply(o1), keyExtractor.apply(o2));
            }
        };
    }

    public static <T, U extends Comparable<U>> MyComparator<T> comparing(
            Function<T, ? extends U> keyExtractor)
    {
        return (c1, c2) -> keyExtractor.apply(c1).compareTo(keyExtractor.apply(c2));
    }

    public static <T> MyComparator<T> comparingInt(ToIntFunction<T> keyExtractor) {
        return new MyComparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return Integer.compare(keyExtractor.applyAsInt(o1), keyExtractor.applyAsInt(o1));
            }
        };
    }

    public static <T> MyComparator<T> nullsFirst(MyComparator<T> comparator) {
        return (o1, o2) -> {
            if(o1 == null){
                return -1;
            }
            if (o2 == null) {
                return 1;
            }
            return comparator.compare(o1, o2);
        };
    }

    public static <T extends Comparable<T>> MyComparator<T> naturalOrder() {
        return Comparable::compareTo;
    }


}
