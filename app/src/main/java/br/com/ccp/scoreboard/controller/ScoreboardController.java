package br.com.ccp.scoreboard.controller;

import br.com.ccp.scoreboard.model.Scoreboard;

public class ScoreboardController {

    private Scoreboard model;
    private ScoreAction onScoreAction;

    public ScoreboardController(ScoreAction onScoreChangedListener) {
        this.model = new Scoreboard();
        this.onScoreAction = onScoreChangedListener;
    }

    public void addScore() {
        model.add();
        onScoreAction.scoreChanged(model);
    }

    public void removeScore() {
        model.remove();
        onScoreAction.scoreChanged(model);
    }

    public void resetScore() {
        model.reset();
        onScoreAction.scoreChanged(model);
    }

    public int getScore() {
        return model.getScore();
    }

    public void start() {
        onScoreAction.scoreStarted(model);
    }

    public void start(int score) {
        model.setScore(score);
        onScoreAction.scoreStarted(model);
    }

    public interface ScoreAction {
        void scoreStarted(Scoreboard scoreboard);
        void scoreChanged(Scoreboard scoreboard);
    }
}
