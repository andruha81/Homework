package annotation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.Instant;

public class ExamplesInvocationHandler implements InvocationHandler {

    private Examples examples = new ExamplesImpl();

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(!method.isAnnotationPresent(Clocking.class)) {
            return method.invoke(examples, args);
        }

        Instant start = Instant.now();
        Object returnObj = method.invoke(examples, args);
        Instant end = Instant.now();

        System.out.println("Method " + method.getName() + " executed in " + Duration.between(end, start) + ".");

        return returnObj;
    }

    private static class ExamplesImpl implements Examples {
        @Override
        public void thisIsAMethod() {
            System.out.println("thisIsAMethod called!");
        }

        @Override
        public void thisIsAnotherMethod(String something) {
            System.out.println("thisIsAnotherMethod called!");
        }

        @Override
        public void thisIsALongRunningMethod() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("thisIsALongRunningMethod called!");
        }
    }

}
