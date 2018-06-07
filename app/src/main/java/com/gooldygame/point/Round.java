package com.gooldygame.point;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Round extends GameObject {

    private int red;
    private int green;
    private int blue;


    public Round(float x, float y, float size, int bitmapId) {
        super(x, y, size, bitmapId);
    }

    @Override
    void init(Context context) { // сжимаем картинку до нужных размеров
        if (bitmap == null) {
            Bitmap cBitmap = BitmapFactory.decodeResource(context.getResources(), bitmapId);
            bitmap = Bitmap.createScaledBitmap(
                    cBitmap, (int) (size * GameView.unitW), (int) (size * GameView.unitH), false);
            cBitmap.recycle();
        }
    }
}
