package com.example.emmaedv.tddc73_project;

import android.content.Context;
import android.util.Log;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * SecondView contains a text field
 *
 * @author Johan Dagvall & Emma Edvardsson
 */
public class SecondView extends LinearLayout {
    Context context;
    EditText testText;

    public SecondView(Context theContext){
        super(theContext);
        context = theContext;
        this.setOrientation(VERTICAL);

        LinearLayout.LayoutParams layoutParams = (new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

        testText = new EditText(context);
        testText.setLayoutParams(layoutParams);
        testText.setText("Andra");
        addView(testText);
    }

}
