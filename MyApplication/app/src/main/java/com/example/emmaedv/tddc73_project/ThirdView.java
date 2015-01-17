package com.example.emmaedv.tddc73_project;

import android.content.Context;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class ThirdView extends LinearLayout{
    Context context;

    EditText testText;

    public ThirdView(Context theContext){
        super(theContext);
        context = theContext;
        this.setOrientation(VERTICAL);

        LinearLayout.LayoutParams layoutParams = (new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

        testText = new EditText(context);
//	        testText.addTextChangedListener(watcher);
        testText.setLayoutParams(layoutParams);
        testText.setText("tredje");
        addView(testText);
    }

}
