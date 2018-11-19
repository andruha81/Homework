/*
 * Задачи по теме 2. Работа со строками
 */
package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        /*
         * Задача 2
         * поиск шестнадцатеричных чисел в строке
         */
        System.out.println("========== Задача 2 =============");

        /* В шаблон поиска добавлена проверка если 16-ричные числа идут подряд */
        String stringWithHexadecimalNumbers = "0x4548ad 0xdf54g 0Xr4887 0x4A5F00x56D";
        Pattern patternTaskTwo = Pattern.compile("0[xX]([1-9a-fA-F]|0(?![xX]))+");
        Matcher matcherTaskTwo = patternTaskTwo.matcher(stringWithHexadecimalNumbers);

        System.out.println("Original string: " + stringWithHexadecimalNumbers);
        System.out.print("Hexadecimal numbers in string: ");
        while (matcherTaskTwo.find()) {
            System.out.print(matcherTaskTwo.group() + ", ");
        }

        /*
         * Задача 3
         * поиск в строке тегов абзацев
         * в том числе тегов с параметрами
         * Заменить теги с параметрами на пустые
         */
        System.out.println("\n========== Задача 3 =============");

        String stringWithTags = "<p> text </p> with <p align=\"justify\"> paragraph tags </p>";  // строка с тегами параграфов
        System.out.println("Original string: " + stringWithTags);

        /* В начале находим все теги абзацев и выводим их */
        Pattern patternTaskThree = Pattern.compile("</?p(.*?)>");
        Matcher matcherTaskThree = patternTaskThree.matcher(stringWithTags);

        System.out.print("Paragraph tags in string: ");
        while (matcherTaskThree.find()) {
            System.out.print(matcherTaskThree.group() + " ");
        }

        /*  Заменяем в строке теги с параметрами на пустые и выводим ее */
        stringWithTags = stringWithTags.replaceAll("<p(.*?)>", "<p>");
        System.out.println("\nModified string: " + stringWithTags);
    }
}
