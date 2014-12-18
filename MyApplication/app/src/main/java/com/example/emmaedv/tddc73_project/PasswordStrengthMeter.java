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
 * Created by emmaedv on 15/12/14.
 */
public class PasswordStrengthMeter extends LinearLayout{

    Context context;
    EditText userName;
    EditText passwordField;
    Button login;
    TextProgressBar textProgressBar;
    Pair<Integer, String> pwStrength;
    int pwLength = 12;
    int pwLevels = 7;
    PasswordAlgorithm pwAlgorithm;
    List<String> levelFeedback = Arrays.asList("Too short", "Weak", "Mjeh", "Okay", "Good", "Strong", "Perfect");

    public PasswordStrengthMeter(Context theContext){
        super(theContext);
        context = theContext;
        this.setOrientation(VERTICAL);

        pwAlgorithm = new PasswordAlgorithm(pwLength, pwLevels, levelFeedback);
        //pwAlgorithm = new PasswordAlgorithm();

        LinearLayout.LayoutParams layoutParams = (new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

        userName = new EditText(context);
        userName.setLayoutParams(layoutParams);
        userName.setText(R.string.userName);

        passwordField = new EditText(context);
        passwordField.addTextChangedListener(watcher);
        passwordField.setLayoutParams(layoutParams);

        login = new Button(context);
        login.setLayoutParams(layoutParams);
        login.setText(R.string.logIn);

        textProgressBar = new TextProgressBar(context, null, android.R.attr.progressBarStyleHorizontal);
        textProgressBar.setText(getResources().getString(R.string.tooShort));

        addView(userName);
        addView(passwordField);
        addView(textProgressBar);
        addView(login);
    }

    public void setPasswordAlgorithm(PasswordAlgorithm pwAlgo){
        pwAlgorithm = pwAlgo;
    }

    TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int start, int before, int count) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
            Log.e("onTextChanged", "");
            String password = charSequence.toString();
            pwStrength = pwAlgorithm.checkStrength(password);
            textProgressBar.visualizeStrength(pwStrength);
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
}