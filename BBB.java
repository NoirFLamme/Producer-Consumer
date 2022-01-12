package com.assignment.ProdcuerConsumer;

import java.util.concurrent.*;

public class BBB {
    public static void main(String args[])
    {
        // Initially, there needs to be some data
        // in order to consume the data. So,
        // Producer object is created first
        ExecutorService executor = Executors.newFixedThreadPool(5);
        ChainQueue q0 = new ChainQueue();
        ChainQueue q1 = new ChainQueue();
        ChainQueue q2 = new ChainQueue();
        Producer p = new Producer(q0);
        Consumer a = new Consumer(q0, "M0", q1);
        Consumer b = new Consumer(q0, "M1", q1);
        Consumer c = new Consumer(q1, "M2", q1);
        Consumer d = new Consumer(q1, "M3", q1);

        q0.add(a);
        q0.add(b);
        q0.add(c);
        q1.add(c);
        q1.add(d);

        executor.execute(a);
        executor.execute(b);
        executor.execute(c);
        executor.execute(d);
        executor.execute(p);

    }
}
