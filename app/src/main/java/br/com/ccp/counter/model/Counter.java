package br.com.ccp.counter.model;

/**
 * The counter keeps a count. You can add or remove the count until it reaches the max/min count.
 */
public class Counter {

    private int count;
    private CounterConfig config;

    public Counter(CounterConfig config) {
        if (config == null) {
            throw new NullPointerException("CounterConfig must be provided.");
        }

        this.count = config.getInitialCount();
        this.config = config;
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
    }

    public void remove() {
        int newCount = count - config.getStep();
        count = newCount < config.getMinCountAllowed() ? config.getMinCountAllowed() : newCount;
    }

    public void reset() {
        count = config.getInitialCount();
    }
}
