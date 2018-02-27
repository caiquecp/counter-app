package br.com.ccp.counter.controller;

import br.com.ccp.counter.model.Counter;

public class CounterControllerImplementation implements CounterController {

    private Counter counter;
    private CounterActionListener listener;

    public CounterControllerImplementation(Counter counter, CounterActionListener listener) {
        this.counter = counter;
        this.listener = listener;
    }

    @Override
    public void startCount() {
        if (listener != null) {
            listener.onCountStarted(counter);
        }
    }

    @Override
    public void addCount() {
        counter.add();
        if (listener != null) {
            listener.onCountChanged(counter);
        }
    }

    @Override
    public void removeCount() {
        counter.remove();
        if (listener != null) {
            listener.onCountChanged(counter);
        }
    }

    @Override
    public void resetCount() {
        counter.reset();
        if (listener != null) {
            listener.onCountChanged(counter);
        }
    }
}