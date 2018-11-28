/*
 * Создание аннотации, которая применяется к методу, выводит время его выполнения
 */
package annotation;

import annotation.Entity.Concat;
import annotation.Entity.ConcatStringAndStringBuilder;
import annotation.Entity.ExamplesInvocationHandler;

import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        int iterations = 30_000;            // количество итераций для объектов String и StringBuilder

        /*
         * Создаем прокси объект на основе интерфейса ConcatStringAndStringBuilder
         * В качестве третьего параметра, передаем ему экземпляр класса ExamplesInvocationHandler, который обрабатывает вызовы методов прокси объекта
         */
        ConcatStringAndStringBuilder concat = (ConcatStringAndStringBuilder) Proxy.newProxyInstance(ConcatStringAndStringBuilder.class.getClassLoader(),
                new Class[]{ConcatStringAndStringBuilder.class},
                new ExamplesInvocationHandler(new Concat()));

        /* Вызываем методы */
        concat.concatInStringBuilder(iterations);
        concat.concatInString(iterations);
    }
}