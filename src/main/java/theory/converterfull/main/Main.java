package theory.converterfull.main;

import theory.converterfull.convertfullclass.Temperature;
import theory.converterfull.fullinterface.ConverterFull;
import theory.converterfull.tempinkel.TemperatureInSomething;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.DoubleSupplier;
import java.util.stream.Stream;

public class Main {

    public static Temperature[] convertAll(Temperature[] cf,
                                    Function<Double, Double> func1,
                                           Function<Temperature, Double> func2 ){
        Temperature[] temperatures = new Temperature[cf.length];
        for(int i = 0; i < cf.length; i++){
            temperatures[i] = new Temperature(func1.apply(func2.apply(cf[i])));
        }
        return temperatures;
    }

    public static TemperatureInSomething convertInSomething(Temperature cf,
                                                            Function<Double, Double> func1,
                                                            DoubleSupplier func2 ){
        return new TemperatureInSomething(func1.apply(func2.getAsDouble()));
    }

    public static void main(String[] args) {
        List<Double> temperatures = new ArrayList<>();
        temperatures.add(0.0);
        temperatures.add(12.532);
        temperatures.add(543.54);
        Stream<Temperature> stream = temperatures.stream().map(Temperature::new);
        Temperature[] inFah = stream.toArray(Temperature[]::new);
        Temperature[] inCel = convertAll(inFah, ConverterFull::fromFahrenheit,
                Temperature::getGrad);
        for(Temperature t : inCel){
            System.out.println(t.getGrad());
        }

        TemperatureInSomething inKel = convertInSomething(inCel[0], (d) -> d + 273,
                inCel[0]::getGrad);
        System.out.println(inKel.getGrad());
    }
}