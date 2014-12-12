package com.example.emmaedv.tddc73_lab1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.RelativeLayout;

/**
 * Created by emmaedv on 10/11/14.
 */
public class Lab1_java1 extends Activity {
    RelativeLayout layout;
    Button theButton;
    EditText textField, multiLineText   ;
    RatingBar rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Declaring all objects
        layout = new RelativeLayout(this);
        theButton = new Button(this);
        textField  = new EditText(this);
        rating = new RatingBar(this);
        multiLineText = new EditText(this);

        //Set id of all objects
        theButton.setId(10);
        textField.setId(20);
        rating.setId(30);
        multiLineText.setId(40);

        //Set text of objects
        theButton.setText(R.string.button);
        textField.setText(R.string.textField);
        multiLineText.setText(R.string.textField_ML);

        textField.setSingleLine();

        //PARAMETERS
        //Layout parameters
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        layout.setLayoutParams(layoutParams);

        //Button parameters
        RelativeLayout.LayoutParams buttonParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        buttonParams.addRule(RelativeLayout.ALIGN_PARENT_START, RelativeLayout.TRUE);

        //Text field parameters
        RelativeLayout.LayoutParams textParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        textParams.addRule(RelativeLayout.BELOW, theButton.getId());

        //Rating bar parameters
        RelativeLayout.LayoutParams ratingParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        ratingParams.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
        ratingParams.addRule(RelativeLayout.BELOW, textField.getId());

        //Multiline text field parameters
        RelativeLayout.LayoutParams multiLineParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        multiLineParams.addRule(RelativeLayout.BELOW, rating.getId());
        multiLineParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);


        //Add all objects to layout
        layout.addView(theButton, buttonParams);
        layout.addView(textField, textParams);
        layout.addView(rating, ratingParams);
        layout.addView(multiLineText, multiLineParams);

        setContentView(layout);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.lab1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
