package com.example.emmaedv.tddc73_project;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


public class MainActivity extends Activity {
    LinearLayout linearLayout;
    LinearLayout buttonLayout;
    PasswordStrengthMeter passwordStrengthMeter;
    StepsLeft stepsLeft;
    Button next;
    Button prev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        linearLayout = new LinearLayout(this);
        setContentView(linearLayout);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        buttonLayout = new LinearLayout(this);
        buttonLayout.setOrientation(LinearLayout.HORIZONTAL);

        stepsLeft = new StepsLeft(this);
        linearLayout.addView(stepsLeft);

        passwordStrengthMeter = new PasswordStrengthMeter(this);
        linearLayout.addView(passwordStrengthMeter);

        prev = new Button(this);
        prev.setText("Föregående");
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Byt bakgrund och eventuellt text på steps left-objekten
                stepsLeft.doStuff();
            }
        });

        next = new Button(this);
        next.setText("Nästa");
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Byt bakgrund och eventuellt text på steps left-objekten
                stepsLeft.doStuff();
            }
        });

        LinearLayout.LayoutParams layoutParams = (new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT, 1));

        buttonLayout.addView(prev, layoutParams);
        buttonLayout.addView(next, layoutParams);

        linearLayout.addView(buttonLayout);
    }
}
