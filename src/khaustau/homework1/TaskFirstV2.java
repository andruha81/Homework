/*
 * Andrei Khaustau
 *
 * Homework 1
 *
 * Task 1
 *
 * version 2
 *
 * Determination of arrival time of a student
 */

package khaustau.homework1;

public class TaskFirstV2 {

    public static void main(String[] args){
        int hourAr = 9;        // at what hour arrived for the exam
        int minAr = 40;         // at what minute arrived for the exam
        int hourExam = 9;       // hour of the exam
        int minExam = 30;       // minute of the exam
        int hourToMinAr;        // transfer of hours in minutes of arrival time
        int hourToMinExam;        // transfer of hours in minutes of exam time

        hourToMinAr = (hourAr * 60) + minAr;
        hourToMinExam = (hourExam * 60) + minExam;

        if ((hourToMinAr <= hourToMinExam) && (hourToMinAr >= (hourToMinExam - 30))) {
            System.out.println("A student arrived in time");
        } else if (hourToMinAr > hourToMinExam){
            System.out.println("A student arrived late");
        } else {
            System.out.println("A student arrived too early");
        }

    }
}
