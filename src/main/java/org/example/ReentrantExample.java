package org.example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantExample {

    private final Lock lock = new ReentrantLock(); // Since it is the Reentrant LOCK
    public void outerMethod(){           // It can access one thread to pass in multiple lock,
        lock.lock();
        try{
            System.out.println("Outer Method");
            innerMethod(); // DEAD LOCK as it is waiting for completing its method
        }finally {
            lock.unlock();
        }}
    public void innerMethod(){
        lock.lock(); // DEAD LOCK , waiting for completing its upper method.
        try{
            System.out.println("Inner Method");
        }finally {
            lock.unlock();
        }}
    public static void main(String[] args) {
        ReentrantExample ex = new ReentrantExample();
        ex.outerMethod();
    }
}
