package com.assignment.ProdcuerConsumer;

import java.util.concurrent.*;

public class BBB {
    public static void main(String args[])
    {
        // Initially, there needs to be some data
        // in order to consume the data. So,
        // Producer object is created first
        ExecutorService executor = Executors.newSingleThreadExecutor();
        ChainQueue start = new ChainQueue();
        ChainQueue end = new ChainQueue();
        Producer p = new Producer(start);
        Consumer a = new Consumer(p.A, 1, end);
        start.add(a);


        executor.execute(p);
        executor.execute(a);


        // Sending this producer object
        // into the consumer




        // Since from the producer object,
        // we have already produced the data.
        // So, we start by consuming it.

    }
}
