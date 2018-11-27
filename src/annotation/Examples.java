package annotation;

public interface Examples {

    @Clocking
    void thisIsAMethod();

    void thisIsAnotherMethod(String something);

    @Clocking
    void thisIsALongRunningMethod();

}
