/*
* Задачи по теме 3 - массивы и строки
* подтема - массивы
 */

package arrays;

import arrays.entity.EditArrays;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[10];
        Random random = new Random();

        for (int i = 0; i < array.length; i++){
            array[i] = random.nextInt(10) + 1;
        }

        System.out.println("Исходный массив : ");
        for (int ar : array) {
            System.out.print(ar + " ");
        }
        System.out.println();

        /*  Задача 14 */
        EditArrays.maxNumber(array);

        /* Задача 15 */
        EditArrays.sumEl(array);

        /* Задача 16 */
        EditArrays.ReverseAr(array);

        /* Задача не из тетради */
        EditArrays.sortEvenPoz(array);

    }
}
