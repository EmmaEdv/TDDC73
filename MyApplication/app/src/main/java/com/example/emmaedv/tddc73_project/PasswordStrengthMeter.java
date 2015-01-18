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
        LinearLayout.LayoutParams barParams = (new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, 100));
        LinearLayout.LayoutParams passParams = (new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

        passwordField = new EditText(context);
        passwordField.addTextChangedListener(watcher);
        passwordField.setLayoutParams(passParams);
        textProgressBar = new TextProgressBar(context, null, android.R.attr.progressBarStyleHorizontal);
        textProgressBar.setText(getResources().getString(R.string.tooShort));
        textProgressBar.setLayoutParams(barParams);

        addView(passwordField);
        addView(textProgressBar);
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