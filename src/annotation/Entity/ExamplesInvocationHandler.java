package annotation.Entity;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/*
 * Создаем класс, который реализует интерфейс InvocationHandler
 * Данный класс обрабатывает все вызовы методов прокси объекта, который связан с данным классом
 */
public class ExamplesInvocationHandler implements InvocationHandler {

    private ConcatStringAndStringBuilder concat;

    public ExamplesInvocationHandler(ConcatStringAndStringBuilder concat) {
        this.concat = concat;
    }

    /*
     * Переопределяем метод invoke, который обрабатывает вызовы методов прокси объекта
     * proxy - проски объект, для которого вызываем метод;
     * method - вызываемый методж
     * args - параметры метода.
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start;  // Время начала выполнения метода
        long end;    // Время окончания выполнения метода

        /*
         * Проверям есть ли на методе аннтотация Clocking
         * Если ее нет, то выполняем метод без замера времени
         */
        if (!method.isAnnotationPresent(Clocking.class)) {
            return method.invoke(concat, args);
        }

        start = System.currentTimeMillis();                     // Вычисляем время начала выполнения метода
        Object returnObj = method.invoke(concat, args);         // Вызываем сам метод и получаем значение, которое возвращает метод. В случае void - null
        end = System.currentTimeMillis();                       // Вычисляем время окончания выполнения метода

        /* Выводим время выполнения метода  */
        System.out.println("Method " + method.getName() + " is executed " + (end - start) + " milliseconds");

        return returnObj;
    }
}