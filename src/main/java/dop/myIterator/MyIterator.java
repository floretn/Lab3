package dop.myIterator;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class MyIterator<E> implements Iterator<E> {

    private Node first;
    private Node last;
    private Node current;

    class Node{
        E object;
        Node next;
        
        Node(E object){
            this.object = object;
            next = null;
        }
    }
    
    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public E next() {
        if(this.hasNext()) {
            E obj = current.object;
            current = current.next;
            return obj;
        }
        return null;
    }

    public void update(){
        current = first;
    }

    public void add(E object){
        if(first == null){
            first = new Node(object);
            last = first;
            current = first;
        }else {
            last.next = new Node(object);
            last = last.next;
        }
    }
    
    public static <E> MyIterator<E> fromIterator(Iterator<E> fromIter){
        MyIterator<E> mi = new MyIterator<>();
        while(fromIter.hasNext()){
            mi.add(fromIter.next());
        }
        return mi;
    }

    public <U> MyIterator<E> filter(Function<E, U> func, U rez){
        MyIterator<E> mi = new MyIterator<E>();
        while(this.hasNext()){
            E obj = this.next();
            if(func.apply(obj).equals(rez)){
                mi.add(obj);
            }
        }
        return mi;
    }

    public <K> Map<K, List<E>> collectToMap(Function<E, K> func){
        Map<K, List<E>> collectToMap = new HashMap<>();
        Node firstNode = this.current;
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
        this.current = firstNode;
        return collectToMap;
    }

    /*
    public <K> Map<K, List<E>> collectToMap1(Function<E, K> func){

        class CollectToMap implements Map<K, List<E>>{

            final ArrayList<MapNode> mapNodes;

            class MapNode{
                final K key;
                List<E> objectsM;

                MapNode(K key){
                    objectsM = new ArrayList<>();
                    this.key = key;
                }
            }

            CollectToMap(){
                mapNodes = new ArrayList<>();
            }

            CollectToMap(MyIterator<E> mi){
                this();
                while (mi.hasNext()){
                    E obj = mi.next();
                        if (this.containsKey(func.apply(obj))){
                            this.get(func.apply(obj)).add(obj);
                        }else{
                            mapNodes.add(new MapNode(func.apply(obj)));
                            mapNodes.get(mapNodes.size() - 1).objectsM.add(obj);
                        }
                }
            }

            @Override
            public int size() {
                return mapNodes.size();
            }

            @Override
            public boolean isEmpty() {
                return mapNodes.isEmpty();
            }

            @Override
            public boolean containsKey(Object key) {
                for (MapNode mapNode : mapNodes) {
                    if (mapNode.key.equals(key)) {
                        return true;
                    }
                }
                return false;
            }

            @Override
            public boolean containsValue(Object value) {
                for (MapNode mapNode : mapNodes) {
                    for(E obj : mapNode.objectsM) {
                        if (obj.equals(value)) {
                            return true;
                        }
                    }
                }
                return false;
            }

            @Override
            public List<E> get(Object key) {
                for (MapNode mapNode : mapNodes) {
                    if (mapNode.key.equals(key)) {
                        return mapNode.objectsM;
                    }
                }
                return null;
            }

            @Override
            public List<E> put(K key, List<E> value) {
                if (this.containsKey(key)) {
                    for (MapNode mapNode : mapNodes) {
                        if (mapNode.key.equals(key)) {
                            List<E> list = mapNode.objectsM;
                            mapNode.objectsM = value;
                            return list;
                        }
                    }
                }
                return null;
            }

            @Override
            public List<E> remove(Object key) {
                if (this.containsKey(key)) {
                    for (MapNode mapNode : mapNodes) {
                        if (mapNode.key.equals(key)) {
                            List<E> list = mapNode.objectsM;
                            mapNodes.remove(mapNode);
                            return list;
                        }
                    }
                }
                return null;
            }

            @Override
            public void putAll(Map<? extends K, ? extends List<E>> m) {
                Set<? extends K> allKeys = m.keySet();
                for (K newKey : allKeys) {
                    this.put(newKey, m.get(newKey));
                }
            }

            @Override
            public void clear() {
                mapNodes.clear();
            }

            @Override
            public Set<K> keySet() {
                Set<K> allKeys = new HashSet<>();
                for (MapNode mapNode : mapNodes){
                    allKeys.add(mapNode.key);
                }
                return allKeys;
            }

            @Override
            public Collection<List<E>> values() {
                Collection<List<E>> allValues = new HashSet<>();
                for (MapNode mapNode : mapNodes){
                    allValues.add(mapNode.objectsM);
                }
                return allValues;
            }

            @Override
            public Set<Entry<K, List<E>>> entrySet() {

                class Elements implements Entry<K, List<E>>{

                    MapNode element;

                    @Override
                    public K getKey() {
                        return element.key;
                    }

                    @Override
                    public List<E> getValue() {
                        return element.objectsM;
                    }

                    @Override
                    public List<E> setValue(List<E> value) {
                        List<E> newList = element.objectsM;
                        element.objectsM = value;
                        return newList;
                    }
                }

                Set<Entry<K, List<E>>> elements = new HashSet<>();
                for (MapNode mapNode : mapNodes){
                    Elements elementForSet = new Elements();
                    elementForSet.element = mapNode;
                    elements.add(elementForSet);
                }
                return elements;
            }
        }

        return new CollectToMap(this);
    }
     */

    public MyIterator<E> map(Consumer<E> func){
        MyIterator<E> mi = fromIterator(this);
        mi.forEach(func);
        return mi;
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

    public MyIterator<E> union(MyIterator1<E> mi){
        MyIterator<E> miNew = new MyIterator<>();
        while(this.hasNext()){
            miNew.add(this.next());
        }

        while(mi.hasNext()){
            miNew.add(mi.next());
        }
        return miNew;
    }

    public E reduce(BiFunction<E, E, E> func){
        MyIterator<E> mi1 = this;
        MyIterator<E> mi2 = new MyIterator<>();
        while(mi1.first != mi1.last){
            while(mi1.hasNext()){
                E obj1 = mi1.next();
                if(mi1.hasNext()){
                    mi2.add(func.apply(obj1, mi1.next()));
                }else{
                    mi2.add(func.apply(obj1, obj1));
                }
            }
            mi1 = mi2;
            mi2 = new MyIterator<>();
        }
        return mi1.next();
    }
}
