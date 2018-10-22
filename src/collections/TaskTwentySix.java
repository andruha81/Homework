/*
* Задача по теме 5 - коллекции
 */
package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/*
* Задача 26
*  удаление неудовлетворительных оценок из списка
 */
public class TaskTwentySix {

    public static void main(String[] args) {
        List<Integer> marks = new ArrayList<>();
        Random rand = new Random();
        int markComp = 6; // неудовлетворительные оценки 6 и ниже

        /*
         * заполняем коллекцию случайными числами от 1 до 10
         */
        for (int i = 0; i < 20; i++) {
            marks.add(rand.nextInt(10) + 1);
        }

        System.out.println("All marks: " + marks);

        /*
         * удаляем все оценки ниже или равные markComp (6)
         */
        Iterator<Integer> iterator = marks.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() <= markComp) {
                iterator.remove();
            }
        }

        System.out.println("Good marks: " + marks);
    }
}
