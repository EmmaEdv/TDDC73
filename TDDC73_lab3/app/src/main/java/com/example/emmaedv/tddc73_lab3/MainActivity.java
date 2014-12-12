package com.example.emmaedv.tddc73_lab3;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

    InteractiveSearcher interactiveSearcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        interactiveSearcher = new InteractiveSearcher(this);

        setContentView(interactiveSearcher);
    }

}