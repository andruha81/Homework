package arrays.entity;

public class EditArrays {

    /*
    * Задача 14
    * вывод номера максимальной оценки
     */
    public static void maxNumber(int[] myArray) {
        int maxNum = myArray[0];
        int maxPoz = 0;

        for (int i = 0; i < myArray.length; i++) {
            if (myArray[i] > maxNum) {
                maxNum = myArray[i];
                maxPoz = i;
            }
        }

        System.out.println("======== Задача 14 ========");
        System.out.println("Максимальная оценка " + maxNum + " находится под номером " + maxPoz);
    }

    /*
    * Задача 15
    * определение суммы элементов массива, расположенных
    * между мин. и макс. значениями
     */
    public static void sumEl(int[] myArray) {
        int maxNum = myArray[0];
        int maxPoz = 0;
        int minNum = myArray[0];
        int minPoz = 0;
        int startPoz, endPoz;
        int sum = 0;

        for (int i = 0; i < myArray.length; i++) {
            if (myArray[i] > maxNum) {
                maxNum = myArray[i];
                maxPoz = i;
            } else if (myArray[i] < minNum) {
                minNum = myArray[i];
                minPoz = i;
            }
        }

        startPoz = Math.min(maxPoz, minPoz) + 1;
        endPoz = Math.max(maxPoz, minPoz);

        for (int i = startPoz; i < endPoz; i++) {
            sum += myArray[i];
        }

        System.out.println("======== Задача 15 ========");
        System.out.println("Сумма элементов между макс. и мин. значениями " + sum);
    }

    /*
    * Задача 16
    * переворот массива
     */
    public static void ReverseAr(int[] myArray) {
        int tmp;

        System.out.println("======== Задача 16 ========");

        for (int i = 0; i < Math.ceil(myArray.length / 2); i++) {
            tmp = myArray[i];
            myArray[i] = myArray[myArray.length - i - 1];
            myArray[myArray.length - i - 1] = tmp;
        }

        System.out.print("Перевернутый массив : ");
        for (int arr : myArray) {
            System.out.print(arr + " ");
        }
        System.out.println();
    }

    /*
    * Задача не из тетради
    * сортировка элементов массива по возрастанию, находящихся на четной позиции
     */
    public static void sortEvenPoz(int[] myArray) {
        int tmp;

        for (int i = (myArray.length - 2); i > 0; i -= 2) {
            for (int j = 0; j < i; j += 2) {
                if (myArray[j] > myArray[j + 2]) {
                    tmp = myArray[j];
                    myArray[j] = myArray[j + 2];
                    myArray[j + 2] = tmp;
                }
            }
        }

        System.out.println("======== Задача не из тетради ========");

        for (int ar : myArray) {
            System.out.print(ar + " ");
        }
    }
}
