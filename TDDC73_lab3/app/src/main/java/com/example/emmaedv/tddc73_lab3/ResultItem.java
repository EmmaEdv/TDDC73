package com.example.emmaedv.tddc73_lab3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by emmaedv on 11/12/14.
 */
public class ResultItem extends View {
    String name;

    public ResultItem(Context context, String theName) {
        super(context);
        name = theName;
    }

    @Override
    protected void onDraw(Canvas canvas){

        Paint text = new Paint();
        text.setColor(Color.BLACK);
        text.setTextSize(50);

        Paint blue = new Paint();
        blue.setColor(Color.BLUE);
        canvas.drawPaint(blue);

        canvas.drawText(name, 10, 70, text);

    }

    @Override
    protected void onMeasure(int widthMeasure, int heightMeasure){
        int width = widthMeasure;
        int height = heightMeasure;

        setMeasuredDimension(width, height);
    }
}
