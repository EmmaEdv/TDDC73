package com.example.emmaedv.tddc73_project;

import android.util.Pair;

/**
 * Created by emmaedv on 18/12/14.
 */
public interface PasswordAlgorithmInterface {
    Pair<Integer, String> checkStrength(String password);
}
