package basics.entity;

/*
* пропись периода времени
 */

public class RecipeTime {
    final private static String[] weeksArr = {" недель ", " неделя ", " недели "};
    final private static String[] daysArr = {" дней ", " день ", " дня "};
    final private static String[] hoursArr = {" часов ", " час ", " часа "};
    final private static String[] minutesArr = {" минут ", " минута ", " минуты "};
    final private static String[] secondsArr = {" секунд ", " секунда ", " секунды "};
    private static int lastNum;
    private static int preLastNum;

    /*
     * number - число недель, или дней, или часов, или минут, или секунд
     * periodType принимает значения: 1 - для недель, 2 - дней, 3 - часов, 4 - минут, 5 - секунд
     * в зависимости от последней и предпоследней цифры числа возвращается правильная пропись периода времени
     */
    public static String getPeriod(int number, int periodType) {

        lastNum = number % 10;
        preLastNum = (number / 10) % 10;
        String period;

        if ((preLastNum != 1) && (lastNum == 1)) {
            switch (periodType) {
                case 1:
                    period = weeksArr[1];
                    break;
                case 2:
                    period = daysArr[1];
                    break;
                case 3:
                    period = hoursArr[1];
                    break;
                case 4:
                    period = minutesArr[1];
                    break;
                default:
                    period = secondsArr[1];
                    break;
            }
        } else if ((preLastNum != 1) && (lastNum >= 2) && (lastNum <= 4)) {
            switch (periodType) {
                case 1:
                    period = weeksArr[2];
                    break;
                case 2:
                    period = daysArr[2];
                    break;
                case 3:
                    period = hoursArr[2];
                    break;
                case 4:
                    period = minutesArr[2];
                    break;
                default:
                    period = secondsArr[2];
                    break;
            }
        } else {
            switch (periodType) {
                case 1:
                    period = weeksArr[0];
                    break;
                case 2:
                    period = daysArr[0];
                    break;
                case 3:
                    period = hoursArr[0];
                    break;
                case 4:
                    period = minutesArr[0];
                    break;
                default:
                    period = secondsArr[0];
                    break;
            }
        }

        return period;
    }
}