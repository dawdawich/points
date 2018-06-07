package com.gooldygame.point;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;

public abstract class GameObject {

    protected float x; // координаты
    protected float y;
    protected float size; // размер
    protected int bitmapId; // id картинки
    static protected Bitmap bitmap; // картинка


    public GameObject(float x, float y, float size, int bitmapId) {
        this.x = x * GameView.unitW;
        this.y = y * GameView.unitH;
        this.size = size;
        this.bitmapId = bitmapId;
    }

    abstract void init(Context context);

    void draw(Paint paint, Canvas canvas){ // рисуем картинку
        ColorFilter filter = new LightingColorFilter(Color.RED, 0);
        paint.setColorFilter(filter);
        canvas.drawBitmap(bitmap, x, y, paint);
    }

}
