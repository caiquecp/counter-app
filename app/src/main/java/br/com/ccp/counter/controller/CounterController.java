package br.com.ccp.counter.controller;

import br.com.ccp.counter.model.Counter;

public interface CounterController {

    void startCount();
    void addCount();
    void removeCount();
    void resetCount();

    interface CounterActionListener {

        void onCountStarted(Counter counter);
        void onCountChanged(Counter counter);
    }
}
