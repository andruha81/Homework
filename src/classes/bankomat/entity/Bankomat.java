package classes.bankomat.entity;

public class Bankomat {
    private int numberTwenty;
    private int numberFifty;
    private int numberHundreed;
    private boolean enoughMoney;

    public Bankomat(int numberTwenty, int numberFifty, int numberHundreed) {
        this.numberTwenty = numberTwenty;
        this.numberFifty = numberFifty;
        this.numberHundreed = numberHundreed;
        this.enoughMoney = true;
    }

    /* добавление денег в банкомат */
    public void setMoney(int numberTwenty, int numberFifty, int numberHundreed) {
        this.numberTwenty = numberTwenty;
        this.numberFifty = numberFifty;
        this.numberHundreed = numberHundreed;
    }

    public boolean isEnoughMoney() {
        return enoughMoney;
    }

    public void setEnoughMoney(boolean enoughMoney) {
        this.enoughMoney = enoughMoney;
    }

    /* вывод количества банкнот в банкомате */
    public void printStatus() {
        System.out.println("STATUS: Hundreeds - " + this.numberHundreed +
                ", Fifties - " + this.numberFifty +
                ", Twenties - " + this.numberTwenty);
    }

    /* выдача денег  */
    public boolean givingMoney(int sum) {
        int giveHundreed = 0;
        int giveFifty = 0;
        int giveTwenty = 0;
        int printSum = sum;

        /*
        * Проверяем запрошенная сумма != 0
         */
        if (sum == 0){
            return false;
        }

        /*
        * Сначала выдаем сотнями, если получится
         */
        giveHundreed = sum / 100;
        giveHundreed = Math.min(giveHundreed, this.numberHundreed);
        sum -= giveHundreed * 100;

        if (sum == 0) {
            this.numberHundreed -= giveHundreed;
            System.out.println("Giving money " + printSum + " : " + giveHundreed);
            return true;
        }

        /*
        * потом выдаеи 50
        */
        giveFifty = sum / 50;
        giveFifty = Math.min(giveFifty, this.numberFifty);
        sum -= giveFifty * 50;

        if (sum == 0) {
            this.numberHundreed -= giveHundreed;
            this.numberFifty -= giveFifty;
            System.out.println("Giving money " + printSum + " : " +
                    ((giveHundreed != 0) ? ("Hundreeds - " + giveHundreed) : "") +
                    " Fifties - " + giveFifty);
            return true;
        }

        /*
        * в конце выдаем 20
         */
        giveTwenty = sum / 20;
        giveTwenty = Math.min(giveTwenty, this.numberTwenty);
        sum -= giveTwenty * 20;

        if (sum == 0) {
            this.numberHundreed -= giveHundreed;
            this.numberFifty -= giveFifty;
            this.numberTwenty -= giveTwenty;
            System.out.println("Giving money " + printSum + " : " +
                    ((giveHundreed != 0) ? ("Hundreeds - " + giveHundreed) : "") +
                    ((giveFifty != 0) ? (" Fifties - " + giveFifty) : "") +
                    " Twenties - " + giveTwenty);
            return true;
        } else {
            return false;
        }
    }
}
