package com.gooldygame.point;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

public class GameObject {

    protected float x; // координаты
    protected float y;
    protected float size; // размер
    protected int bitmapId; // id картинки
    protected Bitmap bitmap; // картинка

    public GameObject(float x, float y, float size, int bitmapId) {
        this.x = x * GameView.unitW;
        this.y = y * GameView.unitH;
        this.size = size;
        this.bitmapId = bitmapId;
    }

    void init(Context context) { // сжимаем картинку до нужных размеров
        Bitmap cBitmap = BitmapFactory.decodeResource(context.getResources(), bitmapId);
        bitmap = Bitmap.createScaledBitmap(
                cBitmap, (int)(size * GameView.unitW), (int)(size * GameView.unitH), false);
        cBitmap.recycle();
    }

    void draw(Paint paint, Canvas canvas){ // рисуем картинку
        canvas.drawBitmap(bitmap, x, y, paint);
    }

}
