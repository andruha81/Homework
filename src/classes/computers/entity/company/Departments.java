package classes.computers.entity.company;

/*
 * Отделы
 */
public class Departments {

    private String name;  // Наименование отдела
    private int priority; // Приоритет в структуре

    public Departments(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "\"" + name + "\"";
    }
}
