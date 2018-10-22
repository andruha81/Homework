/*
* тема 4 - классы и объекты
* Задача 22
* задание промежутка времени с тремя свойствами - часы, минуты, секунды
 */
package classes.time;

import classes.time.entity.TimeUnits;

public class Main {

    public static void main(String[] args) {
        TimeUnits timeGapOne = new TimeUnits(2, 20, 24);
        TimeUnits timeGapTwo = new TimeUnits(9461);

        System.out.print("Time gap one : ");
        timeGapOne.printTimeGap();
        System.out.println("Time gap one in seconds : " + timeGapOne.getFullSeconds());

        System.out.print("Time gap two : ");
        timeGapTwo.printTimeGap();
        System.out.println("Time gap two in seconds : " + timeGapTwo.getFullSeconds());

        if (timeGapOne.compareTo(timeGapTwo) == 1) {
            System.out.println("Time gap one is bigger than time gap two");
        } else if (timeGapOne.compareTo(timeGapTwo) == -1) {
            System.out.println("Time gap two is bigger than time gap one");
        } else {
            System.out.println("time gaps are equal");
        }
    }


}
