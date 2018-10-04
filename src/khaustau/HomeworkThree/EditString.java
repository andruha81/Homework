package khaustau.HomeworkThree;

import java.util.Arrays;

public class EditString {

    /*
     * разбиваем строку на отдельные слова и переносим в массив
     * символ \W означает все не буквенные символы
     * знак + означает один и более символов
     * таким образом выделяются слова вокруг небуквенных симловлов, даже если их несколько
     */
    void lastLetters(String s) {
        String[] newStr = s.split("\\W+");

        for (String letterStr : newStr) {
            System.out.print(letterStr.charAt(letterStr.length() - 1));
        }
    }

    void countSymbols(String s, String checkStr, String printStr) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (checkStr.indexOf(s.charAt(i)) != -1) {
                count++;
            }
        }
        System.out.println("Number of " + printStr + " is " + count);
    }

    /*
     * символ . в регулярных выражениях означае люьой символ
     * поэтому для нахождения точек используем \.
      */
    void textBetween(String s) {
        String[] newStr = s.split("\\.",3);

        if (newStr.length < 3) {
            System.out.println("There is less than two dots in this string");
        } else {
            System.out.println(newStr[1].trim());
        }
    }
    /*
    * пример похожий на задание 1
     */
    void countWords(String s){
        String[] newStr = s.split("\\W+");

        System.out.println("Number of words in the text is "+newStr.length);
    }
}
