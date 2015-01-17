package com.example.emmaedv.tddc73_project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;


public class MainActivity extends Activity {
    LinearLayout linearLayout;
    LinearLayout contentLayout;
    LinearLayout buttonLayout;
    PasswordStrengthMeter passwordStrengthMeter;
    SecondView secondView;
    ThirdView thirdView;
    StepsLeft stepsLeft;
    Button next;
    Button prev;
    EditText userName;
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

        userName = new EditText(MainActivity.this);
        userName.setLayoutParams(layoutParams);
        userName.setText(R.string.userName);

        buttonLayout = new LinearLayout(this);
        buttonLayout.setOrientation(LinearLayout.HORIZONTAL);

        stepsLeft = new StepsLeft(this);

        passwordStrengthMeter = new PasswordStrengthMeter(this);
        secondView = new SecondView(this);
        thirdView = new ThirdView(this);

        prev = new Button(this);
        prev.setText("Föregående");
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Byt bakgrund och eventuellt text pÃ¥ steps left-objekten

                stepsLeft.decreaseStep();
                currentStep = stepsLeft.getStep();
                contentLayout.removeAllViews();
                checkCurrent(currentStep);
            }
        });

        next = new Button(this);
        next.setText("Nästa");
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
        contentLayout.addView(userName);
        contentLayout.addView(passwordStrengthMeter);

        linearLayout.addView(stepsLeft);
        linearLayout.addView(contentLayout);
        buttonLayout.addView(prev, buttonParams);
        buttonLayout.addView(next, buttonParams);
        linearLayout.addView(buttonLayout);
    }

    void checkCurrent (int step){
        switch(step){
            case 1:
                contentLayout.addView(userName);
                contentLayout.addView(passwordStrengthMeter);
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
