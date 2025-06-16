package org.example;

public class MyThread2 extends Thread{

    private Counter counter;

    public MyThread2(Counter counter){
        this.counter = counter;
    }

    @Override
    public void run() {

        for(int i=0; i< 1000;i++){
            counter.increment();
        }
        }
}
