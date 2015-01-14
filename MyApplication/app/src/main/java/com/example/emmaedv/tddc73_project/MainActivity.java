package com.example.emmaedv.tddc73_project;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity {
    PasswordStrengthMeter passwordStrengthMeter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        passwordStrengthMeter = new PasswordStrengthMeter(this);
        setContentView(passwordStrengthMeter);

    }
}
