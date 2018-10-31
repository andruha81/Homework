package classes.computers.entity.computers;

import classes.computers.entity.company.Employees;

/*
 * Компьютерная техника
 */
public class Computers implements ComputerLifeCycle {
    private int inventoryNumber;        // Инвентарный номер
    private ComputerType type;          // Тип
    private String processor;           // Процессор
    private String motherboard;         // Материнская плата
    private int ramSize;                // Объем ОЗУ
    private int driveSize;              // Объем жесткого диска
    private ComputerStatus status;      // Статус
    private Employees employer;         // Сотрудник

    public Computers(int invent, String processor, String motherboard, int ramSize, int driveSize, ComputerType type) {
        this.processor = processor;
        this.motherboard = motherboard;
        this.ramSize = ramSize;
        this.driveSize = driveSize;
        this.inventoryNumber = invent;
        this.type = type;
        this.status = ComputerStatus.Stock;
    }

    /* Передача сотруднику */
    @Override
    public void beginOperation(Employees emp) {
        this.employer = emp;
        this.status = ComputerStatus.Working;
    }

    /* Ремонт */
    @Override
    public void repairing() {
        this.status = ComputerStatus.Repairing;
    }

    /* Возврат с ремонта */
    @Override
    public void continueOperation() {
        this.status = ComputerStatus.Working;
    }

    /* Списание */
    @Override
    public void retiring() {
        this.status = ComputerStatus.Retired;
    }

    public Employees getEmployer() {
        return employer;
    }

    public ComputerStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return this.type + " " + inventoryNumber + " status - " + status
                + ", processor - " + processor + ", motherbord - " + motherboard
                + ", RAM size - " + ramSize + "GB, drive size - " + driveSize + "GB";
    }
}