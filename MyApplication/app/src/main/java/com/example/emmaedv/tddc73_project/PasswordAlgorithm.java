package com.example.emmaedv.tddc73_project;

import android.util.Log;
import android.util.Pair;

import java.util.Arrays;
import java.util.List;

/**
 * PasswordAlgorithm sets the algorithm which measures the strength of a password.
 * @author Johan Dagvall & Emma Edvardsson
 */
public class PasswordAlgorithm implements PasswordAlgorithmInterface {
    //Max strength: 100%
    static int maxStrength = 100;
    int minLength;
    int pwStrength;
    int strengthLevels;
    List<String> pwFeedback;

    /**
     * Default constructor
     * Uses 8 characters as minimum length of password
     * 5 levels of strenght and the following feedback: "Too short", "Weak", "Okay", "Good", "Strong"
     */
    public PasswordAlgorithm(){
        minLength = 8;
        strengthLevels = 5;
        pwFeedback = Arrays.asList("Too short", "Weak", "Okay", "Good", "Strong");
    }

    /**
     * Customizable constructor
     * @param length - minimum length of password
     * @param feedback - list with feedback strings, from which the number of feedback levels is extracted
     */
    public PasswordAlgorithm(int length, List<String> feedback){
        minLength = length;
        pwFeedback = feedback;
        strengthLevels = pwFeedback.size();
    }

    /**
     * checkStrength contains the conditions and the rating of the password
     * @param password                      the password
     * @return Pair of Integer & String     The pair contains the strength in percent of the password
     */
    @Override
    public Pair<Integer, String> checkStrength(String password){
        //The password is strongest if following conditions are met:
        //has length == minLength, has length > minLength, has uppercase, has lowercase, has special characters and has numbers
        int nrOfConditions = 6;

        boolean hasUpperCase = !password.equals(password.toLowerCase());
        boolean hasLowerCase = !password.equals(password.toUpperCase());
        boolean hasSpecialChars = !password.matches("[A-Za-z0-9 ]*");
        boolean hasNumbers = password.matches(".*\\d+.*");

        //Default values of the conditions
        int length = 0, upperC = 0, lowerC = 0, symbols = 0, numbers = 0;

        //If password is too short:
        if(password.length()<minLength) {
            length = 0;
            //maxStrength/nrOfConditions will give a value in percent
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
            //To reach 100% strong password length: have a long enough password!
            length = (password.length()>=minLength) ? (password.length()>minLength ? 2*maxStrength/nrOfConditions : maxStrength/nrOfConditions) : 0;
        }
        //Log.i("Total: " + pwStrength + ", Uppercase: " + upperC + " Lowercase: " + lowerC + ", Symbols: " + symbols, "numbers " + numbers + " length: " + length);

        //Sum the password conditions
        pwStrength = length+upperC+lowerC+symbols+numbers;

        //Get position for list of feedback
        int wordPos = (int) Math.round((strengthLevels-1)*(pwStrength*0.01));

        //Return the strength in percent and the feedback word
        return new Pair(pwStrength, pwFeedback.get(wordPos));
    }
}
