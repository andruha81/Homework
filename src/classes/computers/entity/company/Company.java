package classes.computers.entity.company;

import classes.computers.entity.computers.*;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

/*
 * Компания
 */
public class Company {
    private String name;                            // Наименование компании
    private Map<String, Departments> departments;   // Коллекция отделов
    private Map<Integer, Employees> employees;      // Коллекция сотрудников
    private Map<Integer, Computers> computers;      // Коллекция компьютерной техники

    public Company(String name) {
        this.name = name;
        departments = new HashMap<>();
        employees = new HashMap<>();
        computers = new HashMap<>();
    }

    /*
     * Добавление отдела
     * nameDep : Наименование отдела, prior : Приоритет в структуре
     * Проводим проверку на непустое наименование
     * Проверяем чтобы приоритет не был меньше 1. Если меньше приоритет меньше 1 автоматом изменяем его
     */
    public void addDepartment(String nameDep, int prior) {
        if (nameDep.isEmpty()) {
            throw new NullPointerException("name of a department can't be blank");
        }
        if (prior < 1) {
            prior = Math.abs(prior) + 1;
            System.out.println("Priority is incorrect. New priority is " + prior);
        }

        departments.put(nameDep, new Departments(nameDep, prior));
    }

    /*
     * Добавление сотрудника
     * nameEmp : Имя
     * lastNameEmp: Фамилия, dep : Отдел, tabel : Табельный номер
     * Проверяем на непустые значения Имени, Фамилии
     * проверяем на наличе отдела
     * Проверяем если табельный номер меньше 1 или такой табельный номер уже существует
     * сотруднику присваивается следующий за последним табельный номер или 1 если это первый сотрудник
     */
    public void addEmployee(String nameEmp, String lastNameEmp, String dep, int tabel) {
        if (nameEmp.isEmpty() || lastNameEmp.isEmpty()) {
            throw new NullPointerException("First name and last name can't be blank");
        } else if (!(departments.containsKey(dep))) {
            throw new NullPointerException("There is no such a department \"" + dep + "\"");
        }
        if ((tabel < 1) || (employees.containsKey(tabel))) {
            if (employees.isEmpty()) {
                tabel = 1;
            } else {
                tabel = employees.keySet().stream().max(Integer::compareTo).get() + 1;
            }
            System.out.println("Tabel number is incorrect. New tabel number is " + tabel);
        }

        employees.put(tabel, new Employees(nameEmp, lastNameEmp, departments.get(dep), tabel));
    }

    /*
     * Добавление Desktop без монитора
     * invent : Инвентарный номер, processor : Процессор, motherboard : Материнская плата
     * ramSize : Объем ОЗУ, driveSize : Объем жесткого диска, hasMonitor : Наличие монитора
     * Проверяем на непустые значения Процессор, Материнская плата, Объем ОЗУ, Объем жесткого диска
     * Проверяем если Наличие монитора true, но не указан размер монитора
     * Проверяем если инвентарный номер меньше 100 или такой инвентарный номер уже существует
     * технике присваивается следующий за последним инвентарный номер или 100 если это первая техника
     */
    public void addDesktop(int invent, String processor, String motherboard,
                           int ramSize, int driveSize, boolean hasMonitor) {
        if (processor.isEmpty() || motherboard.isEmpty() || (ramSize == 0) || (driveSize == 0)) {
            throw new NullPointerException("Parameters of a " + ComputerType.Desktop + " can't be blank");
        } else if (hasMonitor) {
            throw new NullPointerException("For monitor you must put size");
        }
        invent = checkInvent(invent, ComputerType.Desktop);

        computers.put(invent, new Desktop(invent, processor, motherboard, ramSize, driveSize, hasMonitor));
    }

    /*
     * Добавление Desktop с монитором
     * invent : Инвентарный номер, processor : Процессор, motherboard : Материнская плата
     * ramSize : Объем ОЗУ, driveSize : Объем жесткого диска, hasMonitor : Наличие монитора, monitorSize : Размер монитора
     * Проверяем на непустые значения Процессор, Материнская плата, Объем ОЗУ, Объем жесткого диска, Размер монитора
     * Проверяем если Наличие монитора false, деламе его true
     * Проверяем если инвентарный номер меньше 100 или такой инвентарный номер уже существует
     * технике присваивается следующий за последним инвентарный номер или 100 если это первая техника
     */
    public void addDesktop(int invent, String processor, String motherboard,
                           int ramSize, int driveSize, boolean hasMonitor, int monitorSize) {

        if (processor.isEmpty() || motherboard.isEmpty() || (ramSize == 0) || (driveSize == 0) || (monitorSize == 0)) {
            throw new NullPointerException("Parameters of a " + ComputerType.Desktop + " can't be blank");
        }
        if (!(hasMonitor)) {
            hasMonitor = true;
        }
        invent = checkInvent(invent, ComputerType.Desktop);

        computers.put(invent, new Desktop(invent, processor, motherboard, ramSize, driveSize, hasMonitor, monitorSize));
    }

