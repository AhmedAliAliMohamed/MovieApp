package com.example.movieapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.movieapp.R;

public class MainActivity extends AppCompatActivity {
    private int progress = 0;
    private final int barMax = 100;
    private Handler handler = new Handler();
    private ProgressBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView splash = findViewById(R.id.logo);
        bar = findViewById(R.id.progress_circular_logo);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (progress < barMax){
                    progress++;
                    android.os.SystemClock.sleep(60);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            bar.setMax(progress);
                            Intent intent = new Intent(MainActivity.this ,ListOfMovies.class);
                            startActivity(intent);
                        }
                    });
                }

            }
        }).start();




    }
}