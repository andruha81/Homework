/*
 * Тема 4 - классы и объекты
 * Задача дополнительная
 * Копьютерная техника в организации
 */
package classes.computers;

import classes.computers.entity.company.Company;
import classes.computers.entity.company.Departments;
import classes.computers.entity.company.Employees;

public class Main {

    public static void main(String[] args) {
        Departments dep;
        Employees emp;

        /* Создаем новую компанию */
        Company company = new Company("Andrey & family");

        /*
         * Добавляем в компанию отделы
         * Параметры : Наименование отдела, Приоритет в структуре
         */
        company.addDepartment("Executives", 1);
        company.addDepartment("Economical", 3);
        company.addDepartment("Technology", 2);

        /*
         * Нанимаем в компанию сотрудников в конкретные отделы
         * Параметры : Имя, Фамилия, Отдел, Табельный номер
         */
        company.addEmployee("Иван", "Иванов", "Executives", 1);
        company.addEmployee("Степан", "Петров", "Economical", 2);
        company.addEmployee("Иван", "Федоров", "Technology", 3);
        company.addEmployee("Анна", "Морозова", "Economical", 4);

        /*
         * Поставляем в компанию компьютерную тхнику
         * Desktop - ПЭВМ, Laptop - ноутбук
         * Параметры : Инвентарный номер техники, Процессор, Материнская плата, Объем ОЗУ, Объем жесткого диска
         * Для Desktop параметры : Наличие монитора, Размер монитора
         * Для Laptop параметры : Размер монитора
         */
        company.addDesktop(100, "Intel", "Asus", 16, 1024, false);
        company.addDesktop(101, "Intel", "Gigabyte", 32, 512, true, 24);
        company.addLaptop(102, "AMD", "Acer", 8, 256, 15);
        company.addLaptop(103, "AMD", "Asus", 32, 512, 17);
        company.addLaptop(104, "Intel", "Acer", 16, 1024, 13);

        /*
         * Выделение компьютеров сотрудникам
         * Параметры : Табельный номер сотрудника, Инвентарный номер техники
         */
        company.beginOperation(1, 103);
        company.beginOperation(2, 102);
        company.beginOperation(3, 101);
        company.beginOperation(4, 100);

        /*
         * Операции с компьютерной техникой
         * repairing() - ремонт
         * continueOperation() - возврат с ремонта
         * retiring() - списание
         */
        company.repairing(102);
        company.repairing(100);
        company.continueOperation(102);
        company.retiring(101);

        /*
         * Вывод информации о компьютерной техники в компании
         */
        company.getCompany();
    }
}