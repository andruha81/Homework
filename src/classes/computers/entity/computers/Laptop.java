package classes.computers.entity.computers;

/*
 * Ноутбуки
 */
public class Laptop extends Computers {
    private int monitorSize;        // размер монитора

    public Laptop(int invent, String processor, String motherboard,
                  int ramSize, int driveSize, int monitorSize) {
        super(invent, processor, motherboard, ramSize, driveSize, ComputerType.Laptop);
        this.monitorSize = monitorSize;
    }

    @Override
    public String toString() {
        return super.toString() + ", monitor size - " + monitorSize;
    }
}
