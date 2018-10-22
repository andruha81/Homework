package classes.appliances.entity;

public class WashingMachine extends Appliances implements Working {
    private String load;         // тип зигурзки
    private int programNumber;   // кол-во программ
    private int spinSpeed;       // скорость отжима
    private int capacity;        // загрузка кг.

    public WashingMachine(String name, String load, int programNumber, int spinSpeed, int capacity) {
        super("Washing machine", name);
        this.load = load;
        this.programNumber = programNumber;
        this.spinSpeed = spinSpeed;
        this.capacity = capacity;
    }

    /* выполнение функций */
    @Override
    public void work() {
        System.out.println("I'm washing clothes");
    }

    /* получение спецификации */
    @Override
    public void getSpec() {
        System.out.println(super.getType() + " " + super.getName());
        System.out.println("Load : " + this.load + ", number of programs : " + this.programNumber);
        System.out.println("Spin speed : " + this.spinSpeed + "RPM, capacity : " + this.capacity + "kilos");
    }
}