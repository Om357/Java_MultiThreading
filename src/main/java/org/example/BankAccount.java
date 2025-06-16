package org.example;

import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    int balance = 1000;

     private final Lock lock = new ReentrantLock(); // AS Lock is an interface.

    public void withdrawAmount(int amount) {
        System.out.println(Thread.currentThread().getName() + " Attempting WithDraw" + amount);

        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                if (balance >= amount){
                    System.out.println(Thread.currentThread().getName()+"Proceeding Payment");
                       try{
                        Thread.sleep(3000);
                           balance -= amount;
                           System.out.println(Thread.currentThread().getName() + "completed withdrawal. Remaining Balance :--" +balance);
                       }catch (Exception e){
                        Thread.currentThread().interrupt();
                        }
                          finally {  // Everytime we used Finally for free the resources
                           lock.unlock();
                       }
                }else {
                    System.out.println(Thread.currentThread().getName() + "Insufficient Balance");
                }
            }else {
                System.out.println(Thread.currentThread().getName() + " could not acquire the Lock, Will try LAter");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }


    //public synchronized void withdrawAmount(int amount); // Used for intrinsic lock
//    public void withdrawAmount(int amount){ // Implementing expicit locks
//        System.out.println(Thread.currentThread().getName()+"Attempting to withdraw " + amount);
//        if(balance >= amount){
//            System.out.println(Thread.currentThread().getName()+"Proceeding Payment");
//            try{
//            Thread.sleep(3000);
//            }catch (Exception e){
//                System.out.println(e);
//            }
//            balance -= amount;
//            System.out.println(Thread.currentThread().getName() + "completed withdrawal. Remaining Balance :--" +balance)   ;
//        }else {
//            System.out.println(Thread.currentThread().getName() + "Insufficient Balance");
//        }


   // }
}
