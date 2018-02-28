package br.com.ccp.counter.model;

import java.util.ArrayList;
import java.util.List;

/**
 * The counter keeps a count. You can add or remove the count until it reaches the max/min count.
 */
public class Counter {

    private int count;
    private CounterConfig config;
    private List<CounterObserver> observers;

    public Counter(CounterConfig config) {
        if (config == null) {
            throw new NullPointerException("CounterConfig must be provided.");
        }

        this.observers = new ArrayList<>();
        this.config = config;
        this.count = config.getInitialCount();
    }

    public void addObserver(CounterObserver counterObserver) {
        observers.add(counterObserver);
    }

    public void removeObserver(CounterObserver counterObserver) {
        observers.remove(counterObserver);
    }

    private void notifyObservers() {
        for (CounterObserver obs : observers) {
            obs.update(this);
        }
    }

    public int getCount() {
        return count;
    }

    public CounterConfig getConfig() {
        return config;
    }

    public void add() {
        int newCount = count + config.getStep();
        count = newCount > config.getMaxCountAllowed() ? config.getMaxCountAllowed() : newCount;
        notifyObservers();
    }

    public void remove() {
        int newCount = count - config.getStep();
        count = newCount < config.getMinCountAllowed() ? config.getMinCountAllowed() : newCount;
        notifyObservers();
    }

    public void reset() {
        count = config.getInitialCount();
        notifyObservers();
    }
}
