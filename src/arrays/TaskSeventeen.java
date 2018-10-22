package arrays;

/*
* создать квадратный массив и заполнить его в виде "бабочки"
 */
public class TaskSeventeen {

    public static void main(String[] args) {
        int arraySize = 10;
        int[][] butterfly = new int[arraySize][arraySize];

        for (int i = 0; i < butterfly.length; i++) {
            for (int j = 0; j < butterfly[i].length; j++) {
                if ((j >= i) && (j < butterfly[i].length - i) ||
                        ((j >= butterfly[i].length - 1 - i) && (j <= i))) {
                    butterfly[i][j] = 1;
                } else {
                    butterfly[i][j] = 0;
                }
            }
        }

        for (int[] arrOne : butterfly) {
            for (int arrTwo : arrOne) {
                System.out.print(arrTwo);
            }
            System.out.println();
        }
    }
}
