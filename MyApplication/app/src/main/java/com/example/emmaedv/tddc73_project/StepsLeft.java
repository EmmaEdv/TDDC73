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
    TextView header, step;
    List<String> headers;

    int shownSteps, even, totalSteps, centerSlot;

    int currentStep = 1;
    int counter = 1;
    int activeSlot = 0;

    public StepsLeft(Context theContext) {
        super(theContext);
        context = theContext;
        this.setOrientation(VERTICAL);

        headers = Arrays.asList("Första", "Andra", "Tredje", "Fjärde", "Femte", "Sjätte", "Sjunde", "Åttånde", "Nionde");
        shownSteps = 8;
        totalSteps = 9;

        even = shownSteps%2;
        centerSlot = shownSteps/2;

        stepLayout = new LinearLayout(context);
        stepLayout.setOrientation(HORIZONTAL);

        LinearLayout.LayoutParams layoutParams = (new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT, 1));

        for(int i = 0; i<shownSteps; i++) {
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

    public StepsLeft(Context theContext, int vS, int tS, List<String> headerList) {
        super(theContext);
        context = theContext;
        this.setOrientation(VERTICAL);

        headers = headerList;
        shownSteps = vS;
        totalSteps = tS;

        even = shownSteps%2;
        centerSlot = shownSteps/2;

        stepLayout = new LinearLayout(context);
        stepLayout.setOrientation(HORIZONTAL);

        LinearLayout.LayoutParams layoutParams = (new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT, 1));

        for(int i = 0; i<shownSteps; i++) {
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

    //Funktion som ökar steg
    protected void increaseStep(){
        currentStep = ((currentStep == totalSteps) ? totalSteps : (currentStep + 1));
        updateTextView(currentStep, true);
        header.setText(headers.get(currentStep-1));
    }

    //Funktion som minskar steg
    protected void decreaseStep(){
        currentStep = ((currentStep == 1) ? 1 : (currentStep - 1));
        updateTextView(currentStep, false);
        header.setText(headers.get(currentStep-1));
    }

    //Funktion för att uppdatera färg och text på steg
    private void updateTextView(int cS, Boolean increase){
        TextView tv;

        switch (even){
            //Om jämnt antal steg
            case 0:
                //SET ACTIVE SLOT:
                //Första är aktiv
                if(counter <= (totalSteps-shownSteps)){
                    counter = (increase ? counter+1 : counter-1);
                    activeSlot = 0;
                    //Log.i("Första", "Counter: " + counter + " activeSlot: " + activeSlot);
                }
                //Någon av de mellersta är aktiva
                else if(counter > (totalSteps-shownSteps) && counter < totalSteps){
                    if(increase){
                        activeSlot++;
                        counter++;
                    }
                    else {
                        activeSlot = (counter <= totalSteps-shownSteps ? 0 : activeSlot-1);
                        counter--;
                        if(activeSlot<0) activeSlot = 0;
                    }
                    //Log.i("Mellersta", "Counter: " + counter + " activeSlot: " + activeSlot);
                }
                //Sista slotten är aktiv
                else{// if(counter >= totalSteps){
                    if(increase){
                        counter = totalSteps;
                        activeSlot = shownSteps-1;
                    }
                    else{
                        counter--;
                        activeSlot--;
                    }
                    //Log.i("Sista", "Counter: " + counter + " activeSlot: " + activeSlot);
                }

                for(int i = 0; i<shownSteps; i++){
                    tv = (TextView) findViewById(i);
                    tv.setBackgroundColor(((i == activeSlot) ? Color.CYAN : Color.WHITE));
                    tv.setText( (i == activeSlot ? cS : (cS-activeSlot+i)) +"/"+totalSteps);
                }

                break;

            //Om udda antal steg
            case 1:
                //SET ACTIVE SLOT:
                //Någon av de första är aktiva
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
                    //Log.i("Första", "Counter: " + counter + " activeSlot: " + activeSlot);
                }

                //Någon av de sista är aktiva
                else if(counter >= (totalSteps-centerSlot)){
                    if(increase){
                        counter++;
                        activeSlot = ((counter == totalSteps-shownSteps+centerSlot) ? shownSteps-1 : activeSlot+1);
                    }
                    else{
                        counter--;
                        activeSlot = (counter <= totalSteps-centerSlot ? centerSlot : activeSlot-1);
                    }
                    //Så att den stannar på högsta steget och inte går vidare
                    if (activeSlot > shownSteps-1) activeSlot = shownSteps-1;
                    if (counter > totalSteps) counter = totalSteps;
                    //Log.i("Sista", "Counter: " + counter + " activeSlot: " + activeSlot);
                }

                //Den mellersta är aktiv
                else{// if(counter >= (centerSlot) && counter <= (totalSteps-shownSteps+centerSlot)){
                    counter = (increase ? counter+1 : counter-1);
                    activeSlot = (counter > centerSlot ? centerSlot : activeSlot-1);
                    //Log.i("mellersta", "Counter: " + counter + " activeSlot: " + activeSlot);
                }

                for(int i = 0; i<shownSteps; i++){
                    tv = (TextView) findViewById(i);
                    tv.setBackgroundColor(((i == activeSlot) ? Color.CYAN : Color.WHITE));
                    tv.setText( (i == activeSlot ? cS : (cS-activeSlot+i)) +"/"+totalSteps);
                }
                break;
        }
    }

    public int getStep() {
        return currentStep;
    }
}
