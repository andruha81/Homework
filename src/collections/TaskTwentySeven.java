/*
 * Задача по теме 5 - коллекции
 */
package collections;

import java.util.*;

/*
 * Задача 27
 *  удаление повторяющихся чисел списка
 */
public class TaskTwentySeven {

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        Random random = new Random();

        /*
        * заполнение коллекции случаными числами от 0 до 20
         */
        for (int i = 0; i < 20; i++) {
            nums.add(random.nextInt(21));
        }

        System.out.println(nums);

        /*
        * создание множества numset на основании коллекции nums
        * в результате чего автоматически уберутся повторяющиеся элементы
         */
        Set<Integer> numsSet = new TreeSet<>(nums);

        System.out.println(numsSet);
    }
}
