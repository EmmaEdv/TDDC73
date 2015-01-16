package com.example.emmaedv.tddc73_project;

import android.util.Pair;

/**
 * Created by emmaedv on 15/01/15.
 */
public interface TextProgressBarInterface {
    void setText(String text);

    void visualizeStrength(Pair<Integer, String> strengthPair);

    int setStrengthColor(int strength);
}
