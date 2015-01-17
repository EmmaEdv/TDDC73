package com.example.emmaedv.tddc73_project;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.Log;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by emmaedv on 20/12/14.
 */
public class StepsLeft extends LinearLayout{
    Context context;
    ArrayList<String> stepNames;

    TextView leftStep;
    TextView centerStep;
    TextView rightStep;

    int shownTv = 3;
    int totalSteps = 5;
    int currentStep = 1;

    public StepsLeft(Context theContext) {
        super(theContext);
        context = theContext;
        this.setOrientation(HORIZONTAL);

        LinearLayout.LayoutParams layoutParams = (new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT, 1));

        /*GradientDrawable gd = new GradientDrawable();
        gd.setColor(0xFF00FF00);
        gd.setCornerRadius(0);
        gd.setStroke(1,0xFF000000);*/

        leftStep = new TextView(context);
        leftStep.setId(0);
        leftStep.setLayoutParams(layoutParams);
        leftStep.setBackgroundColor(Color.CYAN);
        //leftStep.setBackgroundResource(gd);
        //leftStep.setBackgroundResource(R.drawable.border_style);
        leftStep.setText("1/"+totalSteps);

        centerStep = new TextView(context);
        centerStep.setId(1);
        centerStep.setLayoutParams(layoutParams);
        centerStep.setBackgroundColor(Color.WHITE);
        //centerStep.setBackgroundResource(R.drawable.border_style);
        centerStep.setText("2/"+totalSteps);

        rightStep = new TextView(context);
        rightStep.setId(2);
        rightStep.setLayoutParams(layoutParams);
        rightStep.setBackgroundColor(Color.WHITE);
        //rightStep.setBackgroundResource(R.drawable.border_style);
        rightStep.setText("3/"+totalSteps);

        addView(leftStep);
        addView(centerStep);
        addView(rightStep);
    }

    //Funktion som håller koll på vilket steg vi är på och vilka som ska ändra färg & text
    void increaseStep(){
        currentStep = ((currentStep == totalSteps) ? totalSteps : (currentStep + 1));
        updateTextView(currentStep);
    }


    //Funktion som håller koll på vilket steg vi är på och vilka som ska ändra färg & text
    void decreaseStep(){
        currentStep = ((currentStep == 1) ? 1 : (currentStep - 1));
        updateTextView(currentStep);
    }

    //Funktion för att byta bakgrundsfärg
    void updateTextView(int cS){
        int tvId;
        TextView tv;
        //Komma åt den textvy som har id:t som skickas in, och ändra bakgrund på den textvyn...
        //OBS!! Om shown steps är annat än 3 så måste vi snygga till denna hallå! Hehe!
        //Om lägsta steget: aktivt steg är första
        if(cS == 1)
            tvId = 0;
        //Om varken lägsta eller högsta steget: aktivt steg är mittersta
        else if(cS>1 && cS<totalSteps)
            tvId = 1;
        //Om högsta steget: aktivt steg är sista
        else
            tvId = 2;

        switch (tvId) {
            case 0:
                tv = (TextView) findViewById(0);
                tv.setBackgroundColor(Color.CYAN);
                tv.setText(cS+"/"+totalSteps);

                tv = (TextView) findViewById(1);
                tv.setBackgroundColor(Color.WHITE);
                tv.setText((cS+1)+"/"+totalSteps);

                tv = (TextView) findViewById(2);
                tv.setBackgroundColor(Color.WHITE);
                tv.setText((cS+2)+"/"+totalSteps);

                break;

            case 1:
                tv = (TextView) findViewById(0);
                tv.setBackgroundColor(Color.WHITE);
                tv.setText((cS-1)+"/"+totalSteps);

                tv = (TextView) findViewById(1);
                tv.setBackgroundColor(Color.CYAN);
                tv.setText(cS+"/"+totalSteps);

                tv = (TextView) findViewById(2);
                tv.setBackgroundColor(Color.WHITE);
                tv.setText((cS+1)+"/"+totalSteps);

                break;

            case 2:
                tv = (TextView) findViewById(0);
                tv.setBackgroundColor(Color.WHITE);
                tv.setText((cS-2)+"/"+totalSteps);

                tv = (TextView) findViewById(1);
                tv.setBackgroundColor(Color.WHITE);
                tv.setText((cS-2)+"/"+totalSteps);

                tv = (TextView) findViewById(2);
                tv.setBackgroundColor(Color.CYAN);
                tv.setText(cS+"/"+totalSteps);

                break;
        }
    }
}
