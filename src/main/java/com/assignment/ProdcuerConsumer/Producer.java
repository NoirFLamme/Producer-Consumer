package com.assignment.ProdcuerConsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

public class Producer implements Runnable {
    Random rand = new Random();
    ChainQueue A;


    Producer(ChainQueue a)
    {
        A = a;
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
                    A.notifyObservers();
                    A.wait(rand.nextInt(6000));
                }
                catch (Exception e) {
                    e.printStackTrace();
                }


            }

            // Notifying the buffer
        }
    }
}
