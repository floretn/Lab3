package dop.main;

import java.util.Iterator;

public class IteratorForEmployees implements Iterator<Employees> {

    Employees[] employees = new Employees[5];
    int i = 0;

    public  void add(Employees employee){
        employees[i] = employee;
        i++;
    }
    @Override
    public boolean hasNext() {
        if(i != 0) {
            return true;
        }
        return false;
    }

    @Override
    public Employees next() {
        return employees[--i];
    }
}
