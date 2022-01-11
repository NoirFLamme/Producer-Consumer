package com.assignment.ProdcuerConsumer;

public class BBB {
    public static void main(String args[])
    {
        // Initially, there needs to be some data
        // in order to consume the data. So,
        // Producer object is created first
        Producer p = new Producer();

        // Sending this producer object
        // into the consumer

        Consumer c = new Consumer(p.A,1);
        Consumer e = new Consumer(p.A,2);
        Consumer d = new Consumer(e.B,3);
        Consumer f = new Consumer(c.B,4);
        Thread t1 = new Thread(p);
        Thread t2 = new Thread(c);
        Thread t3 = new Thread(e);
        Thread t4 = new Thread(d);
        Thread t5 = new Thread(f);


        // Since from the producer object,
        // we have already produced the data.
        // So, we start by consuming it.
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
