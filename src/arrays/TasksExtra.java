/*
 * Задачи по теме 3 - массивы и строки
 * подтема - массивы
 */
package arrays;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;

public class TasksExtra {

    public static void main(String[] args) {
        Random random = new Random();

        /*
        * Задача 4.2
        * Нахождение наибольшего значения
         */
        int[] arrayTwo = new int[10];

        System.out.println("======== Задача 4.2 ========");

        for (int i = 0; i < arrayTwo.length; i++) {
            arrayTwo[i] = random.nextInt(21);
        }

        System.out.print("Max number in array " + Arrays.toString(arrayTwo) + " is : ");
        Arrays.sort(arrayTwo);
        System.out.print(arrayTwo[arrayTwo.length-1]);

        /*
        * Задача 4.3
        * подсчитать сумму всех цифр числа
         */
        int numberThree = 4820560;
        int printNumber = numberThree;
        int sum = 0;

        System.out.println("\n======== Задача 4.3 ========");

        while (numberThree != 0) {
            sum += numberThree % 10;
            numberThree = numberThree / 10;
        }
        System.out.println("Summary of numerals in number " + printNumber + " is " + sum);

        /*
        * Задача 4.4 и 4.5
        * Найти сумму всех числе до этого числа от 0
        * Найти факториал числа
         */
        BigInteger factorial = new BigInteger("1");
        int sumFour = 0;
        int numberFour = 14;

        System.out.println("======== Задачи 4.4 и 4.5 ========");

        for (int i = 1; i <= numberFour; i++) {
            sumFour += i;
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        System.out.println("Summary of numbers from 0 to " + numberFour + " is : " + sumFour);
        System.out.println("Factorial of number " + numberFour + " is : " + factorial);
    }
}
