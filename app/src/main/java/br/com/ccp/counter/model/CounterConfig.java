package br.com.ccp.counter.model;

/**
 * Provides configuration for the counter: initial count, step, min/max count allowed.
 */
public class CounterConfig {

    private static final int DEFAULT_INITIAL_COUNT = 0;
    private static final int DEFAULT_STEP = 1;
    private static final int DEFAULT_MIN_COUNT_ALLOWED = 0;
    private static final int DEFAULT_MAX_COUNT_ALLOWED = 10;

    private int initialCount;
    private int step;
    private int minCountAllowed;
    private int maxCountAllowed;

    public CounterConfig(int initialCount, int step, int minCountAllowed, int maxCountAllowed) {
        this.initialCount = initialCount;
        this.step = step;
        this.minCountAllowed = minCountAllowed;
        this.maxCountAllowed = maxCountAllowed;
    }

    public int getInitialCount() {
        return initialCount;
    }

    public int getStep() {
        return step;
    }

    public int getMinCountAllowed() {
        return minCountAllowed;
    }

    public int getMaxCountAllowed() {
        return maxCountAllowed;
    }
}
