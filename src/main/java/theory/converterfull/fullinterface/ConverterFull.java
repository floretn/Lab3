package theory.converterfull.fullinterface;

import theory.converter.convertInterface.Converter;

public interface ConverterFull extends Converter {

    public static double fromFahrenheit(double grad){
        return (grad - 32)/1.8;
    }

}
