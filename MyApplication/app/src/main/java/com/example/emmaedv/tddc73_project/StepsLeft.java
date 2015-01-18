package com.example.emmaedv.tddc73_project;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

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

    static int shownTv = 5;
    static int even = shownTv%2;
    static int totalSteps = 9;
    static int centerSlot = shownTv/2;

    int currentStep = 1;
    int counter = 1;
    int activeSlot = 0;
    int prevSlot = 0;
    List<String> headers = Arrays.asList("Första", "Andra", "Tredje", "Fjärde", "Femte", "Sjätte", "Sjunde", "Åttånde", "Nionde");

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
        updateTextView(currentStep, true);
        header.setText(headers.get(currentStep-1));
    }


    //Funktion som håller koll på vilket steg vi är på och vilka som ska ändra färg & text
    void decreaseStep(){
        currentStep = ((currentStep == 1) ? 1 : (currentStep - 1));
        updateTextView(currentStep, false);
        header.setText(headers.get(currentStep-1));
    }

    //Funktion för att byta bakgrundsfärg
    void updateTextView(int cS, Boolean increase){
        TextView tv;
/*
        int tvId;
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
                tv.setText((cS-1)+"/"+totalSteps);

                tv = (TextView) findViewById(2);
                tv.setBackgroundColor(Color.CYAN);
                tv.setText(cS+"/"+totalSteps);

                break;
        }*/

        switch (even){
            case 0:
                //SET ACTIVE SLOT:
                //Första slotten är aktiv
                if(counter < (totalSteps-shownTv)){
                    counter++;
                    activeSlot = 0;
                }
                //Någon av de mellersta är aktiva
                else if(counter >= (totalSteps-shownTv) && counter < totalSteps){
                    activeSlot++;
                    counter++;
                }
                //Sista slotten är aktiv
                else{// if(counter >= totalSteps){
                    counter=totalSteps;
                    activeSlot = shownTv-1;
                }
                Log.i("Jämn","Active slot: " + activeSlot);
                for(int i = 0; i<shownTv; i++){
                    tv = (TextView) findViewById(i);
                    tv.setBackgroundColor(((i==activeSlot)?Color.GREEN:Color.WHITE));
                    tv.setText(cS+"/"+totalSteps);
                }

                break;

            case 1:
                //SET ACTIVE SLOT:
                //Någon av de första är aktiva
                prevSlot = activeSlot;
                if(counter < centerSlot){
                    if(increase){
                        counter++;
                        activeSlot++;
                    }
                    else{
                        counter--;
                        activeSlot--;
                    }

                    if(counter<1) counter=1;
                    if(activeSlot<0) activeSlot=0;
                    Log.i("Första", "Counter: " + counter + " activeSlot: " + activeSlot);
                }

                //Någon av de sista är aktiva
                else if(counter >= (totalSteps-centerSlot)){
                    if(increase){
                        counter++;
                        activeSlot = ((counter == totalSteps-shownTv+centerSlot) ? shownTv-1 : activeSlot+1);
                    }
                    else{
                        counter--;
                        activeSlot = (counter <= totalSteps-centerSlot ? centerSlot : activeSlot-1);
                    }
                    //Så att den stannar på högsta steget och inte går vidare
                    if (activeSlot > shownTv-1) activeSlot = shownTv-1;
                    if (counter > totalSteps) counter = totalSteps;
                    Log.i("Sista", "Counter: " + counter + " activeSlot: " + activeSlot);
                }

                //Den mellersta är aktiv
                else{// if(counter >= (centerSlot) && counter <= (totalSteps-shownTv+centerSlot)){
                    counter = (increase ? counter+1 : counter-1);
                    activeSlot = (counter > centerSlot ? centerSlot : activeSlot-1);
                    Log.i("mellersta", "Counter: " + counter + " activeSlot: " + activeSlot);
                }

                for(int i = 0; i<shownTv; i++){
                    tv = (TextView) findViewById(i);
                    tv.setBackgroundColor(((i==activeSlot) ? Color.CYAN : Color.WHITE));
                    tv.setText( (i == activeSlot ? cS : (cS-activeSlot+i)) +"/"+totalSteps);
                }
                break;
        }
    }

    public int getStep() {
        return currentStep;
    }
}
