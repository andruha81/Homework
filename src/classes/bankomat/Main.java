/*
* Тема 4 - классы и объекты
* Задача 23
* Банкомат
 */
package classes.bankomat;

import classes.bankomat.entity.Bankomat;

public class Main {

    public static void main(String[] args) {
        int sumToGive1 = 140;
        int sumToGive2 = 1490;
        int sumToGive3 = 1270;
        Bankomat belarusbankOne = new Bankomat(40, 20, 10);

        belarusbankOne.printStatus();

        if (belarusbankOne.givingMoney(sumToGive1)) {
            belarusbankOne.printStatus();
        } else {
            System.out.println("Not enough money. Please visit next bankomat");
            belarusbankOne.setEnoughMoney(false);
        }

        if (belarusbankOne.isEnoughMoney() == false) {
            belarusbankOne.setMoney(10, 20, 40);
            belarusbankOne.setEnoughMoney(true);
            belarusbankOne.printStatus();
        }

        if (belarusbankOne.givingMoney(sumToGive2)) {
            belarusbankOne.printStatus();
        } else {
            System.out.println("Not enough money. Please visit next bankomat");
            belarusbankOne.setEnoughMoney(false);
        }

        if (belarusbankOne.isEnoughMoney() == false) {
            belarusbankOne.setMoney(10, 20, 40);
            belarusbankOne.setEnoughMoney(true);
            belarusbankOne.printStatus();
        }

        if (belarusbankOne.givingMoney(sumToGive3)) {
            belarusbankOne.printStatus();
        } else {
            System.out.println("Not enough money. Please visit next bankomat");
            belarusbankOne.setEnoughMoney(false);
        }

    }
}
