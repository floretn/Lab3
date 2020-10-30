package theory.converter.convertClass;

import theory.converter.convertInterface.Converter;

public class CelciumToKelvin implements Converter {
    @Override
    public double convert(double grad) {
        return grad + 273.15;
    }
}
