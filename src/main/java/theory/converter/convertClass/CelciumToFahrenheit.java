package theory.converter.convertClass;

import theory.converter.convertInterface.Converter;

public class CelciumToFahrenheit implements Converter {
    @Override
    public double convert(double grad) {
        return 1.8*grad + 32;
    }
}
