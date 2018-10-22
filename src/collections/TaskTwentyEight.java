/*
 * Задача по теме 5 - коллекции
 */
package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/*
 * Задача 28
 *  поиск наивысшей оценки
 */
public class TaskTwentyEight {

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        Random random = new Random();
        int highestMark = 0;
        int mark;

        /*
         * заполняем коллекцию случайными числами от 1 до 10
         */
        for (int i = 0; i < 20; i++) {
            nums.add(random.nextInt(10) + 1);
        }

        System.out.println(nums);

        /*
        * проходим с помощью итератора коллекцию и находим
        * наивысшую оценку
         */
        Iterator<Integer> iterator = nums.iterator();
        while (iterator.hasNext()) {
            mark = iterator.next();
            if (mark > highestMark) {
                highestMark = mark;
            }
        }

        System.out.println("The highest mark is "+highestMark);
    }
}
