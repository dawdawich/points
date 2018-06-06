package com.gooldygame.point;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;
import java.util.Random;

public class GameView extends SurfaceView implements Runnable {

    public static int maxX = 10; // размер по горизонтали
    public static int maxY = 14; // размер по вертикали
    public static float unitW = 0; // пикселей в юните по горизонтали
    public static float unitH = 0; // пикселей в юните по вертикали

    private boolean firstTime = true;
    private boolean gameRunning = true;
    private Thread gameThread = null;
    private Paint paint;
    private Canvas canvas;
    private SurfaceHolder surfaceHolder;

    private ArrayList<Integer> xPos = new ArrayList<>();
    private ArrayList<Integer> yPos = new ArrayList<>();

    private ArrayList<Round> rounds = new ArrayList<>();

    int x, y;

    public GameView(Context context) {
        super(context);
        //инициализируем обьекты для рисования
        surfaceHolder = getHolder();
        paint = new Paint();

        // инициализируем поток
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        while (gameRunning) {
//            if (xPos.size() == 20 && yPos.size() == 28) {
            if (y > maxY) {
                gameRunning = false;
                canvas = surfaceHolder.lockCanvas();
                canvas.drawColor(Color.BLACK);
                break;
            }
//            update();
            draw();
            control();
        }
    }

    private void draw() {
        if (surfaceHolder.getSurface().isValid()) {  //проверяем валидный ли surface

            if(firstTime){ // инициализация при первом запуске
                firstTime = false;
                unitW = surfaceHolder.getSurfaceFrame().width()/maxX; // вычисляем число пикселей в юните
                unitH = surfaceHolder.getSurfaceFrame().height()/maxY;

//                ship = new Ship(getContext()); // добавляем корабль
            }

            Random random = new Random();

//            int x, y;
//            x = getRandomWithExclusion(random, 0, 19, xPos.toArray(new Integer[xPos.size()]));
//            y = getRandomWithExclusion(random, 0, 27, yPos.toArray(new Integer[yPos.size()]));

            canvas = surfaceHolder.lockCanvas(); // закрываем canvas
            canvas.drawColor(Color.BLACK); // заполняем фон чёрным



//            ship.drow(paint, canvas); // рисуем корабль
            Round round = new Round(x, y, 1, R.drawable.round);
            round.init(getContext());
            rounds.add(round);
            for (Round r : rounds) {
                r.draw(paint, canvas);
            }

            if (x == 20) {
                y++;
                x = 0;
            } else {
                x++;
            }

            surfaceHolder.unlockCanvasAndPost(canvas); // открываем canvas
        }
    }

    private void control() { // пауза на 17 миллисекунд
        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getRandomWithExclusion(Random rnd, int start, int end, Integer... exclude) {
        int random = start + rnd.nextInt(end - start + 1 - exclude.length);
        for (int ex : exclude) {
            if (random < ex) {
                break;
            }
            random++;
        }
        return random;
    }

}
