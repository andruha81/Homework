package khaustau.homeworkTwo;

import java.util.Random;

public class First {

    public static void main(String[] args) {
        int[] array = new int[10];
        Random random = new Random();
        int tmp;

        for (int i = 0; i < array.length; i++){
            array[i] = random.nextInt(10);
        }

        for (int ar : array) {
            System.out.print(ar + " ");
        }

        for (int i = (array.length - 2); i > 0; i -= 2) {
            for (int j = 0; j < i; j += 2) {
                if (array[j] > array[j + 2]) {
                    tmp = array[j];
                    array[j] = array[j + 2];
                    array[j + 2] = tmp;
                }
            }
        }

        System.out.println();

        for (int ar : array) {
            System.out.print(ar + " ");
        }
    }
}
