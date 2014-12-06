package com.example.emmaedv.tddc73_lab1;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by emmaedv on 10/11/14.
 */
public class Lab1_java2 extends Activity {
    RelativeLayout layout;
    TextView nameText, passText, mailText, ageText;
    EditText nameField, passField, mailField;
    SeekBar ageBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int topMargin_px = getResources().getDimensionPixelSize(R.dimen.text_marg);
        //Declaring all objects
        layout = new RelativeLayout(this);
        nameText = new TextView(this);
        passText = new TextView(this);
        mailText = new TextView(this);
        ageText = new TextView(this);
        nameField = new EditText(this);
        passField = new EditText(this);
        mailField = new EditText(this);
        ageBar = new SeekBar(this);

        //Set id of all objects
        nameText.setId(11);
        passText.setId(21);
        mailText.setId(31);
        ageText.setId(41);
        nameField.setId(12);
        passField.setId(22);
        mailField.setId(32);
        ageBar.setId(42);

        //Settings of objects
        nameText.setText(R.string.name);
        nameText.setEnabled(false);
        passText.setText(R.string.password);
        passText.setEnabled(false);
        mailText.setText(R.string.email);
        mailText.setEnabled(false);
        ageText.setText(R.string.age);
        ageText.setEnabled(false);

        nameField.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
        nameField.setText("Emma");
        passField.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        passField.setText("Password");
        mailField.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        mailField.setText("emmed608@student.liu.se");
        ageBar.setProgress(25);


        //PARAMETERS
        //Layout parameters
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        layout.setLayoutParams(layoutParams);

        //NAME parameters
        RelativeLayout.LayoutParams nameTextParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        nameTextParams.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
        nameTextParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
        nameTextParams.setMargins(0,(topMargin_px/2),0,0);


        RelativeLayout.LayoutParams nameFieldParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        nameFieldParams.addRule(RelativeLayout.ALIGN_BASELINE, nameText.getId());
        nameFieldParams.addRule(RelativeLayout.ALIGN_START, passField.getId());

        //PASSWORD parameters
        RelativeLayout.LayoutParams passTextParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        passTextParams.addRule(RelativeLayout.BELOW, nameText.getId());
        passTextParams.setMargins(0,topMargin_px,0,0);

        RelativeLayout.LayoutParams passFieldParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        passFieldParams.addRule(RelativeLayout.ALIGN_BASELINE, passText.getId());
        passFieldParams.addRule(RelativeLayout.END_OF, passText.getId());

        //Email parameters
        RelativeLayout.LayoutParams mailTextParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        mailTextParams.addRule(RelativeLayout.BELOW, passText.getId());
        mailTextParams.setMargins(0, topMargin_px, 0, 0);

        RelativeLayout.LayoutParams mailFieldParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        mailFieldParams.addRule(RelativeLayout.ALIGN_BASELINE, mailText.getId());
        mailFieldParams.addRule(RelativeLayout.ALIGN_START, passField.getId());

        //Age parameters
        RelativeLayout.LayoutParams ageTextParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        ageTextParams.addRule(RelativeLayout.BELOW, mailText.getId());
        ageTextParams.setMargins(0,topMargin_px,0,0);

        RelativeLayout.LayoutParams ageBarParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        ageBarParams.addRule(RelativeLayout.ALIGN_TOP, ageText.getId());
        ageBarParams.addRule(RelativeLayout.ALIGN_START, passField.getId());

        //Add all objects to layout
        layout.addView(nameText, nameTextParams);
        layout.addView(nameField, nameFieldParams);
        layout.addView(passText, passTextParams);
        layout.addView(passField, passFieldParams);
        layout.addView(mailText, mailTextParams);
        layout.addView(mailField, mailFieldParams);
        layout.addView(ageText, ageTextParams);
        layout.addView(ageBar, ageBarParams);


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
