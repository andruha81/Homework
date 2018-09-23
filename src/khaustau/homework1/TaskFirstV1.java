/*
 * Andrei Khaustau
 *
 * Homework 1
 *
 * Task 1
 *
 * version 1
 *
 * Determination of arrival time of a student
 */

package khaustau.homework1;

public class TaskFirstV1 {

    public static void main (String[] args) {

        Time timeAr = new Time(9,20);
        Time timeExam = new Time(9, 30);

        timeAr.hourTransf();
        timeExam.hourTransf();

        if ((timeAr.hourToMinute <= timeExam.hourToMinute) &&
            (timeAr.hourToMinute >= (timeExam.hourToMinute - 30))) {
            System.out.println("A student arrived in time");
        } else if (timeAr.hourToMinute > timeExam.hourToMinute){
            System.out.println("A student arrived late");
        } else {
            System.out.println("A student arrived too early");
        }
    }
}
