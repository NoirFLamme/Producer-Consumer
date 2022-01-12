package com.assignment.ProdcuerConsumer;

import java.util.Random;

class Consumer implements IObserver, Runnable {

    // Creating the object of the
    // producer class
    String name;
    ChainQueue previousQ;
    ChainQueue nextQ;

    Random rand = new Random();
    Boolean state = false;


    // Assigning the object of the
    // producer class
    Consumer(ChainQueue publisher, String name, ChainQueue receiver) {
        previousQ = publisher;
        nextQ = receiver;
        this.name = name;
    }

    // Overriding the run method
    @Override
    public void run() {
        while (true) {
            synchronized (previousQ.data) {
                if (state) {
                    try {
                        int timeout = rand.nextInt(6000);
                        int y = previousQ.data.take();
                        Thread.sleep(timeout);
                        nextQ.data.put(y);
                        nextQ.notifyObservers();
                        System.out.print(name + " Consumed " + y + " \n");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    @Override
    public void update() {
        if (previousQ.isEmpty()) {
            state = false;
        }
        state = true;
    }
}