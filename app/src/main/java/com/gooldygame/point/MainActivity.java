package com.gooldygame.point;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private SurfaceHolder surfaceHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GameView gameView = new GameView(this); // создаём gameView

        LinearLayout gameLayout = findViewById(R.id.gameLayout); // находим gameLayout
        gameLayout.addView(gameView); // и добавляем в него gameView

    }
}
