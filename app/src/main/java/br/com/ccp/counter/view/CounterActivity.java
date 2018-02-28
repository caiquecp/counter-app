package br.com.ccp.counter.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.ccp.counter.R;
import br.com.ccp.counter.controller.CounterController;
import br.com.ccp.counter.controller.CounterControllerImplementation;
import br.com.ccp.counter.model.Counter;
import br.com.ccp.counter.model.CounterConfig;
import br.com.ccp.counter.model.CounterObserver;

public class CounterActivity extends AppCompatActivity implements CounterObserver {

    private Counter counter;
    private CounterController counterController;

    private TextView countTextView;
    private ImageButton addCountButton;
    private ImageView removeCountButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        counter = createDefaultCounter();
        counterController = new CounterControllerImplementation(counter);

        countTextView = findViewById(R.id.count_text_view);
        addCountButton = findViewById(R.id.add_count_button);
        removeCountButton = findViewById(R.id.remove_count_button);

        addCountButton.setOnClickListener(view -> {
            counterController.addCount();
        });

        removeCountButton.setOnClickListener(view -> {
            counterController.removeCount();
        });

        bindCounter(counter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.counter_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.reset_count_button:
                counterController.resetCount();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void update(Counter counter) {
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
        counter.addObserver(this);
        return counter;
    }
}
