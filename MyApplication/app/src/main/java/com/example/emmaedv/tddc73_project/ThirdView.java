package com.example.emmaedv.tddc73_project;

import android.content.Context;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * ThirdView contains a text field
 *
 * @author Johan Dagvall & Emma Edvardsson
 */
public class ThirdView extends LinearLayout{
    Context context;
    EditText testText;

    public ThirdView(Context theContext){
        super(theContext);
        context = theContext;
        this.setOrientation(VERTICAL);

        LinearLayout.LayoutParams layoutParams = (new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

        testText = new EditText(context);
        testText.setLayoutParams(layoutParams);
        testText.setText("Tredje");
        addView(testText);
    }

}
