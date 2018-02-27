package br.com.ccp.scoreboard.model;

public class Scoreboard {

    public static final int DEFAULT_STEP = 1;
    public static final int DEFAULT_SCORE = 0;

    private int step;
    private int score;

    public Scoreboard(int score) {
        this.step = DEFAULT_STEP;
        this.score = score;
    }

    public Scoreboard() {
        this.step = DEFAULT_STEP;
        this.score = DEFAULT_SCORE;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void add() {
        this.score = this.score + this.step;
    }

    public void remove() {
        int newScore = this.score - this.step;
        this.score = newScore < 0 ? 0 : newScore;
    }

    public void reset() {
        this.score = DEFAULT_SCORE;
    }
}
