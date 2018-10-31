package classes.computers.entity.computers;

/*
 * ПЭВМ
 */
public class Desktop extends Computers {
    private boolean hasMonitor;      // Наличие монитора
    private double monitorSize;      // размер монитора

    public Desktop(int invent, String processor, String motherboard,
                   int ramSize, int driveSize, boolean hasMonitor) {
        super(invent, processor, motherboard, ramSize, driveSize, ComputerType.Desktop);
        this.hasMonitor = hasMonitor;
    }

    public Desktop(int invent, String processor, String motherboard,
                   int ramSize, int driveSize, boolean hasMonitor, double monitorSize) {
        super(invent, processor, motherboard, ramSize, driveSize, ComputerType.Desktop);
        this.hasMonitor = hasMonitor;
        this.monitorSize = monitorSize;
    }

    @Override
    public String toString() {
        if (hasMonitor) {
            return super.toString() + ", monitor size - " + monitorSize;
        } else {
            return super.toString() + ", without monitor";
        }
    }
}
