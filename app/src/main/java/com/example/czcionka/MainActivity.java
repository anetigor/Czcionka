package com.example.czcionka;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private TextView tvSizeLabel;
    private SeekBar seekBar;
    private TextView tvQuote;
    private Button btnChangeQuote;
    private int currentQuoteIndex = 0;
    private final String[] quotes = {"Dzień dobry", "Good morning", "Buenos dias"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSizeLabel = findViewById(R.id.tvSizeLabel);
        seekBar = findViewById(R.id.seekBar);
        tvQuote = findViewById(R.id.tvQuote);
        btnChangeQuote = findViewById(R.id.btnChangeQuote);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvSizeLabel.setText("Rozmiar: " + progress);
                tvQuote.setTextSize(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // No action needed here
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // No action needed here
            }
        });

        btnChangeQuote.setOnClickListener(v -> {
            currentQuoteIndex = (currentQuoteIndex + 1) % quotes.length;
            tvQuote.setText(quotes[currentQuoteIndex]);
        });
    }
}