/*
 * Andrei Khaustau
 *
 * Homework 1
 *
 * Task 3
 *
 * Will a circle cover a rectangle
 */

package khaustau.homework1;

public class TaskThird {

    public static void main(String[] args) {
        double a = 6;            // fisrt side of a rectangle
        double b = 8;            // second side of a rectangle
        double r = 5;            // radius of a circle
        double lehgthComp;       // length to compare with radius

        lehgthComp = Math.sqrt(Math.pow((a / 2), 2) + Math.pow((b / 2), 2));

        if (r >= lehgthComp) {
            System.out.println("Circle with radius " + r + " will cover the rectangle");
        } else {
            System.out.println("Circle with radius " + r + " won't cover the rectangle");
        }
    }
}
