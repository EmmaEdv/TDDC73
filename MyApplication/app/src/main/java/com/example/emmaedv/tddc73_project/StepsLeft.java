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
 * StepsLeft: Shows how far a user has come when filling in data over multiple steps
 * @author Johan Dagvall & Emma Edvardsson
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

    /**
     * Default constructor
     * Shows 5 steps out of 9
     **/
    public StepsLeft(Context theContext) {
        super(theContext);
        context = theContext;
        this.setOrientation(VERTICAL);

        headers = Arrays.asList("First", "Second", "Third", "Fourth", "Fifth", "Sixth", "Seventh", "Eight", "Ninth");
        shownSteps = 5;
        totalSteps = headers.size();

        even = shownSteps%2;
        centerSlot = shownSteps/2;

        stepLayout = new LinearLayout(context);
        stepLayout.setOrientation(HORIZONTAL);

        LinearLayout.LayoutParams layoutParams = (new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT, 1));

        //Dynamically create and add the correct number of steps.
        for(int i = 0; i<shownSteps; i++) {
            step = new TextView(context);
            step.setId(i);
            step.setLayoutParams(layoutParams);
            step.setBackgroundColor(i == 0 ? Color.CYAN : Color.WHITE);
            step.setText((i+1)+"/" + totalSteps);
            stepLayout.addView(step);
        }
        addView(stepLayout);

        //Set and add the header text
        header = new TextView(context);
        header.setText(headers.get(0));
        header.setTextSize(20);
        header.setGravity(1);
        addView(header);
    }

    /**
     * Constructor where user can set number of visual steps and headers
     *
     * @param theContext
     * @param visualSteps - number of shown steps
     * @param headerList - list of headers. Number of total steps is extracted from size of list
     */
    public StepsLeft(Context theContext, int visualSteps, List<String> headerList) {
        super(theContext);
        context = theContext;
        this.setOrientation(VERTICAL);

        headers = headerList;
        shownSteps = visualSteps;
        totalSteps = headers.size();

        even = shownSteps%2;
        centerSlot = shownSteps/2;

        stepLayout = new LinearLayout(context);
        stepLayout.setOrientation(HORIZONTAL);

        LinearLayout.LayoutParams layoutParams = (new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT, 1));

        //Dynamically create and add the correct number of steps.
        for(int i = 0; i<shownSteps; i++) {
            step = new TextView(context);
            step.setId(i);
            step.setLayoutParams(layoutParams);
            step.setBackgroundColor(i == 0 ? Color.CYAN : Color.WHITE);
            step.setText((i+1)+"/" + totalSteps);
            stepLayout.addView(step);
        }
        addView(stepLayout);

        //Set and add the header text
        header = new TextView(context);
        header.setText(headers.get(0));
        header.setTextSize(20);
        header.setGravity(1);
        addView(header);
    }

    /**
     * Method called when user wants to increase the step
     */
    protected void increaseStep(){
        //If at the last step, stay at last step otherwise increase
        currentStep = ((currentStep == totalSteps) ? totalSteps : (currentStep + 1));
        //Call updateTextView function
        updateTextView(currentStep, true);
        //Set the header
        header.setText(headers.get(currentStep-1));
    }

    /**
     * Method called when user wants to decrease the step
     */
    protected void decreaseStep(){
        //If at the first step, stay at first step otherwise decrease
        currentStep = ((currentStep == 1) ? 1 : (currentStep - 1));
        //Call updateTextView function
        updateTextView(currentStep, false);
        //Set the header
        header.setText(headers.get(currentStep-1));
    }

    /**
     * Updates the text views with correct background color and text
     * @param cS - current step
     * @param increase - true if increase, false if decrease
     */
    private void updateTextView(int cS, Boolean increase){
        TextView tv;

        switch (even){
            //Case 0: Even number of shown steps
            case 0:
                //Set the active step

                //First step is active
                if(counter <= (totalSteps-shownSteps)){
                    counter = (increase ? counter+1 : counter-1);
                    activeSlot = 0;
                }
                //Step between first and last is active
                else if(counter > (totalSteps-shownSteps) && counter < totalSteps){
                    if(increase){
                        activeSlot++;
                        counter++;
                    }
                    else {
                        activeSlot = (counter <= totalSteps-shownSteps ? 0 : activeSlot-1);
                        counter--;
                        //Just to make sure we're not making activeSlot negative
                        if(activeSlot<0) activeSlot = 0;
                    }
                }
                //Last step is active
                else{// if(counter >= totalSteps){
                    if(increase){
                        counter = totalSteps;
                        activeSlot = shownSteps-1;
                    }
                    else{
                        counter--;
                        activeSlot--;
                    }
                }

                //Set the correct background color and text to each text view
                for(int i = 0; i<shownSteps; i++){
                    tv = (TextView) findViewById(i);
                    tv.setBackgroundColor(((i == activeSlot) ? Color.CYAN : Color.WHITE));
                    tv.setText( (i == activeSlot ? cS : (cS-activeSlot+i)) +"/"+totalSteps);
                }

                break;

            //Case 1: Odd number of steps
            case 1:
                //Set the active step
                //First until middle steps are active
                if(counter < centerSlot){
                    if(increase){
                        counter++;
                        activeSlot++;
                    }
                    else{
                        counter--;
                        activeSlot--;
                    }

                    //Don't decrease if at first step
                    if(counter<1) counter=1;
                    if(activeSlot<0) activeSlot=0;
                }

                //Last until middle steps are active
                else if(counter >= (totalSteps-centerSlot)){
                    if(increase){
                        counter++;
                        activeSlot = ((counter == totalSteps-shownSteps+centerSlot) ? shownSteps-1 : activeSlot+1);
                    }
                    else{
                        counter--;
                        activeSlot = (counter <= totalSteps-centerSlot ? centerSlot : activeSlot-1);
                    }
                    //Don't increase if at highest step
                    if (activeSlot > shownSteps-1) activeSlot = shownSteps-1;
                    if (counter > totalSteps) counter = totalSteps;
                }

                //Middle slot is active
                else{// if(counter >= (centerSlot) && counter <= (totalSteps-shownSteps+centerSlot)){
                    counter = (increase ? counter+1 : counter-1);
                    activeSlot = (counter > centerSlot ? centerSlot : activeSlot-1);
                }

                //Set the correct background color and text to each text view
                for(int i = 0; i<shownSteps; i++){
                    tv = (TextView) findViewById(i);
                    tv.setBackgroundColor(((i == activeSlot) ? Color.CYAN : Color.WHITE));
                    tv.setText( (i == activeSlot ? cS : (cS-activeSlot+i)) +"/"+totalSteps);
                }
                break;
        }
    }

    /**
     * Method to get which step is the current.
     * @return curentStep
     */
    public int getStep() {
        return currentStep;
    }
}
