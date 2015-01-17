package com.example.emmaedv.tddc73_project;

import android.content.Context;
import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

/**
 * Created by emmaedv on 20/12/14.
 */
public class StepsLeft extends LinearLayout{
    Context context;

    LinearLayout stepLayout;
    TextView header;
    TextView step;

    List<String> headers = Arrays.asList("Första", "Andra", "Tredje", "Fjärde", "Femte");
    int shownTv = 5;
    int totalSteps = 5;
    int currentStep = 1;

    public StepsLeft(Context theContext) {
        super(theContext);
        context = theContext;
        this.setOrientation(VERTICAL);

        stepLayout = new LinearLayout(context);
        stepLayout.setOrientation(HORIZONTAL);

        LinearLayout.LayoutParams layoutParams = (new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT, 1));

        /*GradientDrawable gd = new GradientDrawable();
        gd.setColor(0xFF00FF00);
        gd.setCornerRadius(0);
        gd.setStroke(1,0xFF000000);*/

        for(int i = 0; i<shownTv; i++) {
            step = new TextView(context);
            step.setId(i);
            step.setLayoutParams(layoutParams);
            step.setBackgroundColor(i == 0 ? Color.CYAN : Color.WHITE);
            step.setText((i+1)+"/" + totalSteps);
            stepLayout.addView(step);
        }
        addView(stepLayout);

        //Rubrik för stegen
        header = new TextView(context);
        header.setText(headers.get(0));
        header.setTextSize(20);
        header.setGravity(1);
        addView(header);
    }

    //Funktion som håller koll på vilket steg vi är på och vilka som ska ändra färg & text
    void increaseStep(){
        currentStep = ((currentStep == totalSteps) ? totalSteps : (currentStep + 1));
        updateTextView(currentStep);
        header.setText(headers.get(currentStep-1));
    }


    //Funktion som håller koll på vilket steg vi är på och vilka som ska ändra färg & text
    void decreaseStep(){
        currentStep = ((currentStep == 1) ? 1 : (currentStep - 1));
        updateTextView(currentStep);
        header.setText(headers.get(currentStep-1));
    }

    //Funktion för att byta bakgrundsfärg
    void updateTextView(int cS){
        int tvId;
        TextView tv;
        //OBS!! Om shown steps är annat än 3 så måste vi snygga till denna hallå! Hehe!
        //Om lägsta steget: aktivt steg är första
        //tvId = ((cS==1) ? 1 : ((cS == totalSteps) ? shownTv : ));

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
                tv.setText((cS-1)+"/"+totalSteps);

                tv = (TextView) findViewById(2);
                tv.setBackgroundColor(Color.CYAN);
                tv.setText(cS+"/"+totalSteps);

                break;
        }
    }

    public int getStep() {
        return currentStep;
    }
}
