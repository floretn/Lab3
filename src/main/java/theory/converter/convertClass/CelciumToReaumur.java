package theory.converter.convertClass;

import theory.converter.convertInterface.Converter;

public class CelciumToReaumur implements Converter {
    @Override
    public double convert(double grad) {
        return 1.25*grad;
    }
}
