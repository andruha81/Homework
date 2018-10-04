package khaustau.HomeworkThree;

public class Main {

    public static void main(String[] args) {
        EditString es = new EditString();
        String str1 = "Lets take this string! And print only last letters, of each word. ";
        String str2 = "How many, commas,, are here,";
        String checkStr2 = ",";
        String printStr2 = "commas";
        String str3 = "Here : is a lot of - punctuation marks! Can, you count??";
        String checkStr3 = ".?!,;:-\"()\\";
        String printStr3 = "punctuation marks";
        String str4 = "Be attentive. Print text only between two dots. If you have them.";
        String str5 = "Count words  in this text , carefully ";

        System.out.println("Task 1. Printing last letters of words");
        System.out.println(str1);
        es.lastLetters(str1);                          // вызываем фунцию вывода последних букв слов текста
        System.out.println();

        System.out.println("Task 2. Counting commas");
        System.out.println(str2);
        es.countSymbols(str2, checkStr2, printStr2);  // вызываем функцию подсчета символов

        System.out.println("Task 3. Counting punctuation marks");
        System.out.println(str3);
        es.countSymbols(str3, checkStr3, printStr3);  // вызываем функцию подсчета символов

        System.out.println("Task 4. Printing text between dots");
        System.out.println(str4);
        es.textBetween(str4);                         // вызываем функцию вывода текста между точек

        System.out.println("Task 5. Counting words");
        System.out.println(str5);
        es.countWords(str5);                          // вызываем функцию подсчета слов в тексте
    }
}
