package classes.time.entity;

public class TimeUnits {
    private int hours;
    private int minutes;
    private int seconds;

    public TimeUnits(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    /* перевод секунд - в часы, минуты, секунды  */
    public TimeUnits(int fullSeconds) {
        this.seconds = fullSeconds % 60;
        fullSeconds = fullSeconds / 60;
        this.minutes = fullSeconds % 60;
        this.hours = fullSeconds / 60;
    }

    /* получение промежутка времени в секундах*/
    public int getFullSeconds() {
        return (this.hours * 60 * 60 + this.minutes * 60 + this.seconds);
    }

    /*
    * Сравнение двух промежутков времени
    * return 1 если этот промежуток времени больше другого
    * return -1 если этот промежуток времени меньше другого
    * return 0 если этот промежутки времени равны
     */
    public int compareTo(TimeUnits anotherTimeGap) {
        if (this.getFullSeconds() > anotherTimeGap.getFullSeconds()) {
            return 1;
        } else if (this.getFullSeconds() < anotherTimeGap.getFullSeconds()) {
            return -1;
        } else {
            return 0;
        }
    }

    /* вывод промежутка времени */
    public void printTimeGap() {
        System.out.print((this.hours != 0 ? (this.hours + " hours ") : "") +
                (this.minutes != 0 ? (this.minutes + " minutes ") : "") +
                this.seconds + " seconds");
        System.out.println();
    }
}
