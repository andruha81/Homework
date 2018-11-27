package annotation;

import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        Examples examples = (Examples) Proxy.newProxyInstance(Examples.class.getClassLoader(), new Class[]{Examples.class}, new ExamplesInvocationHandler());

        examples.thisIsAMethod();
        examples.thisIsAnotherMethod("");
        examples.thisIsALongRunningMethod();
    }
}
