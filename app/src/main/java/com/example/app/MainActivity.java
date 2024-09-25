package com.example.app;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.SeekBar;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.CheckBox;
import android.widget.Toast;
import android.widget.Switch;
import android.widget.CompoundButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  // Ensure this matches your XML layout file name

        // Find the RadioGroup by its ID
        RadioGroup radioGroup = findViewById(R.id.radio_group);

        // Set a listener for when a radio button is selected
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // Find the selected radio button by its ID
                RadioButton selectedRadioButton = findViewById(checkedId);

                // Show a Toast message with the text of the selected option
                String selectedText = selectedRadioButton.getText().toString();
                Toast.makeText(MainActivity.this, "Selected: " + selectedText, Toast.LENGTH_SHORT).show();
            }
        });

        // Find the CheckBox by its ID
        CheckBox checkBox = findViewById(R.id.checkbox_example);

        // Set a listener for the CheckBox
        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                // The checkbox is checked
                Toast.makeText(MainActivity.this, "You agreed to the terms and conditions", Toast.LENGTH_SHORT).show();
            } else {
                // The checkbox is unchecked
                Toast.makeText(MainActivity.this, "You must agree to the terms", Toast.LENGTH_SHORT).show();
            }
            RatingBar ratingBar = findViewById(R.id.rating_bar);
            TextView ratingText = findViewById(R.id.rating_text);

            // Set a listener for the RatingBar
            ratingBar.setOnRatingBarChangeListener((ratingBar1, rating, fromUser) -> {
                // Update the TextView with the selected rating
                ratingText.setText("Selected Rating: " + rating);
            });
        });
        SeekBar seekBar = findViewById(R.id.seek_bar);
        TextView progressText = findViewById(R.id.progress_text);

        // Set a listener for the SeekBar
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Update the TextView with the current progress
                progressText.setText("Progress: " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Optional: Add any action when the user starts dragging the SeekBar
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Optional: Add any action when the user stops dragging the SeekBar
            }

            ;

        });
        Switch switchExample = findViewById(R.id.switch_example);

        switchExample.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this, "Switch is ON", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Switch is OFF", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }}