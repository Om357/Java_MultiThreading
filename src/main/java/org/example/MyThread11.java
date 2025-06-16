package org.example;

public class MyThread11 extends Thread{
    @Override
    public void run() {
        System.out.println("Thread in running..");
        for(int i =0;i<=5 ; i++){
            try {
                Thread.sleep(1000); // 1000ms = 1 second
                System.out.println(i); // interu[[t se yeh line print nahi hogi.
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread11 t1 = new MyThread11();
        t1.start();
        t1.interrupt(); // iska matlab hai abhi jis thread se jo bhi kara rahe ho usko app vahi rok do.
        t1.join(); // It will wait to complete all the ti operations first and then execute the below code presented.
        System.out.println("Executed after join"); // it will executed after 5 seconds
    }
}
