package com.example.emmaedv.tddc73_lab3;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

    InteractiveSearcher interactiveSearcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("onCreate", "");
        interactiveSearcher = new InteractiveSearcher(this);

        setContentView(interactiveSearcher);
    }

}