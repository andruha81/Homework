package classes.appliances.entity;

abstract class Appliances {
    private String name;      // наименование
    private boolean isOn;     // признак включения
    private String type;      // тип

    public Appliances(String type, String name) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    /* включение */
    public void turnOn() {
        this.isOn = true;
        System.out.println(this.type + " " + this.name + " turn on");
    }

    /* выключение */
    public void turnOf() {
        this.isOn = false;
        System.out.println(this.type + " " + this.name + " turn off");
    }
}
