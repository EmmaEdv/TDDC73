package com.example.emmaedv.tddc73_project;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;
import android.widget.ProgressBar;

/**
 * TextProgressBar is a component which includes a progressbar and a string
 * The progressbar is used to show strength of a password
 * The string will provide the user feedback of how good the password is
 *
 * @author Johan Dagvall & Emma Edvardsson
 */
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
        //To set color and font size:
        Paint textPaint = new Paint();
        textPaint.setAntiAlias(true);
        textPaint.setColor(textColor);
        textPaint.setTextSize(textSize);

        // To know the size of the text (useful to position the text)
        Rect bounds = new Rect();
        textPaint.getTextBounds(text, 0, text.length(), bounds);
        int x = 0;
        int y = getHeight()/2+bounds.centerY();
        textPaint.setTextAlign(Paint.Align.LEFT);

        //Draw text with chosen color and size and alignment
        canvas.drawText(text, x, y, textPaint);
    }

    /**
     * Set the text of the text progress bar
     * @param text
     */
    public synchronized void setText(String text) {
        if (text != null) {
            this.text = text;
        } else {
            this.text = "";
        }
        postInvalidate();
    }

    /**
     * Method to visualize the strength of a password
     * @param strengthPair
     */
    public void visualizeStrength(Pair<Integer, String> strengthPair){
        //Set the color of the bar by using the method setStrengthColor
        getProgressDrawable().setColorFilter(setStrengthColor(strengthPair.first), PorterDuff.Mode.SRC_IN);
        setProgress(strengthPair.first);
        setText(strengthPair.second);
    }

    @Override
    /**
     * Set the strengthColor.
     * We use a range from red to green
     */
    public int setStrengthColor(int strength){
        //Strength: 0-100%
        //Red: 0, yellow: 60, green: 120 -> 0-1.2*strength = 0-120
        float[] hsv = new float[3];
        hsv[0] = (float) (strength*1.2);
        hsv[1] = 100;
        hsv[2] = 100;
        //Log.i("Color: ", "" + hsv[0]);
        return Color.HSVToColor(hsv);
    }
}
