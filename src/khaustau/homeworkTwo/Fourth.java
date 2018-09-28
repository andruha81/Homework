package khaustau.homeworkTwo;

public class Fourth {

    public static void main(String[] args) {
        int number = 12;
        int sum = 0;
        int mult = 1;

        for (int i = 0; i <= number; i++) {
            sum += i;
            if (i != 0) {
                mult *= i;
            }
        }

        System.out.println("Summary of numbers from 0 to " + number + " is " + sum);
        System.out.println("Factorial of number " + number + " is " + mult);
    }
}
