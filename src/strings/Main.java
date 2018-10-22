/*
 * Задачи по теме 3 - массивы и строки
 * подтема - строки
 */
package strings;

import strings.entity.EditString;

public class Main {

    public static void main(String[] args) {
        EditString es = new EditString();

        /*
        * Задача 18 подсчет знаков препинания
         */
        String str3 = "Here : is a lot of - punctuation marks! Can, you count??";
        String checkStr3 = ".?!,;:-\"()\\";
        String printStr3 = "punctuation marks";

        System.out.println("======== Task 18. Counting punctuation marks ========");
        System.out.println(str3);
        es.countSymbols(str3, checkStr3, printStr3);  // вызываем функцию подсчета символов

        /*
        * Задача 19 подсчет количества слов в тексте
         */
        String str5 = "Count words  in this text , carefully ";

        System.out.println("======== Task 20. Counting words ========");
        System.out.println(str5);
        es.countWords(str5);           // вызываем функцию подсчета слов в тексте

        /*
        * Задача 20 вывод текста, составленного из последних букв всех слов
         */
        String str1 = "Lets take this string! And print only last letters, of each word. ";

        System.out.println("======== Task 20 Printing last letters of words ========");
        System.out.println(str1);
        es.lastLetters(str1);                          // вызываем фунцию вывода последних букв слов текста
        System.out.println();

        /*
        * Задача не из тетради
        * подсчет кол-ва запятых
         */
        String str2 = "How many, commas,, are here,";
        String checkStr2 = ",";
        String printStr2 = "commas";

        System.out.println("======== Task. Counting commas ========");
        System.out.println(str2);
        es.countSymbols(str2, checkStr2, printStr2);  // вызываем функцию подсчета символов

        /*
         * Задача не из тетради
         * вывод текста между двумя первыми точками
         */
        String str4 = "Be attentive. Print text only between two dots. If you have them.";

        System.out.println("======== Task. Printing text between dots ========");
        System.out.println(str4);
        es.textBetween(str4);                         // вызываем функцию вывода текста между точек
    }
}
