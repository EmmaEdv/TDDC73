package com.example.emmaedv.tddc73_project;

import android.util.Log;
import android.util.Pair;

import java.util.Arrays;
import java.util.List;

/**
 * Created by emmaedv on 17/12/14.
 */
public class PasswordAlgorithm {
    static int maxStrength = 100;
    int minLength;
    int pwStrength;
    int strengthLevels;
    List<String> pwFeedback;

    public PasswordAlgorithm(){
        minLength = 8;
        strengthLevels = 5;
        pwFeedback = Arrays.asList("Too short", "Weak", "Okay", "Good", "Strong");
    }

    public PasswordAlgorithm(int length, int levels, List<String> feedback){
        minLength = length;
        strengthLevels = levels;
        pwFeedback = feedback;
    }

    public Pair<Integer, String> checkStrength(String password){
        boolean hasUpperCase = !password.equals(password.toLowerCase());
        boolean hasLowerCase = !password.equals(password.toUpperCase());
        boolean hasSpecialChars = !password.matches("[A-Za-z0-9 ]*");
        boolean hasNumbers = password.matches(".*\\d+.*");

        int length = 0, upperC = 0, lowerC = 0, symbols = 0, numbers = 0;
        int nrOfConditions = 6;

        if(password.length()<minLength) {
            length = 0;
            upperC = (hasUpperCase) ? maxStrength/nrOfConditions : 0;
            lowerC = (hasLowerCase) ? maxStrength/nrOfConditions : 0;
            symbols = (hasSpecialChars) ? maxStrength/nrOfConditions : 0;
            numbers = (hasNumbers) ? maxStrength/nrOfConditions : 0;
        }
        else {
            upperC = (hasUpperCase) ? maxStrength/nrOfConditions : 0;
            lowerC = (hasLowerCase) ? maxStrength/nrOfConditions : 0;
            symbols = (hasSpecialChars) ? maxStrength/nrOfConditions : 0;
            numbers = (hasNumbers) ? maxStrength/nrOfConditions : 0;
            length = (password.length()>=minLength) ? (password.length()>minLength ? 2*maxStrength/nrOfConditions : maxStrength/nrOfConditions) : 0;
        }
        Log.e("Total: " + pwStrength + ", Uppercase: " + upperC + " Lowercase: " + lowerC + ", Symbols: " + symbols, "numbers " + numbers + " length: " + length);
        pwStrength = length+upperC+lowerC+symbols+numbers;

        int wordPos = (int) Math.round((strengthLevels-1)*(pwStrength*0.01));

        return new Pair(pwStrength, pwFeedback.get(wordPos));
    }
}
