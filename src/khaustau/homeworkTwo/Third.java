package khaustau.homeworkTwo;

public class Third {

    public static void main(String[] args) {
        int number = 482056;
        int checkNumber = number;
        int sum = 0;

        while (number != 0) {
            sum += number % 10;
            number = number / 10;
        }

        System.out.println("Summary of numerals in number " + checkNumber + " is " + sum);
    }
}
