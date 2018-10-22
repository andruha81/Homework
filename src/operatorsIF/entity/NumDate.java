package operatorsIF.entity;

public class NumDate {
    private int year;
    private int month;
    private int day;

    public NumDate(int year, int month, int day) {
        if (year < 0) {
            System.out.println("ОШИБКА!!! Год может быть только положительным");
        }

        if ((month <= 0) || (month > 12)) {
            System.out.println("ОШИБКА!!! Месяц может быть в диапазоне от 1 до 12");
        }

        if (day <= 0) {
            System.out.println("ОШИБКА!!! День не может быть меньше 1");
        }

        if (((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10) || (month == 12)) &&
                (day > 31)) {
            System.out.println("ОШИБКА!!! день в месяце " + month + " не может быть больше 31");
        } else if (((month == 4) || (month == 6) || (month == 9) || (month == 11)) &&
                (day > 30)) {
            System.out.println("ОШИБКА!!! день в месяце " + month + " не может быть больше 30");
        } else if (month == 2) {
            if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
                if (day > 29) {
                    System.out.println("ОШИБКА!!! день в месяце " + month + " не может быть больше 29");
                }
            } else if (day > 28) {
                System.out.println("ОШИБКА!!! день в месяце " + month + " не может быть больше 28");
            }
        }

        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void addDay() {
        day++;

        /*
        * проверка на переход дней на другой месяц
        * в случае второго месяца дополнительно проверяется высокосный год
         */
        if (((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10) || (month == 12)) &&
                (day > 31)) {
            addMonth();
        } else if (((month == 4) || (month == 6) || (month == 9) || (month == 11)) &&
                (day > 30)) {
            addMonth();
        } else if (month == 2) {
            if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
                if (day > 29) {
                    addMonth();
                }
            } else if (day > 28) {
                addMonth();
            }
        }
    }

    /*
    * проверка перехода месяца на другой год
     */
    private void addMonth() {
        day = 1;
        month++;
        if (month > 12) {
            month = 1;
            year++;
        }
    }
}
