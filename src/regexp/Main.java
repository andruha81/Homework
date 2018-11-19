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

        System.out.print("Hexadecimal numbers: ");
        while (matcherTaskTwo.find()) {
            System.out.print(matcherTaskTwo.group() + ", ");
        }

        /*
         * Задача 2
         * поиск в строке тегов абзацев
         * если тег с параметрами, заменить его на пустой
         */
        System.out.println("\n========== Задача 3 =============");

        String stringWithTags = "<p dfdf> <p>";
        Pattern patternTaskThree = Pattern.compile("<p(.*?)>");
        Matcher matcherTaskThree = patternTaskThree.matcher(stringWithTags);

        while (matcherTaskThree.find()) {
            System.out.println(matcherTaskThree.group());
            if (!matcherTaskThree.group(1).isEmpty()) {

            }
        }
    }
}
