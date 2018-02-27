package br.com.ccp.scoreboard.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import br.com.ccp.scoreboard.R;
import br.com.ccp.scoreboard.controller.ScoreboardController;
import br.com.ccp.scoreboard.model.Scoreboard;

public class ScoreboardActivity extends AppCompatActivity
        implements ScoreboardController.ScoreAction {

    private static final String SAVED_SCORE = "saved_score";

    private ScoreboardController controller;

    private TextView scoreTextView;
    private Button addScoreButton;
    private Button removeScoreButton;
    private Button resetScoreButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);

        controller = new ScoreboardController(this);

        scoreTextView = findViewById(R.id.score_text_view);
        addScoreButton = findViewById(R.id.add_score_button);
        removeScoreButton = findViewById(R.id.remove_score_button);
        resetScoreButton = findViewById(R.id.reset_score_button);

        addScoreButton.setOnClickListener(view -> {
            controller.addScore();
        });

        removeScoreButton.setOnClickListener(view -> {
            controller.removeScore();
        });

        resetScoreButton.setOnClickListener(view -> {
            controller.resetScore();
        });

        if (savedInstanceState == null) {
            controller.start();
        } else {
            int lastScore = savedInstanceState.getInt(SAVED_SCORE);
            controller.start(lastScore);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SAVED_SCORE, controller.getScore());
    }

    @Override
    public void scoreStarted(Scoreboard scoreboard) {
        addScoreButton.setText(getString(R.string.add_score_button, scoreboard.getStep()));
        removeScoreButton.setText(getString(R.string.remove_score_button, scoreboard.getStep()));
        scoreTextView.setText(String.valueOf(scoreboard.getScore()));
        removeScoreButton.setEnabled(scoreboard.getScore() > 0);
    }

    @Override
    public void scoreChanged(Scoreboard scoreboard) {
        scoreTextView.setText(String.valueOf(scoreboard.getScore()));
        removeScoreButton.setEnabled(scoreboard.getScore() > 0);
    }
}
