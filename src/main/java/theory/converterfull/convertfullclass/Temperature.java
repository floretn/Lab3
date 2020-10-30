package theory.converterfull.convertfullclass;

import theory.converterfull.fullinterface.ConverterFull;


public class Temperature implements ConverterFull {

    private double grad;

    public Temperature(double grad){
        this.grad = grad;
    }

    @Override
    public double convert(double grad) {
        return grad*1.8 + 32;
    }

    public double getGrad() {
        return grad;
    }
}
