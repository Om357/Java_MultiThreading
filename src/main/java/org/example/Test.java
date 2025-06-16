package org.example;

public class Test {
    public static void main(String[] args) {
        Counter counter = new Counter(); // Common resource for two different threads.
        MyThread2 t1 = new MyThread2(counter);
        MyThread2 t2 = new MyThread2(counter);

        t1.start();
        t2.start();

        try{
            t1.join(); // Waiting to complete the both threads.
            t2.join();
        }catch (Exception e){
            System.out.println(e);
        }

        System.out.println(counter.getCount()); // Never throws output 2000 which we are expecting.
    // Kyunki kuch cases aise ho gaye hai , jo ek time pe dono thread ek particular vlue read kar lengi aur usko increment karengi.
        // Toh kuch cases leave ho jayenga, ek object ko hum multiple threads mai share kar rahe hai isiliye.


    }
}
