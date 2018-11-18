/*
 * Задача 1 Потоки
 * моделирование касс в магазине
 */
package threads;

import threads.Entity.Cashbox;
import threads.Entity.Customer;
import threads.Entity.Food;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        Map<Cashbox, Integer> cashboxes = new HashMap<>();    // коллекция касс (key - касса, value - очередь)
        List<Food> food = new ArrayList<>();                 // коллекция продуктов доступных к покупке
        String[] names = {"Donald Trump", "Angela Merkel", "Teresa May",
                "Emanuel Makron", "Vladimir Putin", "Xi Jinping", "Alex Lukashenko"}; // имена для посетителей
        int customersCount = 10;      // Кол-во покупателей
        ExecutorService customers = Executors.newFixedThreadPool(customersCount);
        int cashboxCount = 3;   // кол-во касс
        Random random = new Random();

        /* Создаем cashboxCount касс */
        for (int i = 0; i < cashboxCount; i++) {
            cashboxes.put(new Cashbox(i + 1), 0);
        }

        /* Добавляем продукты: наименование и цена */
        food.add(new Food("Bread", BigDecimal.valueOf(1.12)));
        food.add(new Food("Milk", BigDecimal.valueOf(0.78)));
        food.add(new Food("Cheese", BigDecimal.valueOf(2.30)));
        food.add(new Food("Yogurt", BigDecimal.valueOf(1.53)));
        food.add(new Food("Sausages", BigDecimal.valueOf(7.61)));
        food.add(new Food("Beer", BigDecimal.valueOf(4.15)));
        food.add(new Food("Pepsi", BigDecimal.valueOf(1.79)));
        food.add(new Food("Sour cream", BigDecimal.valueOf(1.04)));
        food.add(new Food("Candies", BigDecimal.valueOf(4.50)));

        /* запускаем покупателей */
        for (int i = 0; i < customersCount; i++) {
            customers.execute(new Customer(names[random.nextInt(names.length)], food, cashboxes));
        }

    }
}
