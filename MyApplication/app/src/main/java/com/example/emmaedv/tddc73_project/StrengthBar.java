package com.example.emmaedv.tddc73_project;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by emmaedv on 16/12/14.
 */
public class StrengthBar extends ProgressBar {
    Context context;
    ProgressBar progressBar;
    TextView pwFeedback;

    public StrengthBar(Context theContext, AttributeSet attrs, int defStyleAttr){
        super(theContext, attrs, defStyleAttr);
        context = theContext;
        //LinearLayout.LayoutParams layoutParams = (new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        pwFeedback = new TextView(context);
        pwFeedback.setText(R.string.tooShort);
        pwFeedback.setTextAlignment(TEXT_ALIGNMENT_VIEW_END);
        //pwFeedback.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        progressBar = new ProgressBar(context, null, android.R.attr.progressBarStyleHorizontal);
        //progressBar.setLayoutParams(layoutParams);
    }

}