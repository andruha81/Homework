/*
* задачи по теме 1 - Основы
 */
package basics;

import basics.entity.RecipeTime;

public class Main {

    public static void main(String[] args) {

        /*
        * Задача 1
        * вывод сообщения Hello World
        */
        System.out.println("======= Задача 1 =======");
        System.out.println("Hello World!");

        /*
        * Задача 2
        * Вывод промежутка времени в секундах в виде недель, дней, чсаов, минут, секунд
         */
        int s = 5955581;        //период в секундах
        int seconds;
        int minutes;
        int hours;
        int days;
        int weeks;
        int m, h, d;

        System.out.println("======= Задача 2 =======");

        seconds = s % 60;
        m = s / 60;
        minutes = m % 60;
        h = m / 60;
        hours = h % 24;
        d = h / 24;
        days = d % 7;
        weeks = d / 7;

        System.out.println((weeks != 0 ? (weeks + RecipeTime.getPeriod(weeks, 1)) : "")
                            + (days != 0 ? (days + RecipeTime.getPeriod(days, 2)) : "")
                            + (hours != 0 ? (hours + RecipeTime.getPeriod(hours, 3)) : "")
                            + (minutes != 0 ? (minutes + RecipeTime.getPeriod(minutes, 4)) : "")
                            + (seconds != 0 ? (seconds + RecipeTime.getPeriod(seconds, 5)) : ""));
    }
}