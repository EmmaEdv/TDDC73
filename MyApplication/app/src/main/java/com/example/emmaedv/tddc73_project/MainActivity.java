package com.example.emmaedv.tddc73_project;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

import java.util.Arrays;
import java.util.List;


public class MainActivity extends Activity {
    LinearLayout linearLayout;
    LinearLayout contentLayout;
    LinearLayout buttonLayout;
    FirstView firstView;
    SecondView secondView;
    ThirdView thirdView;
    StepsLeft stepsLeft;
    Button next;
    Button prev;
    List<String> list = Arrays.asList("first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eight", "ninth", "tenth", "eleventh");

    int currentStep = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        linearLayout = new LinearLayout(this);
        contentLayout = new LinearLayout(this);

        LinearLayout.LayoutParams layoutParams = (new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        contentLayout.setLayoutParams(layoutParams);

        contentLayout.setOrientation(LinearLayout.VERTICAL);

        setContentView(linearLayout);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        buttonLayout = new LinearLayout(this);
        buttonLayout.setOrientation(LinearLayout.HORIZONTAL);

        //STEPS LEFT
        //To use default constructor:  stepsLeft = new StepsLeft(this);
        stepsLeft = new StepsLeft(this, 6, list);

        //VIEWS
        firstView = new FirstView(this);
        secondView = new SecondView(this);
        thirdView = new ThirdView(this);

        //PREVIOUS AND NEXT BUTTONS:
        prev = new Button(this);
        prev.setText("Previous");
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            stepsLeft.decreaseStep();
            currentStep = stepsLeft.getStep();
            contentLayout.removeAllViews();
            checkCurrent(currentStep);
            }
        });
        next = new Button(this);
        next.setText("Next");
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            stepsLeft.increaseStep();
            currentStep = stepsLeft.getStep();
            contentLayout.removeAllViews();
            checkCurrent(currentStep);
            }
        });

        LinearLayout.LayoutParams buttonParams = (new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT, 1));

        contentLayout.addView(firstView);
        linearLayout.addView(stepsLeft);
        linearLayout.addView(contentLayout);
        buttonLayout.addView(prev, buttonParams);
        buttonLayout.addView(next, buttonParams);
        linearLayout.addView(buttonLayout);
    }

    /**
     *  checkCurrent
     *  Adds the view for correct step
     * @param step - current step which is received by getStep function in StepsLeft
     */
    void checkCurrent (int step){
        switch(step){
            case 1:
                contentLayout.addView(firstView);
                break;
            case 2:
                contentLayout.addView(secondView);
                break;
            case 3:
                contentLayout.addView(thirdView);
                break;
        }
    }
}
