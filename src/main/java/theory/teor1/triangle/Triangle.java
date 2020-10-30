package theory.teor1.triangle;

import theory.teor1.inter.AreaOfFigures;

public class Triangle implements AreaOfFigures {
    double a;
    double h;

    public Triangle(double a, double h) {
        this.a = a;
        this.h = h;
    }

    public String toString(){
        return getName();
    }

    @Override
    public String getName(){
        return "Triangle";
    }

    @Override
    public double getArea() {
        return a*h/2;
    }
}
