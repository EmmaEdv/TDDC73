package com.example.emmaedv.tddc73_project;

import android.content.Context;
import android.util.Log;
import android.widget.EditText;
import android.widget.LinearLayout;

public class FirstView extends LinearLayout {
    Context context;
    LinearLayout linearLayout;
    PasswordStrengthMeter passwordStrengthMeter;
    EditText userName;

    public FirstView(Context theContext){
        super(theContext);
        context = theContext;
        this.setOrientation(VERTICAL);
        Log.d("hej", "firstView");
        LinearLayout.LayoutParams layoutParams = (new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

        userName = new EditText(theContext);
        userName.setLayoutParams(layoutParams);
        userName.setText(R.string.userName);

        passwordStrengthMeter = new PasswordStrengthMeter(theContext);
        addView(userName);
        addView(passwordStrengthMeter);

    }
}