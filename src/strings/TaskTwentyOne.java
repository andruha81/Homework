package strings;

public class TaskTwentyOne {

    public static void main(String[] args) {
        String str = new String();
        StringBuilder sb = new StringBuilder();
        long beginTime;

        beginTime = System.nanoTime();
        for (int i = 0; i < 2000; i++) {
            str += "string ";
        }

        System.out.println("Time String is " + (System.nanoTime() - beginTime));

        beginTime = System.nanoTime();
        for (int i = 0; i < 2000; i++) {
            sb.append("string ");
        }

        System.out.println("Time StringBuilder is " + (System.nanoTime() - beginTime));
    }
}
