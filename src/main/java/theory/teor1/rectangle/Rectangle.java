package theory.teor1.rectangle;

import theory.teor1.inter.AreaOfFigures;

public class Rectangle implements AreaOfFigures {
    double a;
    double b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public String toString(){
        return getName();
    }

    @Override
    public String getName(){
        return "Rectangle";
    }

    @Override
    public double getArea() {
        return a*b;
    }
}
