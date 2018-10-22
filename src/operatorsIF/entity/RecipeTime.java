package operatorsIF.entity;

/*
* пропись периода времени
 */

public class RecipeTime {
    final private static String[] hoursArr = {" часов ", " час ", " часа "};
    final private static String[] minutesArr = {" минут ", " минуту ", " минуты "};
    private static int lastNum;
    private static int preLastNum;

    /*
     * number - число недель, или дней, или часов, или минут, или секунд
     * periodType принимает значения: 1 - для часов, 2 - минут
     * в зависимости от последней и предпоследней цифры числа возвращается правильная пропись периода времени
     */
    public static String getPeriod(int number, int periodType) {

        lastNum = number % 10;
        preLastNum = (number / 10) % 10;
        String period;

        if ((preLastNum != 1) && (lastNum == 1)) {
            switch (periodType) {
                case 1:
                    period = hoursArr[1];
                    break;
                default:
                    period = minutesArr[1];
            }
        } else if ((preLastNum != 1) && (lastNum >= 2) && (lastNum <= 4)) {
            switch (periodType) {
                case 1:
                    period = hoursArr[2];
                    break;
                default:
                    period = minutesArr[2];
            }
        } else {
            switch (periodType) {
                case 1:
                    period = hoursArr[0];
                    break;
                default:
                    period = minutesArr[0];
            }
        }

        return period;
    }
}