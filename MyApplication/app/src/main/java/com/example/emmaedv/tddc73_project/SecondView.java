package com.example.emmaedv.tddc73_project;

import android.content.Context;
import android.graphics.PorterDuff;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Pair;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.Arrays;
import java.util.List;

public class SecondView extends LinearLayout {

    Context context;

    EditText testText;

    public SecondView(Context theContext){
        super(theContext);
        context = theContext;
        this.setOrientation(VERTICAL);

        LinearLayout.LayoutParams layoutParams = (new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

        testText = new EditText(context);
//        testText.addTextChangedListener(watcher);
        testText.setLayoutParams(layoutParams);
        testText.setText("andra");
        addView(testText);
    }

}
