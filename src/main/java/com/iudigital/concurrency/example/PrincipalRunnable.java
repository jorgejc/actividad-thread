/**
 * PrincipalRunnable.java
 */
package com.iudigital.concurrency.example;

public class PrincipalRunnable {
    public static void main(String[] args) {
        RunnableClass runnableClass = new RunnableClass();
        Thread hilo = new Thread(runnableClass);
        hilo.start();
        System.out.println("Hello, I am principal main thread");
        System.out.println("Finish ");
        System.out.println("===================================== ");
    }
}
