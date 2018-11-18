package threads.Entity;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Customer implements Runnable {
    Random random = new Random();
    List<Food> food;                            // список доступных продуктов
    Map<Cashbox, Integer> cashboxes;            // список имеющихся  касс с кол-вом покупателей в очереди
    private BigDecimal sum = BigDecimal.ZERO;   // Итого по чеку покупателя
    private int foodNumber;                     // Кол-во продуктов в чеке покупателя
    private String customerName;                // Имя покупателя
    private Cashbox customerCashbox;            // Касса, которую выбрал покупаель
    private Food customerFood;                  // Один из выбранных продуктов
    private StringBuilder customerCheck = new StringBuilder();  // Чек

    public Customer(String customerName, List<Food> food, Map<Cashbox, Integer> cashboxes) {
        this.customerName = customerName;
        this.food = food;
        this.cashboxes = cashboxes;
    }

    @Override
    public void run() {

        /* Постепенное заполнение чека */
        customerCheck.append("Customer: " + customerName + "\n");
        customerCheck.append("---------------\n");

        /*
         * Каждому покупателю случ. образом набираем продукты от 1 до 5.
         * Продукты рандомом выбираются из списка доступных продуктов
         */
        foodNumber = (random.nextInt(5) + 1);
        for (int i = 1; i <= foodNumber; i++) {
            customerFood = food.get(random.nextInt(food.size()));
            customerCheck.append(customerFood.getFoodName() + ":   " + customerFood.getPrice() + "\n");
            sum = sum.add(customerFood.getPrice());
        }
        customerCheck.append("---------------\n");
        customerCheck.append("Total:   " + sum + "\n");

        /*
         * Поток "засыпает" на время (случ. для каждого покупателя)
         * необходимое для выбора продуктов
         */
        try {
            Thread.sleep(1000 * (random.nextInt(10) + 1));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /* Выбор кассы для расчета */
        chooseCashbox();

        customerCashbox.payment();

        /*
         * поток "засыпает" на время необходимое для оплаты
         * Время оплаты зависит от кол-во продуктов
         */
        try {
            Thread.sleep(1000 * foodNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        customerCheck.append("Cashbox: " + customerCashbox.getCashboxNumber());
        System.out.println(customerCheck);
        System.out.println("&&&&&&&&&&&&&&&\n");

        /* После оплаты покупатель покидает очередьб очередб уменьш. на 1 */
        delCustomerQueue();

        /* Освобождение кассы для след. покупателя */
        customerCashbox.newCustomer();
    }

    /*
     * Метод выбора кассы синронизируется по классу, чтобы только один поток
     * выбирал кассу одномоментно.
     */
    private void chooseCashbox() {
        synchronized (Customer.class) {
            /* Поиск кассы с минимальной очередью */
            customerCashbox = cashboxes.entrySet().stream().min(Comparator.comparingInt(Map.Entry::getValue)).map(Map.Entry::getKey).get();

            /* Добавление в очередь кассы новго покупателя */
            cashboxes.put(customerCashbox, cashboxes.get(customerCashbox) + 1);

            /* Проверял постановку в очередь */
//            System.out.println(customerName + " - TO cashbox " + customerCashbox.getCashboxNumber());
//            System.out.println(cashboxes.get(customerCashbox));
//            System.out.println("--------------------------");
        }
    }

    /* После оплаты покупатель покидает очередьб очередб уменьш. на 1 */
    private void delCustomerQueue() {
        synchronized (Customer.class) {
            cashboxes.put(customerCashbox, cashboxes.get(customerCashbox) - 1);

            /* Проверял выход из очереди */
//            System.out.println(customerName + " - FROM cashbox " + customerCashbox.getCashboxNumber());
//            System.out.println(cashboxes.get(customerCashbox));
//            System.out.println("--------------------------");
        }
    }
}
