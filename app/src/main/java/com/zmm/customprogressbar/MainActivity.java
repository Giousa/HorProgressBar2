package com.zmm.customprogressbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final HProgressBar hProgressBar = (HProgressBar) findViewById(R.id.h_progress_bar);
        SeekBar seekBar = (SeekBar) findViewById(R.id.seek_bar);

        hProgressBar.setBarLength(800);
        hProgressBar.setRadian(15);
        hProgressBar.setSize(30);
        hProgressBar.setTextMarginTop(50);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                hProgressBar.setPercent(i*1.0f/100);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
