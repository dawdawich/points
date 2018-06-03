package com.gooldygame.point;

import android.content.Context;
import android.graphics.Color;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class TestObject extends SurfaceView implements Runnable{

    private Thread gameThread = null;
    private SurfaceHolder surfaceHolder;


    public TestObject(Context context) {
        super(context);
        surfaceHolder = getHolder();
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            update();
            draw();
            control();
        }
    }

    private void update() {}

    private void draw() {
        if (surfaceHolder.getSurface().isValid()) {  //проверяем валидный ли surface

            if(firstTime){ // инициализация при первом запуске
                firstTime = false;
                unitW = surfaceHolder.getSurfaceFrame().width()/maxX; // вычисляем число пикселей в юните
                unitH = surfaceHolder.getSurfaceFrame().height()/maxY;

                ship = new Ship(getContext()); // добавляем корабль
            }

            canvas = surfaceHolder.lockCanvas(); // закрываем canvas
            canvas.drawColor(Color.BLACK); // заполняем фон чёрным

            surfaceHolder.unlockCanvasAndPost(canvas); // открываем canvas
        }
    }


    private void control() {
        try {
            gameThread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
