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
 * PasswordStrengthMeter contains a TextProgressBar and a text field to enter a password
 * @author Johan Dagvall & Emma Edvardsson
 */
public class PasswordStrengthMeter extends LinearLayout {
    Context context;

    EditText passwordField;
    TextProgressBar textProgressBar;
    Pair<Integer, String> pwStrength;
    PasswordAlgorithmInterface pwAlgorithm;
    int pwLength = 12;
    List<String> levelFeedback = Arrays.asList("Too short", "Weak", "Mjeh", "Okay", "Good", "Strong", "Perfect");
    int pwLevels = levelFeedback.size();

    /**
     * Constructor
     * @param theContext
     */
    public PasswordStrengthMeter(Context theContext){
        super(theContext);
        context = theContext;
        this.setOrientation(VERTICAL);
        //Default constructor:  pwAlgorithm = new PasswordAlgorithm();
        pwAlgorithm = new PasswordAlgorithm(pwLength, levelFeedback);
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

    /**
     * Method to set the passwordAlgorithm
     * @param pwAlgo
     */
    public void setPasswordAlgorithm(PasswordAlgorithmInterface pwAlgo){
        pwAlgorithm = pwAlgo;
    }

    /**
     * A textWatcher to update the textProgressBar when the password changes
     */
    TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int start, int before, int count) {
        }
        @Override
        public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
            //Log.i("onTextChanged", "");
            //The password is extracted from the character sequence
            String password = charSequence.toString();
            //Send password to the algorithm to get the strength
            pwStrength = pwAlgorithm.checkStrength(password);
            //Visualize the strength
            textProgressBar.visualizeStrength(pwStrength);
        }
        @Override
        public void afterTextChanged(Editable editable) {
        }
    };
}