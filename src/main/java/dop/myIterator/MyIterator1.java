package dop.myIterator;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class MyIterator1<E> implements Iterator<E> {

    Iterator<E> iter;

    @Override
    public boolean hasNext() {
        return iter.hasNext();
    }

    @Override
    public E next() {
        return iter.next();
    }

    public MyIterator1(Iterator<E> iter) {
        this.iter = iter;
    }


    public static <E> MyIterator1<E> fromIterator(Iterator<E> fromIter){
        return new MyIterator1<E>(fromIter);
    }

    public <U> MyIterator1<E> filter(Function<E, U> func, U rez){
        return fromIterator(new Iterator<E>() {
            E obj = null;
            E objOld = null;

            @Override
            public boolean hasNext() {
                if (MyIterator1.this.hasNext()) {
                    obj = MyIterator1.this.next();
                    while (!func.apply(obj).equals(rez) && MyIterator1.this.hasNext()){
                        obj = MyIterator1.this.next();
                    }
                    return func.apply(obj).equals(rez);
                }
                obj = null;
                return false;
            }

            @Override
            public E next() {
                if (obj == objOld){
                    if (this.hasNext()){
                        objOld = obj;
                        return obj;
                    }
                    return null;
                }
                objOld = obj;
                return obj;
            }
        });
    }

    public <K> Map<K, List<E>> collectToMap(Function<E, K> func){
        Map<K, List<E>> collectToMap = new HashMap<>();
        while (this.hasNext()){
            E obj = this.next();
            if (collectToMap.containsKey(func.apply(obj))){
                collectToMap.get(func.apply(obj)).add(obj);
            }else{
                List<E> objs = new ArrayList<>();
                objs.add(obj);
                collectToMap.put(func.apply(obj), objs);
            }
        }
        return collectToMap;
    }

    public <U> MyIterator1<U> map(Function<E, U> func){
        return fromIterator(new Iterator<U>() {
            @Override
            public boolean hasNext() {
                return MyIterator1.this.hasNext();
            }


            @Override
            public U next() {
                E obj = MyIterator1.this.next();
                U objNew = func.apply(obj);
                return objNew;
            }

        });
    }

    public void forEach(Consumer<E> func){
        while (this.hasNext()){
            func.accept(this.next());
        }
    }

    public ArrayList<E> collect(){
        ArrayList<E> collectAL = new ArrayList<>();
        while(this.hasNext()){
            collectAL.add(this.next());
        }
        return collectAL;
    }

    public MyIterator1<E> union(MyIterator1<E> mi){
        return fromIterator(new Iterator<E>() {

            @Override
            public boolean hasNext() {
                if (MyIterator1.this.hasNext()){
                    return true;
                }
                return mi.hasNext();
            }

            @Override
            public E next() {
                if (MyIterator1.this.hasNext()){
                    return MyIterator1.this.next();
                }
                if(mi.hasNext()){
                    return mi.next();
                }
                return null;
            }
        });
    }

    public E reduce(BiFunction<E, E, E> func){
        E obj = this.next();
        while (this.hasNext()){
            obj = func.apply(obj, this.next());
        }
        return obj;
    }

}
