package threads.Entity;

public class Cashbox {
    private int cashboxNumber;      // номер кассы
    private boolean busy = false;   // занятость кассы для расчета с покупателем

    public Cashbox(int cashboxNumber) {
        if (cashboxNumber <=0) {
            throw new IllegalArgumentException("cashbox number must start from 1");
        }
        this.cashboxNumber = cashboxNumber;
    }

    public int getCashboxNumber() {
        return cashboxNumber;
    }

    /*
     * Расчет за продукты. Если касса уже обслуживает кого-то,
     * то покупатель становится в ожидание.
     * Иначе покупатель занимает кассу
     */
    public synchronized void payment() {
        while (busy) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        busy = true;
    }

    /* Освобождение кассы для след. покупателя */
    public synchronized void newCustomer() {
        busy = false;
        notifyAll();
    }

    /* Переопделяем hashCode чтобы в HashMap кассы залетали по номерам */
    @Override
    public int hashCode() {
        return cashboxNumber;
    }
}
