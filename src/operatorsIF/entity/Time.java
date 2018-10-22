package operatorsIF.entity;

public class Time {
    private int hour;
    private int minute;
    private int hourToMinute;

    public int getHourToMinute() {
        return hourToMinute;
    }

    public Time (int hour, int minute) {
        this.hour = hour;
        this.minute = minute;

        if ((this.hour < 0) || (this.hour > 23)) {
            System.out.println("ОШИБКА!! Часы должны быть в диапазоне от 0 до 23");
        }

        if ((this.minute < 0) || (this.minute > 60)) {
            System.out.println("ОШИБКА!!! Минуты должны быть в диапазоне от 0 до 60");
        }
    }

    /*   Перевод часов в минуты  */
    public void hourTransf() {
        this.hourToMinute = (this.hour * 60) + this.minute;
    }
}
