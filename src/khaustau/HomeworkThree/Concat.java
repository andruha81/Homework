package khaustau.HomeworkThree;

public class Concat {

    public static void main(String[] args) {
        String str = new String();
        StringBuilder sb = new StringBuilder();
        long beginTime, endTime;

        beginTime = System.currentTimeMillis();
        for (int i = 0; i < 2000; i++) {
            str += "string ";
        }
        endTime = System.currentTimeMillis();

        System.out.println("Time String is " + (endTime - beginTime));

        beginTime = System.currentTimeMillis();
        for (int i = 0; i < 2000; i++) {
            sb.append("string ");
        }
        endTime = System.currentTimeMillis();

        System.out.println("Time StringBuilder is " + (endTime - beginTime));
    }
}
