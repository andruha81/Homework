/*
 * Andrei Khaustau
 *
 * Homework 1
 *
 * Task 2
 *
 * detecting the last numeral of a number
 */

package khaustau.homeworkOne;

public class TaskSecond {

    public static void main(String[] args) {
        double number = 1249.1547;           // number type double
        int intNumber = 5675;                 // number type int
        int lastNum = 7;                     // numeral to compare
        char charNum = Character.forDigit(lastNum, 10);
        String stringNum = Double.toString(number);

        /*  finding last numeral in the number type int */
        if ((Math.abs(intNumber) % 10) == lastNum) {
            System.out.println("The lust numeral of " + intNumber + " is " + lastNum);
        } else {
            System.out.println("The lust numeral of " + intNumber + " isn't " + lastNum);
        }

        /*  finding last numeral in the number type double */
        if (stringNum.charAt(stringNum.length() - 1) == charNum) {
            System.out.println("The lust numeral of " + number + " is " + lastNum);
        } else {
            System.out.println("The lust numeral of " + number + " isn't " + lastNum);
        }
    }
}
