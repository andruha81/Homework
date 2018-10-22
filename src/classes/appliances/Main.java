/*
 * Тема 4 - классы и объекты
 * Задача 24
 * Бытовая техника
 */
package classes.appliances;

import classes.appliances.entity.Fridge;
import classes.appliances.entity.WashingMachine;

public class Main {

    public static void main(String[] args) {
        WashingMachine wm = new WashingMachine("Bosch", "front", 12,900,5);
        Fridge fridge = new Fridge("Samsung", 4, 3, 300, "A++");

        wm.getSpec();
        wm.turnOn();
        wm.work();
        wm.turnOf();

        fridge.getSpec();
        fridge.turnOn();
        fridge.work();
        fridge.turnOf();
    }
}
