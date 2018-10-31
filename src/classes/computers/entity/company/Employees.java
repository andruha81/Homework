package classes.computers.entity.company;

/*
 * Сотрудники
 */
public class Employees implements Comparable<Employees> {

    private String firstName;           // Имя
    private String lastName;            // Фамилия
    private Departments department;     // Отдел
    private int tabelNumber;            // Табельный номер

    public Employees(String name, String lastName, Departments department, int tabelNumber) {
        this.firstName = name;
        this.lastName = lastName;
        this.department = department;
        this.tabelNumber = tabelNumber;
    }

    public int getTabelNumber() {
        return tabelNumber;
    }

    public Departments getDepartment() {
        return department;
    }

    /*
     * Сравнение сотрудников по табельному номеру для TreeSet
     */
    public int compareTo(Employees emp) {
        if (this.tabelNumber > emp.getTabelNumber()) {
            return 1;
        } else if (this.tabelNumber < emp.getTabelNumber()) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName + ", tabel number " + this.getTabelNumber();
    }
}