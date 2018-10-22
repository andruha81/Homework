/*
* Задачи по теме 2 - операторы управления
* подтема - условное выполнение
 */
package operatorsIF;

import operatorsIF.entity.RecipeTime;
import operatorsIF.entity.Time;
import operatorsIF.entity.NumDate;

public class Main {

    public static void main (String[] args) {

        /*
        * Задача 3
        * определение является ли  последняя цифра в чиле 7
        * отдельно определяется последняя цифра в числах типа int и double
         */
        double number = 1249.1547;           // число типа double
        int intNumber = 5675;                // число типа int
        int lastNum = 7;                     // цифра для нахождения
        char charNum = Character.forDigit(lastNum, 10);
        String stringNum = Double.toString(number);  // переводим число в строку

        System.out.println("======= Задача 3 =======");

        /*  нахождение последней цифры в числе типа int */
        if ((Math.abs(intNumber) % 10) == lastNum) {
            System.out.println("Последней цифрой числа " + intNumber + " является " + lastNum);
        } else {
            System.out.println("Последней цифрой числа " + intNumber + " не является " + lastNum);
        }

        /*  нахождение последней цифры в числе типа double */
        if (stringNum.charAt(stringNum.length() - 1) == charNum) {
            System.out.println("Последней цифрой числа " + number + " является " + lastNum);
        } else {
            System.out.println("Последней цифрой числа " + number + " не является " + lastNum);
        }

        /*
        * Задача 4
        * определение закроет ли круг с радиусом r отверстие со сторонами a и b
         */
        double a = 6;            // первая сторона прямоугольника
        double b = 8;            // втроая сторона прямоугольника
        double r = 5;            // радиус круга
        double lehgthComp = Math.sqrt(Math.pow((a / 2), 2) + Math.pow((b / 2), 2));

        System.out.println("======= Задача 4 =======");

        /* сравниваем радиус с расстоянием от центра до угла прямоугольника по теореме пифагора*/
        if (r >= lehgthComp) {
            System.out.println("Круг с радиусом " + r + " закроет прямоугольник " + a + "*" + b);
        } else {
            System.out.println("Круг с радиусом " + r + " не закроет прямоугольник" + a + "*" + b);
        }

        /*
         * Задача 5
         * Вывод числа со словом "рублей" в нужном падеже
         * проверяется последняя и предпоследняя цифра для вывода нужного падежа
         */
        int sum = 4502;
        int lastNumTaskFive = sum % 10;
        int prelastNum = (sum / 10) % 10;
        String rubl;

        System.out.println("======= Задача 5 =======");

        if ((lastNumTaskFive == 1) && (prelastNum != 1)) {
            rubl = " рубль";
        } else if ((lastNumTaskFive >= 2) && (lastNumTaskFive <= 4) && (prelastNum != 1)) {
            rubl = " рубля";
        } else {
            rubl = " рублей";
        }

        System.out.println("Сумма : " + sum + rubl);

        /*
         * Задача 6
         * имеются три чила - день, месяц, год
         * вывести в виде трех чисел дату следующего дня
         */
        System.out.println("======= Задача 6 =======");

        NumDate numDate = new NumDate(2018,12,31);

        System.out.println("Дата: год " + numDate.getYear() + ", месяц " + numDate.getMonth() + ", день " + numDate.getDay());

        numDate.addDay();

        System.out.println("Следующий день: год " + numDate.getYear() + ", месяц " + numDate.getMonth() + ", день " + numDate.getDay());

        /*
         * Задача 7
         * Вместятся ли 2 дома с размерами k*l и m*n на участке e*f
         */
        int widthOne = 8;   // ширина 1-го дома
        int lengthOne = 10;  // длина 1-го дома
        int widthTwo = 5;   // ширина 2-го дома
        int lengthTwo = 30;   // длина 2-го дома
        int widthArea = 20;  // ширина участка
        int lengthArea = 30;  // длина участка

        System.out.println("======= Задача 7 =======");
        System.out.println("Первый дом " + widthOne + "*" + lengthOne);
        System.out.println("Второй дом " + widthTwo + "*" + lengthTwo);
        System.out.println("Участок " + widthArea + "*" + lengthArea);

        /* проверяется условие, чтобы размеры каждого дома не были больше одного из размеров участка */
        if ((widthOne <= widthArea) && (widthTwo <= widthArea) && (lengthOne <= lengthArea) && (lengthTwo <= lengthArea)) {

            /* проверяется условие чтобы дома входили или в длину, или в ширину */
            if ((widthOne + widthTwo <= widthArea) || (lengthOne + lengthTwo <= lengthArea)) {
                System.out.println("Два дома поместятся на участке");
            } else {
                System.out.println("Два дома НЕ поместятся на участке");
            }
        } else {
            System.out.println("Два дома НЕ поместятся на участке");
        }

        /*
        * Задача не из тетради
        * Есть время экзамена. Студент пришел вовремя если он пришел за полчаса до экзамена
        * или вовремя. Если он пришел более чем на 30 минут раньше, он пришел зарано.
        * Если он пришел после начала экзамена, он опоздал.
        * Если студент пришел зарано или опоздал определить насколько
         */
        Time timeAr = new Time(7,30);
        Time timeExam = new Time(9, 30);
        int timeDif;
        String printDif;

        System.out.println("======= Задача не из тетради =======");

        timeAr.hourTransf();
        timeExam.hourTransf();

        if ((timeAr.getHourToMinute() <= timeExam.getHourToMinute()) &&
                (timeAr.getHourToMinute() >= (timeExam.getHourToMinute() - 30))) {
            System.out.println("Студент пришел вовремя");
        } else if (timeAr.getHourToMinute() > timeExam.getHourToMinute()){
            timeDif = timeAr.getHourToMinute() - timeExam.getHourToMinute();
            printDif = ((timeDif / 60 != 0) ? (timeDif / 60 + RecipeTime.getPeriod(timeDif / 60, 1)) : "")
                    + ((timeDif % 60 != 0) ? (timeDif % 60 + RecipeTime.getPeriod(timeDif % 60, 2)) : "");

            System.out.println("Студент опоздал на " + printDif);
        } else {
            timeDif = timeExam.getHourToMinute() - timeAr.getHourToMinute();
            printDif = ((timeDif / 60 != 0) ? (timeDif / 60 + RecipeTime.getPeriod(timeDif / 60, 1)) : "")
                    + ((timeDif % 60 != 0) ? (timeDif % 60 + RecipeTime.getPeriod(timeDif % 60, 2)) : "");

            System.out.println("Студент пришел зарано на " + printDif);
        }
    }
}
