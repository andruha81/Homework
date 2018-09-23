/*
 * Andrei Khaustau
 *
 * Homework 1
 *
 * Task 2
 *
 * detecting the last numeral of a number
 */

package khaustau.homework1;

public class TaskSecond {

    public static void main(String[] args) {
        double number = 1249.1547;           // number
        int lastNum = 7;                // numeral to compare
        int fracNumber;                 // the fractional part of the number
        String stringNum, frac;         // strings to get the fractional part of number

        stringNum = "" + number;
        frac = stringNum.substring((stringNum.indexOf(".") + 1));
        fracNumber = Integer.valueOf(frac);

        if (fracNumber == 0) {
            if ((number % 10) == lastNum) {
                System.out.println("The lust numeral of the number is " + lastNum);
            } else {
                System.out.println("The lust numeral of the number isn't " + lastNum);
            }
        } else {
            if ((fracNumber % 10) == lastNum) {
                System.out.println("The lust numeral of the number is " + lastNum);
            } else {
                System.out.println("The lust numeral of the number isn't " + lastNum);
            }
        }
    }
}
