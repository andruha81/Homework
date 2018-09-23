/*
 * Andrei Khaustau
 *
 * Homework 1
 *
 * Task 1
 *
 * version 1
 *
 * time management
 */

package khaustau.homework1;

public class Time {
    int hour;
    int minute;
    public int hourToMinute;

    public Time (int hour, int minute) {
        this.hour = hour;
        this.minute = minute;

        if ((this.hour < 0) || (this.hour > 23)) {
            System.out.println("ERROR!!! Hours must be in range from 0 to 23");
            System.exit(0);
        }

        if ((this.minute < 0) || (this.minute > 60)) {
            System.out.println("ERROR!!! Minutes must be in range from 0 to 60");
            System.exit(0);
        }
    }

    /*   Transferring hours to minutes  */
    public void hourTransf() {
        this.hourToMinute = (this.hour * 60) + this.minute;
    }
}
