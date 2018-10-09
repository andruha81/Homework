package khaustau.homeworkFour.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MeteoSat extends Satallite{
    Random rand = new Random();
    List data;
    public static int counter = 0;

    public MeteoSat(String name, int lifeTime, double mass) {
        super(name, lifeTime, mass);

        type = "Meteo Sat";
        isWorking = false;
        counter++;
    }

    /* измерение тепературы */
    Integer measureTemp() {
        return Integer.valueOf(rand.nextInt(51));
    }

    /* измерение силы ветра */
    Double measureWind() {
        return Double.valueOf(rand.nextInt(101));
    }

    /* измерение облачности */
    String findCloud() {
        return "cloudly";
    }

    /*
    * в процессе работы спутник передает на землю информацию
    * о температуре, силе ветра и облачности
     */
    @Override
    public void operate() {
        data = new ArrayList();

        data.add(measureTemp());
        data.add(measureWind());
        data.add(findCloud());

        System.out.println("sendind data to earth " + data);
    }
}
