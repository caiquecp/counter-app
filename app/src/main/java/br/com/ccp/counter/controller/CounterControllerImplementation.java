package br.com.ccp.counter.controller;

import br.com.ccp.counter.model.Counter;

public class CounterControllerImplementation implements CounterController {

    private Counter counter;

    public CounterControllerImplementation(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void addCount() {
        counter.add();
    }

    @Override
    public void removeCount() {
        counter.remove();
    }

    @Override
    public void resetCount() {
        counter.reset();
    }
}