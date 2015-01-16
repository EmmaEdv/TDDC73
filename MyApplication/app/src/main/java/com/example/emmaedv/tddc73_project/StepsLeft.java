package com.example.emmaedv.tddc73_project;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
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

    int totalSteps = 5;
    int currentStep;

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
        rightStep.setId(1);
        leftStep.setLayoutParams(layoutParams);
        leftStep.setBackgroundColor(Color.WHITE);
        //leftStep.setBackgroundResource(gd);
        //leftStep.setBackgroundResource(R.drawable.border_style);
        leftStep.setText("1/"+totalSteps);

        centerStep = new TextView(context);
        rightStep.setId(2);
        centerStep.setLayoutParams(layoutParams);
        centerStep.setBackgroundColor(Color.CYAN);
        //centerStep.setBackgroundResource(R.drawable.border_style);
        centerStep.setText("2/"+totalSteps);

        rightStep = new TextView(context);
        rightStep.setId(3);
        rightStep.setLayoutParams(layoutParams);
        rightStep.setBackgroundColor(Color.CYAN);
        //rightStep.setBackgroundResource(R.drawable.border_style);
        rightStep.setText("3/"+totalSteps);

        addView(leftStep);
        addView(centerStep);
        addView(rightStep);
    }

    //Funktion som håller koll på vilket steg vi är på och vilka som ska ändra färg & text
    void doStuff(){
        setBgColor();
        setStepText();
    }

    //Funktion för att byta bakgrundsfärg
    void setBgColor(int tvId){
        //Komma åt den textvy som har id:t som skickas in, och ändra bakgrund på den textvyn...
        tv.setBackgroundColor(Color.RED);
    }

    //En funktion för att byta text
    void setStepText(int tvId, int step){
        tv.setText(step+"/"+totalSteps);
    }
}
