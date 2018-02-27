package br.com.ccp.counter.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import br.com.ccp.counter.R;
import br.com.ccp.counter.controller.CounterController;
import br.com.ccp.counter.controller.CounterControllerImplementation;
import br.com.ccp.counter.model.Counter;
import br.com.ccp.counter.model.CounterConfig;

public class CounterActivity extends AppCompatActivity
        implements CounterController.CounterActionListener {

    private CounterController controller;

    private TextView countTextView;
    private Button addCountButton;
    private Button removeCountButton;
    private Button resetCountButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        controller = new CounterControllerImplementation(createDefaultCounter(), this);

        countTextView = findViewById(R.id.count_text_view);
        addCountButton = findViewById(R.id.add_count_button);
        removeCountButton = findViewById(R.id.remove_count_button);
        resetCountButton = findViewById(R.id.reset_count_button);

        addCountButton.setOnClickListener(view -> {
            controller.addCount();
        });

        removeCountButton.setOnClickListener(view -> {
            controller.removeCount();
        });

        resetCountButton.setOnClickListener(view -> {
            controller.resetCount();
        });

        controller.startCount();
    }

    @Override
    public void onCountStarted(Counter counter) {
        addCountButton.setText(getString(R.string.add_score_button, counter.getConfig().getStep()));
        removeCountButton.setText(getString(R.string.remove_score_button,
                counter.getConfig().getStep()));
        bindCounter(counter);
    }

    @Override
    public void onCountChanged(Counter counter) {
        bindCounter(counter);
    }

    private void bindCounter(Counter counter) {
        countTextView.setText(String.valueOf(counter.getCount()));
        addCountButton.setEnabled(counter.getCount() < counter.getConfig().getMaxCountAllowed());
        removeCountButton.setEnabled(counter.getCount() > counter.getConfig().getMinCountAllowed());
    }

    private Counter createDefaultCounter() {
        CounterConfig counterConfig = new CounterConfig(0, 1, 0,
                100);
        Counter counter = new Counter(counterConfig);
        return counter;
    }
}
