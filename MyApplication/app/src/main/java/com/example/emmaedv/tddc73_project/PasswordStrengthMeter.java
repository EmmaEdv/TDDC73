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

/**
 * PasswordStrengthMeter
 * @author
 * @author
 */
public class PasswordStrengthMeter extends LinearLayout {

    Context context;
    EditText passwordField;
    Button login;
    TextProgressBar textProgressBar;
    Pair<Integer, String> pwStrength;
    PasswordAlgorithmInterface pwAlgorithm;

    int pwLength = 12;
    int pwLevels = 7;
    List<String> levelFeedback = Arrays.asList("Too short", "Weak", "Mjeh", "Okay", "Good", "Strong", "Perfect");

    public PasswordStrengthMeter(Context theContext){
        super(theContext);
        context = theContext;
        this.setOrientation(VERTICAL);

        pwAlgorithm = new PasswordAlgorithm(pwLength, pwLevels, levelFeedback);
        //pwAlgorithm = new PasswordAlgorithm();

        LinearLayout.LayoutParams layoutParams = (new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

        passwordField = new EditText(context);
        passwordField.addTextChangedListener(watcher);
        passwordField.setLayoutParams(layoutParams);

        login = new Button(context);
        login.setLayoutParams(layoutParams);
        login.setText(R.string.logIn);

        textProgressBar = new TextProgressBar(context, null, android.R.attr.progressBarStyleHorizontal);
        textProgressBar.setText(getResources().getString(R.string.tooShort));

        addView(passwordField);
        addView(textProgressBar);
        addView(login);
    }

    public void setPasswordAlgorithm(PasswordAlgorithmInterface pwAlgo){
        pwAlgorithm = pwAlgo;
    }

    TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int start, int before, int count) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
            Log.i("onTextChanged", "");
            String password = charSequence.toString();
            pwStrength = pwAlgorithm.checkStrength(password);
            textProgressBar.visualizeStrength(pwStrength);
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
}
