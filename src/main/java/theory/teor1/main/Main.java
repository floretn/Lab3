package theory.teor1.main;

import theory.teor1.circle.Circle;
import theory.teor1.inter.AreaOfFigures;
import theory.teor1.rectangle.Rectangle;
import theory.teor1.square.Square;
import theory.teor1.triangle.Triangle;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static AreaOfFigures[] sortFigure(AreaOfFigures... aof){
        for(int i = 0; i < aof.length - 1; i++){
            for(int j = i; j < aof.length; j++) {
                if (aof[i].getArea() > aof[j].getArea()) {
                    AreaOfFigures max = aof[i];
                    aof[i] = aof[j];
                    aof[j] = max;
                }
            }
        }
        return aof;
    }

    public static Object[] sortFigureWithoutPolymorphism(Object... objects){
        for (int i = 0; i < objects.length - 1; i++){
            for (int j = i; j < objects.length; j++){
                double a1 = 0;
                double a2 = 0;
                if (objects[i] instanceof Circle){
                    a1 = ((Circle) objects[i]).getArea();
                }

                if (objects[i] instanceof Square){
                    a1 = ((Square) objects[i]).getArea();
                }

                if (objects[i] instanceof Rectangle){
                    a1 = ((Rectangle) objects[i]).getArea();
                }

                if (objects[i] instanceof Triangle){
                    a1 = ((Triangle) objects[i]).getArea();
                }

                if (objects[j] instanceof Circle){
                    a2 = ((Circle) objects[i]).getArea();
                }

                if (objects[j] instanceof Square){
                    a2 = ((Square) objects[i]).getArea();
                }

                if (objects[j] instanceof Rectangle){
                    a2 = ((Rectangle) objects[i]).getArea();
                }

                if (objects[j] instanceof Triangle){
                    a2 = ((Triangle) objects[i]).getArea();
                }

                if (a1 > a2){
                    Object obj = objects[i];
                    objects[i] = objects[j];
                    objects[j] = obj;
                }
            }
        }
        return objects;
    }

    public static void main(String[] args) {

        Circle a1 = new Circle(1);
        Square a2 = new Square(1);
        Rectangle a3 = new Rectangle(1, 2);
        Triangle a4 = new Triangle(1, 2);
        Object[] objects = sortFigureWithoutPolymorphism(a1, a2, a3, a4);
        System.out.println(Arrays.toString(objects));

        AreaOfFigures circle = new Circle(1);
        AreaOfFigures square = new Square(1);
        AreaOfFigures rectangle = new Rectangle(1, 2);
        AreaOfFigures triangle = new Triangle(1, 2);
        AreaOfFigures[] aof = sortFigure(circle, square, rectangle, triangle);
        System.out.println(Arrays.toString(aof));
    }
}
