package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main   {
    public static void main(String[] args) {

//        World world = new World(); // NEW STATE OF THREAD
//        Thread t1 = new Thread(world);
//        t1.start(); // RUNNABLE STATE,, JAB CPU ko time milega tab yeh running state mai ayega.
//
//
//        for( ; ; ){ // INFINITE LOOP
//        System.out.println("Hello ");
//    }

        BankAccount acc1 = new BankAccount();
        Runnable task = new Runnable() { // Anonymous class as we opted not for implementing the runnable interface.
            @Override
            public void run() {
                acc1.withdrawAmount(500);
            }
        };

        Thread t1 = new Thread(task, "Thread 1 ");
        Thread t2 = new Thread(task, "Thread2 ");

        t1.start();
        t2.start();

    }
}