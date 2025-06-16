package org.example;

public class Counter {

    private int count = 0;

    public synchronized void increment(){ // To make sure at a time, only one thread can acces this resource.
        count++; // CRITICAL SECTION ..
                // RISK CONDITION.
            // Mutual Exclusion --> Prevent process of accessing same resource by different thread at a time.
        synchronized (this)
        {
            count--; // to make sure  only this block of code will synchronized for thread accessing.
        };

    }

    public int getCount(){
        return count;
    }
}
