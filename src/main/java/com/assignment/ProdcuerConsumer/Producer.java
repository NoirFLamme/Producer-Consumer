package com.assignment.ProdcuerConsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

public class Producer extends Thread {
    Random rand = new Random();
    ChainQueue A;


    Producer()
    {
        A = new ChainQueue();
    }

    public void run()
    {
        synchronized (A)
        {
           while (true){
               int i = rand.nextInt(50);
                try {
                    System.out.println("Produced " + i);
                    A.data.add(i);
                    A.wait(rand.nextInt(6000));
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
               A.notify();
            }

            // Notifying the buffer
        }
    }
}
