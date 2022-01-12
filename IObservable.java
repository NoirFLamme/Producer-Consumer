package com.assignment.ProdcuerConsumer;

public interface IObservable {
    public void add(IObserver a);
    public void remove(IObserver a);
    public void notifyObservers();
}
