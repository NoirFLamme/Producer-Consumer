package com.assignment.ProdcuerConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ChainQueue implements IObservable{
    private List<IObserver> subscribers;
    public BlockingQueue<Integer> data;

    public ChainQueue() {
        this.subscribers = new ArrayList<>();
        this.data = new LinkedBlockingQueue<>();
    }

    @Override
    public void add(IObserver machine)
    {
        subscribers.add(machine);
    }

    @Override
    public void remove(IObserver machine)
    {
        subscribers.remove(machine);
    }

    @Override
    public void notifyObservers() {
        for (IObserver obs : subscribers)
        {
            obs.update();
        }
    }

    public boolean isEmpty()
    {
        if (this.data.isEmpty())
        {
            return true;
        }
        return false;
    }
}
