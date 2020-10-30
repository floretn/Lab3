package theory.teor1.square;

import theory.teor1.inter.AreaOfFigures;

public class Square implements AreaOfFigures {
    double a;

    public Square(double a) {
        this.a = a;
    }

    public String toString(){
        return getName();
    }

    @Override
    public String getName(){
        return "Square";
    }

    @Override
    public double getArea() {
        return a*a;
    }
}
