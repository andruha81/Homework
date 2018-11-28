package annotation.Entity;

public class Concat implements ConcatStringAndStringBuilder {

    @Override
    public void concatInStringBuilder(int iterations) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= iterations; i++) {
            sb.append("Text");
        }

        System.out.println("-----------------------------");
        System.out.println("concat in stringbuilder");
    }

    @Override
    public void concatInString(int iterations) {
        String str = "";

        for (int i = 0; i <= iterations; i++) {
            str += "Text";
        }

        System.out.println("-----------------------------");
        System.out.println("concat in string");
    }
}
