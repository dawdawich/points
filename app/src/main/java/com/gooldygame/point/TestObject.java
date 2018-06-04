package com.gooldygame.point;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;

public class TestObject extends SurfaceView implements Runnable{

    public static int maxX = 20; // размер по горизонтали
    public static int maxY = 28; // размер по вертикали
    public static float unitW = 0; // пикселей в юните по горизонтали
    public static float unitH = 0; // пикселей в юните по вертикали
    private Thread gameThread = null;
    private SurfaceHolder surfaceHolder;
    private Paint paint;
    private boolean firstTime = true;
    private Canvas canvas;
    private ArrayList<Body> points = new ArrayList<>(); // тут будут харанится астероиды



    public TestObject(Context context) {
        super(context);
        surfaceHolder = getHolder();
        paint = new Paint();
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

//                ship = new Ship(getContext()); // добавляем корабль
            }

            canvas = surfaceHolder.lockCanvas(); // закрываем canvas
            canvas.drawColor(Color.BLACK); // заполняем фон чёрным

            Body newBody = new Body();
            newBody.init(getContext());
            points.add(newBody);

            for (Body point : points) {
                int p = points.indexOf(point) + 1;
                point.x = p;
                point.y = p;
                point.drow(paint, canvas);
            }

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
