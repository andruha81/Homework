package classes.computers.entity.computers;

import classes.computers.entity.company.Employees;

public interface ComputerLifeCycle {
    void beginOperation(Employees emp);
    void repairing();
    void continueOperation();
    void retiring();

}
