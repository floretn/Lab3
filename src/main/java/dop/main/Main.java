package dop.main;

import dop.myIterator.MyIterator1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*
        IteratorForEmployees ife1 = new IteratorForEmployees();
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 2; i++){
            System.out.print("Введите зарплату, имя, должность и бонус работника: ");
            double salary = sc.nextDouble();
            String name = sc.next();
            String post = sc.next();
            double bonus = sc.nextDouble();
            ife1.add(new Employees(salary, name, post, bonus));
        }
        MyIterator1<Employees> mi1 = new MyIterator1<>(ife1);
        System.out.println();

        while (mi1.hasNext()){
            System.out.println(mi1.next());
        }

         */

        MyIterator1<Employees> mi1;
        System.out.println("*********************************************************************");

        ArrayList<Employees> ife = new ArrayList<>();
        //IteratorForEmployees ife = new IteratorForEmployees();
        for (int i = 0; i < 5; i++){
            System.out.print("Введите зарплату, имя и должность работника: ");
            double salary = sc.nextDouble();
            String name = sc.next();
            String post = sc.next();
            double bonus = sc.nextDouble();
            ife.add(new Employees(salary, name, post, bonus));
        }

        System.out.println();

        MyIterator1<Employees> mi2 = MyIterator1.fromIterator(ife.iterator());
        while (mi2.hasNext()){
            System.out.println(mi2.next());
        }

        System.out.println("*********************************************************************");
        mi2 = MyIterator1.fromIterator(ife.iterator());
        mi1 = mi2.filter(Employees::getName, "Ivan");

        System.out.println(mi1.next());
        System.out.println(mi1.next());
        System.out.println(mi1.next());
        System.out.println(mi1.next());

        System.out.println("*********************************************************************");
        mi2 = MyIterator1.fromIterator(ife.iterator());
        mi1 = mi2.filter(Employees::getName, "Ivan");
        while (mi1.hasNext()){
            System.out.println(mi1.next());
        }

        System.out.println("*********************************************************************");
        mi2 = MyIterator1.fromIterator(ife.iterator());
        mi1 = mi2.filter(
                (Employees employees) -> employees.bonus + employees.salary,
                123.0);

        while (mi1.hasNext()){
            System.out.println(mi1.next());
        }

        System.out.println("*********************************************************************");

        mi2 = MyIterator1.fromIterator(ife.iterator());
        Map<String, List<Employees>> mapOnPost = mi2.collectToMap(Employees::getPost);

       List<Employees> listOfDirectors = mapOnPost.get("Director");
       if (listOfDirectors != null) {
           for (Employees employee : listOfDirectors) {
               System.out.println(employee);
           }
       }

        System.out.println(mapOnPost.size());

        System.out.println(mapOnPost.values());

        mapOnPost.clear();

        System.out.println(mapOnPost.size());

        System.out.println("*********************************************************************");

        mi2 = MyIterator1.fromIterator(ife.iterator());
        mi1 = mi2.map((Employees emp) -> {emp.bonus += 10;
        return emp; }
        );
        while (mi1.hasNext()){
            System.out.println(mi1.next());
        }

        System.out.println("*********************************************************************");

        mi2 = MyIterator1.fromIterator(ife.iterator());
        mi2.forEach(System.out::println);

        System.out.println("*********************************************************************");

        mi2 = MyIterator1.fromIterator(ife.iterator());
        ArrayList<Employees> al = mi2.collect();
        System.out.println(al);

        System.out.println("*********************************************************************");
        mi1 = MyIterator1.fromIterator(ife.iterator());
        mi2 = MyIterator1.fromIterator(ife.iterator());
        mi1 = mi2.union(mi1);
        while (mi1.hasNext()){
            System.out.println(mi1.next());
        }

        System.out.println("*********************************************************************");
        mi2 = MyIterator1.fromIterator(ife.iterator());
        Employees employee = mi2.reduce((Employees e1, Employees e2) -> {
            if(e1.salary > e2.salary){
                return e1;
            }else{
                return e2;
            }
        });
        System.out.println(employee);
    }
}
