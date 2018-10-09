package khaustau.homeworkFour.entity;

import java.util.Arrays;
import java.util.Random;

public class NavSat extends Satallite {
    Random rand = new Random();
    double[] data;
    public static int counter = 0;

    public NavSat(String name, int lifeTime, double mass) {
        super(name, lifeTime, mass);

        type = "Navigation Sat";
        isWorking = false;
        counter++;
    }

    double calculatePosition() {
        return Math.random() * 10;
    }

    /*
    * вычисление координат x, y, z и передача их абоненту
     */
    @Override
    public void operate() {
        data = new double[3];

        for (int i = 0; i < data.length; i++) {
            data[i] = calculatePosition();
        }

        System.out.println("sendind data to earth " + Arrays.toString(data));
    }
}
