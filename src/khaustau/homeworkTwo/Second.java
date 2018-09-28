package khaustau.homeworkTwo;

import java.util.Random;

public class Second {

    public static void main(String[] args) {
        int[] array = new int[10];
        Random random = new Random();
        int maxNum;

        for (int i = 0; i < array.length; i++){
            array[i] = random.nextInt(20);
        }

        for (int ar : array) {
            System.out.print(ar + " ");
        }

        maxNum = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] > maxNum) {
                maxNum = array[i];
            }
        }

        System.out.println();
        System.out.println("Max number in array is " + maxNum);
    }
}
