package classes.appliances.entity;

public class Fridge extends Appliances implements Working {
    private int shelvesNumber;    // кол-во полок
    private int freezeShelves;    // полки морозильника
    private int capacity;         // объем в л.
    private String energyClass;   // класс энерго эффект.

    public Fridge(String name, int shelvesNumber, int freezeShelves, int capacity, String energyClass) {
        super("Fridge", name);
        this.shelvesNumber = shelvesNumber;
        this.freezeShelves = freezeShelves;
        this.capacity = capacity;
        this.energyClass = energyClass;
    }

    /* выполнение функций */
    @Override
    public void work() {
        System.out.println("I'm freezing food");
    }

    /* получение спецификации */
    @Override
    public void getSpec() {
        System.out.println(super.getType() + " " + super.getName());
        System.out.println("Number of shelves : " + this.shelvesNumber +
                ", including freeze shelves : " + this.freezeShelves);
        System.out.println("Capacity : " + this.capacity + "l., energy class : " + this.energyClass);
    }
}
