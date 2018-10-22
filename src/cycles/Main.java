/*
* задачи по теме 2 - операторы управления программой
* подтема - циклы
 */
package cycles;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        /*
        * Задача 8
        * рассчитать факториал числа
         */
        int factorial = 1;
        int numFact = 11;  // число, для которого надо рассчитать факториал
        int i = 1;

        System.out.println("======= Задача 8 =======");

        while (i <= numFact) {
            factorial *= i++;
        }

        System.out.println("Факториал числа " + numFact + " равен " + factorial);

        /*
        * Задача 9
        * найти наибольшее число случайной последовательности чисел
         */
        int maxRand = 0;
        int quantityNums = 20;  // кол-во случайных чисел
        int numRand;
        int j = 1;
        Random random = new Random();

        System.out.println("======= Задача 9 =======");

        while (j <= quantityNums) {
            numRand = random.nextInt(101);
            maxRand = Math.max(maxRand, numRand);
            j++;
            System.out.print(numRand + " ");
        }

        System.out.println("\nНаибольшее число случайной последовательности чисел : " + maxRand);

        /*
        * Задача 10
        * посчитать сумму цифр числа
         */
        int numTaskTen = 445457;
        int numTaskPrint = numTaskTen;
        int sumNums = 0;

        System.out.println("======= Задача 10 =======");

        while (numTaskTen != 0) {
            sumNums += numTaskTen % 10;
            numTaskTen /= 10;
        }

        System.out.println("Сумма цифр числа " + numTaskPrint + " составит " + sumNums);

        /*
        * Задача 11
        * Оперделить является ли число простым
         */
        int numTaskElevan = 137;
        boolean isSimple = true;

        System.out.println("======= Задача 11 =======");

        for (int ind = 2; ind < numTaskElevan; ind++) {
            if (numTaskElevan % ind == 0) {
                isSimple = false;
                break;
            }
        }

        if (isSimple == true) {
            System.out.println("Число " + numTaskElevan + " является простым");
        } else {
            System.out.println("Число " + numTaskElevan + " не является простым");
        }

        /*
        * задача 12
        *  вывести число в бухгалтерском формате с пробелами
         */
        long numTaskTwelve = 4971485L;
        long printTaskTwelve = numTaskTwelve;
        String buhSum = "";

        System.out.println("======= Задача 12 =======");

        for (int x = 1; numTaskTwelve != 0; x++) {
            buhSum = (numTaskTwelve % 10) + buhSum;
            numTaskTwelve = numTaskTwelve / 10;
            if ((x % 3 == 0) && (numTaskTwelve != 0)) {
                buhSum = " " + buhSum;
            }
        }

        System.out.println("Число " + printTaskTwelve + " в бух. формате выводится так " + buhSum);

        /*
        * Задача 13
        * вывод простых чисел
         */
        int quantityNum = 100;  // кол-во чисел от 1, среди которых будем искать простые

        System.out.println("======= Задача 13 =======");
        System.out.print("Список простых чисел до " + quantityNum + " : ");

        LOOP: for (int x = 1; x <= quantityNum; x++) {
            for (int y = 2; y < x; y++) {
                if (x % y == 0) {
                    continue LOOP;
                }
            }
            System.out.print(x + " ");
        }
    }
}
