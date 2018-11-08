package io;

import java.io.*;
import java.math.BigDecimal;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final String PATH = "src\\io\\test_io.txt";
    private static final String PATH_TWO = "src\\io\\test_ioNum.txt";
    private static final String PATH_THREE = "src\\io\\test_ioBin.txt";
    private static final String PATH_FOUR = "src";

    public static void main(String[] args) {

        Pattern pattern;
        Matcher matcher;

        /*
         * задача 30
         * Прочитать текстовый файл
         * Подсчитать кол-во знаков препинания и слов
         */
        System.out.println("---------- Task 30 -------------");

        String lineOne;
        int countPunkt = 0;  // Кол-во знаков пунктуации
        int countWords = 0;  // Кол-во слов

        /* Используем конструкцию try with resources и считываем содержимое файла с помощью Scanner */
        try (Scanner sc = new Scanner(new File(PATH))) {
            pattern = Pattern.compile("\\p{Punct}");     //Шаблон для знаков пунктуации

            while (sc.hasNextLine()) {
                lineOne = sc.nextLine();  // читаем каждую строку

                /* Находим знаки пунктуации в строке и считаем их */
                matcher = pattern.matcher(lineOne);
                while (matcher.find()) {
                    countPunkt++;
                }

                /* Выделяем отдельные слова, получаем массив полученных слов */
                countWords += lineOne.split("\\W+").length;
            }

            System.out.println("Number of punktuation marks in this file - " + countPunkt);
            System.out.println("Number of words in this file - " + countWords);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        /*
         * Задача 31
         * Прочитать текстовый файл
         * Распечатать все числа в нем и посчитать их сумму
         * Убрать повторяющиеся числа и распечатать их
         */
        System.out.println("---------- Task 31 -------------");

        String lineTwo;
        BigDecimal sumNum = BigDecimal.ZERO;  //Сумма чисел. Используем BigDecimal для точности вычислений
        double numTwo;
        Set<Double> list = new LinkedHashSet<>();  //Множество чисел

        /* Используем конструкцию try with resources и считываем содержимое файла с помощью Scanner */
        try (Scanner sc = new Scanner(new File(PATH_TWO))) {
            pattern = Pattern.compile("-?\\d+\\.?\\d*");  // шаблон для чисел, включая отрицательные числа и числа с десятичной дробью

            System.out.print("Numbers in file: ");

            while (sc.hasNextLine()) {
                lineTwo = sc.nextLine();    // читаем каждую строку

                /* Ищем в строке числа. Для единства все числа переводим в double. Суммируем их и добавляем в множество */
                matcher = pattern.matcher(lineTwo);
                while (matcher.find()) {
                    numTwo = Double.parseDouble(matcher.group());
                    sumNum = sumNum.add(BigDecimal.valueOf(numTwo));
                    System.out.print(numTwo + " ");
                    list.add(numTwo);
                }
            }

            System.out.println("\nSum of numbers in this file " + sumNum);
            System.out.print("Numbers without duplicate: ");
            list.forEach(l -> System.out.print(l + " "));   //выводим множество

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        /*
         * Задача 32
         * Записать в двоичный файл 20 случайных чисел
         * прочитать файл, распечатать, вывести среднее арифметическое
         */
        System.out.println("\n---------- Task 32 -------------");

        int quantityRandNumbers = 20;       // Кол-во случайных чисел
        Random random = new Random();
        int numBin;
        int sumBin = 0;

        /* Используем конструкцию try with resources */
        try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(PATH_THREE)))) {
            for (int i = 0; i < quantityRandNumbers; i++) {
                dos.writeInt(random.nextInt(101));  // Записываем в двоичный файл quantityRandNumbers случ. чисел
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /* Используем конструкцию try with resources */
        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(PATH_THREE)))) {
            System.out.print("Numbers from binary file: ");

            /* Считываем двоичный файл. После чтение последнего числа ловим EOFException и прерываем цикл */
            while (true) {
                try {
                    numBin = dis.readInt();
                    sumBin += numBin;
                    System.out.print(numBin + " ");
                } catch (EOFException e) {
                    break;
                }
            }

            /* Выводим среднее арифметическое */
            System.out.println("\nArithmetical mean: " + ((double) sumBin / quantityRandNumbers));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
         * Задача 33
         * Вывод списка каталогов и файлов в указанном месте на диске
         * Каталоги и файлы должны быть распечатаны отдельно
         */
        System.out.println("---------- Task 33 -------------");

        List<File> dirs = new ArrayList<>();    // Коллекция каталогов
        List<File> files = new ArrayList<>();   // Коллекция файлов

        /* Вызываем рекурсивный метод получения каталогов и файлов в данном каталоге */
        printDir(Paths.get(PATH_FOUR), dirs, files);

        System.out.println("Main directory: " + Paths.get(PATH_FOUR).toAbsolutePath());
        System.out.print("Directories: ");
        dirs.forEach(d -> System.out.print(d.getName() + ", "));  // распечатываем каталоги
        System.out.print("\nFiles: ");
        files.forEach(d -> System.out.print(d.getName() + ", ")); // распечатываем файлы

    }

    private static void printDir(Path path, List<File> dirs, List<File> files) {

        /* Получаем объект типа DirectoryStream с каталогами и файлами находящимися в указаном каталоге */
        try (DirectoryStream<Path> fs = Files.newDirectoryStream(path)) {

            /* перебираем полученный DirectoryStream */
            for (Path filesDirs : fs) {
                if (filesDirs.toFile().isFile()) {                  // Проверяем если файл
                    files.add(filesDirs.toFile());
                } else if (filesDirs.toFile().isDirectory()) {      // Проверяем если каталог
                    dirs.add(filesDirs.toFile());
                    printDir(filesDirs, dirs, files);               // Заново вызываем рекурсивный метод
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