    /*
     * Добавление Laptop
     * invent : Инвентарный номер, processor : Процессор, motherboard : Материнская плата
     * ramSize : Объем ОЗУ, driveSize : Объем жесткого диска, monitorSize : Размер монитора
     * Проверяем на непустые значения Процессор, Материнская плата, Объем ОЗУ, Объем жесткого диска, Размер монитора
     * Проверяем если инвентарный номер меньше 100 или такой инвентарный номер уже существует
     * технике присваивается следующий за последним инвентарный номер или 100 если это первая техника
     */
    public void addLaptop(int invent, String processor, String motherboard,
                          int ramSize, int driveSize, int monitorSize) {
        if (processor.isEmpty() || motherboard.isEmpty() || (ramSize == 0) || (driveSize == 0) || (monitorSize == 0)) {
            throw new NullPointerException("Parameters of a " + ComputerType.Laptop + " can't be blank");
        }
        invent = checkInvent(invent, ComputerType.Laptop);

        computers.put(invent, new Laptop(invent, processor, motherboard, ramSize, driveSize, monitorSize));
    }

    /*
     * Выдача компьютерной техники сотруднику
     * tabelNumber : Табельный номер, invent - Инвентарный номер техники
     * Проверяем на наличиие сотрудника с данным табельным номером и техники с данным инвентарным номером
     */
    public void beginOperation(int tabelNumber, int invent) {
        if (!(employees.containsKey(tabelNumber))) {
            throw new IllegalArgumentException("There is no employer with tabel number " + tabelNumber);
        }
        if (!(computers.containsKey(invent))) {
            throw new IllegalArgumentException("There is no computer with inventory number " + invent);
        }

        computers.get(invent).beginOperation(employees.get(tabelNumber));
    }

    /*
     * Ремонт компьютерной техники
     * invent - Инвентарный номер техники
     * Проверяем на наличиие в работе техники с данным инвентарным номером в работе
     */
    public void repairing(int invent) {
        if (computers.entrySet().stream().filter(v -> v.getValue().getStatus() == ComputerStatus.Working).noneMatch(c -> c.getKey() == invent)) {
            throw new IllegalArgumentException("There is no working computer with inventory number " + invent);
        }
        computers.get(invent).repairing();
    }

    /*
     * Возврат с ремонта компьютерной техники
     * invent - Инвентарный номер техники
     * Проверяем на наличиие в ремонте техники с данным инвентарным номером
     */
    public void continueOperation(int invent) {
        if (computers.entrySet().stream().filter(c -> c.getValue().getStatus() == ComputerStatus.Repairing).noneMatch(c -> c.getKey() == invent)) {
            throw new IllegalArgumentException("There is no repairing computer with inventory number " + invent);
        }
        computers.get(invent).continueOperation();
    }

    /*
     * Списание компьютерной техники
     * invent - Инвентарный номер техники
     * Проверяем на наличиие не списанной техники с данным инвентарным номером
     */
    public void retiring(int invent) {
        if (computers.entrySet().stream().filter(c -> c.getValue().getStatus() != ComputerStatus.Retired).noneMatch(c -> c.getKey() == invent)) {
            throw new IllegalArgumentException("There is no computer for retiring with inventory number " + invent);
        }
        computers.get(invent).retiring();
    }

    public void getCompany() {
        System.out.println("Company : " + this.name);

        System.out.println("-------------- Computers in stock --------------");
        computers.values().stream().filter(c -> c.getStatus() == ComputerStatus.Stock).forEach(System.out::println);

        System.out.println("-------------- Computers in operation --------------");
        for (Map.Entry<String, Departments> dep : departments.entrySet()) {
            System.out.println("Department " + dep.getValue());

            TreeSet<Employees> collectEmp = employees.values().stream().filter(v -> v.getDepartment() == dep.getValue())
                    .collect(Collectors.toCollection(TreeSet::new));
            for (Employees emp : collectEmp) {
                System.out.println(emp);
                computers.values().stream()
                        .filter(e -> (e.getEmployer() == emp) && ((e.getStatus() == ComputerStatus.Working) || (e.getStatus() == ComputerStatus.Repairing)))
                        .forEach(System.out::println);
            }
        }

        System.out.println("-------------- Computers out of service --------------");
        computers.values().stream().filter(c -> c.getStatus() == ComputerStatus.Retired)
                .forEach(System.out::println);

    }

    /*
     * Проверка инвентарного номера : не меньше 100 и не должен повторяться
     * В случае не прохождения условия номер берется следующий за последним
     * Возвращает инвентарный номер
     */
    private int checkInvent(int invent, ComputerType type) {
        if ((invent < 100) || computers.containsKey(invent)) {
            if (computers.isEmpty()) {
                invent = 100;
            } else {
                invent = computers.keySet().stream().max(Integer::compareTo).get() + 1;
            }
            System.out.println("Inventory number of a " + type + " is not valid." +
                    " New inventory number is " + invent);
        }

        return invent;
    }
}