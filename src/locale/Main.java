package locale;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        /*
         * Задача 4
         * Вывести чило 153.5 в денежном виде для Украины
         */
        System.out.println("========== Задача 4 =============");

        BigDecimal sumUkr = new BigDecimal(153.5);             // Число для вывода в денежном виде
        Locale locUkr = new Locale("uk", "UA");
        NumberFormat nfUkr = NumberFormat.getCurrencyInstance(locUkr);

        System.out.println(nfUkr.format(sumUkr));

        /*
         * Задача 5
         * Приветствие пользователя на языках: английском, русском, белорусском
         */
        System.out.println("========== Задача 5 =============");

        Scanner scanner = new Scanner(System.in);
        Locale loc;

        System.out.println("Choose language for greeting please");
        System.out.println("For Eglish enter - 1, Russian - 2, Belarusian - 3");

        /*
         * Считываем сканером значение для выбора языка.
         * Если такого значения нет, выбираем английский язык
         */
        switch (scanner.nextLine()) {
            case "1":
                loc = new Locale("en", "GB");
                break;

            case "2":
                loc = new Locale("ru", "Ru");
                break;

            case "3":
                loc = new Locale("be", "BY");
                break;

            default:
                loc = new Locale("en", "GB");
        }

        ResourceBundle rb = ResourceBundle.getBundle("MessagesBundle", loc);
        System.out.println(rb.getString("greetings"));
    }
}
