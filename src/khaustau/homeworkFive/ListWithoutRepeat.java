package khaustau.homeworkFive;

import java.util.*;

public class ListWithoutRepeat {

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
