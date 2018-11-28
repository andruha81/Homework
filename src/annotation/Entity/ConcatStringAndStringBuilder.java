package annotation.Entity;

public interface ConcatStringAndStringBuilder {

    @Clocking
    void concatInStringBuilder(int iterations);

    @Clocking
    void concatInString(int iterations);

}
