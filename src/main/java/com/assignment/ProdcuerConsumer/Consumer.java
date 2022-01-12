package com.assignment.ProdcuerConsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

class Consumer implements IObserver, Runnable {

    // Creating the object of the
    // producer class
    Random rand = new Random();
    Boolean state = false;
    ChainQueue A;
    ChainQueue B;
    int a;

    // Assigning the object of the
    // producer class
    Consumer(ChainQueue publisher, int a, ChainQueue receiver)
    {
        A = publisher;
        B = receiver;
        this.a = a;
    }

    // Overriding the run method
    @Override
    public void run()
    {

        // Controlling the access of the
        // buffer to the shared producer
        synchronized (A.data)
        {

            while (true) {
                try {
                    A.data.wait(rand.nextInt(6000));
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // Printing the values of the string buffer
                // and consuming the buffer

                try {
                    B.data.put(A.data.take());
                    System.out.print(a + " Consumed " + B.data.peek() + " \n");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    @Override
    public void update() {
        if (A.isEmpty())
        {
            state = false;
        }
        state = true;
    }
}