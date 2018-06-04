package com.gooldygame.point;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;

public class Body {

    protected float x; // координаты
    protected float y;
    protected float size = 5; // размер
    protected float speed; // скорость
    protected int bitmapId; // id картинки
    protected Bitmap bitmap; // картинка


    void init(Context context) { // сжимаем картинку до нужных размеров
        bitmapId = R.drawable.round;
        Bitmap cBitmap = BitmapFactory.decodeResource(context.getResources(), bitmapId);
        bitmap = Bitmap.createScaledBitmap(
                cBitmap, (int)(size * TestObject.unitW), (int)(size * TestObject.unitH), false);
        cBitmap.recycle();
    }

    void update(){ // тут будут вычисляться новые координаты
    }

    void drow(Paint paint, Canvas canvas){ // рисуем картинку
        canvas.drawBitmap(bitmap, x*TestObject.unitW, y*TestObject.unitH, paint);
    }

}
