package com.example.emmaedv.tddc73_project;

/**
 * Created by emmaedv on 16/12/14.
 */
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;
import android.widget.ProgressBar;
import android.widget.TextView;

public class TextProgressBar extends ProgressBar implements TextProgressBarInterface {

    private String text;
    private int textColor = Color.BLACK;
    private float textSize = 30;

    public TextProgressBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //create an instance of class Paint, set color and font size
        Paint textPaint = new Paint();
        textPaint.setAntiAlias(true);
        textPaint.setColor(textColor);
        textPaint.setTextSize(textSize);
        //In order to show text in a middle, we need to know its size
        Rect bounds = new Rect();
        textPaint.getTextBounds(text, 0, text.length(), bounds);
        //Now we store font size in bounds variable and can calculate it's position
        int x = 0;//getWidth();// / 2 - bounds.centerX();
        int y = getHeight()/2+bounds.centerY();
        textPaint.setTextAlign(Paint.Align.LEFT);
        //drawing text with appropriate color and size in the center
        canvas.drawText(text, x, y, textPaint);
    }

    @Override
    public synchronized void setText(String text) {
        if (text != null) {
            this.text = text;
        } else {
            this.text = "";
        }
        postInvalidate();
    }

    @Override
    public void visualizeStrength(Pair<Integer, String> strengthPair){
        Log.i("Visualize Strength: ", "styrka: " + strengthPair.first);
        getProgressDrawable().setColorFilter(setStrengthColor(strengthPair.first), PorterDuff.Mode.SRC_IN);
        setProgress(strengthPair.first);
        setText(strengthPair.second);
    }

    @Override
    public int setStrengthColor(int strength){
        //Strength: 0-100%
        //Red: 0, yellow: 60, green: 120 -> 0-1.2*strength = 0-120
        float[] hsv = new float[3];
        hsv[0] = (float) (strength*1.2);
        hsv[1] = 100;
        hsv[2] = 100;
        Log.i("Color: ", "" + hsv[0]);
        return Color.HSVToColor(hsv);
    }
}
