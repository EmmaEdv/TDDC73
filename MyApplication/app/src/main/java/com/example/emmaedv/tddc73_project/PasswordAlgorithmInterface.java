package com.example.emmaedv.tddc73_project;

import android.util.Pair;

/**
 * An interface to create your own password algorithm.
 * The algorithm is created in the method checkStrength
 */
public interface PasswordAlgorithmInterface {
    /**
     * checkStrength contains the conditions and the rating of the password
     * @param password - the password to check strength of
     * @return Pair of Integer & String     The pair contains the strength in percent of the password
     *                                      and the word the strength represents
     */
    Pair<Integer, String> checkStrength(String password);
}
