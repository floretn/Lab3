package theory.teor1.circle;

import theory.teor1.inter.AreaOfFigures;

public class Circle implements AreaOfFigures {
    int r;

    public Circle(int r) {
        this.r = r;
    }

    public String toString(){
        return getName();
    }

    @Override
    public String getName(){
        return "Circle";
    }

    @Override
    public double getArea() {
        return Math.PI*r*r;
    }
}
