package locale;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main {

    public static void main(String[] args) {

        /*
         * Задача 4
         * Вывести чило 153.5 в денежном виде для Украины
         */
        System.out.println("========== Задача 4 =============");

        double sumUkr = 153.5;                                      // Число в денежном виде
        Locale locUkr = new Locale("uk", "UA");
        NumberFormat nfUkr = NumberFormat.getCurrencyInstance(locUkr);

        System.out.println(nfUkr.format(sumUkr));

        /*
         * Задача 5
         * Приветствие пользователя на языках: английском, русском, белорусском
         */
        System.out.println("========== Задача 5 =============");

        ResourceBundle rb = ResourceBundle.getBundle("MessagesBundle");
        System.out.println(rb.getString("greetings"));
    }
}
